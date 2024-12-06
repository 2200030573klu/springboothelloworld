package com.example.demo;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	@GetMapping("/")
	public String fun1() {
		return "client 1";
		
	}
	@GetMapping("/add/{a}/{b}")
	public String fun2 (@PathVariable("a") int a,@PathVariable("b") int b) {
		URL url;
		String result = null;
		try {
			url = new URL("http://localhost:8082/add/" + a + "/" + b);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Accept", "application/json");
			con.setUseCaches(false);
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			result = br.readLine();
		}
		catch(Exception e) {
			e.printStackTrace(); //Print errors
		}
		return result;
		
	}
	
	

}
