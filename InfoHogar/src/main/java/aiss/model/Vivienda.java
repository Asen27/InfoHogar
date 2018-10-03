package aiss.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Vivienda extends InmuebleImpl {
	
	private Integer tamaño; //En m^2
	private Integer baños;
	private Integer habitaciones;
	private Boolean duplex;
	private Boolean garaje;
	private Boolean ascensor;
	
	public Vivienda() {
		super();
	}
	
	public Vivienda(String id, Integer precio, Integer distancia, Operacion operacion, Integer tamaño, Integer baños, Integer habitaciones, Boolean duplex, Boolean garaje,
			Boolean ascensor) {
		super(id, precio, distancia, operacion);
		this.tamaño = tamaño;
		this.baños = baños;
		this.habitaciones = habitaciones;
		this.duplex = duplex;
		this.garaje = garaje;
		this.ascensor = ascensor;

	}
	public Vivienda(Integer precio, Integer distancia, Operacion operacion, Integer tamaño, Integer baños, Integer habitaciones, Boolean duplex, Boolean garaje,
			Boolean ascensor) {
		super(precio, distancia, operacion);
		this.tamaño = tamaño;
		this.baños = baños;
		this.habitaciones = habitaciones;
		this.duplex = duplex;
		this.garaje = garaje;
		this.ascensor = ascensor;

	}
	public Integer getTamaño() {
		return tamaño;
	}
	public void setTamaño(Integer tamaño) {
		this.tamaño = tamaño;
	}
	public Integer getBaños() {
		return baños;
	}
	public void setBaños(Integer baños) {
		this.baños = baños;
	}
	public Integer getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(Integer habitaciones) {
		this.habitaciones = habitaciones;
	}
	public Boolean getDuplex() {
		return duplex;
	}
	public void setDuplex(Boolean duplex) {
		this.duplex = duplex;
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
	
}
