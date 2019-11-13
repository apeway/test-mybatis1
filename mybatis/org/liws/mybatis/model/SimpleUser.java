package org.liws.mybatis.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SimpleUser {
	private int id;
	private String user_name;
	private String password;
	private String nickname;
	private int type;	// 默认为0表示普通用户、1表示管理员
	
	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", password=" + password + ", nickname=" + nickname
				+ ", type=" + type + "]";
	}

	public SimpleUser(int id) {
		super();
		this.id = id;
	}
	public SimpleUser() {
		super();
	}
}
