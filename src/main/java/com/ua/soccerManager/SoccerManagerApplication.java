package com.ua.soccerManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ua.soccerManager.utils.FillBase;

@SpringBootApplication
public class SoccerManagerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SoccerManagerApplication.class, args);
		FillBase.FillBaseWithValues(context);
	}

}
