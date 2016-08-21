package com.zghw.framework.open.api.module.base.chain.A1_BASE_001;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.zghw.framework.base.service.api.IHelloBaseService;
import com.zghw.framework.chain.ValueStack;
import com.zghw.framework.chain.impl.AbstractNode;
import com.zghw.framework.ons.api.ProducerConfig;
import com.zghw.framework.ons.api.producer.api.IOnsProducerService;

/**
 * 处理节点
 * 
 * @author zghw
 *
 */
public class HandleNode extends AbstractNode {
	private Logger logger = LogManager.getLogger(this.getClass());
	private IHelloBaseService helloBaseService;
	private IOnsProducerService onsProducerService;
	private ProducerConfig producerConfig;

	@Override
	public String doNode(ValueStack valueStack) throws Exception {
		String message = helloBaseService.helloBase();
		valueStack.setValue(MESSAGE, message);
		logger.info("接口：[ PC_A1_BASE_001 ] 推送消息到ONS >> " + message);
		onsProducerService.sendSingle(producerConfig, message);
		return NEXT;
	}

	@Autowired
	public void setHelloBaseService(@Qualifier("helloBaseService") IHelloBaseService helloBaseService) {
		this.helloBaseService = helloBaseService;
	}

	@Autowired
	public void setOnsProducerService(@Qualifier("onsProducerService") IOnsProducerService onsProducerService) {
		this.onsProducerService = onsProducerService;
	}

	/**
	 * 注入配置 PC_A1_BASE_001
	 * 
	 * @param producerConfig
	 */
	@Autowired
	public void setProducerConfig(@Qualifier("PC_A1_BASE_001") ProducerConfig producerConfig) {
		this.producerConfig = producerConfig;
	}
}
