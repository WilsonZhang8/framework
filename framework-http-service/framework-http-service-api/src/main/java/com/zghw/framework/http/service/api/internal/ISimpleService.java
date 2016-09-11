package com.zghw.framework.http.service.api.internal;

import com.zghw.framework.object.dto.Result;

public interface ISimpleService {
	public String register(String dataDTO);

	public Result registerToResult(String dataDTO);
	
	public String memberStatus(String dataDTO);
	
	public Result memberStatusToResult(String dataDTO);
}
