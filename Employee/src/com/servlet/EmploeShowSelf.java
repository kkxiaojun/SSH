package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.DeptDaoImpl;
import com.daoImpl.PostDaoImpl;
import com.entity.Dept;
import com.entity.Post;

public class EmploeShowSelf extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DeptDaoImpl ddi = new DeptDaoImpl();
		ArrayList<Dept> deptList = ddi.getAllDept();
		request.getSession().setAttribute("deptList", deptList);
		PostDaoImpl pdi = new PostDaoImpl();
		ArrayList<Post> postList = pdi.getAllPost();
		request.getSession().setAttribute("postList", postList);
		response.sendRedirect("emploe/show_self.jsp");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
