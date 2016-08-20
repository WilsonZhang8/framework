package com.zghw.framework.ons.api.producer.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyun.openservices.ons.api.SendResult;
import com.zghw.framework.ons.api.ProducerConfig;
import com.zghw.framework.ons.api.producer.api.IOnsProducerService;

@Service
public class OnsProducerService implements IOnsProducerService {

	@Override
	public SendResult sendSingle(ProducerConfig producerConfig, String messageBody) {
		List<SendResult> sendResultList = send(producerConfig, messageBody);
		if (sendResultList == null) {
			return null;
		}
		return sendResultList.size() > 0 ? sendResultList.get(0) : null;
	}

	@Override
	public List<SendResult> send(ProducerConfig producerConfig, String... messageBody) {
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.ProducerId, producerConfig.getProducerId());
		properties.put(PropertyKeyConst.AccessKey, producerConfig.getAccessKey());
		properties.put(PropertyKeyConst.SecretKey, producerConfig.getSecretKey());
		// 地址可以为空，默认会取得当前项目的地址
		if (producerConfig.getOnsAddr() != null && !producerConfig.getOnsAddr().isEmpty()) {
			properties.put(PropertyKeyConst.ONSAddr, producerConfig.getOnsAddr());
		}
		Producer producer = ONSFactory.createProducer(properties);
		// 在发送消息前，必须调用start方法来启动Producer，只需调用一次即可。
		producer.start();
		List<SendResult> sendResultList = new ArrayList<SendResult>();
		//动态tag存在则优先取动态值dynamicTag
		String tag=producerConfig.getDynamicTag()!=null?producerConfig.getDynamicTag():producerConfig.getTag();
		//动态key存在则优先取动态值dynamicKey
		String key=producerConfig.getDynamicKey()!=null?producerConfig.getDynamicKey():producerConfig.getKey();
		for (String msg : messageBody) {
			Message message = new Message( //
					// Message Topic
					producerConfig.getTopicId(),
					// Message Tag,
					// 可理解为Gmail中的标签，对消息进行再归类，方便Consumer指定过滤条件在ONS服务器过滤
					tag,
					// Message Body
					// 任何二进制形式的数据， ONS不做任何干预，
					// 需要Producer与Consumer协商好一致的序列化和反序列化方式
					msg.getBytes());
			// 设置代表消息的业务关键属性，请尽可能全局唯一。
			// 以方便您在无法正常收到消息情况下，可通过ONS Console查询消息并补发。
			// 注意：不设置也不会影响消息正常收发
			message.setKey(key);
			// 发送消息，只要不抛异常就是成功
			SendResult sendResult = producer.send(message);
			sendResultList.add(sendResult);
		}
		// 注意：如果不销毁也没有问题
		producer.shutdown();
		return sendResultList;
	}
}
