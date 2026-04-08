package co.edu.unbosque.miprimerspring.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.miprimerspring.entity.Expareja;


public interface ExparejaRepository extends CrudRepository<Expareja, Long>{
	
	public Optional<List<Expareja>> findByNombre(String nombre);
	public void deleteByNombre(String nombre);
	
	
}
