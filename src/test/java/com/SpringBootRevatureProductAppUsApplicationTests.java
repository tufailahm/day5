package com;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SpringBootRevatureProductAppUsApplicationTests {

	@LocalServerPort
	private String port;

	@Autowired
	private RestTemplate restTemplate;

	private String restAPIURL = "http://localhost";

	@Test
	@DisplayName("Testing home")
	public void contextLoads() throws MalformedURLException {

		URL url = new URL(restAPIURL + ":" + port);

		ResponseEntity<String> response = restTemplate.getForEntity(url.toString(), String.class);

		assertEquals("Welcome To Revature", response.getBody());

	}

	@Test
	@DisplayName("Testing message")
	public void testMessageAPI() throws MalformedURLException {
		String expected = "-- Revature Training App --";

		URL url = new URL(restAPIURL + ":" + port + "/message");

		ResponseEntity<String> response = restTemplate.getForEntity(url.toString(), String.class);

		assertEquals(expected, response.getBody());
	}

}
