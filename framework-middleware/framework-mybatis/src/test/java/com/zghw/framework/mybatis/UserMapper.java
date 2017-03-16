package com.zghw.framework.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	@Select("SELECT * FROM user WHERE id = #{id}")
	public User getById(Long id);
	@Insert("insert into user(name,age) values(#{name},#{age})")
	public void save(User user);
}
