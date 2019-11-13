package org.liws.mybatis.model.mapper;

import java.util.List;

import org.liws.mybatis.model.SimpleUser;

/**
 * 可以为每一个xml增加一个Mapper接口，为xml中每一个方法增加相应的接口方法
 */
public interface UserXmlMapper {

	public void add(SimpleUser user);
	
	public void update(SimpleUser user);
	
	public void delete(int id);
	
	public SimpleUser load(int id);
	
	public List<SimpleUser> list();
}
