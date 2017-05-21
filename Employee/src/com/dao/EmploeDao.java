package com.dao;

import java.util.ArrayList;
import com.entity.Emploe;

//员工管理
public interface EmploeDao {
	//员工注册（包含问题及问题答案）
	public boolean registerEmploe(Emploe emploe);
	//员工注册（不包含问题及问题答案）
	public boolean registerEmploe2(Emploe emploe);
	//管理员添加员工
	 public boolean addEmploe(Emploe emploe);
	//注销账户
	public	boolean remove(int eid);
	
	//更新员工
	public boolean updateEmploe(int eid,Emploe emploe);
	//通过名字查询员工
	public Emploe getEmploeByName(String ename);
	
	//通过编号查询员工 
	public Emploe getEmploeById(int eid);
	
	//通过部门查员工
	public ArrayList<Emploe> getEmploeByDname(String dname);
	//通过pname获得所有员工
	public ArrayList<Emploe> getEmploeByPname(String pname);
	//通过eid更改pid
	public boolean updatePidByEid(int eid,int pid);
	//查看所有员工
	public ArrayList<Emploe> getAllEmploe();
	//通过分页查看所有员工
	public ArrayList<Emploe> getAllEmploeByPage(int pageNow);
	//登录
	public int emploeLogin(int eid, String epassword);
	//关闭资源
	public void close();
}	
