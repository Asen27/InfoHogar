package aiss.model;



import aiss.model.InmuebleImpl.Operacion;

public interface Inmueble {
	String getId();
	void setId(String id);
	Integer getPrecio();
	void setPrecio(Integer precio);
	Integer getDistancia();
	void setDistancia(Integer distancia);
	Operacion getOperacion();
	void setOperacion(Operacion operacion);
}
