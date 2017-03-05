package com.zghw.framework.http.service.api.internal;

import com.zghw.framework.object.dto.Result;

/**
 * 封住http请求open-api相应的配置，发布rpc服务供调用或直接使用
 * 
 * @author zghw
 *
 */
public interface IBaseService {
	/**
	 * 得到信息的json串
	 * 
	 * @return
	 */
	public String getInfo();

	/**
	 * 得到信息的json对象
	 * 
	 * @return
	 */
	public Result getInfoToResult();
}
