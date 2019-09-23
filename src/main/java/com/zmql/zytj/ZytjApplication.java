package com.zmql.zytj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zmql.zytj.mapper")
public class ZytjApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZytjApplication.class, args);
    }

}
