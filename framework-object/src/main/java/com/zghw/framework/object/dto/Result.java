package com.zghw.framework.object.dto;

import java.io.Serializable;

/**
 * 返回结果对象
 * 
 * @author zghw
 *
 */
public class Result implements Serializable {
	private static final long serialVersionUID = 1L;
	// 状态码 一般值为数字，比如0表示成功1表示失败等
	private String code;
	// 状态码的产生简短信息 比如 code为0 则state为success
	private String state;
	//结果信息的详细描述 比如 code为0，则msg等于请求相应成功
	private String msg;
	//结果携带的数据对象
	private Object data;

	public Result() {
	}

	public Result(Object data) {
		this.data = data;
	}

	public Result(String msg, Object data) {
		this.msg = msg;
		this.data = data;
	}

	public Result(String state, String msg, Object data) {
		this.state = state;
		this.msg = msg;
		this.data = data;
	}

	public Result(String code, String state, String msg, Object data) {
		this.code = code;
		this.state = state;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 返回状态码
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置状态码
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 返回状态
	 * 
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * 设置状态
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 返回结果描述信息
	 * 
	 * @return
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 返回结果描述信息
	 * 
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 返回数据对象
	 * 
	 * @return
	 */
	public Object getData() {
		return data;
	}

	/**
	 * 设置数据对象
	 * 
	 * @param data
	 */
	public void setData(Object data) {
		this.data = data;
	}

	
}
