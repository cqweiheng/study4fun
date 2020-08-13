package com.springcloud.eurekaserver;

import org.aspectj.weaver.ast.Var;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverApplication.class, args);
	}

}
