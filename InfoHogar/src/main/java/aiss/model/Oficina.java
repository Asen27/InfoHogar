package aiss.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Oficina extends InmuebleImpl {
	public enum Diseño {ABIERTO,CERRADO}
	public enum Tipo {EXCLUSIVO, MIXTO}
	private Boolean seguridad;
	private Boolean garaje;
	private Boolean ascensor;
	private Diseño diseño;
	private Tipo tipo;
	
	public Oficina() {
		super();
	}
	public Oficina(Integer precio, Integer distancia, Operacion operacion, Boolean seguridad, Boolean garaje, Boolean ascensor, Diseño diseño, Tipo tipo) {
		super(precio, distancia, operacion);
		this.seguridad = seguridad;
		this.garaje = garaje;
		this.ascensor = ascensor;
		this.diseño = diseño;
		this.tipo = tipo;
	}
	public Oficina(String id, Integer precio, Integer distancia, Operacion operacion, Boolean seguridad, Boolean garaje, Boolean ascensor, Diseño diseño, Tipo tipo) {
		super(id, precio, distancia, operacion);
		this.seguridad = seguridad;
		this.garaje = garaje;
		this.ascensor = ascensor;
		this.diseño = diseño;
		this.tipo = tipo;
	}
	
	public Boolean getSeguridad() {
		return seguridad;
	}
	public void setSeguridad(Boolean seguridad) {
		this.seguridad = seguridad;
	}
	public Boolean getGaraje() {
		return garaje;
	}
	public void setGaraje(Boolean garaje) {
		this.garaje = garaje;
	}
	public Boolean getAscensor() {
		return ascensor;
	}
	public void setAscensor(Boolean ascensor) {
		this.ascensor = ascensor;
	}
	public Diseño getDiseño() {
		return diseño;
	}
	public void setDiseño(Diseño diseño) {
		this.diseño = diseño;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ascensor == null) ? 0 : ascensor.hashCode());
		result = prime * result + ((diseño == null) ? 0 : diseño.hashCode());
		result = prime * result + ((garaje == null) ? 0 : garaje.hashCode());
		result = prime * result + ((seguridad == null) ? 0 : seguridad.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oficina other = (Oficina) obj;
		if (ascensor == null) {
			if (other.ascensor != null)
				return false;
		} else if (!ascensor.equals(other.ascensor))
			return false;
		if (diseño != other.diseño)
			return false;
		if (garaje == null) {
			if (other.garaje != null)
				return false;
		} else if (!garaje.equals(other.garaje))
			return false;
		if (seguridad == null) {
			if (other.seguridad != null)
				return false;
		} else if (!seguridad.equals(other.seguridad))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Oficina [seguridad=" + seguridad + ", garaje=" + garaje + ", ascensor=" + ascensor + ", diseño="
				+ diseño + ", tipo=" + tipo + "]";
	}

	
}
