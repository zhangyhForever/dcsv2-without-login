package com.zicms.bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.zicms")
@MapperScan("com.zicms.mapper")
public class Dcsv2WithoutLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(Dcsv2WithoutLoginApplication.class, args);
	}

}
