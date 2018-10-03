package aiss.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Garaje extends InmuebleImpl {
	private Boolean pAutomatica;
	private Boolean parkingMotos;
	private Boolean seguridad;

	public Garaje() {
		super();
	}
	public Garaje(Integer precio, Integer distancia, Operacion operacion, Boolean pAutomatica, Boolean parkingMotos, Boolean seguridad) {
		super(precio, distancia, operacion);
		this.pAutomatica = pAutomatica;
		this.parkingMotos = parkingMotos;
		this.seguridad = seguridad;
		}
	public Garaje(String id, Integer precio, Integer distancia, Operacion operacion, Boolean pAutomatica, Boolean parkingMotos, Boolean seguridad) {
		super(id, precio, distancia, operacion);
		this.pAutomatica = pAutomatica;
		this.parkingMotos = parkingMotos;
		this.seguridad = seguridad;
		}
	public Boolean getpAutomatica() {
		return pAutomatica;
	}
	public void setpAutomatica(Boolean pAutomatica) {
		this.pAutomatica = pAutomatica;
	}
	public Boolean getParkingMotos() {
		return parkingMotos;
	}
	public void setParkingMotos(Boolean parkingMotos) {
		this.parkingMotos = parkingMotos;
	}
	public Boolean getSeguridad() {
		return seguridad;
	}
	public void setSeguridad(Boolean seguridad) {
		this.seguridad = seguridad;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pAutomatica == null) ? 0 : pAutomatica.hashCode());
		result = prime * result + ((parkingMotos == null) ? 0 : parkingMotos.hashCode());
		result = prime * result + ((seguridad == null) ? 0 : seguridad.hashCode());
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
		Garaje other = (Garaje) obj;
		if (pAutomatica == null) {
			if (other.pAutomatica != null)
				return false;
		} else if (!pAutomatica.equals(other.pAutomatica))
			return false;
		if (parkingMotos == null) {
			if (other.parkingMotos != null)
				return false;
		} else if (!parkingMotos.equals(other.parkingMotos))
			return false;
		if (seguridad == null) {
			if (other.seguridad != null)
				return false;
		} else if (!seguridad.equals(other.seguridad))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Garaje [pAutomatica=" + pAutomatica + ", parkingMotos=" + parkingMotos + ", seguridad=" + seguridad
				+ "]";
	}
	
	
	
	
	
	
}
