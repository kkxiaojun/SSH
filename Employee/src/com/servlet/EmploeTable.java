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
import com.entity.Dept;
import com.entity.Emploe;
import com.entity.Manager;

public class EmploeTable extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmploeDaoImpl edi = new EmploeDaoImpl();
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
		ArrayList<Emploe> listByPage = edi.getAllEmploeByPage(Integer.parseInt(pageNow));
		request.getSession().setAttribute("listByPage", listByPage);
		DeptDaoImpl ddi = new DeptDaoImpl();
		ArrayList<Dept> deptList =ddi.getAllDept();
		request.getSession().setAttribute("deptList", deptList);
		pageCount =edi.getPageCount();
		request.getSession().setAttribute("pageCount", pageCount);
		System.out.println(pageNow);
		request.getSession().setAttribute("pageNow", pageNow);
		int lineCount =edi.getLineCount();
		request.getSession().setAttribute("lineCount", lineCount);
		String mname = (String)request.getSession().getAttribute("mname");
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		response.sendRedirect("manager/emploe_table.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
