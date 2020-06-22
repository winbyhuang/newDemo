package com.winby.demo.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.util.Set;

@Configuration
public class RedisConfig {
    @Value("${spring.redis.host}") String host;
    @Value("${spring.redis.port}") Integer port;

    @Value("${spring.redis.sentinel.master}") String sentinelMaster;
    @Value("#{'${spring.redis.sentinel.nodes}'.split(',')}") Set<String> sentinelNodes;

    @Value("#{'${spring.redis.cluster.nodes}'.split(',')}") Set<String> clusterNodes;
    @Value("${spring.redis.cluster.max-redirects}") Integer clusterMaxRedirects;

    @Value("${spring.redis.lettuce.pool.max-active}") Integer maxTotal;
    @Value("${spring.redis.lettuce.pool.max-wait}") Long maxWaitMillis;
    @Value("${spring.redis.lettuce.pool.max-idle}") Integer maxIdle;
    @Value("${spring.redis.lettuce.pool.min-idle}") Integer minIdle;

    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericFastJsonRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        GenericObjectPoolConfig<?> defaultPoolConfig = new GenericObjectPoolConfig<>();
        defaultPoolConfig.setMaxIdle(maxIdle);
        defaultPoolConfig.setMinIdle(minIdle);
        defaultPoolConfig.setMaxTotal(maxTotal);
        defaultPoolConfig.setMaxWaitMillis(maxWaitMillis);
        LettuceClientConfiguration clientConfig = LettucePoolingClientConfiguration.builder().poolConfig(defaultPoolConfig).build();

        //单机
        RedisConfiguration redisConfig = new RedisStandaloneConfiguration(host, port);

        //哨兵
//        RedisConfiguration redisConfig = new RedisSentinelConfiguration(sentinelMaster, sentinelNodes);

        //集群
//        RedisClusterConfiguration redisConfig = new RedisClusterConfiguration(clusterNodes);
//        redisConfig.setMaxRedirects(clusterMaxRedirects);

        return new LettuceConnectionFactory(redisConfig, clientConfig);
    }
}
