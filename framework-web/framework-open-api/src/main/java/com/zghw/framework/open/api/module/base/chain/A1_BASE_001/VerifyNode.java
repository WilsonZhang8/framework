package com.zghw.framework.open.api.module.base.chain.A1_BASE_001;

import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.chain.impl.AbstractNode;
/**
 * 验证参数节点
 * @author zghw
 *
 */
public class VerifyNode extends AbstractNode {

	@Override
	public String doNode(ValueStack valueStack) throws Exception {
		
		return NEXT;
	}

}
