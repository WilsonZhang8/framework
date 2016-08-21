package com.zghw.framework.chain.impl;

import java.util.Map;

import com.zghw.framework.chain.ChainConstant;
import com.zghw.framework.chain.Node;
import com.zghw.framework.chain.ValueStack;

/**
 * 抽象节点，主要抽象节点名字、节点流向，处理doNode方法留给子类具体实现
 * 
 * @author zghw
 *
 */
public abstract class AbstractNode implements Node,ChainConstant {

	protected Map<String, String> forwards;
	protected String name;

	/**
	 * 获得指定节点设置的值
	 * 
	 * @param expr
	 * @param valueStack
	 * @return
	 */
	public Object geNodeValue(String nodeName, String expr, ValueStack valueStack) {
		return valueStack.getValue(nodeName + "." + expr);
	}

	/**
	 * 设置当前节点出参
	 * 
	 * @param expr
	 * @param value
	 * @param valueStack
	 */
	public void setNodeValue(String expr, Object value, ValueStack valueStack) {
		valueStack.setValue(name + "." + expr, value);
	}

	public Map<String, String> getForwards() {
		return forwards;
	}

	public void setForwards(Map<String, String> forwards) {
		this.forwards = forwards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
