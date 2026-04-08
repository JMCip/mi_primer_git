package co.edu.unbosque.miprimerspring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

//triene l a funcion de conectar con la URL

@RestController // indica que esta clase tiene capacidad se conecta con una api
@RequestMapping("/primerapi") // Mapeo de las solicitudes --> url del endpoint --> siempre en minuscula
@CrossOrigin(origins = { "http://localhost:8080", "*" }) // seguridad--> se indica desde que origenes se puede ahcer
															// solicitudes al aplicatibos, quie se va conectar, s eusa
															// con un arrglos para ocnectar con arios fronts
//SI YA VOY  AMONTARLO PARA E USUARIO DEBO MODIFICAR EL CROSSORIGIN
public class PrimerApiRestController {

	@GetMapping("/saludar")
	public String getSaludar() {
		return "Buenos dias";
	}
	
	@GetMapping("/saludarpornombre")
	public String getSaludarPorNombre (@RequestParam String nombre) {
		return "Buenos dias " + nombre;
	}
	
	@GetMapping("sumar")
	public String getSumar(@RequestParam int num1, @RequestParam int num2) {
		int resultado=num1+num2;
		return "Restultado: " + resultado;
	}
	
	@GetMapping("resta")
	public String getResta(@RequestParam int num1, @RequestParam int num2) {
		int resultado=num1-num2;
		
		return "su resultado "+resultado;
	}
	
	@GetMapping("multiplicar")
	public String getMultiplicar(@RequestParam int num1, @RequestParam int num2) {
		int resultado=num1*num2;
		
		return "su resultado "+resultado;
	}
	
	@GetMapping("dividir")
	public String getDividir(@RequestParam int num1,@RequestParam int num2) {
		int resultado=num1/num2;
		
		return "su resultado "+resultado;
	}
	
}
