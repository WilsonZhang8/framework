package com.zghw.framework.open.api.module.simple.chain.A1_SIMPLE_002;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.chain.impl.AbstractNode;
import com.zghw.framework.entity.open.api.dto.simple.MemberStatusInfo;
import com.zghw.framework.object.dto.ResultBuilder;

/**
 * 处理节点
 * 
 * @author zghw
 *
 */
public class HandleNode extends AbstractNode {
	public static Logger logger = LoggerFactory.getLogger(HandleNode.class);

	@Override
	public String doNode(ValueStack valueStack) throws Exception {
		MemberStatusInfo personInfo = valueStack.getValue(DTO, MemberStatusInfo.class);
		valueStack.setValue(RESULT, ResultBuilder.buildSuccess("成功!", personInfo));
		return SUCCESS;
	}

}
