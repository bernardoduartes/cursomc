package com.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursomc.services.DBService;
import com.cursomc.services.EmailService;
import com.cursomc.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevProfileConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instatiateDataBase () throws ParseException {
		
		if(!strategy.equalsIgnoreCase("create"))
			return false;
		
		dbService.instatiateTestDatabase();
		
		return true;
	}
	
	@Bean
	public EmailService emailService ()  {
		return new SmtpEmailService();
	}
}
