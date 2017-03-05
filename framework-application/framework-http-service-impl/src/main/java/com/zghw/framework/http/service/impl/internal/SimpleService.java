package com.zghw.framework.http.service.impl.internal;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zghw.framework.common.util.JsonUtil;
import com.zghw.framework.http.HttpClientUtil;
import com.zghw.framework.http.WebURL;
import com.zghw.framework.http.service.api.internal.ISimpleService;
import com.zghw.framework.object.dto.Result;

@Service
public class SimpleService implements ISimpleService {
	private WebURL simpleRegister;
	private WebURL simpleMemberStatus;

	@Override
	public String register(String dataDTO) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("data", dataDTO);
		String result = HttpClientUtil.doGet(simpleRegister.toString(), params);
		return result;
	}

	@Override
	public Result registerToResult(String dataDTO) {
		String result = register(dataDTO);
		return JsonUtil.jsonToResult(result);
	}

	@Override
	public String memberStatus(String dataDTO) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("data", dataDTO);
		String result = HttpClientUtil.doGet(simpleMemberStatus.toString(), params);
		return result;
	}

	@Override
	public Result memberStatusToResult(String dataDTO) {
		String result = memberStatus(dataDTO);
		return JsonUtil.jsonToResult(result);
	}

	@Autowired
	public void setSimpleRegister(@Qualifier("simpleRegister") WebURL simpleRegister) {
		this.simpleRegister = simpleRegister;
	}

	@Autowired
	public void setSimpleMemberStatus(@Qualifier("simpleMemberStatus") WebURL simpleMemberStatus) {
		this.simpleMemberStatus = simpleMemberStatus;
	}

}
