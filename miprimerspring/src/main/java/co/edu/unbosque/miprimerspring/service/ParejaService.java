package co.edu.unbosque.miprimerspring.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.miprimerspring.dto.ParejaDTO;
import co.edu.unbosque.miprimerspring.entity.Pareja;
import co.edu.unbosque.miprimerspring.repository.ParejaRepository;

@Service
public class ParejaService implements CRUDoperation<ParejaDTO>{
	
	@Autowired //El springboot la autoinicializar el objeto
	private ParejaRepository parejaRep;
	
	@Autowired
	private ModelMapper mapper;
	
	public ParejaService () {
		
	}
	
	

	@Override
	public int create(ParejaDTO data) { 
		Pareja entity = mapper.map(data, Pareja.class);
		parejaRep.save(entity);
		return 0;
	}

	@Override
	public List<ParejaDTO> getAll() {
		List<Pareja> entityList = (List<Pareja>)parejaRep.findAll();
		List<ParejaDTO> dtoList = new ArrayList<>();
		//Funciones lamdba, son anominas y autocompletan codigo
		entityList.forEach((entity) -> {
			ParejaDTO dto = mapper.map(entity, ParejaDTO.class);
			dtoList.add(dto);
		});
		return dtoList;
	}

	@Override
	public int delateById(Long id) {
		Optional<Pareja> encontrado = parejaRep.findById(id); 
		
		if(encontrado.isPresent()) {
			parejaRep.delete (encontrado.get());
			return 0;
		}
		return 1;
	}

	@Override
	public int updateById(Long id, ParejaDTO data) {
	    Optional<Pareja> encontrado = parejaRep.findById(id);
	    if (encontrado.isPresent()) {
	        Pareja temp = encontrado.get(); 
	        mapper.map(data, temp);  
	        temp.setId(id); 
	        parejaRep.save(temp);         
	        return 0;
	    }
	    return 1;
	}


	@Override
	public long count() {		
		return parejaRep.count();
	}

	@Override
	public boolean exist(Long id) {	
		return parejaRep.existsById(id)? true:false;
	}
	
	public List<ParejaDTO> findByNombre (String nombre) {
		Optional <List<Pareja>> encontrados = parejaRep.findByNombre(nombre);
		
		if (encontrados.isPresent() && !encontrados.get().isEmpty() ) {
			List<Pareja> entityList = encontrados.get();
			List<ParejaDTO> dtoList = new ArrayList<>();
			
			entityList.forEach((entity) -> {
				ParejaDTO dto = mapper.map(entity, ParejaDTO.class);
				dtoList.add(dto);
			});
			return dtoList;
			
		} else {
			return new ArrayList<ParejaDTO>(); // retorno una losta vacia para que no se rompa todo
		}	
	}
	
	
	public List<ParejaDTO> findByEdad (int edad) {
		Optional <List<Pareja>> encontrados = parejaRep.findByEdad(edad);
		
		if (encontrados.isPresent() && !encontrados.get().isEmpty() ) {
			List<Pareja> entityList = encontrados.get();
			List<ParejaDTO> dtoList = new ArrayList<>();
			
			entityList.forEach((entity) -> {
				ParejaDTO dto = mapper.map(entity, ParejaDTO.class);
				dtoList.add(dto);
			});
			return dtoList;
			
		} else {
			return new ArrayList<ParejaDTO>(); // retorno una losta vacia para que no se rompa todo
		}	
	}
	
	
	public List<ParejaDTO> findByCarrera (String carrera) {
		Optional <List<Pareja>> encontrados = parejaRep.findByCarrera(carrera);
		
		if (encontrados.isPresent() && !encontrados.get().isEmpty() ) {
			List<Pareja> entityList = encontrados.get();
			List<ParejaDTO> dtoList = new ArrayList<>();
			
			entityList.forEach((entity) -> {
				ParejaDTO dto = mapper.map(entity, ParejaDTO.class);
				dtoList.add(dto);
			});
			return dtoList;
			
		} else {
			return new ArrayList<ParejaDTO>(); // retorno una losta vacia para que no se rompa todo
		}	
	}
	
	
	public List<ParejaDTO> findByFecha (LocalDateTime fecha) {
		Optional <List<Pareja>> encontrados = parejaRep.findByFechaAniversario(fecha);
		
		if (encontrados.isPresent() && !encontrados.get().isEmpty() ) {
			List<Pareja> entityList = encontrados.get();
			List<ParejaDTO> dtoList = new ArrayList<>();
			
			entityList.forEach((entity) -> {
				ParejaDTO dto = mapper.map(entity, ParejaDTO.class);
				dtoList.add(dto);
			});
			return dtoList;
			
		} else {
			return new ArrayList<ParejaDTO>(); // retorno una losta vacia para que no se rompa todo
		}	
	}
}
