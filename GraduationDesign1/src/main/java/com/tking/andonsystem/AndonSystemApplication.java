package com.tking.andonsystem;

import com.tking.andonsystem.bean.SpringContextUtil;
import javafx.application.Application;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.tking.andonsystem.mapper")
@EnableScheduling
public class

AndonSystemApplication {

    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(AndonSystemApplication.class, args);
        ApplicationContext context = new SpringApplicationBuilder(AndonSystemApplication.class).web(WebApplicationType.NONE).run(args);
        new  SpringContextUtil().setApplicationContext(context);
        Application.launch(App.class, args);
    }


}
