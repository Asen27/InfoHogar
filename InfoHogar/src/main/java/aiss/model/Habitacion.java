package aiss.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Habitacion extends InmuebleImpl {
	public enum Sexo {HOMBRE, MUJER}
	private Integer compañeros; // (Compañeros de habitación)
	private Boolean fumadores;
	private Boolean mascotas;
	private Sexo sexo;

	public Habitacion() {
		super();
	}
	public Habitacion(Integer precio, Integer distancia, Integer compañeros, Boolean fumadores, Boolean mascotas, Sexo sexo) {
		super(precio, distancia, Operacion.ALQUILER);
		this.compañeros = compañeros;
		this.fumadores = fumadores;
		this.mascotas = mascotas;
		this.sexo = sexo;
	}
	public Habitacion(String id, Integer precio, Integer distancia, Integer compañeros, Boolean fumadores, Boolean mascotas, Sexo sexo) {
		super(id, precio, distancia, Operacion.ALQUILER);
		this.compañeros = compañeros;
		this.fumadores = fumadores;
		this.mascotas = mascotas;
		this.sexo = sexo;
	}
	public Integer getCompañeros() {
		return compañeros;
	}
	public void setCompañeros(Integer compañeros) {
		this.compañeros = compañeros;
	}
	public Boolean getFumadores() {
		return fumadores;
	}
	public void setFumadores(Boolean fumadores) {
		this.fumadores = fumadores;
	}
	public Boolean getMascotas() {
		return mascotas;
	}
	public void setMascotas(Boolean mascotas) {
		this.mascotas = mascotas;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((compañeros == null) ? 0 : compañeros.hashCode());
		result = prime * result + ((fumadores == null) ? 0 : fumadores.hashCode());
		result = prime * result + ((mascotas == null) ? 0 : mascotas.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Habitacion other = (Habitacion) obj;
		if (compañeros == null) {
			if (other.compañeros != null)
				return false;
		} else if (!compañeros.equals(other.compañeros))
			return false;
		if (fumadores == null) {
			if (other.fumadores != null)
				return false;
		} else if (!fumadores.equals(other.fumadores))
			return false;
		if (mascotas == null) {
			if (other.mascotas != null)
				return false;
		} else if (!mascotas.equals(other.mascotas))
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}

	public String toString() {
		return "Habitacion [compañeros=" + compañeros + ", fumadores=" + fumadores + ", mascotas=" + mascotas
				+ ", sexo=" + sexo + "]";
	}
	
	
	
	
	
}
