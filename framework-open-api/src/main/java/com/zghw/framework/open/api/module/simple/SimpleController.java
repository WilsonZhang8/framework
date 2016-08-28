package com.zghw.framework.open.api.module.simple;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zghw.framework.chain.Chain;
import com.zghw.framework.chain.ChainConstant;
import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.entity.open.api.dto.simple.PersonInfo;
import com.zghw.framework.object.dto.Result;
import com.zghw.framework.open.api.module.ChainHandler;
import com.zghw.framework.open.api.module.base.BaseController;

@Controller
@RequestMapping("open/simple")
public class SimpleController {
	public static Logger logger = LoggerFactory.getLogger(BaseController.class);

	private Chain chain_A1_SIMPLE_001;// 接口A1_SIMPLE_001
	// 引入处理器
	private ChainHandler handler;

	/**
	 * 接口A1_SIMPLE_001
	 * http://localhost:8089/framework-open-api/open/simple/register?data={"idType":"身份证","idNo":"411024198902151655","name":"zhanghongwei","hobby":["音乐","象棋","跑步"]}
	 */
	@RequestMapping("/register")
	public @ResponseBody Result register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ValueStack valueStack = new ValueStack();
		valueStack.setValue(ChainConstant.REQUEST, request);
		valueStack.setValue(ChainConstant.CLASS_TYPE, PersonInfo.class);
		Result result = handler.handle(chain_A1_SIMPLE_001, valueStack);
		return result;
	}

	@Autowired
	public void setChain_A1_SIMPLE_001(@Qualifier("chain_A1_SIMPLE_001") Chain chain_A1_SIMPLE_001) {
		this.chain_A1_SIMPLE_001 = chain_A1_SIMPLE_001;
	}

	@Autowired
	public void setHandler(ChainHandler handler) {
		this.handler = handler;
	}
}
