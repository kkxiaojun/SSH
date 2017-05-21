package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.*;
import com.entity.Dept;

public class ManagerDeptUpdate extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String did = request.getParameter("did");
		DeptDaoImpl ddi = new DeptDaoImpl();
		Dept dept = ddi.getDeptById(Integer.parseInt(did));
		request.getSession().setAttribute("dept", dept);
		ArrayList<Dept> deptList = ddi.getAllDept();
		request.getSession().setAttribute("deptList", deptList);
		response.sendRedirect("manager/dept_update.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
