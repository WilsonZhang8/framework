package com.zghw.framework.open.api.module.base;

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
import com.zghw.framework.object.dto.Result;
import com.zghw.framework.open.api.module.ChainHandler;

@Controller
@RequestMapping("open/base")
public class BaseController {
	public static Logger logger = LoggerFactory.getLogger(BaseController.class);

	private Chain chain_A1_BASE_001;// 接口A1_BASE_001
	private Chain chain_A1_BASE_002;// 接口A1_BASE_002
	// 引入处理器
	private ChainHandler handler;

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

		// 创建值栈
		ValueStack valueStack = new ValueStack();
		// request请求放入值栈中
		valueStack.setValue(ChainConstant.REQUEST, request);
		// 处理结果
		Result result = handler.handle(chain_A1_BASE_001, valueStack);
		return result;
	}

	/**
	 * 冻结会员接口A1_BASE_002
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/freezeMember")
	public @ResponseBody Result freezeMember(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		// 创建值栈
		ValueStack valueStack = new ValueStack();
		// request请求放入值栈中
		valueStack.setValue(ChainConstant.REQUEST, request);
		// 处理结果
		Result result = handler.handle(chain_A1_BASE_002, valueStack);
		return result;
	}

	@Autowired
	public void setChain_A1_BASE_001(@Qualifier("chain_A1_BASE_001") Chain chain_A1_BASE_001) {
		this.chain_A1_BASE_001 = chain_A1_BASE_001;
	}

	@Autowired
	public void setChain_A1_BASE_002(@Qualifier("chain_A1_BASE_002") Chain chain_A1_BASE_002) {
		this.chain_A1_BASE_002 = chain_A1_BASE_002;
	}

	@Autowired
	public void setHandler(ChainHandler handler) {
		this.handler = handler;
	}

}
