package com.zghw.framework.test.ons.api;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.zghw.framework.ons.api.ProducerConfig;
import com.zghw.framework.ons.api.producer.api.IOnsProducerService;

@ContextConfiguration(locations = { "classpath:/api/spring-ons.xml" })
public class TestProducer extends AbstractJUnit4SpringContextTests {
	@Autowired
	private IOnsProducerService onsProducerService;

	private ProducerConfig producerConfig;
	/**
	 * 测试发布一条消息
	 */
	@Test
	public void testSendSingle() {
		onsProducerService.sendSingle(producerConfig, "test message!");
	}
	/**
	 * 测试发布多条消息
	 */
	@Test
	public void testSend() {
		onsProducerService.send(producerConfig, "test message!","test message2!","test message3!");
	}
	
	/**
	 * 循环发送不同的消息
	 */
	@Test
	public void testSendDynamic() {
		
		int m=0;
		for(int i = 0;i<2;i++){
			for(int j=0;j<5;j++){
				m++;
				//设置动态key
				producerConfig.setDynamicKey(m+"");
				//设置动态tag
				producerConfig.setDynamicTag(producerConfig.getTag()+""+i);
				onsProducerService.send(producerConfig, "测试数据"+m);
			}
		}
	}

	public void setOnsProducerService(IOnsProducerService onsProducerService) {
		this.onsProducerService = onsProducerService;
	}

	/**
	 * 注入配置
	 * 
	 * @param producerConfig
	 */
	@Autowired
	public void setProducerConfig(@Qualifier("PC_A1_CUST_017") ProducerConfig producerConfig) {
		this.producerConfig = producerConfig;
	}

}
