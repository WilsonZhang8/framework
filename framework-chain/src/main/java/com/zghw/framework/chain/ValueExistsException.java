package com.zghw.framework.chain;

/**
 * 放入值栈中一个数据，如果值栈中已经存在则抛出异常
 * 
 * @author zghw
 *
 */
public class ValueExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	public ValueExistsException() {
		super();
	}

	public ValueExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValueExistsException(String message) {
		super(message);
	}

	public ValueExistsException(Throwable cause) {
		super(cause);
	}
}
