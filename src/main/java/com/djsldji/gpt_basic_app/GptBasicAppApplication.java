package com.djsldji.gpt_basic_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GptBasicAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GptBasicAppApplication.class, args);
		InitHttpClient.setupAPI();
	}

}
