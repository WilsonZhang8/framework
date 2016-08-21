package com.zghw.framework.open.api.common.nodes;

import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.chain.impl.AbstractNode;

/**
 * 循环调用节点
 * @author zghw
 *
 */
public class LoopNode extends AbstractNode {

	@Override
	public String doNode(ValueStack valueStack) throws Exception {
		
		return NEXT;
	}

}
