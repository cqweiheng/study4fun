package com.example.mybatis02.mybatis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class AyncConfig implements AsyncConfigurer {

	private Logger logger = LoggerFactory.getLogger(AyncConfig.class);

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(10);
		taskExecutor.setMaxPoolSize(30);
		taskExecutor.setQueueCapacity(2000);
		// 等待任务在关机时完成--表明等待所有线程执行完
		taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		// 15分钟未完成，强行终止
		taskExecutor.setAwaitTerminationSeconds(60 * 15);
		taskExecutor.setThreadNamePrefix("MyAsync-");
		taskExecutor.initialize();
		return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// implements AsyncUncaughtExceptionHandler
		return (throwable, method, objects)->{
			System.out.println("==========异步线程异常捕获");
			logger.info("Exception message - " + throwable.getMessage());
			logger.info("Method name - " + method.getName());
			for (Object param : objects) {
				logger.info("Parameter value - " + param);
			}
		};
	}
}
