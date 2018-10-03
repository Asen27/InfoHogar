package aiss.model.repository;

import java.util.Collection;

import aiss.model.Ciudad;
import aiss.model.InmuebleImpl;

public interface CiudadRepository {
	
	
	// Songs
	public void addInmueble(InmuebleImpl s);
	public Collection<InmuebleImpl> getAllInmuebles();
	public InmuebleImpl getInmueble(String songId);
	public void updateInmueble(InmuebleImpl s);
	public void deleteInmueble(String songId);
	
	// Playlists
	public void addCiudad(Ciudad p);
	public Collection<Ciudad> getAllCiudades();
	public Ciudad getCiudades(String playlistId);
	public void updateCiudad(Ciudad p);
	public void deleteCiudad(String playlistId);
	public Collection<InmuebleImpl> getAll(String playlistId);
	public void addInmueble(String playlistId, String songId);
	public void removeInmueble(String playlistId, String songId); 

	
	
	
	
	

}
