package com.zghw.framework.common.util;

import java.io.IOException;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.ParseException;
import com.zghw.framework.object.dto.Result;
import com.zghw.framework.object.dto.ResultBuilder;

/**
 * json工具使用的是alibaba的fastjson
 * 
 * @author zghw
 *
 */
public class JsonUtil {
	/**
	 * 返回字符串结果转化为Result对象
	 * 
	 * @param result
	 * @return
	 */
	public static Result jsonToResult(String result) {
		try {
			Result res = JSON.parse(result, Result.class);
			return res;
		} catch (ParseException e) {
			e.printStackTrace();
			return ResultBuilder.buildError("result格式不正确无法转换为json!", result);
		}
	}

	/**
	 * 返回Result对象转化为字符串结果
	 * 
	 * @param result
	 * @return
	 */
	public static String resultToJson(Result result) {

		try {
			String res = JSON.json(result);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			// 不会执行到异常
			return null;
		}
	}
}
