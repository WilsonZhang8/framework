package com.zghw.framework.chain.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.zghw.framework.chain.Chain;
import com.zghw.framework.chain.Node;
import com.zghw.framework.chain.ValueStack;

/**
 * 默认的责任连实现，实现时需要设置节点集合及首节点名称
 * 
 * @author zghw
 *
 */
public class DefaultChain implements Chain {
	private Collection<Node> nodes;
	private String first;
	private Map<String, Node> nodesMap;

	/**
	 * 从所有节点中查询到第一节点，从第一个节点开始处理，处理后的数据放入valueStack中，
	 * 到下一个节点由上一个节点的返回值确定，如果返回值不为空，
	 * 根据返回值查询上一个节点流向下个节点对应的节点。递归下个节点，直到返回值为null或没有下个节点流向，则该链条处理完成。
	 * 
	 * @author zghw
	 */
	@Override
	public void doChain(ValueStack valueStack) throws Exception {
		if (nodesMap == null) {
			initNodesMap();
		}
		Node node = nodesMap.get(getFirst());
		if (node == null) {
			throw new IllegalArgumentException("首节点(first)未找到");
		}
		while (node != null) {
			String r = node.doNode(valueStack);
			if (r == null) {
				return;
			}
			Map<String, String> fwds = node.getForwards();
			if (fwds == null) {
				break;
			}
			String fwd = fwds.get(r);
			if (fwd == null) {
				throw new IllegalArgumentException("流向(" + r + ")未找到");
			}
			node = nodesMap.get(fwd);
		}
	}

	/**
	 * 初始化节点，把所有集合节点，放入map中
	 */
	private void initNodesMap() {
		nodesMap = new HashMap<String, Node>();
		for (Node node : nodes) {
			if (nodesMap.containsKey(node.getName())) {
				throw new IllegalArgumentException("节点(" + node.getName() + ")重复");
			}
			nodesMap.put(node.getName(), node);
		}
	}

	@Override
	public Collection<Node> getNodes() {
		return nodes;
	}

	@Override
	public void setNodes(Collection<Node> nodes) {
		this.nodes = nodes;
	}

	@Override
	public String getFirst() {
		return first;
	}

	@Override
	public void setFirst(String first) {
		this.first = first;
	}

}
