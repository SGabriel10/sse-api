package com.api.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:api.properties")
public class Setting {
    public static int PAGE_SIZE;

    @Value("${page.size}")
    public void setPAGE_SIZE(int size) {
        PAGE_SIZE = size;
    }
}