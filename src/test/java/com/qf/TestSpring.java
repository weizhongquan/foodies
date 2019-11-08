package com.qf;

import com.qf.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void run(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
        // 获取对象
        AccountService as = (AccountService) ac.getBean("accountService");
        // 调用方法
        as.findAll();
        /*for (Account account : accounts) {
            System.out.println(account);
        }*/
    }

}