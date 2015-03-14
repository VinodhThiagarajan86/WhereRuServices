package com.hack.whereru

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer
import org.springframework.context.annotation.Configuration
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer
import org.springframework.context.annotation.Configuration
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.ComponentScan;

@Configuration
@EnableAutoConfiguration
@ComponentScan('com.hack.whereru')

class Application extends SpringBootServletInitializer{

	static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(Application.class, args)
		//this.log.info('Starting up SpringBoot application')
		ctx.beanDefinitionNames.sort { it }.each {
			//this.log.info(it)
		}
		
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}