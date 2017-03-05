package com.zghw.framework.chain;

/**
 * 得到值栈中的值，如果不存在则抛出异常
 * 
 * @author zghw
 *
 */
public class ValueNotExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	public ValueNotExistsException() {
		super();
	}

	public ValueNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValueNotExistsException(String message) {
		super(message);
	}

	public ValueNotExistsException(Throwable cause) {
		super(cause);
	}
}
