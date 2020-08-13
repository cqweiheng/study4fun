package com.productconsumer.consumer;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @date 2020/7/27 16:56
 * @author wei.heng
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableCircuitBreaker
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

//	/**
//	 *
//	 * 配置消费端的负载均衡策略
//	 * @return com.netflix.loadbalancer.RandomRule
//	 * @date 2020/7/27 17:38
//	 * @author wei.heng
//	 */
//	@Bean
//	public RandomRule randomRule() {
//		return new RandomRule();
//	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
