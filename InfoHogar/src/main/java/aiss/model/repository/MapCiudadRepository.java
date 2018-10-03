package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import aiss.model.Ciudad;
import aiss.model.Garaje;
import aiss.model.Habitacion;
import aiss.model.InmuebleImpl;
import aiss.model.InmuebleImpl.Operacion;
import aiss.model.Local;
import aiss.model.Local.Localizacion;
import aiss.model.Local.TipoLocal;
import aiss.model.Oficina;
import aiss.model.Oficina.Diseño;
import aiss.model.Oficina.Tipo;
import aiss.model.Vivienda;
import aiss.model.Habitacion.Sexo;


public class MapCiudadRepository implements CiudadRepository{

	Map<String, Ciudad> ciudades; //<Nombre,Ciudad>
	Map<String, Vivienda> viviendas;//<Id, Inmueble>
	Map<String, Oficina> oficinas;
	Map<String, Garaje> garajes;
	Map<String, Habitacion> habitaciones;
	Map<String, Local> locales;
	Map<String, InmuebleImpl> inmuebles;
	private static MapCiudadRepository instance=null;
	private int index=0;			
	
	
	public static MapCiudadRepository getInstance() {
		
		if (instance==null) {
			instance = new MapCiudadRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		// Create viviendas
		inmuebles = new HashMap<String, InmuebleImpl>();
		ciudades = new HashMap<String, Ciudad>();
		viviendas = new HashMap<String, Vivienda>();
		locales = new HashMap<String, Local>();
		garajes = new HashMap<String, Garaje>();
		habitaciones = new HashMap<String, Habitacion>();
		oficinas = new HashMap<String, Oficina>();
		
		
		
		Vivienda v1 =new Vivienda();
		v1.setId("v1");
		v1.setAscensor(true);
		v1.setBaños(3);
		v1.setDistancia(300);
		v1.setDuplex(false);
		v1.setOperacion(Operacion.VENTA);
		v1.setGaraje(true);
		v1.setPrecio(250000);
		v1.setTamaño(80);
		
		Vivienda v2 =new Vivienda();
		v2.setId("v2");
		v2.setAscensor(false);
		v2.setBaños(2);
		v2.setDistancia(100);
		v2.setDuplex(false);
		v2.setOperacion(Operacion.VENTA);
		v2.setGaraje(false);
		v2.setPrecio(210000);
		v2.setTamaño(50);
		
		Vivienda v3 =new Vivienda();
		v3.setId("v3");
		v3.setAscensor(true);
		v3.setBaños(1);
		v3.setDistancia(70);
		v3.setDuplex(false);
		v3.setOperacion(Operacion.ALQUILER);
		v3.setGaraje(true);
		v3.setPrecio(450);
		v3.setTamaño(65);
		
		addInmueble(v1);
		addInmueble(v2);
		addInmueble(v3);
		
		//Create Oficinas
		Oficina o1 = new Oficina();
		o1.setId("o1");
		o1.setAscensor(true);
		o1.setDiseño(Diseño.ABIERTO);
		o1.setDistancia(200);
		o1.setGaraje(true);
		o1.setOperacion(Operacion.ALQUILER);
		o1.setPrecio(500);
		o1.setSeguridad(true);
		o1.setTipo(Tipo.EXCLUSIVO);
		
		Oficina o2 = new Oficina();
		o2.setId("o2");
		o2.setAscensor(false);
		o2.setDiseño(Diseño.CERRADO);
		o2.setDistancia(250);
		o2.setGaraje(true);
		o2.setOperacion(Operacion.ALQUILER);
		o2.setPrecio(550);
		o2.setSeguridad(true);
		o2.setTipo(Tipo.MIXTO);
		
		Oficina o3 = new Oficina();
		o3.setId("o3");
		o3.setAscensor(true);
		o3.setDiseño(Diseño.CERRADO);
		o3.setDistancia(250);
		o3.setGaraje(true);
		o3.setOperacion(Operacion.VENTA);
		o3.setPrecio(110000);
		o3.setSeguridad(true);
		o3.setTipo(Tipo.EXCLUSIVO);
		System.out.println("pruebaput");

		addInmueble(o1);
		addInmueble(o2);
		addInmueble(o3);
		
		//Create Habitaciones
		Habitacion h1 = new Habitacion();
		h1.setId("h1");
		h1.setCompañeros(3);
		h1.setDistancia(100);
		h1.setFumadores(false);
		h1.setPrecio(400);
		h1.setMascotas(true);
		h1.setSexo(Sexo.HOMBRE);
		
		Habitacion h2 = new Habitacion();
		h2.setId("h2");
		h2.setCompañeros(1);
		h2.setDistancia(50);
		h2.setFumadores(true);
		h2.setPrecio(500);
		h2.setMascotas(false);
		h2.setSexo(Sexo.MUJER);
		
		Habitacion h3 = new Habitacion();
		h3.setId("h3");
		h3.setCompañeros(2);
		h3.setDistancia(340);
		h3.setFumadores(true);
		h3.setPrecio(350);
		h3.setMascotas(true);
		h3.setSexo(Sexo.MUJER);
		
		addInmueble(h1);
		addInmueble(h2);
		addInmueble(h3);
		
		//Create Garajes
		
		Garaje g1 = new Garaje();
		g1.setId("g1");
		g1.setDistancia(200);
		g1.setOperacion(Operacion.VENTA);
		g1.setParkingMotos(true);
		g1.setpAutomatica(true);
		g1.setPrecio(60000);
		g1.setSeguridad(true);
		
		Garaje g2 = new Garaje();
		g2.setId("g2");
		g2.setDistancia(300);
		g2.setOperacion(Operacion.ALQUILER);
		g2.setParkingMotos(false);
		g2.setpAutomatica(true);
		g2.setPrecio(150);
		g2.setSeguridad(false);
		
		Garaje g3 = new Garaje();
		g3.setId("g3");
		g3.setDistancia(50);
		g3.setOperacion(Operacion.ALQUILER);
		g3.setParkingMotos(false);
		g3.setpAutomatica(false);
		g3.setPrecio(200);
		g3.setSeguridad(false);
		
		addInmueble(g1);
		addInmueble(g2);
		addInmueble(g3);
		
		//Create Locales
		 
		Local l1 = new Local();
		l1.setId("l1");
		l1.setDistancia(160);
		l1.setLocalizacion(Localizacion.CENTRO_COMERCIAL);
		l1.setOperacion(Operacion.VENTA);
		l1.setPrecio(180000);
		l1.setTamaño(40);
		l1.setTipoLocal(TipoLocal.LOCAL);
		l1.setVentilado(true);
		
		Local l2 = new Local();
		l2.setId("l2");
		l2.setDistancia(100);
		l2.setLocalizacion(Localizacion.CALLE);
		l2.setOperacion(Operacion.VENTA);
		l2.setPrecio(145000);
		l2.setTamaño(45);
		l2.setTipoLocal(TipoLocal.LOCAL);
		l2.setVentilado(true);
		
		Local l3 = new Local();
		l3.setId("l3");
		l3.setDistancia(600);
		l3.setLocalizacion(Localizacion.CALLE);
		l3.setOperacion(Operacion.VENTA);
		l3.setPrecio(200000);
		l3.setTamaño(80);
		l3.setTipoLocal(TipoLocal.EDIFICIO_INDUSTRIAL);
		l3.setVentilado(true);
		
		addInmueble(l1);
		addInmueble(l2);
		addInmueble(l3);

		
		
		inmuebles.putAll(viviendas);
		inmuebles.putAll(garajes);
		inmuebles.putAll(habitaciones);
		inmuebles.putAll(locales);
		inmuebles.putAll(oficinas);

		
		
		// Create Ciudades
		Ciudad Madrid=new Ciudad();
		Madrid.setNombre("Madrid");
		addCiudad(Madrid);
		
		Ciudad Sevilla = new Ciudad();
		Sevilla.setNombre("Sevilla");
		addCiudad(Sevilla);
		
		// Añadir inmuebles a las ciudades
		addInmueble(Madrid.getNombre(), v1.getId());
		addInmueble(Madrid.getNombre(), o2.getId());
		addInmueble(Madrid.getNombre(), o3.getId());
		addInmueble(Madrid.getNombre(), g2.getId());
		addInmueble(Madrid.getNombre(), l3.getId());
		
		addInmueble(Sevilla.getNombre(), v2.getId());
		addInmueble(Sevilla.getNombre(), v3.getId());
		addInmueble(Sevilla.getNombre(), g1.getId());
		addInmueble(Sevilla.getNombre(), h3.getId());
		addInmueble(Sevilla.getNombre(), h2.getId());

	}
	
	// Ciudad related operations
	@Override
	public void addCiudad(Ciudad p) {
		String nombre = p.getNombre();
		ciudades.put(nombre,p);
	}
	
	@Override
	public Collection<Ciudad> getAllCiudades() {
			return ciudades.values();
	}

	@Override
	public Ciudad getCiudades(String nombre) {
		return ciudades.get(nombre);
	}
	
	@Override
	public void updateCiudad(Ciudad p) {
		Ciudad oldCiudad = ciudades.get(p.getNombre());
		oldCiudad.setCapital(p.getCapital());
		oldCiudad.setGarajes(p.getGarajes());
		oldCiudad.setNombre(p.getNombre());
		oldCiudad.setOficinas(p.getOficinas());
		oldCiudad.setViviendas(p.getViviendas());
		ciudades.put(oldCiudad.getNombre(),oldCiudad);
	}

	@Override
	public void deleteCiudad(String nombre) {	
		ciudades.remove(nombre);
	}
	

	@Override
	public void addInmueble(String nombreCiudad, String InmuebleId) {
		Ciudad ciudad = getCiudades(nombreCiudad);
		ciudad.añadirInmueble(inmuebles.get(InmuebleId));
	}

	@Override
	public Collection<InmuebleImpl> getAll(String nombreCiudad) {
		return getCiudades(nombreCiudad).getInmuebles();
	}

	public void removeInmueble (String nombreCiudad, String inmuebleId) {
		getCiudades(nombreCiudad).eliminarInmueble(inmuebleId);
	}

	
	// Inmuebles related operations
	
	@Override
	public void addInmueble(InmuebleImpl s) {
		String id = "I" + index++;
		s.setId(id);
		if (inmuebles.containsKey(id)){
			inmuebles.remove(id);
		}
		inmuebles.put(id, s);
	}
	
	@Override
	public Collection<InmuebleImpl> getAllInmuebles() {
			return inmuebles.values();
	}

	@Override
	public InmuebleImpl getInmueble(String inmuebleId) {
		InmuebleImpl x = null;
		if (inmuebles.containsKey(inmuebleId)){
			x = inmuebles.get(inmuebleId);
		}	
		return x;
	}

	@Override
	public void updateInmueble(InmuebleImpl s) {
		Vivienda v = new Vivienda();
		Oficina o = new Oficina();
		Garaje g = new Garaje();
		Local l = new Local();
		Habitacion h = new Habitacion();
		InmuebleImpl inm = getInmueble (s.getId());
		inm.setDistancia(s.getDistancia());
		inm.setId(s.getId());
		inm.setOperacion(s.getOperacion());
		inm.setPrecio(s.getPrecio());
		
		if (s.equals(Vivienda.class)){
		v = (Vivienda) inm;
		Vivienda sv = (Vivienda) s;
		v.setAscensor(sv.getAscensor());
		v.setBaños(sv.getBaños());
		v.setDuplex(sv.getDuplex());
		v.setGaraje(sv.getGaraje());
		v.setHabitaciones(sv.getHabitaciones());
		v.setTamaño(sv.getTamaño());
		addInmueble(v);
		} else if (s.equals(Oficina.class)){
			
		 o = (Oficina) inm;
		 Oficina so = (Oficina) s;
		 o.setAscensor(so.getAscensor());
		 o.setDiseño(so.getDiseño());
		 o.setGaraje(so.getGaraje());
		 o.setSeguridad(so.getSeguridad());
		 o.setTipo(so.getTipo());
		 addInmueble(o);
		} else if (s.equals(Garaje.class)){
			g = (Garaje) inm;
			Garaje sg = (Garaje) s;
			g.setParkingMotos(sg.getParkingMotos());
			g.setpAutomatica(sg.getpAutomatica());
			g.setSeguridad(sg.getSeguridad());
			addInmueble(g);
		} else if (s.equals(Habitacion.class)){
			h = (Habitacion) inm;
			Habitacion sh = (Habitacion) h;
			h.setCompañeros(sh.getCompañeros());
			h.setFumadores(sh.getFumadores());
			h.setMascotas(sh.getMascotas());
			h.setSexo(sh.getSexo());
			addInmueble(h);
			
	} else if (s.equals(Local.class))		{
		l = (Local) inm;
		Local sl = (Local) l;
		l.setLocalizacion(sl.getLocalizacion());
		l.setTamaño(sl.getTamaño());
		l.setTipoLocal(sl.getTipoLocal());
		l.setVentilado(sl.getVentilado());
		addInmueble(l);
		
	}			
			
		
		
	}

	@Override
	public void deleteInmueble(String songId) {
		inmuebles.remove(songId);
	}
	
}
