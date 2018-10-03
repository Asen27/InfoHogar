package aiss.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;


import aiss.model.InmuebleImpl;
import aiss.model.repository.MapCiudadRepository;
import aiss.model.repository.CiudadRepository;

import java.net.URI;
import java.util.Collection;



@Path("/inmuebles")
public class InmuebleResource {

	public static InmuebleResource _instance=null;
	CiudadRepository repository;
	
	private InmuebleResource(){
		repository=MapCiudadRepository.getInstance();
	}
	
	public static InmuebleResource getInstance()
	{
		if(_instance==null)
			_instance=new InmuebleResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<InmuebleImpl> getAll(){
		return repository.getAllInmuebles();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public InmuebleImpl get(@PathParam("id") String inmuebleId) // Con PathParam coge el parámetro id de Path y lo guarda en songID
	{
		InmuebleImpl inmueble = repository.getInmueble(inmuebleId);
		
		if (inmueble == null){
			throw new NotFoundException("El inmueble con id '" + inmuebleId + "' no ha sido encontrado.");
		}
		
		return inmueble;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addInmueble(@Context UriInfo uriInfo, InmuebleImpl inmueble) {
		if (inmueble.getId() == null || "".equals(inmueble.getId())){
			throw new BadRequestException("La id del inmueble está vacía");
		}
		repository.addInmueble(inmueble);
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(inmueble.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(inmueble);
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateInmueble(InmuebleImpl inmueble) {
		InmuebleImpl oldInmueble = repository.getInmueble(inmueble.getId());
		if (oldInmueble == null){
			throw new NotFoundException("El inmueble con id '" + inmueble.getId() + "' no ha sido encontrado");
		}
		
		repository.updateInmueble(inmueble);
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeInmueble(@PathParam("id") String inmuebleId) {
		InmuebleImpl eliminar = repository.getInmueble(inmuebleId);
		if (eliminar == null)
			throw new NotFoundException("El inmueble con id '"+ inmuebleId +"' no ha sido encontrado");
		else
		repository.deleteInmueble(inmuebleId);
		
		return Response.noContent().build();
	}
	
}
