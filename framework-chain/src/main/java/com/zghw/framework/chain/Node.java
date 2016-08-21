package com.zghw.framework.chain;

import java.util.Map;

/**
 * 节点，主要功能设置节点名、节点处理、设置该节点数据、流向下个节点设置
 * 
 * @author zghw
 *
 */
public interface Node {
	/**
	 * 得到节点名称
	 * @return 节点名称
	 */
	public String getName(); 

	/**
	 * 设置节点名称
	 * @param name
	 */
	public void setName(String name);

	/**
	 * 节点主要处理方法，处理后的数据设置到valueStack，返回值为下个节点名称
	 * @param valueStack 保存节点处理的数据结果
	 * @return 下个节点名称
	 * @throws Exception
	 */
	public String doNode(ValueStack valueStack) throws Exception;

	/**
	 * 得到该节点下的所有流向包含的节点名称映射
	 * @return 得到该节点下的所有流向包含的节点名称映射
	 */
	public Map<String, String> getForwards(); // 流向

	/**
	 * 设置该节点下的所有流向包含的节点名称映射
	 * @param forwards
	 */
	public void setForwards(Map<String, String> forwards);
}
