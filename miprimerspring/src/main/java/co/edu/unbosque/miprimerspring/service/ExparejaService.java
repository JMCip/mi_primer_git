package co.edu.unbosque.miprimerspring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.miprimerspring.dto.ExparejaDTO;
import co.edu.unbosque.miprimerspring.dto.ParejaDTO;
import co.edu.unbosque.miprimerspring.entity.Expareja;
import co.edu.unbosque.miprimerspring.entity.Pareja;
import co.edu.unbosque.miprimerspring.repository.ExparejaRepository;
import jakarta.transaction.Transactional;

@Service
public class ExparejaService implements CRUDoperation<ExparejaDTO> {

	@Autowired // El springboot la autoinicializar el objeto
	private ExparejaRepository exparejaRepo;

	@Autowired
	private ModelMapper mapper;

	public ExparejaService() {

	}

	@Override
	public int create(ExparejaDTO data) {
		Expareja entity = mapper.map(data, Expareja.class);
		exparejaRepo.save(entity);
		return 0;
	}

	@Override
	public List<ExparejaDTO> getAll() {
		List<Expareja> entityList = (List<Expareja>) exparejaRepo.findAll();
		List<ExparejaDTO> dtoList = new ArrayList<>();

		entityList.forEach((entity) -> {
			ExparejaDTO dto = mapper.map(entity, ExparejaDTO.class);
			dtoList.add(dto);
		});
		return dtoList;
	}

	@Override
	public int delateById(Long id) {
		Optional<Expareja> encontrado = exparejaRepo.findById(id);

		if (encontrado.isPresent()) {
			exparejaRepo.delete(encontrado.get());
			return 0;
		}
		return 1;
	}

	@Override
	public long count() {
		return exparejaRepo.count();
	}

	@Override
	public boolean exist(Long id) {
		return exparejaRepo.existsById(id) ? true : false;
	}

	@Override
	public int updateById(Long id, ExparejaDTO data) {
		Optional<Expareja> encontrado = exparejaRepo.findById(id);
		if (encontrado.isPresent()) {
			Expareja temp = encontrado.get();
			mapper.map(data, temp);
			temp.setId(id); // restauramos el id original después del map
			exparejaRepo.save(temp);
			return 0;
		}
		return 1;
	}

	public List<ExparejaDTO> findByNombre(String Nombre) {
		Optional<List<Expareja>> encontrados = exparejaRepo.findByNombre(Nombre);

		if (encontrados.isPresent() && !encontrados.get().isEmpty()) {
			List<Expareja> entityList = encontrados.get();
			List<ExparejaDTO> dtoList = new ArrayList<>();

			entityList.forEach((entity) -> {
				ExparejaDTO dto = mapper.map(entity, ExparejaDTO.class);
				dtoList.add(dto);

			});

			return dtoList;
		} else {
			return new ArrayList<ExparejaDTO>();
		}
	}
	
	@Transactional
	public List<ExparejaDTO> deleteByNombre(String nombre) {
		Optional<List<Expareja>> encontrados = exparejaRepo.findByNombre(nombre);

		if (encontrados.isPresent() && !encontrados.get().isEmpty()) {
			List<Expareja> entityList = encontrados.get();
			List<ExparejaDTO> dtoList = new ArrayList<>();

			entityList.forEach((entity) -> {
				ExparejaDTO dto = mapper.map(entity, ExparejaDTO.class);
				dtoList.add(dto);
			});
			
			exparejaRepo.deleteByNombre(nombre);
			return dtoList;

		} else {
			return new ArrayList<ExparejaDTO>();
		}

	}

}
