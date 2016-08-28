package com.zghw.framework.open.api.common.nodes;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.chain.impl.AbstractNode;
import com.zghw.framework.common.util.RequestUtils;

/**
 * 把request中的参数放入valueStack中
 * 
 * @author zghw
 *
 */
public class ParamValuesNode extends AbstractNode {
	public static Logger logger = LoggerFactory.getLogger(ParamValuesNode.class);

	@Override
	public String doNode(ValueStack valueStack) throws Exception {
		HttpServletRequest request = valueStack.getValue(REQUEST, HttpServletRequest.class);
		if (request != null) {
			Map<String, String> params = RequestUtils.getQueryParamMap(request);
			logger.info("Request params:"+params);
			valueStack.setAll(params);
		}
		return NEXT;
	}

}
