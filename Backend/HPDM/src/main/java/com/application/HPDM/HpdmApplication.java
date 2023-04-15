package com.application.HPDM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HpdmApplication {
	public static void main(String[] args) {
		SpringApplication.run(HpdmApplication.class, args);
	}
}
