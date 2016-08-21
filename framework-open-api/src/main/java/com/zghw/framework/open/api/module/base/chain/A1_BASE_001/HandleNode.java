package com.zghw.framework.open.api.module.base.chain.A1_BASE_001;

import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.chain.impl.AbstractNode;

/**
 * 处理节点
 * @author zghw
 *
 */
public class HandleNode extends AbstractNode {

	@Override
	public String doNode(ValueStack valueStack) throws Exception {
		return NEXT;
	}

}
