package com.dao;

import java.util.ArrayList;

import com.entity.Post;
public interface PostDao {
	//查找所有职位
	public ArrayList<Post> getAllPost();
	//查看职位
	public Post getPostById(int pid);
	//关闭资源
	public void close();
}
