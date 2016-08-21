package com.zghw.framework.open.api.common.nodes;

import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.chain.impl.AbstractNode;
/**
 * 把request中的参数放入valueStack中
 * @author zghw
 *
 */
public class ParamValuesNode extends AbstractNode {

	@Override
	public String doNode(ValueStack valueStack) throws Exception {
		
		return NEXT;
	}

}
