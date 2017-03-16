package com.zghw.mybaits.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.JdbcUpdateAffectedIncorrectNumberOfRowsException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zghw.mybaits.IDaoSupport;

public class MybatisDaoSupport implements IDaoSupport {
	protected SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	/**
	 * 执行一个映射的SQL SELECT语句返回查询获得的结果集<br />
	 * SELECT 语句不接收参数
	 * 
	 * @param statementName
	 *            需要执行语句的名称
	 * @return 包含返回结果的集合 {@link List}
	 * @throws java.sql.SQLException
	 *             SQL异常产生时抛出
	 */
	@Override
	public List<?> selectForList(String statementName) {
		return this.sqlSessionTemplate.selectList(statementName);
	}

	/**
	 * 执行一个映射的SQL SELECT语句返回查询获得的结果集
	 * <p/>
	 * 参数对象通常用于为SELECT语句的WHERE查询条件提供输入数据
	 * 
	 * @param statementName
	 *            需要执行语句的名称
	 * @param parameterObject
	 *            参数对象 (e.g. JavaBean, Map, XML etc.).
	 * @return 包含返回结果的集合 {@link List}
	 * @throws java.sql.SQLException
	 *             SQL异常产生时抛出
	 */
	@Override
	public List<?> selectForList(String statementName, Object parameterObject) {
		return this.sqlSessionTemplate.selectList(statementName, parameterObject);
	}

	/**
	 * 执行一个映射的SQL SELECT语句将返回的数据填充到一个对象中
	 * <p/>
	 * SELECT 语句不接收参数
	 * 
	 * @param statementName
	 *            需要执行语句的名称
	 * @return 填充了查询结果的一个对象,当没有返回结果的时候为null
	 * 
	 * @throws java.sql.SQLException
	 *             如果查询到多条记录 ,或者其他的SQL异常
	 */
	@Override
	public Object selectForObject(String statementName) {
		return this.sqlSessionTemplate.selectOne(statementName);
	}

	/**
	 * 执行一个映射的SQL SELECT语句将返回的数据填充到一个对象中
	 * <p/>
	 * 参数对象通常用于为SELECT语句的WHERE查询条件提供输入数据
	 * 
	 * @param statementName
	 *            需要执行语句的名称
	 * @param parameterObject
	 *            参数对象 (e.g. JavaBean, Map, XML etc.).
	 * @return 填充了查询结果的一个对象,当没有返回结果的时候为null
	 * @throws java.sql.SQLException
	 *             如果查询到多条记录 ,或者其他的SQL异常
	 */
	@Override
	public Object selectForObject(String statementName, Object parameterObject) {
		return this.sqlSessionTemplate.selectOne(statementName, parameterObject);
	}

	/**
	 * 执行一个映射的SQL UPDATE语句 ,Update同样可以用于其他的更新类型如insert和delete. 返回影响记录的行数 *
	 * <p/>
	 * UPDATE 语句不接收参数
	 * 
	 * @param statementName
	 *            需要执行语句的名称
	 * @return 返回影响记录的行数
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int update(String statementName) {
		return sqlSessionTemplate.update(statementName);
	}

	/**
	 * 执行一个映射的SQL UPDATE语句 ,Update同样可以用于其他的更新类型如insert和delete. 返回影响记录的行数
	 * <p/>
	 * 参数对象通常用于为UPDATE语句的WHERE查询条件提供输入数据
	 * 
	 * @param statementName
	 *            需要执行语句的名称
	 * @param parameterObject
	 *            参数对象 (e.g. JavaBean, Map, XML etc.).
	 * @return 返回影响记录的行数
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int update(String statementName, Object parameterObject) {
		return sqlSessionTemplate.update(statementName, parameterObject);
	}

	/**
	 * 执行一个映射的SQL UPDATE语句 ,Update同样可以用于其他的更新类型如insert和delete.<br />
	 * 当实际影响的行数和需要影响的行数不相等时抛出异常
	 * <p/>
	 * 参数对象通常用于为UPDATE语句的WHERE查询条件提供输入数据
	 * 
	 * @param statementName
	 *            需要执行语句的名称
	 * @param parameterObject
	 *            参数对象 (e.g. JavaBean, Map, XML etc.).
	 * @param requiredRowsAffected
	 *            需要影响的行数
	 * @throws JdbcUpdateAffectedIncorrectNumberOfRowsException
	 *             如果实际影响的行数和需要影响的行数不相等抛出
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(String statementName, Object parameterObject, int requiredRowsAffected) {
		int i = sqlSessionTemplate.update(statementName, parameterObject);
		if (requiredRowsAffected != i) {
			throw new JdbcUpdateAffectedIncorrectNumberOfRowsException(statementName, requiredRowsAffected, i);
		}
	}

	/**
	 * 执行一个映射的SQL INSERT语句, 返回产生的主键
	 * <p/>
	 * INSERT 语句不接收参数
	 * 
	 * @param statementName
	 *            需要执行语句的名称
	 * @return 产生的主键
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Object save(String statementName) {
		return sqlSessionTemplate.insert(statementName);
	}

	/**
	 * 执行一个映射的SQL INSERT语句, 返回产生的主键
	 * <p/>
	 * 参数对象通常用于为INSERT语句的WHERE查询条件提供输入数据
	 * 
	 * @param statementName
	 *            需要执行语句的名称
	 * @param parameterObject
	 *            参数对象 (e.g. JavaBean, Map, XML etc.).
	 * @return 产生的主键
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Object save(String statementName, Object parameterObject) {
		return sqlSessionTemplate.insert(statementName, parameterObject);
	}

	/**
	 * 执行一个映射的SQL DELETE语句 .返回影响记录的行数
	 * <p/>
	 * DELETE 语句不接收参数
	 * 
	 * @param statementName
	 *            需要执行语句的名称
	 * 
	 * @return 影响记录的行数
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int delete(String statementName) {
		return sqlSessionTemplate.delete(statementName);
	}

	/**
	 * 执行一个映射的SQL DELETE语句 .返回影响记录的行数
	 * <p/>
	 * 参数对象通常用于为INSERT语句的WHERE查询条件提供输入数据
	 * 
	 * @param statementName
	 *            需要执行语句的名称
	 * @param parameterObject
	 *            参数对象 (e.g. JavaBean, Map, XML etc.).
	 * @return 影响记录的行数
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int delete(String statementName, Object parameterObject) {
		return sqlSessionTemplate.delete(statementName, parameterObject);
	}

	/**
	 * 执行一个映射的SQL DELETE语句 <br />
	 * 当实际影响的行数和需要影响的行数不相等时抛出异常
	 * 
	 * @param statementName
	 *            需要执行语句的名称
	 * @param parameterObject
	 *            参数对象 (e.g. JavaBean, Map, XML etc.).
	 * @param requiredRowsAffected
	 *            如果实际影响的行数和需要影响的行数不相等抛出
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(String statementName, Object parameterObject, int requiredRowsAffected) {
		int i = sqlSessionTemplate.delete(statementName, parameterObject);
		if (requiredRowsAffected != i) {
			throw new JdbcUpdateAffectedIncorrectNumberOfRowsException(statementName, requiredRowsAffected, i);
		}
	}


	@Resource(name = "sqlSessionTemplate")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}
