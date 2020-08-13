package com.springcloud.productprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Repository;

/**
 *
 * @date 2020/7/27 16:31
 * @author wei.heng
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages={"com.springcloud.productprovider.*"}
	, annotationClass = Repository.class)
public class ProductProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductProviderApplication.class, args);
	}

}
