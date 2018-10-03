package aiss.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Local extends InmuebleImpl {
 public enum Localizacion {CENTRO_COMERCIAL,CALLE,ENTREPLANTA,SUBTERRANEO}
 public enum TipoLocal {LOCAL,EDIFICIO_INDUSTRIAL}
 
 private Boolean ventilado;
 private Integer tamaño;
 private Localizacion localizacion;
 private TipoLocal tipo;
 
public Local() {
	super();
	// TODO Auto-generated constructor stub
}

public Local(Integer precio, Integer distancia, Operacion operacion, Boolean ventilado, Integer tamaño, Localizacion localizacion, TipoLocal tipo) {
	super(precio, distancia, operacion);
	this.ventilado = ventilado;
	this.tamaño = tamaño;
	this.localizacion = localizacion;
	this.tipo = tipo;
}

public Local(String id, Integer precio, Integer distancia, Operacion operacion, Boolean ventilado, Integer tamaño, Localizacion localizacion, TipoLocal tipo) {
	super(id, precio, distancia, operacion);
	this.ventilado = ventilado;
	this.tamaño = tamaño;
	this.localizacion = localizacion;
	this.tipo = tipo;
}

public Boolean getVentilado() {
	return ventilado;
}

public void setVentilado(Boolean ventilado) {
	this.ventilado = ventilado;
}

public Integer getTamaño() {
	return tamaño;
}

public void setTamaño(Integer tamaño) {
	this.tamaño = tamaño;
}

public Localizacion getLocalizacion() {
	return localizacion;
}

public void setLocalizacion(Localizacion localizacion) {
	this.localizacion = localizacion;
}

public TipoLocal getTipoLocal() {
	return tipo;
}

public void setTipoLocal(TipoLocal tipo) {
	this.tipo = tipo;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((localizacion == null) ? 0 : localizacion.hashCode());
	result = prime * result + ((tamaño == null) ? 0 : tamaño.hashCode());
	result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
	result = prime * result + ((ventilado == null) ? 0 : ventilado.hashCode());
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
	Local other = (Local) obj;
	if (localizacion != other.localizacion)
		return false;
	if (tamaño == null) {
		if (other.tamaño != null)
			return false;
	} else if (!tamaño.equals(other.tamaño))
		return false;
	if (tipo != other.tipo)
		return false;
	if (ventilado == null) {
		if (other.ventilado != null)
			return false;
	} else if (!ventilado.equals(other.ventilado))
		return false;
	return true;
}

@Override
public String toString() {
	return "Local [ventilado=" + ventilado + ", tamaño=" + tamaño + ", localizacion=" + localizacion + ", tipo=" + tipo
			+ "]";
}
 
	
	
}
