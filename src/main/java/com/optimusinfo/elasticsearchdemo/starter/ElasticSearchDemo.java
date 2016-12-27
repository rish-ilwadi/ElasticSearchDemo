package com.optimusinfo.elasticsearchdemo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.optimusinfo.elasticsearchdemo")
public class ElasticSearchDemo {

	public static void main(String[] args) {
		SpringApplication.run(ElasticSearchDemo.class, args);
	}
}
