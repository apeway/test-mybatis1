package org.liws.mybatis.model.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.liws.mybatis.model.SimpleUser;

/**
 * 可以为每一个xml增加一个Mapper接口，为xml中每一个方法增加相应的接口方法
 */
public interface UserAnnoMapper {

	@Insert("insert into t_user (user_name, password, nickname, type) "
			+ "value (#{user_name}, #{password}, #{nickname}, #{type})")
	public void add(SimpleUser user);
	
	@Update("update t_user set "
			+ "nickname = #{nickname}, password = #{password}, type = #{type} "
			+ "where id = #{id}")
	public void update(SimpleUser user);
	
	@Delete("delete from t_user "
			+ "where id = #{id}")
	public void delete(@Param("id") int id);
	
	@Select("select * from t_user where id=#{id}")
	public SimpleUser load(@Param("id") int id);
	
	@Select("select * from t_user")
	public List<SimpleUser> list();
	
}
