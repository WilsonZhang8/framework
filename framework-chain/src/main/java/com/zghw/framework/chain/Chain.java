package com.zghw.framework.chain;

import java.util.Collection;

/**
 * 责任链
 * 
 * @author zghw
 *
 */
public interface Chain {
	/**
	 * 
	 * @param valueStack
	 *            值栈保存链条中传递的值
	 * @throws Exception
	 */
	public void doChain(ValueStack valueStack) throws Exception;

	/**
	 * 得到首节点名称
	 * 
	 * @return
	 */
	public String getFirst();

	/**
	 * 设置首节点名称
	 * 
	 * @param first
	 */
	public void setFirst(String first);

	/**
	 * 得到链条中所有节点集合
	 * 
	 * @return
	 */
	public Collection<Node> getNodes();

	/**
	 * 设置节点集合
	 * 
	 * @param nodes
	 */
	public void setNodes(Collection<Node> nodes);
}
