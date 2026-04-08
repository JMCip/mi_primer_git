package co.edu.unbosque.miprimerspring.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.miprimerspring.entity.Pareja;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;


public interface ParejaRepository extends CrudRepository<Pareja, Long>{
	
	public Optional<List<Pareja>> findByNombre(String nombre); 
	public Optional<List<Pareja>> findByEdad (int edad); 
	public Optional<List<Pareja>> findByCarrera(String carrera);
	public Optional<List<Pareja>> findByFechaAniversario(LocalDateTime fechaAniversario);
	
	
}
