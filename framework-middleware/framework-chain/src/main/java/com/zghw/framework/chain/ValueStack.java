package com.zghw.framework.chain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于存储数据的值栈，用在责任链中的节点中保存的数据，使用map来存储
 * 
 * @author zghw
 *
 */
public class ValueStack implements Serializable {
	private static final long serialVersionUID = 4334533639888405700L;

	private Map<String, Object> context;

	public ValueStack() {
		this.context = new HashMap<String, Object>();
	}

	/**
	 * 放入值栈中一个数据
	 * 
	 * @param expr
	 *            对应的key
	 * @param value
	 *            对应的value
	 */
	public void setValue(String expr, Object value) {
		context.put(expr, value);
	}

	/**
	 * 放入值栈中一个数据，如果值栈中已经存在则抛出异常
	 * 
	 * @param expr
	 *            对应的key
	 * @param value
	 *            对应的value
	 */
	public void setValueIfNotExists(String expr, Object value) throws ValueExistsException {
		if (existsValue(expr)) {
			throw new ValueExistsException(expr + "值已经存在!");
		}
		setValue(expr, value);
	}

	/**
	 * 值栈中是否存在相应的值
	 * 
	 * @param expr
	 * @return
	 */
	public boolean existsValue(String expr) {
		return !(context.get(expr) == null);
	}

	/**
	 * 得到值栈中的值,返回字符串
	 * 
	 * @param expr
	 * @return
	 */
	public String getString(String expr) {
		return this.getValue(expr, String.class);
	}

	/**
	 * 得到值栈中的值,返回字符串，如果不存在则抛出异常
	 * 
	 * @param expr
	 * @return
	 * @throws ValueNotExistsException
	 */
	public String getStringIfExists(String expr) throws ValueNotExistsException {
		return this.getValueIfExists(expr, String.class);
	}

	/**
	 * 得到值栈中的值,返回Object
	 * 
	 * @param expr
	 * @return
	 */
	public Object getValue(String expr) {
		return context.get(expr);
	}

	/**
	 * 得到值栈中的值,返回Object，如果不存在则抛出异常
	 * 
	 * @param expr
	 * @return
	 * @throws ValueNotExistsException
	 */
	public Object getValueIfExists(String expr) throws ValueNotExistsException {
		if (!existsValue(expr)) {
			throw new ValueNotExistsException(expr + "值不存在!");
		}
		return getValue(expr);
	}

	/**
	 * 得到值栈中的类型相同的值,返回该类型对象，如果不存在则返回null
	 * 
	 * @param expr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getValue(String expr, Class<T> asType) {
		Object v = this.getValue(expr);
		if (v == null || (v.getClass() != asType && v.getClass().isAssignableFrom(asType))) {
			return null;
		}
		return (T) v;
	}

	/**
	 * 得到值栈中的类型相同的值,返回该类型对象，如果不存在则抛出异常
	 * 
	 * @param expr
	 * @return
	 * @throws ValueNotExistsException
	 */
	@SuppressWarnings("unchecked")
	public <T> T getValueIfExists(String expr, Class<T> asType) throws ValueNotExistsException {
		Object v = this.getValueIfExists(expr);
		if (v == null || (v.getClass() != asType && v.getClass().isAssignableFrom(asType))) {
			throw new ValueNotExistsException("类型为 " + asType.getName() + " 的 " + expr + " 值不存在!");
		}
		return (T) v;
	}

	/**
	 * 设置一组数据
	 * 
	 * @param map
	 */
	public void setAll(Map<String, ?> map) {
		if (map != null) {
			context.putAll(map);
		}
	}

	/**
	 * 清空值栈数据
	 */
	public void clear() {
		context.clear();
	}

	/**
	 * 得到值栈对象，返回map
	 * 
	 * @return
	 */
	public Map<String, Object> getContext() {
		return context;
	}

}
