package com.weibo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
//import org.springframework.test.context.ActiveProfiles;

/**
 * 慕课网课程《2小时学会spring boot》
 * 课程代码
 * 2018/10/14
 */
@SpringBootApplication
//@ActiveProfiles("dev")
public class DemoApplication {

    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class, args);
    }
}
