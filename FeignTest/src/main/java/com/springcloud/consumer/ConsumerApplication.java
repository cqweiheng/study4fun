package com.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @date 2020/7/28 10:45
 * @author wei.heng
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerApplication {

	/**
	 *
	 * 初始化 RestTemplate -  @LoadBalanced做多节点负载均衡
	 * @return org.springframework.web.client.RestTemplate
	 * @date 2020/7/27 16:57
	 * @author wei.heng
	 */
	@LoadBalanced
	@Bean(name = "restTemplate")
	public RestTemplate initRestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
