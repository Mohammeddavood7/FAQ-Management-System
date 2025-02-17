package com.faq.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableCaching
public class FaqManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(FaqManagementSystemApplication.class, args);
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("faqs");
    }
}
