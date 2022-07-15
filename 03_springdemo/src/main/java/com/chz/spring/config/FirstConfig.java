package com.chz.spring.config;


import com.chz.spring.beans.FirstBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirstConfig {

    @Bean
    public FirstBean firstBean(){
        return new FirstBean();
    }
}
