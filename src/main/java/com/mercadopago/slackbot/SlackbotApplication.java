package com.mercadopago.slackbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot", "com.mercadopago"})
public class SlackbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlackbotApplication.class, args);
	}
}
