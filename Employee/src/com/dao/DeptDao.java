package com.dao;

import java.util.ArrayList;

import com.entity.Dept;

public interface DeptDao {
	//查看部门
	public Dept getDeptById(int did);
	//查找所有部门
	public ArrayList<Dept> getAllDept();
	//通过分页查找所有部门
	public ArrayList<Dept> getAllDeptByPage(int n);
	//添加部门
	public boolean insertDept(Dept dept);
	//更新部门
	public boolean updateDept(int did,Dept dept);
	//关闭资源
	public void close();
}
