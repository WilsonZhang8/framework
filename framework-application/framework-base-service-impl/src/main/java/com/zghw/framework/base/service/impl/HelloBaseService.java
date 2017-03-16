package com.zghw.framework.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zghw.framework.base.dao.api.IHelloBaseDao;
import com.zghw.framework.base.service.api.IHelloBaseService;
import com.zghw.framework.entity.base.HelloBase;

@Service
public class HelloBaseService implements IHelloBaseService {
	private IHelloBaseDao helloBaseDao;

	@Autowired
	public void setHelloBaseDao(@Qualifier("helloBaseDao")IHelloBaseDao helloBaseDao) {
		this.helloBaseDao = helloBaseDao;
	}

	@Override
	public String helloBase() {
		System.out.println("调用helloBase()");
		return "helloBase";
	}

	@Override
	public HelloBase save(HelloBase helloBase) {
		helloBaseDao.save("saveHelloBase", helloBase);
		return helloBase ;
	}

	@Override
	public void delete(HelloBase helloBase) {
		helloBaseDao.delete("deleteHelloBase", helloBase);
	}

	@Override
	public void update(HelloBase helloBase) {
		helloBaseDao.update("updateHelloBase", helloBase);
	}

	@Override
	public HelloBase load(HelloBase helloBase) {
		return (HelloBase) helloBaseDao.selectForObject("loadHelloBase", helloBase);
	}

	@Override
	public List<HelloBase> selectForList(HelloBase helloBase) {
		return (List<HelloBase>) helloBaseDao.selectForList("selectHelloBase", helloBase);
	}

}
