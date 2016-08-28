package com.zghw.framework.http.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zghw.framework.common.util.JsonUtil;
import com.zghw.framework.entity.open.api.dto.simple.PersonInfo;
import com.zghw.framework.http.service.api.internal.IBaseService;
import com.zghw.framework.http.service.api.internal.ISimpleService;
import com.zghw.framework.object.dto.Result;

public class TestSimpleService {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("spring.xml");
        context.start ();
        ISimpleService simpleService=(ISimpleService)context.getBean("simpleService");
        PersonInfo personInfo = new PersonInfo();
        personInfo.setIdType("身份证");
        personInfo.setIdNo("4110241989021516xx");
        personInfo.setName("张红伟");
        personInfo.setTelphone("13699120xxx");
        List<String> hobby = new ArrayList<String>();
        hobby.add("音乐");
        hobby.add("象棋");
        hobby.add("游泳");
        hobby.add("跑步");
        String dataDTO=JsonUtil.json(personInfo);
        Result result=simpleService.registerToResult(dataDTO);
        System.out.println("======>>>>"+JsonUtil.resultToJson(result));
        System.in.read ();
       
	}

}
