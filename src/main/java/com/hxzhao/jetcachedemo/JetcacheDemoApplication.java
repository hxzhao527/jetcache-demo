package com.hxzhao.jetcachedemo;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMethodCache(basePackages = "com.hxzhao.jetcachedemo")
@EnableCreateCacheAnnotation
public class JetcacheDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JetcacheDemoApplication.class, args);
    }
}
