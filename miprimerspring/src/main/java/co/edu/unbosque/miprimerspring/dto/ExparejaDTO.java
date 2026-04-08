package co.edu.unbosque.miprimerspring.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class ExparejaDTO {
	private Long id;
	private String nombre;
	private int edad;
	private LocalDateTime fechaNacimianto;
	private LocalDateTime fechaRuptura;
	private String motivo;
	
	
	public ExparejaDTO() {
		
	}
	
	public ExparejaDTO (String nombre, int edad, LocalDateTime fechaNacimianto, LocalDateTime fechaRuptura, String motivo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimianto = fechaNacimianto;
		this.fechaRuptura = fechaRuptura;
		this.motivo = motivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public LocalDateTime getFechaNacimianto() {
		return fechaNacimianto;
	}

	public void setFechaNacimianto(LocalDateTime fechaNacimianto) {
		this.fechaNacimianto = fechaNacimianto;
	}

	public LocalDateTime getFechaRuptura() {
		return fechaRuptura;
	}

	public void setFechaRuptura(LocalDateTime fechaRuptura) {
		this.fechaRuptura = fechaRuptura;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "ExparejaDTO [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", fechaNacimianto="
				+ fechaNacimianto + ", fechaRuptura=" + fechaRuptura + ", motivo=" + motivo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, fechaNacimianto, fechaRuptura, id, motivo, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExparejaDTO other = (ExparejaDTO) obj;
		return edad == other.edad && Objects.equals(fechaNacimianto, other.fechaNacimianto)
				&& Objects.equals(fechaRuptura, other.fechaRuptura) && Objects.equals(id, other.id)
				&& Objects.equals(motivo, other.motivo) && Objects.equals(nombre, other.nombre);
	}
}
