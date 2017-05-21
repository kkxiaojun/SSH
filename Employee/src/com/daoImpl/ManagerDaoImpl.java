package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.ManagerDao;
import com.entity.Emploe;
import com.entity.Manager;
import com.util.ConnDB;

public class ManagerDaoImpl implements ManagerDao {
	Connection conn = null;
	PreparedStatement psta = null;
	ResultSet rs = null;
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

	public int managerLogin(String mname, String mpassword) {
		int n = 0;//1代表登录成功，2代表密码错误，3代表用户名不存在
		conn = ConnDB.getConn();
		try {
			psta=conn.prepareStatement("select mpassword from manager where mname=?");
			psta.setString(1, mname);
			rs = psta.executeQuery();
			if(rs.next()){
				if(mpassword.equals(rs.getString("mpassword"))){
					n=1;
				}else{
					n=2;
				}
			}else{
				n=3;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return  n;
	}

	public Manager getMangerByName(String mname) {
		Manager manager = new Manager();
		conn = ConnDB.getConn();
		try {
			psta=conn.prepareStatement("select * from manager where mname=?");
			psta.setString(1, mname);
			rs = psta.executeQuery();
			if(rs.next()){
				manager.setMid(rs.getInt("mid"));
				manager.setMname(rs.getString("mname"));
				manager.setMpassword(rs.getString("mpassword"));
				manager.setMpower(rs.getInt("mpower"));
				manager.setMstatus(rs.getInt("mstatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return manager;
	}

	public boolean mupdatePassword(int mid,String newPsw) {
		boolean flag = false;
		conn = ConnDB.getConn();
		try {
			psta=conn.prepareStatement("update manager set mpassword=? where mid=?");
			psta.setString(1, newPsw);
			psta.setInt(2, mid);
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
