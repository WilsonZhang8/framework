package com.zghw.framework.open.api.module.base;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.zghw.framework.chain.Chain;
import com.zghw.framework.chain.ChainConstant;
import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.entity.common.Result;
import com.zghw.framework.entity.common.ResultBuilder;

@Controller
@RequestMapping("open/base")
public class BaseController {
	private Logger logger = LogManager.getLogger(this.getClass());
	private Chain chain_A1_BASE_001;// 接口A1_BASE_001

	/**
	 * 得到信息 接口A1_BASE_001
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/getInfo")
	public @ResponseBody Result getInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ValueStack valueStack = new ValueStack();
		valueStack.setValue(ChainConstant.REQUEST, request);
		try {
			chain_A1_BASE_001.doChain(valueStack);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultBuilder.buildError(e.getMessage(), valueStack.getValue(ChainConstant.DATA));
		}
		Result result= (Result) valueStack.getValue(ChainConstant.RESULT);
		return result;
	}

	@Autowired
	public void setChain_A1_BASE_001(@Qualifier("chain_A1_BASE_001") Chain chain_A1_BASE_001) {
		this.chain_A1_BASE_001 = chain_A1_BASE_001;
	}
}
