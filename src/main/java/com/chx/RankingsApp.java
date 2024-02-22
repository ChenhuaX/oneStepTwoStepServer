package com.chx;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//启动类
@SpringBootApplication
public class RankingsApp {
    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(RankingsApp.class, args);
    }
}
