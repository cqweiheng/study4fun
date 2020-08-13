package com.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @date 2020/7/25 12:12
 * @author wei.heng
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer01Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer01Application.class, args);
	}

}
