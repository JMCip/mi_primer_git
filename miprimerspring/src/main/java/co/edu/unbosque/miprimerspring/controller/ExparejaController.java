package co.edu.unbosque.miprimerspring.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.miprimerspring.dto.ExparejaDTO;
import co.edu.unbosque.miprimerspring.dto.ParejaDTO;
import co.edu.unbosque.miprimerspring.service.ExparejaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController 
@RequestMapping("/expareja")
@CrossOrigin(origins = { "http://localhost:8080", "*" })
public class ExparejaController {

	@Autowired
	private ExparejaService exparejaSer;

	public ExparejaController() {

	}

	@PostMapping("/crear")
	public ResponseEntity<String> crearExpareja(@RequestParam String nombre, @RequestParam int edad,
			@RequestParam LocalDateTime fechaNacimineto, @RequestParam LocalDateTime fechaRuptura,
			@RequestParam String motivo) {

		ExparejaDTO nuevo = new ExparejaDTO (nombre, edad, fechaNacimineto, fechaRuptura, motivo);
		int status = exparejaSer.create(nuevo);
		
		if (status == 0) {
			return new ResponseEntity<>("Dato creado con exito", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Error al crear expareja", HttpStatus.BAD_REQUEST);
		}	
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<String> eliminarExpareja (@RequestParam long id) {
		int busqueda = exparejaSer.delateById(id);
		
		if (busqueda == 0) {
			return new ResponseEntity<>("Dato eliminado con exito", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("No se encontro el id", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<String> actualizarExpareja (@RequestParam long id, String nombre, @RequestParam int edad,
			@RequestParam LocalDateTime fechaNacimineto, @RequestParam LocalDateTime fechaRuptura,
			@RequestParam String motivo) {
		
		ExparejaDTO actualizar = new ExparejaDTO (nombre, edad, fechaNacimineto, fechaRuptura, motivo);
		int busqueda = exparejaSer.updateById(id, actualizar);
		
		if (busqueda == 0) {
			return new ResponseEntity<>("Dato actualizado con exito", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("No se encontro el id", HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/mostrar")
	public ResponseEntity<List<ExparejaDTO>> mostrarTodo () {
		
		List<ExparejaDTO> exparejas = exparejaSer.getAll();
		
		if (exparejas.isEmpty()) {
			return new ResponseEntity <List<ExparejaDTO>> (exparejas, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity <List<ExparejaDTO>> (exparejas, HttpStatus.ACCEPTED);
		}
	}	
	
	@GetMapping("/cantidad")
	public long contar () {
		long exparejas = exparejaSer.count();
		return exparejas;
	}
	
	@PostMapping("/existe")
	public boolean existe (long id) {
		boolean exparejas = exparejaSer.exist(id);
		return exparejas;
	}
	
	@GetMapping("/buscarpornombre")
	public ResponseEntity<List<ExparejaDTO>> encontrarNombre (@RequestParam String nombre) {
		
		List<ExparejaDTO> par = exparejaSer.findByNombre(nombre);
		
		if (par.isEmpty()) {
			return new ResponseEntity<List<ExparejaDTO>>(par, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ExparejaDTO>>(par, HttpStatus.ACCEPTED);
		}
	}
	
	@DeleteMapping("/eliminarpornombre")
	public ResponseEntity<List<ExparejaDTO>> eliminarNombre (@RequestParam String nombre) {
		List<ExparejaDTO> eliminados = exparejaSer.deleteByNombre(nombre);
		
		if (eliminados.isEmpty()) {
			return new ResponseEntity<>(eliminados, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(eliminados, HttpStatus.OK);
		}
	}
}
