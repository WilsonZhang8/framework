package com.zghw.framework.http.service.impl.internal;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zghw.framework.common.util.JsonUtil;
import com.zghw.framework.http.HttpClientUtil;
import com.zghw.framework.http.WebURL;
import com.zghw.framework.http.service.api.internal.IBaseService;
import com.zghw.framework.object.dto.Result;

@Service
public class BaseService implements IBaseService {
	//可以有多个WebURL对象，由spring注入，其中名字最好和spring bean 名称相等
	private WebURL baseGetInfo;

	@Override
	public String getInfo() {
		//使用map设置参数列表
		Map<String, String> params = new HashMap<String, String>();
		//使用httpclient工具处理请求相应的结果
		String result = HttpClientUtil.doGet(baseGetInfo.toString(), params);
		return result;
	}

	@Override
	public Result getInfoToResult() {
		String result = getInfo();
		//使用json工具处理结果为Result对象
		return JsonUtil.jsonToResult(result);
	}

	//注入webURL配置 一定要写 @Qualifier("baseGetInfo")来表示注入那个bean
	@Autowired
	public void setWebURL(@Qualifier("baseGetInfo") WebURL baseGetInfo) {
		this.baseGetInfo = baseGetInfo;
	}

}
