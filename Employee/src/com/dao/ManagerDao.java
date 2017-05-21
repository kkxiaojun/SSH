package com.dao;

import com.entity.Manager;

public interface ManagerDao {
	//管理员账号mname和密码mpassword登录
	public int managerLogin(String mname,String mpassword);
	//通过mid更改管理员密码
	public boolean mupdatePassword(int mid,String newPsw);
	//通过账号获得管理员
	public Manager getMangerByName(String mname);
	//关闭资源
	public void close();
}
