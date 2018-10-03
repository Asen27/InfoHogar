package aiss.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Ciudad {


	private String capital;
	private String nombre;
	private List<InmuebleImpl> inmuebles;
	private List<Vivienda> viviendas;
	private List<Oficina> oficinas;
	private List<Garaje> garajes;
	private List<Local> locales;
	private List<Habitacion> habitaciones;
	
	public Ciudad() {}
	
	public Ciudad(String nombre) {
		this.nombre = nombre;
	}
	
	protected void setInmuebles(List<InmuebleImpl> s) {
		inmuebles.addAll(viviendas);
		inmuebles.addAll(oficinas);
		inmuebles.addAll(garajes);
		inmuebles.addAll(locales);
		inmuebles.addAll(habitaciones);
	}
	
	public String getCapital() {
		return capital;
	}

	public List<Vivienda> getViviendas() {
		return viviendas;
	}

	public void setViviendas(List<Vivienda> viviendas) {
		this.viviendas = viviendas;
	}

	public List<Oficina> getOficinas() {
		return oficinas;
	}

	public void setOficinas(List<Oficina> oficinas) {
		this.oficinas = oficinas;
	}

	public List<Garaje> getGarajes() {
		return garajes;
	}

	public void setGarajes(List<Garaje> garajes) {
		this.garajes = garajes;
	}

	public List<Local> getLocales() {
		return locales;
	}

	public void setLocales(List<Local> locales) {
		this.locales = locales;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<InmuebleImpl> getInmuebles() {
		return inmuebles;
	}
	
	public InmuebleImpl getInmueble(String id) { //Consigue un inmueble determinado de la ciudad actual filtrandolo por su id
		InmuebleImpl inmueble =null;
		if (!(inmuebles==null)){	
		for (InmuebleImpl in: inmuebles){
			if (in.getId().equals(id) ){
				inmueble = in;
			}
		}		}
		return inmueble;
	}
	
	public void añadirInmueble(InmuebleImpl i) {
		if (inmuebles==null){
			inmuebles = new ArrayList<InmuebleImpl>();
			}	
		inmuebles.add(i);
	}
	
	public void eliminarInmueble(InmuebleImpl i) {
		inmuebles.remove(i);
	}
	
	public void eliminarInmueble(String id) {
		InmuebleImpl s = getInmueble(id);
		if (s!=null){
			inmuebles.remove(s);
			}
	}
	@Override
	public String toString() {
		return "Ciudad [capital=" + capital + ", nombre=" + nombre + ", inmuebles=" + inmuebles + ", viviendas="
				+ viviendas + ", oficinas=" + oficinas + ", garajes=" + garajes + ", locales=" + locales
				+ ", habitaciones=" + habitaciones + "]";
	}

}
