package aiss.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class InmuebleImpl implements Inmueble {
	public enum Operacion {VENTA, ALQUILER}
	private String id;
	private Integer precio;
	private Integer distancia; //Distancia al centro
	private Operacion operacion;

	public InmuebleImpl() {
	}

	public InmuebleImpl (Integer precio, Integer distancia, Operacion operacion) {
		this.precio = precio;
		this.distancia = distancia;
		this.operacion = operacion;
	}
	
	public InmuebleImpl(String id, Integer precio, Integer distancia, Operacion operacion) {
		this.id=id;
		this.precio = precio;
		this.distancia = distancia;
		this.operacion = operacion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public Operacion getOperacion() {
		return operacion;
	}

	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distancia == null) ? 0 : distancia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((operacion == null) ? 0 : operacion.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InmuebleImpl other = (InmuebleImpl) obj;
		if (distancia == null) {
			if (other.distancia != null)
				return false;
		} else if (!distancia.equals(other.distancia))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (operacion != other.operacion)
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Inmueble [id=" + id + ", precio=" + precio + ", distancia=" + distancia + ", operacion=" + operacion
				+ "]";
	}


}
