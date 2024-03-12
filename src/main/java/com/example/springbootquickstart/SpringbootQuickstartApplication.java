//SpringbootQuickstartApplication.java

package com.example.springbootquickstart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//启动类
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.example.springbootquickstart.mapper")
public class SpringbootQuickstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootQuickstartApplication.class, args);
    }

}
