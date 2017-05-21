package com.daoImpl;

import java.sql.*;
import java.util.ArrayList;

import com.dao.PostDao;
import com.entity.Post;
import com.util.ConnDB;

public class PostDaoImpl implements PostDao {
	Connection conn = null;
	PreparedStatement psta = null;
	ResultSet rs = null;
	
	public ArrayList<Post> getAllPost() {
		ArrayList<Post> postList = new ArrayList<Post>();
		conn = ConnDB.getConn();
		try {
			psta = conn.prepareStatement("select * from post where pstatus=1");
			rs = psta.executeQuery();
			while(rs.next()){
				Post post = new Post();
				post.setPid(rs.getInt("pid"));
				post.setPname(rs.getString("pname"));
				post.setPstatus(rs.getInt("pstatus"));
				postList.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return postList;
	}
	public Post getPostById(int pid) {
		Post post = new Post();
		conn = ConnDB.getConn();
		try {
			psta = conn.prepareStatement("select * from post where pid=? and pstatus=1");
			psta.setInt(1, pid);
			rs = psta.executeQuery();
			if(rs.next()){
				post.setPid(rs.getInt("pid"));
				post.setPname(rs.getString("pname"));
				post.setPstatus(rs.getInt("pstatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return post;
	}
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
}
