package com.megamaker.springwebsocketchat;

import com.megamaker.springwebsocketchat.config.WebSocketConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(WebSocketConfig.class)
@SpringBootApplication(scanBasePackages = "com.megamaker.springwebsocketchat.controller")
public class SpringwebsocketchatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringwebsocketchatApplication.class, args);
	}

}
