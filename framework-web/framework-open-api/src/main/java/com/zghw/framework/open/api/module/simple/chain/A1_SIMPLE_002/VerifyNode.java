package com.zghw.framework.open.api.module.simple.chain.A1_SIMPLE_002;

import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.chain.impl.AbstractNode;
import com.zghw.framework.entity.open.api.dto.simple.MemberStatusInfo;
import com.zghw.framework.object.dto.ResultBuilder;

/**
 * 验证参数节点
 * 
 * @author zghw
 *
 */
public class VerifyNode extends AbstractNode {

	@Override
	public String doNode(ValueStack valueStack) throws Exception {
		MemberStatusInfo personInfo = valueStack.getValue(DTO, MemberStatusInfo.class);
		if (personInfo == null) {
			valueStack.setValue(RESULT, ResultBuilder.buildError("会员信息不能为空"));
			return ERROR;
		}
		return NEXT;
	}

}
