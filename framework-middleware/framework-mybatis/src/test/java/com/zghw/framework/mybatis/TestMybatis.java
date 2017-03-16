package com.zghw.framework.mybatis;

import java.io.Reader;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class TestMybatis {

	public static void main(String[] args) {
		// 初始化数据库连接池
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/framework");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		// 构建数据库事务方式
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		// 创建了数据库运行环境
		Environment environment = new Environment("development", transactionFactory, dataSource);
		// 创建一个Configuration类对象,并把数据库运行环境注册给它.
		Configuration config = new Configuration(environment);
		// 注册一个role的别名.
		config.getTypeAliasRegistry().registerAlias("user", User.class);
		// 加入一个映射器
		config.addMapper(UserMapper.class);
		// 用SqlSessionFactoryBuilder 通过Configuration对象创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			UserMapper userMapper = session.getMapper(UserMapper.class);
			User saveUser = new User();
			saveUser.setName("zghw");
			saveUser.setAge(18);
			userMapper.save(saveUser);
			User user = userMapper.getById(1L);
			System.out.println(user.getName());
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}

}
