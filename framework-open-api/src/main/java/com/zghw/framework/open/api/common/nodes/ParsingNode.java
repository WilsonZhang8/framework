package com.zghw.framework.open.api.common.nodes;

import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.chain.impl.AbstractNode;
/**
 * 解析参数节点
 * @author zghw
 *
 */
public class ParsingNode extends AbstractNode {

	@Override
	public String doNode(ValueStack valueStack) throws Exception {
		return NEXT;
	}

}
