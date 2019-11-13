package org.liws.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.liws.mybatis.model.SimpleUser;
import org.liws.mybatis.model.mapper.UserAnnoMapper;
import org.liws.mybatis.model.mapper.UserXmlMapper;
import org.liws.mybatis.util.MyBatisUtil;

public class T1_MyBatis {
	
	// XXX 为了方便调用，mapper文件的namespace最好设置为类的全路径名
	private final String USER_NAMESPACE = SimpleUser.class.getName(); 
	
	@Test
	public void testLoad() {
		SqlSession session = null;
		try{
			session = MyBatisUtil.openSession();
			
			SimpleUser user = (SimpleUser) session.selectOne(USER_NAMESPACE + ".load", 1);
			System.out.println(user);
			
			user = session.getMapper(UserXmlMapper.class).load(1);
			System.out.println(user);
			
			user = session.getMapper(UserAnnoMapper.class).load(1);
			System.out.println(user);
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	/**
	 * SqlSessionFactoryBuilder、Resources
	 * SqlSessionFactory
	 * SqlSession
	 */
	@Test
	public void testAdd() {
		SqlSession session = null;
		try {
			// 1、从SQLSessionFactory获取SqlSession
			session = MyBatisUtil.openSession();
			
			SimpleUser user = new SimpleUser();
			user.setNickname("孙悟空");
			user.setPassword("111");
			user.setType(1);
			user.setUser_name("wukong");
			// 2.1、调用mapper文件（XXX mybatis配置文件中需要配置好<mappers>节点）
			session.insert(USER_NAMESPACE + ".add", user);
			
			user = new SimpleUser();
			user.setNickname("猪八戒");
			user.setPassword("222");
			user.setType(1);
			user.setUser_name("bajie");
			// 2.2、调用mapper接口
			session.getMapper(UserXmlMapper.class).add(user); 

			user = new SimpleUser();
			user.setNickname("沙悟净");
			user.setPassword("333");
			user.setType(1);
			user.setUser_name("wujing");
			// 2.3、调用mapper接口
			session.getMapper(UserAnnoMapper.class).add(user); 
			
			// 3、session提交
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// session回滚
			session.rollback();
		} finally {
			// 4、session关闭
			MyBatisUtil.closeSession(session);
		}
	}

	@Test
	public void testUpdate() {
		SqlSession session = null;
		try {
			session = MyBatisUtil.openSession();
			
			SimpleUser user = new SimpleUser(2);
			user.setNickname("孙悟空update");
			user.setPassword("111update");
			user.setType(0);
			session.update(USER_NAMESPACE + ".update", user);
			
			user = new SimpleUser(3);
			user.setNickname("猪八戒update");
			user.setPassword("222update");
			user.setType(0);
			session.update(USER_NAMESPACE + ".update", user);
			session.getMapper(UserXmlMapper.class).update(user);
			
			user = new SimpleUser(4);
			user.setNickname("沙悟净update");
			user.setPassword("333update");
			user.setType(0);
			session.update(USER_NAMESPACE + ".update", user);
			session.getMapper(UserAnnoMapper.class).update(user);
			
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}
	
	@Test
	public void testList() {
		SqlSession session = null;
		try{
			session = MyBatisUtil.openSession();
			
			List<SimpleUser> users = session.selectList(USER_NAMESPACE + ".list");
			System.out.println(users);
			
			users = session.getMapper(UserXmlMapper.class).list();
			System.out.println(users);

			users = session.getMapper(UserAnnoMapper.class).list();
			System.out.println(users);
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	@Test
	public void testDelete() {
		SqlSession session = null;
		try {
			session = MyBatisUtil.openSession();
			
			session.delete(USER_NAMESPACE + ".delete", 2);
			
			session.getMapper(UserXmlMapper.class).delete(3);
			
			session.getMapper(UserAnnoMapper.class).delete(4);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}
	
}
