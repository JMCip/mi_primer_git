package co.edu.unbosque.miprimerspring.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "pareja")
public class Pareja {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
	private String nombre;
	private int edad;
	private String carrera;
	private LocalDateTime fechaAniversario;

	public Pareja() {
		
	}

	// siempre todos los atributos menos el id en el constructor completo
	public Pareja(String nombre, int edad, String carrera, LocalDateTime fechaAniversario) {
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
		Pareja other = (Pareja) obj;
		return Objects.equals(carrera, other.carrera) && edad == other.edad
				&& Objects.equals(fechaAniversario, other.fechaAniversario) && id == other.id
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Pareja [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", carrera=" + carrera
				+ ", fechaAniversario=" + fechaAniversario + "]";
	}
}
