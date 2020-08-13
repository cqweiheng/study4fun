package com.weiheng.eurekaclient01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClient01Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient01Application.class, args);
	}

}
