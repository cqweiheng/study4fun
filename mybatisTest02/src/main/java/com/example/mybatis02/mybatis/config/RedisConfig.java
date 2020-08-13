package com.example.mybatis02.mybatis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * redis配置
 * @date 2020/6/27 16:29
 * @author wei.heng
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

	@Autowired
	RedisConnectionFactory redisConnectionFactory;

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
		return new RedisCacheManager(RedisCacheWriter.lockingRedisCacheWriter(redisConnectionFactory)
			// 默认失效时间
			, this.getRedisCacheConfigurationWithTtl(3600 * 24)
			, this.getRedisCacheConfigurationMap());
	}

	private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer seconds) {
		return RedisCacheConfiguration.defaultCacheConfig()
			.serializeKeysWith(RedisSerializationContext.SerializationPair
				.fromSerializer(new Jackson2JsonRedisSerializer<>(String.class)))
			.serializeValuesWith(RedisSerializationContext.SerializationPair
				.fromSerializer(new Jackson2JsonRedisSerializer<>(Object.class)))
			.entryTtl(Duration.ofSeconds(seconds));

	}

	/**
	 *
	 * 指定失效时间
	 * @return java.util.Map<java.lang.String,org.springframework.data.redis.cache.RedisCacheConfiguration>
	 * @date 2020/6/27 16:30
	 * @author wei.heng
	 */
	private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {
		Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
		redisCacheConfigurationMap.put("short_cache", this.getRedisCacheConfigurationWithTtl(30));
		redisCacheConfigurationMap.put("long_cache", this.getRedisCacheConfigurationWithTtl(60));
		return redisCacheConfigurationMap;

	}

}
