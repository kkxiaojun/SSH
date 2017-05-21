package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.DeptDaoImpl;
import com.daoImpl.EmploeDaoImpl;
import com.daoImpl.MessageDaoImpl;
import com.daoImpl.PostDaoImpl;
import com.entity.Dept;
import com.entity.Emploe;
import com.entity.Message;
import com.entity.Post;

public class ManagerNewsDetail extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String muser = request.getParameter("muser");
		MessageDaoImpl mdi = new MessageDaoImpl();
		Message msg = mdi.getMsgByUser(muser);
		request.getSession().setAttribute("msg", msg);
		response.sendRedirect("manager/news_detail.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
