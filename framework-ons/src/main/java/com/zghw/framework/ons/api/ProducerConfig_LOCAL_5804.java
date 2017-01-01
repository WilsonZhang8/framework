package com.zghw.framework.ons.api;

import java.io.Serializable;

/**
 * 消息生产者对应的配置
 * 
 * @author zghw
 *
 */
public class ProducerConfig implements Serializable {

	private static final long serialVersionUID = 1L;
	// 服务序号 如api接口的唯一名称
	private String serviceNo;
	// 消息提供者id
	private String producerId;
	// 消息主题id
	private String topicId;
	// 消息再分类比如分时间段 分省份
	private String tag;
	// 设置代表消息的业务关键属性，请尽可能全局唯一。
	// 以方便您在无法正常收到消息情况下，可通过ONS Console查询消息并补发。
	// 注意：不设置也不会影响消息正常收发
	private String key;
	// ons配置的访问key
	private String accessKey;
	// ons配置的安全key
	private String secretKey;
	// ons的访问地址
	private String onsAddr;
	// 动态tag 备用字段，如果设置了dynamicTag则将代替 tag值
	private String dynamicTag;
	// 动态key 备用字段，如果设置了dynamicKey则将代替 key值
	private String dynamicKey;

	public String getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}

	public String getProducerId() {
		return producerId;
	}

	public void setProducerId(String producerId) {
		this.producerId = producerId;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getOnsAddr() {
		return onsAddr;
	}

	public void setOnsAddr(String onsAddr) {
		this.onsAddr = onsAddr;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDynamicTag() {
		return dynamicTag;
	}

	public void setDynamicTag(String dynamicTag) {
		this.dynamicTag = dynamicTag;
	}

	public String getDynamicKey() {
		return dynamicKey;
	}

	public void setDynamicKey(String dynamicKey) {
		this.dynamicKey = dynamicKey;
	}

}
