package com.zghw.framework.base.service.api;

import java.util.List;

import com.zghw.framework.entity.base.HelloBase;

public interface IHelloBaseService {
	public String helloBase();

	public HelloBase save(HelloBase helloBase);

	public void delete(HelloBase helloBase);

	public void update(HelloBase helloBase);

	public HelloBase load(HelloBase helloBase);

	public List<HelloBase> selectForList(HelloBase helloBase);

}
