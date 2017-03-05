package com.zghw.framework.test.open.api;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zghw.framework.simple.service.api.IHelloWorldService;

public class TestDubboService {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("spring.xml");
        context.start ();
        IHelloWorldService helloWorldSerivce=(IHelloWorldService)context.getBean("helloWorldService");
        System.out.println(helloWorldSerivce.helloBase());
        try {
            System.in.read ();
        } catch (IOException e) {
            e.printStackTrace ();
        }// 按任意键退出
	}

}
