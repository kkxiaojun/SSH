package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.DeptDaoImpl;
import com.daoImpl.EmploeDaoImpl;
import com.daoImpl.PostDaoImpl;
import com.entity.Emploe;
import com.entity.Post;

public class ManagerDeptTable_add extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmploeDaoImpl edi = new EmploeDaoImpl();
		//适合当经理的职位架构师，列出所有适合人选
		ArrayList<Emploe> pnameList = edi.getEmploeByPname("架构师");
		request.getSession().setAttribute("pnameList", pnameList);
		response.sendRedirect("manager/dept_add.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
