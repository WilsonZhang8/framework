package com.zghw.framework.object.dto;

import com.zghw.framework.object.dto.Result;
import com.zghw.framework.object.dto.ResultConstant;
/**
 * 构建几个默认结果对象
 * @author zghw
 *
 */
public class ResultBuilder {

	/**
	 * 构建一个默认的成功结果对象
	 * 
	 * @return
	 */
	public static Result buildSuccess() {
		Result result = new Result();
		result.setCode(ResultConstant.SUCCESS_CODE);
		result.setState(ResultConstant.SUCCESS_STATE);
		result.setMsg(ResultConstant.SUCCESS_MSG);
		return result;
	}

	/**
	 * 构建一个默认的成功结果对象
	 * 
	 * @return
	 */
	public static Result buildSuccess(String msg) {
		Result result = new Result();
		result.setCode(ResultConstant.SUCCESS_CODE);
		result.setState(ResultConstant.SUCCESS_STATE);
		result.setMsg(msg);
		return result;
	}

	/**
	 * 构建一个默认的成功结果对象
	 * 
	 * @return
	 */
	public static Result buildSuccess(String msg, Object data) {
		Result result = new Result();
		result.setCode(ResultConstant.SUCCESS_CODE);
		result.setState(ResultConstant.SUCCESS_STATE);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}

	/**
	 * 构建一个默认的成功结果对象
	 * 
	 * @return
	 */
	public static Result buildError() {
		Result result = new Result();
		result.setCode(ResultConstant.ERROR_CODE);
		result.setState(ResultConstant.ERROR_STATE);
		result.setMsg(ResultConstant.ERROR_MSG);
		return result;
	}

	/**
	 * 构建一个默认的错误结果对象
	 * 
	 * @return
	 */
	public static Result buildError(String msg) {
		Result result = new Result();
		result.setCode(ResultConstant.ERROR_CODE);
		result.setState(ResultConstant.ERROR_STATE);
		result.setMsg(msg);
		return result;
	}

	/**
	 * 构建一个默认的错误结果对象
	 * 
	 * @return
	 */
	public static Result buildError(String msg, Object data) {
		Result result = new Result();
		result.setCode(ResultConstant.ERROR_CODE);
		result.setState(ResultConstant.ERROR_STATE);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}
}
