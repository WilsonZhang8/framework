package com.zghw.framework.test.open.api;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zghw.framework.open.api.module.base.BaseController;

public class TestChain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("spring.xml");
		context.start ();
        BaseController bc=context.getBean(BaseController.class);
        bc.getInfo();
        try {
            System.in.read ();
        } catch (IOException e) {
            e.printStackTrace ();
        }// 按任意键退出
	}

}
