package co.edu.unbosque.miprimerspring.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.google.gson.Gson;

import co.edu.unbosque.miprimerspring.dto.JokeDTO;
import co.edu.unbosque.miprimerspring.dto.JokeMulDTO;

public class ExternalHTTPRequestHandler {

	private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder() // Constante
			.version(Version.HTTP_2).connectTimeout(Duration.ofSeconds(2)).build(); // va empazar a hacer solicitudesm
																					// con diferentes caracteristicas,
																					// la version y la duracion d el

	/*
	 * funcion que me pertmite hacer solicitudes de tipo GET opcion 1: agregar
	 * opciones a la URL opcion 2: La url base y endpoint y se concatenan Los
	 * cabelzales son informacoin estra que s emandan en la sollicitudes, puedo se
	 * mas espesifico en la filtracion de solicitudes se puede indicar cuale
	 * slcientes pueden utilizar y cuales no. se puedes hacer autenticaciones, como
	 * par amodos admin para negar solicitudes por rango
	 */
	public static String doGet(String url) {
		HttpRequest solicitud = HttpRequest.newBuilder().GET().uri(URI.create(url))
				.setHeader("User-Agent", "Java 11 HttpClient Bot").build();

		HttpResponse<String> respuesta = null;
		
		try {
			respuesta = HTTP_CLIENT.send(solicitud, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("status code -> " + respuesta.statusCode());	
		return respuesta.body();
	}
	
	
	public static JokeDTO doGetJokeDTO(String url) {
		HttpRequest solicitud = HttpRequest.newBuilder().GET().uri(URI.create(url))
				.setHeader("User-Agent", "Java 11 HttpClient Bot").build();

		HttpResponse<String> respuesta = null;
		
		try {
			respuesta = HTTP_CLIENT.send(solicitud, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("status code -> " + respuesta.statusCode());
		
		Gson gson = new Gson();
		return gson.fromJson(respuesta.body(), JokeDTO.class);
	}
	
	public static JokeMulDTO doGetMuJokeMulDTO (String url) {
		HttpRequest solicitud = HttpRequest.newBuilder().GET().uri(URI.create(url))
				.setHeader("User-Agent", "Java 11 HttpClient Bot").build();
		
		HttpResponse<String> respuesta = null;
		
		try {
			respuesta = HTTP_CLIENT.send(solicitud, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e){
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("status code -> " + respuesta.statusCode());
		Gson gson = new Gson();
		return gson.fromJson(respuesta.body(), JokeMulDTO.class);		
	} 
	
	
	
	public static void main(String[] args) {
		JokeDTO chiste = doGetJokeDTO("https://v2.jokeapi.dev/joke/Programming?lang=es&blacklistFlags=religious,political&amount=2");
		System.out.println(chiste.toString());
		
		JokeMulDTO chistes = doGetMuJokeMulDTO("https://v2.jokeapi.dev/joke/Programming?lang=es&blacklistFlags=religious,political&amount=2");
		System.out.println(chistes.toString());
	}
}
