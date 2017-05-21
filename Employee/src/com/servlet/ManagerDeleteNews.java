package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.MessageDaoImpl;
import com.entity.Message;

public class ManagerDeleteNews extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		MessageDaoImpl mdi = new MessageDaoImpl();
		boolean flag = mdi.deleteNews(Integer.parseInt(mid));
		System.out.println(flag);
		if(flag){
			response.sendRedirect("NewsTable");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
