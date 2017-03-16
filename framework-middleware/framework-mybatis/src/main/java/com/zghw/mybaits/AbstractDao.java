package com.zghw.mybaits;

import java.util.List;

public abstract class AbstractDao implements IDaoSupport {
	protected IDaoSupport daoSupport;

	@Override
	public List<?> selectForList(String statementName) {
		return daoSupport.selectForList(statementName);
	}

	@Override
	public List<?> selectForList(String statementName, Object parameterObject) {
		return daoSupport.selectForList(statementName, parameterObject);
	}

	@Override
	public Object selectForObject(String statementName) {
		return daoSupport.selectForObject(statementName);
	}

	@Override
	public Object selectForObject(String statementName, Object parameterObject) {
		return daoSupport.selectForObject(statementName, parameterObject);
	}

	@Override
	public int update(String statementName) {
		return daoSupport.update(statementName);
	}

	@Override
	public int update(String statementName, Object parameterObject) {
		return daoSupport.update(statementName, parameterObject);
	}

	@Override
	public void update(String statementName, Object parameterObject, int requiredRowsAffected) {
		daoSupport.update(statementName, parameterObject, requiredRowsAffected);
	}

	@Override
	public Object save(String statementName) {
		return daoSupport.save(statementName);
	}

	@Override
	public Object save(String statementName, Object parameterObject) {
		return daoSupport.save(statementName, parameterObject);
	}

	@Override
	public int delete(String statementName) {
		return daoSupport.delete(statementName);
	}

	@Override
	public int delete(String statementName, Object parameterObject) {
		return daoSupport.delete(statementName, parameterObject);
	}

	@Override
	public void delete(String statementName, Object parameterObject, int requiredRowsAffected) {
		daoSupport.delete(statementName, parameterObject, requiredRowsAffected);
	}

	public IDaoSupport getDaoSupport() {
		return daoSupport;
	}

	public abstract void setDaoSupport(IDaoSupport daoSupport);

}
