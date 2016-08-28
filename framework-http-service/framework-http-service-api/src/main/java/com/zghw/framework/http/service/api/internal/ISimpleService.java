package com.zghw.framework.http.service.api.internal;

import com.zghw.framework.object.dto.Result;

public interface ISimpleService {
	public String register(String dataDTO);

	public Result registerToResult(String dataDTO);
}
