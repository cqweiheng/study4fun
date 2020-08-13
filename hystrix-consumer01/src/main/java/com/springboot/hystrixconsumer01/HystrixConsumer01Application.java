package com.springboot.hystrixconsumer01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class HystrixConsumer01Application {

	public static void main(String[] args) {
		SpringApplication.run(HystrixConsumer01Application.class, args);
	}

}
