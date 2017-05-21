package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.DeptDaoImpl;
import com.entity.Dept;
import com.entity.Message;

public class ManagerDeptTable extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DeptDaoImpl ddi = new DeptDaoImpl();
		String pageNow =request.getParameter("n");
		if(pageNow==null||pageNow.equals("")){
			pageNow="1";
		}
		if(Integer.parseInt(pageNow)<1){
			pageNow="1";
		}
		int pageCount =1;
		if(request.getSession().getAttribute("pageCount")!=null&&!request.getSession().getAttribute("pageCount").equals("")){
			pageCount =(Integer)request.getSession().getAttribute("pageCount");
		}
		if(Integer.parseInt(pageNow)>pageCount){
			pageNow = pageCount+"";
		}
		ArrayList<Dept> deptlist = ddi.getAllDeptByPage(Integer.parseInt(pageNow));
		System.out.println("ÎÒÊÇ·ñÎª¿Õ"+deptlist.isEmpty());
		request.getSession().setAttribute("deptlist", deptlist);
		pageCount =ddi.getPageCount();
		request.getSession().setAttribute("pageCount", pageCount);
		request.getSession().setAttribute("pageNow", pageNow);
		int lineCount =ddi.getLineCount();
		request.getSession().setAttribute("lineCount", lineCount);
		response.sendRedirect("manager/dept_table.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

}
