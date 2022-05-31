package br.com.seniorlabschallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SeniorlabsChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeniorlabsChallengeApplication.class, args);
	}

}
