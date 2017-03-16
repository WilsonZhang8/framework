package com.zghw.framework.base.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zghw.framework.base.dao.api.IHelloBaseDao;
import com.zghw.mybaits.AbstractDao;
import com.zghw.mybaits.IDaoSupport;

@Service
public class HelloBaseDao extends AbstractDao implements IHelloBaseDao {

	@Override
	@Autowired
	public void setDaoSupport(@Qualifier("mybatisDaoSupport") IDaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}

}
