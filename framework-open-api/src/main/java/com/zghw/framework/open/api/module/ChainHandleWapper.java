package com.zghw.framework.open.api.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zghw.framework.chain.Chain;
import com.zghw.framework.chain.ChainConstant;
import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.object.dto.Result;
import com.zghw.framework.object.dto.ResultBuilder;
import com.zghw.framework.open.api.module.base.BaseController;

/**
 * 包装了异常处理返回结果
 * 
 * @author zghw
 *
 */
@Service
public class ChainHandleWapper implements ChainHandler {

	public static Logger logger = LoggerFactory.getLogger(BaseController.class);

	@Override
	public Result handle(Chain chain, ValueStack valueStack) {
		try {
			// 调用链条开始处理
			chain.doChain(valueStack);
		} catch (Exception e) {
			e.printStackTrace();
			// 异常日志
			Result result = ResultBuilder.buildError("服务器内部异常！", valueStack.getValue(ChainConstant.DATA));
			logger.error("处理请求出错：" + e.getMessage());
			return result;
		}
		Result result = (Result) valueStack.getValue(ChainConstant.RESULT);
		return result;
	}

}
