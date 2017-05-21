package com.dao;

import java.util.ArrayList;
import com.entity.Message;

public interface MessageDao {
	//查看所有留言
	public ArrayList<Message> getALlMsg();
	//通过分页查看所有留言
	public ArrayList<Message> getALlMsgByPage(int n);
	//添加留言
	public boolean addMessage(Message msg);
	//通过muser查询留言详情
	public Message getMsgByUser(String muser);
	//通过mid删除留言信息
	public boolean deleteNews(int mid);
	//关闭资源
	public void close();
}
