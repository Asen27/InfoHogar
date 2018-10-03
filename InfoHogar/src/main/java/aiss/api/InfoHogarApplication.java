package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;
import aiss.api.resources.CiudadResource;
import aiss.api.resources.InmuebleResource;


public class InfoHogarApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();


	public InfoHogarApplication() {
		singletons.add(CiudadResource.getInstance());
		singletons.add(InmuebleResource.getInstance());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
