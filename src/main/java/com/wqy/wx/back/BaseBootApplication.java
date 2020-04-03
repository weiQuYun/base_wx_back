package com.wqy.wx.back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@MapperScan("com.wqy.wx.back")
@SpringBootApplication
@ServletComponentScan("com.wqy.wx.back")
public class BaseBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseBootApplication.class, args);
        System.out.println("==========启动成功 ！=======");
    }

}
