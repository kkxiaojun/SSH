package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.DeptDaoImpl;
import com.entity.Dept;

public class ManagerDeptUpdate_table extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String did = request.getParameter("did");
		String dname = request.getParameter("dname");
		String dnumber = request.getParameter("dnumber");
		String daddr = request.getParameter("daddr");
		String eid= request.getParameter("eid");
		Dept dept = new Dept();
		dept.setDid(Integer.parseInt(did));
		dept.setDname(dname);
		dept.setDnumber(Integer.parseInt(dnumber));
		dept.setDaddr(daddr);
		dept.setEid(Integer.parseInt(eid));
		DeptDaoImpl ddi = new DeptDaoImpl();
		boolean flag = ddi.updateDept(Integer.parseInt(did), dept);
		if(flag){
			response.sendRedirect("ManagerDeptTable");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
