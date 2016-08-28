package com.zghw.framework.open.api.common.nodes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.chain.impl.AbstractNode;
import com.zghw.framework.common.util.JsonUtil;

/**
 * 解析参数节点 data对应DTO
 * 
 * @author zghw
 *
 */
public class ParseDTODataNode extends AbstractNode {
	public static Logger logger = LoggerFactory.getLogger(ParamValuesNode.class);

	@Override
	public String doNode(ValueStack valueStack) throws Exception {
		String data = valueStack.getString(DATA);
		if (StringUtils.hasText(data)) {
			Class<?> clazz = (Class<?>) valueStack.getValue(CLASS_TYPE);
			if (clazz != null) {
				logger.info("Request data:" + data);
				Object dto = JsonUtil.parse(data, clazz);
				valueStack.setValue(DTO, dto);
			}
		}
		return NEXT;
	}

}
