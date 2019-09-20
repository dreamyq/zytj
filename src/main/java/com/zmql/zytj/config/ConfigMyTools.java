package com.zmql.zytj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class ConfigMyTools {
    /**
     * 格式化当前日期
     * @return
     */
    @Bean("dateFormat")
    public SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
    }
}
