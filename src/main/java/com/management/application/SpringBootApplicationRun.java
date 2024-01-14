package com.management.application;

import org.springframework.boot.SpringApplication;  

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*
 * SQL USER : raphaelbaudry2
 * pass : 0zkhlpjvSwnt96Dw
 * 
 * https://copyprogramming.com/howto/get-column-value-onclick-html-table
 * https://stackoverflow.com/questions/11553768/remove-table-row-after-clicking-table-row-delete-button
 */
@SpringBootApplication(scanBasePackages = "com.management.*", exclude = {ErrorMvcAutoConfiguration.class, DataSourceAutoConfiguration.class})
//@EnableConfigurationProperties(CustomConfig.class)
public class SpringBootApplicationRun extends SpringBootServletInitializer {

	public static void main(String[] args) {
		 System.getProperties().put( "server.port", "8376");  // port is set here
		 SpringApplication.run(SpringBootApplicationRun.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootApplicationRun.class);
	}
}
