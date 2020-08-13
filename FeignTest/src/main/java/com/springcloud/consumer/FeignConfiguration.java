package com.springcloud.consumer;

import feign.Feign;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

	public Feign.Builder feignBuilder(){
		return Feign.builder();
	}
}
