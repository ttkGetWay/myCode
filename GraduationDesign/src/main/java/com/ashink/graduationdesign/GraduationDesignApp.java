package com.ashink.graduationdesign;

import com.ashink.graduationdesign.util.SpringContextUtil;
import javafx.application.Application;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.ashink.graduationdesign.mapper")
@EnableScheduling
public class GraduationDesignApp {

    public static void main(String[] args) {
//        SpringApplication.run(GraduationDesignApp.class, args);
        ApplicationContext context = new SpringApplicationBuilder(GraduationDesignApp.class).web(WebApplicationType.NONE).run(args);
        new SpringContextUtil().setApplicationContext(context);
        Application.launch(App.class,args);
    }

}
