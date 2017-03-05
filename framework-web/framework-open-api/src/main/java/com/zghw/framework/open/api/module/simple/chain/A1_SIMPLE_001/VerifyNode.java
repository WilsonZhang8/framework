package com.zghw.framework.open.api.module.simple.chain.A1_SIMPLE_001;

import org.springframework.util.StringUtils;

import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.chain.impl.AbstractNode;
import com.zghw.framework.entity.open.api.dto.simple.PersonInfo;
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
		PersonInfo personInfo = valueStack.getValue(DTO, PersonInfo.class);
		if (personInfo == null) {
			valueStack.setValue(RESULT, ResultBuilder.buildError("注册信息不能为空"));
			return ERROR;
		}
		if (!StringUtils.hasText(personInfo.getIdType())) {
			valueStack.setValue(RESULT, ResultBuilder.buildError("证件类型不能为空!", personInfo));
			return ERROR;
		}
		if (!StringUtils.hasText(personInfo.getIdNo())) {
			valueStack.setValue(RESULT, ResultBuilder.buildError("证件号码不能为空!", personInfo));
			return ERROR;
		}
		if (!StringUtils.hasText(personInfo.getName())) {
			valueStack.setValue(RESULT, ResultBuilder.buildError("姓名不能为空!", personInfo));
			return ERROR;
		}
		return NEXT;
	}

}
