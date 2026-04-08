package co.edu.unbosque.miprimerspring.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.miprimerspring.dto.ParejaDTO;
import co.edu.unbosque.miprimerspring.service.ParejaService;

@RestController
@RequestMapping("/pareja")
@CrossOrigin(origins = { "http://localhost:8080", "*" })
public class ParejaController {

	@Autowired
	private ParejaService parejaSer;

	public ParejaController() {

	}

	@PostMapping("/crear")
	public ResponseEntity<String> crearPareja(@RequestParam String nombre, @RequestParam int edad,
			@RequestParam String carrera, @RequestParam LocalDateTime fechaAniversario) {

		ParejaDTO nuevo = new ParejaDTO(nombre, edad, carrera, fechaAniversario);
		int status = parejaSer.create(nuevo);
		if (status == 0) {
			return new ResponseEntity<>("Dato creado con exito", HttpStatus.CREATED);// dentro del parenticis va el //
																						// codigo de estado y el cuerpo																					// // de la respuesta
		} else {
			return new ResponseEntity<>("Error al crear pareja", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/eliminar")
	public ResponseEntity<String> eliminarPareja(@RequestParam long id) {
		int eliminar = parejaSer.delateById(id);

		if (eliminar == 0) {
			return new ResponseEntity<>("Dato eliminado con exito", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("Error al eliminar pareja", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/actualizar")
	public ResponseEntity<String> actualziarPareja(@RequestParam long id, @RequestParam String nombre,
			@RequestParam int edad, @RequestParam String carrera, @RequestParam LocalDateTime fechaAniversario) {

		ParejaDTO nueva = new ParejaDTO(nombre, edad, carrera, fechaAniversario);
		int actualizar = parejaSer.updateById(id, nueva);

		if (actualizar == 0) {
			return new ResponseEntity<>("Dato actualizado con exito", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("Error al actualziar pareja", HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/mostrar")
	public ResponseEntity<List<ParejaDTO>> mostrarTodo() {

		List<ParejaDTO> parejas = parejaSer.getAll();
		if (parejas.isEmpty()) {
			return new ResponseEntity<List<ParejaDTO>>(parejas, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ParejaDTO>>(parejas, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/buscarpornombre")
	public ResponseEntity<List<ParejaDTO>> encontrarNombre(@RequestParam String nombre) {

		List<ParejaDTO> par = parejaSer.findByNombre(nombre);

		if (par.isEmpty()) {
			return new ResponseEntity<List<ParejaDTO>>(par, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ParejaDTO>>(par, HttpStatus.ACCEPTED);
		}

	}

	@GetMapping("/buscarporedad")
	public ResponseEntity<List<ParejaDTO>> encontrarEdad(@RequestParam int edad) {

		List<ParejaDTO> par = parejaSer.findByEdad(edad);

		if (par.isEmpty()) {
			return new ResponseEntity<List<ParejaDTO>>(par, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ParejaDTO>>(par, HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/buscarporcarrera")
	public ResponseEntity<List<ParejaDTO>> encontrarCarrera(@RequestParam String carrera) {

		List<ParejaDTO> par = parejaSer.findByCarrera(carrera);

		if (par.isEmpty()) {
			return new ResponseEntity<List<ParejaDTO>>(par, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ParejaDTO>>(par, HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/buscarporfecha")
	public ResponseEntity<List<ParejaDTO>> encontrarFecha(@RequestParam LocalDateTime fecha) {

		List<ParejaDTO> par = parejaSer.findByFecha(fecha);

		if (par.isEmpty()) {
			return new ResponseEntity<List<ParejaDTO>>(par, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ParejaDTO>>(par, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/contar")
	public String contar() {
		return ("Total de parejas: " + parejaSer.count());
	}

	@PostMapping("/existe")
	public Boolean existe(long id) {
		return parejaSer.exist(id);
	}

}
