package com.dhsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Sample application for demonstrating security with JWT Tokens
 * 
 * @author dh-software-team
 *
 * Aug 3, 2016
 */
@SpringBootApplication
@EnableConfigurationProperties
public class SpringbootSecurityJwtApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityJwtApplication.class, args);
	}
}
