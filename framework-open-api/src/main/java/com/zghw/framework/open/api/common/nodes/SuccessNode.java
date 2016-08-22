package com.zghw.framework.open.api.common.nodes;

import org.springframework.util.StringUtils;

import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.chain.impl.AbstractNode;
import com.zghw.framework.entity.common.Result;
import com.zghw.framework.entity.common.ResultConstant;

/**
 * 成功节点处理结果
 * 
 * @author zghw
 *
 */
public class SuccessNode extends AbstractNode {

	@Override
	public String doNode(ValueStack valueStack) throws Exception {
		String code = valueStack.getString(CODE);
		String state = valueStack.getString(STATE);
		String msg = valueStack.getString(MSG);
		Object data = valueStack.getValue(DATA);
		code = StringUtils.hasText(code) ? code : ResultConstant.SUCCESS_CODE;
		state = StringUtils.hasText(state) ? state : ResultConstant.SUCCESS_STATE;
		msg = StringUtils.hasText(msg) ? msg : ResultConstant.SUCCESS_MSG;
		Result result = new Result(code, state, msg, data);
		valueStack.setValue(RESULT, result);
		return null;
	}

}
