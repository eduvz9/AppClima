package com.clima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.clima.model.ClimaModel;
import com.clima.service.ClimaService;

import java.util.Map;

@RestController
public class ClimaController {
	private final ClimaService weatherService = new ClimaService();

	@GetMapping("/weather")
	public Object getWeather(@RequestParam double lat, @RequestParam double lon) {
		ClimaModel response = weatherService.getWeather(lat, lon);
		if (response == null) {
			return Map.of("error", "No se puede obtener el clima. Revisa coordenadas o conexión.");
		}
		return response;
	}
}