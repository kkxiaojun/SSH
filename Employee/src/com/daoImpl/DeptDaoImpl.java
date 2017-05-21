package com.daoImpl;

import java.sql.*;
import java.util.ArrayList;

import com.dao.DeptDao;
import com.entity.Dept;
import com.entity.Message;
import com.util.ConnDB;

public class DeptDaoImpl implements DeptDao {
	Connection conn = null;
	PreparedStatement psta = null;
	ResultSet rs = null;
	
	/**
	 * 根据id查询部门
	 */
	public Dept getDeptById(int did) {
		Dept dept = new Dept();
		conn = ConnDB.getConn();
		try {
			psta = conn.prepareStatement("select * from dept where did=?");
			psta.setInt(1, did);
			rs = psta.executeQuery();
			if(rs.next()){
				dept.setDname(rs.getString("dname"));
				dept.setDaddr(rs.getString("daddr"));
				dept.setDnumber(rs.getInt("dnumber"));
				dept.setEid(rs.getInt("eid"));
				dept.setDstatus(rs.getInt("dstatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return dept;
	}
	/**
	 * 关闭数据库连接
	 */
	public void close() {
		try {
			if(rs!=null){
				rs.close();
			}
			if(psta!=null){
				psta.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询所有部门
	 */
	public ArrayList<Dept> getAllDept() {
		ArrayList<Dept> list = new ArrayList<Dept>();
		conn = ConnDB.getConn();
		try {
			psta = conn.prepareStatement("select * from dept where dstatus=1");
			rs = psta.executeQuery();
			while(rs.next()){
				Dept dept = new Dept();
				dept.setDid(rs.getInt("did"));
				dept.setDname(rs.getString("dname"));
				dept.setDaddr(rs.getString("daddr"));
				dept.setDnumber(rs.getInt("dnumber"));
				dept.setEid(rs.getInt("eid"));
				dept.setDstatus(rs.getInt("dstatus"));
				list.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return list;
	}
	
	/**
	 * 分页查询部门
	 */
	int lineCount = 0;
	public int getLineCount(){
		return lineCount;
	}
	int pageCount = 0;
	public int getPageCount(){
		return pageCount;
	}
	public ArrayList<Dept> getAllDeptByPage(int n) {
		int pageSize = 2;
		int pageNow = n;
		
		ArrayList<Dept> deptList = new  ArrayList<Dept>();
		conn = ConnDB.getConn();
		try {
			psta=conn.prepareStatement("select count(*) from dept where dstatus=1");
			rs = psta.executeQuery();
			if(rs.next()){
				lineCount = rs.getInt(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		pageCount = (int)Math.ceil(lineCount*1.0/pageSize);
		try {
			psta=conn.prepareStatement("select * from dept where dstatus=1 limit ?,?");
			psta.setInt(1, (pageNow-1)*pageSize);
			psta.setInt(2, pageSize);
			rs = psta.executeQuery();
			while(rs.next()){
				Dept dept = new Dept();
				dept.setDid(rs.getInt("did"));
				dept.setDname(rs.getString("dname"));
				dept.setDnumber(rs.getInt("dnumber"));
				dept.setDaddr(rs.getString("daddr"));
				dept.setEid(rs.getInt("eid"));
				dept.setDstatus(1);
				deptList.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return deptList; 
	}
	
	/**
	 * 新增部门
	 */
	public boolean insertDept(Dept dept) {
		boolean flag = false;
		conn = ConnDB.getConn();
		try {
			psta=conn.prepareStatement("insert into dept(did,dname,dnumber,daddr,eid,dstatus) values(?,?,?,?,?,?)");
			psta.setInt(1, dept.getDid());
			psta.setString(2, dept.getDname());
			psta.setInt(3, dept.getDnumber());
			psta.setString(4, dept.getDaddr());
			psta.setInt(5, dept.getEid());
			psta.setInt(6,1);
			int n = psta.executeUpdate();
			if(n>0){
				flag = true;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return flag;
	}
	/**
	 * 更新部门
	 */
	public boolean updateDept(int did,Dept dept) {
		boolean flag = false;
		conn = ConnDB.getConn();
		try {
			psta=conn.prepareStatement("update dept set did=?,dname=?,dnumber=?,daddr=?,eid=? where did=?");
			psta.setInt(1, dept.getDid());
			psta.setString(2, dept.getDname());
			psta.setInt(3, dept.getDnumber());
			psta.setString(4, dept.getDaddr());
			psta.setInt(5, dept.getEid());
			psta.setInt(6, did);
			int n = psta.executeUpdate();
			if(n>0){
				flag = true;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return flag;
	}

}
