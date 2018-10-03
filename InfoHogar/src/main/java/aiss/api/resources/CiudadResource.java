package aiss.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.Ciudad;
import aiss.model.InmuebleImpl;
import aiss.model.repository.MapCiudadRepository;
import aiss.model.repository.CiudadRepository;


@Path("/ciudades")
public class CiudadResource {
	
	
	private static CiudadResource _instance=null;
	CiudadRepository repository;
	
	private CiudadResource() {
		repository=MapCiudadRepository.getInstance();

	}
	
	public static CiudadResource getInstance()
	{
		System.out.println("prueba");
		if(_instance==null){
			_instance=new CiudadResource();
			System.out.println("prueba2");
			System.out.println(_instance.toString());

		}
				
		return _instance;
	}
	

	@GET
	@Produces("application/json")
	public Collection<Ciudad> getAll()
	{
		return repository.getAllCiudades();
	}
	
	
	@GET
	@Path("/{nombre}")
	@Produces("application/json")
	public Ciudad get(@PathParam("nombre") String id)
	{
		Ciudad list = repository.getCiudades(id);
		
		if (list == null) {
			throw new NotFoundException("La ciudad con el nombre "+ id +" no ha sido encontrada");			
		}
		
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addCiudad(@Context UriInfo uriInfo, Ciudad ciudad) {
		if (ciudad.getNombre() == null || "".equals(ciudad.getNombre()))
			throw new BadRequestException("The name of the city must not be null");
		
		if (ciudad.getInmuebles()!=null)
			throw new BadRequestException("The inmuebles property is not editable.");

		repository.addCiudad(ciudad);

	
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(ciudad.getNombre());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(ciudad);			
		return resp.build();
	}

	
	@PUT
	@Consumes("application/json")
	public Response updateCiudad(Ciudad ciudad) {
		Ciudad oldCiudad = repository.getCiudades(ciudad.getNombre());
		if (oldCiudad == null) {
			throw new NotFoundException("La Ciudad con id '"+ ciudad.getNombre() +"' no ha sido encontrada");			
		}
		
		if (ciudad.getInmuebles()!=null)
			throw new BadRequestException("La propiedad inmuebles no es editable.");
		
		
		if (ciudad.getNombre()!=null)
			repository.updateCiudad(ciudad);
		
		
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{nombreCiudad}")
	public Response removeCiudad(@PathParam("nombreCiudad") String nombreCiudad) {
		Ciudad toberemoved=repository.getCiudades(nombreCiudad);
		if (toberemoved == null)
			throw new NotFoundException("La Ciudad con id '"+ nombreCiudad +"' no ha sido encontrada");
		else
			repository.deleteCiudad(nombreCiudad);
		
		return Response.noContent().build();
	}
	
	
	@POST	
	@Path("/{nombreCiudad}/{inmuebleId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addInmueble(@Context UriInfo uriInfo,@PathParam("nombreCiudad") String nombreCiudad, @PathParam("inmuebleId") String inmuebleId)
	{				
		
		Ciudad Ciudad = repository.getCiudades(nombreCiudad);
		InmuebleImpl inmueble = repository.getInmueble(inmuebleId);
		
		if (Ciudad==null)
			throw new NotFoundException("La ciudad con el nombre '" + nombreCiudad + "' no ha sido encontrada");
		
		if (inmueble == null)
			throw new NotFoundException("El inmueble con id '" + inmuebleId + "' no ha sido encontrado");
		
		if (Ciudad.getInmueble(inmuebleId)!=null)
			throw new BadRequestException("El inmueble ya está en la Ciudad.");
			
		repository.addInmueble(nombreCiudad, inmuebleId);		


		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(nombreCiudad);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(Ciudad);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{nombreCiudad}/{inmuebleId}")
	public Response removeInmueble(@PathParam("nombreCiudad") String nombreCiudad, @PathParam("inmuebleId") String inmuebleId) {
		Ciudad ciudad = repository.getCiudades(nombreCiudad);
		InmuebleImpl inmueble = repository.getInmueble(inmuebleId);
		System.out.println("Ciudad: " + ciudad + "Inmueble: " + inmueble);
		if (ciudad==null)
			throw new NotFoundException("La ciudad con el nombre '" + nombreCiudad + "' no ha sido encontrada");
		
		if (inmueble == null)
			throw new NotFoundException("El inmueble con id '" + inmuebleId + "' no ha sido encontrado");
		
		
		repository.removeInmueble(nombreCiudad, inmuebleId);		
		
		return Response.noContent().build();
	}
}
