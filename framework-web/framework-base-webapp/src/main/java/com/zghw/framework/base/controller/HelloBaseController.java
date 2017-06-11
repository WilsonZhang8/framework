package com.zghw.framework.base.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.zghw.framework.base.service.api.IHelloBaseService;
import com.zghw.framework.common.util.StringRandom;
import com.zghw.framework.entity.base.HelloBase;

@RequestMapping("base/helloBase")
@Controller
public class HelloBaseController {
	private IHelloBaseService helloBaseService;

	@RequestMapping(value = "/save")
	public @ResponseBody String save(HttpServletRequest request) throws IOException {
		for (int i = 0; i < 10000000; i++) {
			Integer hits = new Random().nextInt(1000000);
			HelloBase helloBase = new HelloBase();
			helloBase.setName(StringRandom.getStringRandom(50) + hits);
			helloBase.setHits(hits);
			helloBase = helloBaseService.save(helloBase);
		}
		return JSON.json(null);
	}

	@Autowired
	public void setHelloBaseService(IHelloBaseService helloBaseService) {
		this.helloBaseService = helloBaseService;
	}

}
