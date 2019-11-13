
====== mybatis开发流程：

	1、创建【配置文件】，在该文件中完成和数据库的连接设置操作
		在配置文件中<properties>、<settings>、<environments>元素
	
	2、根据数据表创建相应的实体类
		在配置文件中配置好<typeAliases>元素
	
	3、创建【映射文件】、mapper接口等完成对实体类的映射 
		在配置文件中配置好<mappers>元素
		
	4、创建一个Mybatis工具类，使用API完成对数据库的操作

	   
