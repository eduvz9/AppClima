package com.clima.service;

import org.springframework.web.client.RestTemplate;
import com.clima.model.ClimaModel;

public class ClimaService {
	private final String url = "https://api.open-meteo.com/v1/forecast?latitude={lat}&longitude={lon}&current_weather=true";

	public ClimaModel getWeather(double lat, double lon) {
		RestTemplate restTemplate = new RestTemplate();
		try {
			return restTemplate.getForObject(url, ClimaModel.class, lat, lon);
		} catch (Exception e) {
			System.out.println("Error al consultar Open-Meteo: " + e.getMessage());
			return null;
		}
	}
}