package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.MessageDaoImpl;
import com.entity.Message;

public class ManagerNewsAdd extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mtitle = request.getParameter("mtitle");
		String muser = request.getParameter("muser");
		String mcontent = request.getParameter("mcontent");
		Date d = new Date();
		String mtime = d.toLocaleString();
		System.out.println(mtime);
		Message msg = new Message();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			msg.setMtime(sdf.parse(mtime));
			System.out.println(sdf.parse(mtime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		msg.setMtitle(mtitle);
		msg.setMcontent(mcontent);
		msg.setMuser(muser);
		msg.setMstatus(1);
		MessageDaoImpl mdi = new MessageDaoImpl();
		boolean flag = mdi.addMessage(msg);
		if(flag){
			request.getSession().setAttribute("Message", msg);
			response.sendRedirect("NewsTable");
		}else{
			response.sendRedirect("manager/news_add.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
