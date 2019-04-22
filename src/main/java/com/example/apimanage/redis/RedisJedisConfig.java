package com.example.apimanage.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableAutoConfiguration
@PropertySource(value = "classpath:application.yml")
public class RedisJedisConfig {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Bean
    public JedisPoolConfig getRedisConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }
    @Bean
    public JedisPool getJedisPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置最大10个连接
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMaxIdle(1000);
        jedisPoolConfig.setMinIdle(100);
        JedisPool pool = new JedisPool(jedisPoolConfig, host,port);
        return pool;
    }
}
