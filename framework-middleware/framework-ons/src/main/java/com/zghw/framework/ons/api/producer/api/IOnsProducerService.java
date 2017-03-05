package com.zghw.framework.ons.api.producer.api;

import java.util.List;

import com.aliyun.openservices.ons.api.SendResult;
import com.zghw.framework.ons.api.ProducerConfig;

/**
 * 消息生产服务，负责生产并发送消息。
 * 
 * @author zghw
 *
 */
public interface IOnsProducerService {

	/**
	 * 通过提供的ons配置发送
	 * 
	 * @param producerConfig
	 *            提供的ons配置
	 * @param messageBody
	 *            消息体
	 * @return
	 */
	SendResult sendSingle(ProducerConfig producerConfig, String messageBody);

	/**
	 * 通过提供的ons配置发送多个消息
	 * 
	 * @param producerConfig
	 *            提供的ons配置
	 * @param messageBody
	 *            消息列表
	 * @return
	 */
	List<SendResult> send(ProducerConfig producerConfig, String... messageBody);

}
