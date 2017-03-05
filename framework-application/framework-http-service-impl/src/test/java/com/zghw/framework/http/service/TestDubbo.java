package com.zghw.framework.http.service;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zghw.framework.common.util.JsonUtil;
import com.zghw.framework.http.service.api.internal.IBaseService;
import com.zghw.framework.object.dto.Result;

public class TestDubbo {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("spring.xml");
		 IBaseService baseService=(IBaseService)context.getBean("baseService");
        context.start ();
        Result result=baseService.getInfoToResult();
        System.out.println("======>>>>"+JsonUtil.resultToJson(result));
        System.in.read ();
       
	}

}
