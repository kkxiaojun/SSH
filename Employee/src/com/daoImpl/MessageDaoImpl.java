package com.daoImpl;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.dao.MessageDao;
import com.entity.Emploe;
import com.entity.Message;
import com.util.ConnDB;

public class MessageDaoImpl implements MessageDao {
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
	
	
	//分页处理消息
	int lineCount = 0;
	public int getLineCount(){
		return lineCount;
	}
	int pageCount = 0;
	public int getPageCount(){
		return pageCount;
	}
	public ArrayList<Message> getALlMsgByPage(int n){
		int pageSize = 3;
		int pageNow = n;
		
		ArrayList<Message> msgList = new  ArrayList<Message>();
		conn = ConnDB.getConn();
		try {
			psta=conn.prepareStatement("select count(*) from message where mstatus=1");
			rs = psta.executeQuery();
			if(rs.next()){
				lineCount = rs.getInt(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		pageCount = (int)Math.ceil(lineCount*1.0/pageSize);
		try {
			psta=conn.prepareStatement("select * from message where mstatus=1 limit ?,?");
			psta.setInt(1, (pageNow-1)*pageSize);
			psta.setInt(2, pageSize);
			rs = psta.executeQuery();
			while(rs.next()){
				Message msg = new Message();
				msg.setMid(rs.getInt("mid"));
				msg.setMuser(rs.getString("muser"));
				msg.setMtitle(rs.getString("mtitle"));
				msg.setMtime(rs.getDate("mtime"));
				msg.setMcontent(rs.getString("mcontent"));
				msgList.add(msg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return msgList; 
	}
	
	
	
	public ArrayList<Message> getALlMsg() {
		ArrayList<Message> msgList = new  ArrayList<Message>();
		conn = ConnDB.getConn();
		try {
			psta=conn.prepareStatement("select * from message where mstatus=1");
			rs = psta.executeQuery();
			while(rs.next()){
				Message msg = new Message();
				msg.setMid(rs.getInt("mid"));
				msg.setMuser(rs.getString("muser"));
				msg.setMtitle(rs.getString("mtitle"));
				msg.setMtime(rs.getDate("mtime"));
				msg.setMcontent(rs.getString("mcontent"));
				msgList.add(msg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return msgList; 
	}

	public boolean addMessage(Message msg) {
		boolean flag = false;
		conn = ConnDB.getConn();
		try {
			psta=conn.prepareStatement("insert into message(mtitle,mcontent,mtime,muser,mstatus) values(?,?,?,?,?)");
			psta.setString(1, msg.getMtitle());
			psta.setString(2, msg.getMcontent());
			psta.setDate(3, new java.sql.Date(msg.getMtime().getTime()));
			psta.setString(4, msg.getMuser());
			psta.setInt(5, 1);
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

	public Message getMsgByUser(String muser) {
		Message msg = new Message();
		conn = ConnDB.getConn();
		try {
			psta=conn.prepareStatement("select * from message where muser=?");
			psta.setString(1,muser);
			rs = psta.executeQuery();
			if(rs.next()){
				msg.setMid(rs.getInt("mid"));
				msg.setMtitle(rs.getString("mtitle"));
				msg.setMtime(rs.getDate("mtime"));
				msg.setMcontent(rs.getString("mcontent"));
				msg.setMstatus(rs.getInt("mstatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return msg; 
	}
	//通过将状态值从一改为零实现
	public boolean deleteNews(int mid) {
		boolean flag = false;
		conn = ConnDB.getConn();
		try {
			psta=conn.prepareStatement("update message set mstatus=0 where mid=?");
			psta.setInt(1,mid);
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
