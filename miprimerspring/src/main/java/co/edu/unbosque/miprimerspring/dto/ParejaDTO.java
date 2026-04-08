package co.edu.unbosque.miprimerspring.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class ParejaDTO {
	private long id;
	private String nombre;
	private int edad;
	private String carrera;
	private LocalDateTime fechaAniversario;
	
	public ParejaDTO() {
		
	}
	
	public ParejaDTO(String nombre, int edad, String carrera, LocalDateTime fechaAniversario) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.carrera = carrera;
		this.fechaAniversario = fechaAniversario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public LocalDateTime getFechaAniversario() {
		return fechaAniversario;
	}

	public void setFechaAniversario(LocalDateTime fechaAniversario) {
		this.fechaAniversario = fechaAniversario;
	}

	@Override
	public String toString() {
		return "ParejaDTO [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", carrera=" + carrera
				+ ", fechaAniversario=" + fechaAniversario + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(carrera, edad, fechaAniversario, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParejaDTO other = (ParejaDTO) obj;
		return Objects.equals(carrera, other.carrera) && edad == other.edad
				&& Objects.equals(fechaAniversario, other.fechaAniversario) && id == other.id
				&& Objects.equals(nombre, other.nombre);
	}
}
