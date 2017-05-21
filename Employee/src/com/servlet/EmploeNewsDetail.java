package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.MessageDaoImpl;
import com.entity.Message;

public class EmploeNewsDetail extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String muser = request.getParameter("muser");
		System.out.println(muser);
		MessageDaoImpl mdi = new MessageDaoImpl();
		Message msg = mdi.getMsgByUser(muser);
		System.out.println(msg.getMcontent());
		request.getSession().setAttribute("msg", msg);
		response.sendRedirect("emploe/news_detail.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
