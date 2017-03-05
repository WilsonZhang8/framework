package com.zghw.framework.open.api.module;

import com.zghw.framework.chain.Chain;
import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.object.dto.Result;

/**
 * 对Chain处理过程的预处理、后处理、异常处理等操作
 * @author zghw
 *
 */
public interface ChainHandler {
	/**
	 * 对Chain包装处理
	 * @param chain
	 * @param valueStack
	 * @return
	 */
	Result handle(Chain chain, ValueStack valueStack);
}
