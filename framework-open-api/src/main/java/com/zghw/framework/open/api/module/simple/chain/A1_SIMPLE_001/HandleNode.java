package com.zghw.framework.open.api.module.simple.chain.A1_SIMPLE_001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.chain.impl.AbstractNode;
import com.zghw.framework.object.dto.ResultBuilder;
import com.zghw.framework.simple.service.api.IHelloWorldService;

/**
 * 处理节点
 * 
 * @author zghw
 *
 */
public class HandleNode extends AbstractNode {
	public static Logger logger = LoggerFactory.getLogger(HandleNode.class);

	private IHelloWorldService helloWorldService;

	@Override
	public String doNode(ValueStack valueStack) throws Exception {
		String data=helloWorldService.helloBase();
		valueStack.setValue(RESULT, ResultBuilder.buildSuccess("成功!", data));
		return SUCCESS;
	}

	@Autowired
	public void setHelloWorldService(@Qualifier("helloWorldService") IHelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

}
