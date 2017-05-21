package com.util;
import java.sql.*;
import java.util.*;
public class ConnPool {
	private String username  = "root";
	private String password = "123456";
	private String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
	private static String driverName = "com.mysql.jdbc.Driver";
	private LinkedList<Connection> list = new LinkedList<Connection>();
	
	static{
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public ConnPool(){
		for(int i = 0 ;i < 10; i++){
			Connection conn;
			try {
				conn = DriverManager.getConnection(url, username, password);
				list.add(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public Connection get(){
		if(list.size()<1){
			Connection conn;
			try {
				conn = DriverManager.getConnection(url, username, password);
				list.add(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list.removeLast();
	}
	public void put(Connection conn){
		list.addFirst(conn);
	}
}
