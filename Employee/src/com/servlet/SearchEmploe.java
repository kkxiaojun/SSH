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

public class SearchEmploe extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ename = request.getParameter("ename");
		String eid = request.getParameter("eid");
		String dname = request.getParameter("dname");
		EmploeDaoImpl edi = new EmploeDaoImpl();
		DeptDaoImpl ddi = new DeptDaoImpl();
		ArrayList<Dept> deptList =ddi.getAllDept();
		request.getSession().setAttribute("deptList", deptList);
		if(ename!=null&&!ename.equals("")){
			System.out.println("姓名检索执行了");
			Emploe emploe = edi.getEmploeByName(ename);
			request.getSession().setAttribute("emploe", emploe);
			ArrayList<Emploe> listByPage =new ArrayList<Emploe>();
			listByPage.add(emploe);
			request.getSession().setAttribute("listByPage", listByPage);
			response.sendRedirect("manager/emploe_table.jsp");
		}else if(eid!=null&&!eid.equals("")){
			System.out.println("编号检索执行了");
			Emploe emploe = edi.getEmploeById(Integer.parseInt(eid));
			request.getSession().setAttribute("emploe", emploe);
			ArrayList<Emploe> listByPage =new ArrayList<Emploe>();
			listByPage.add(emploe);
			System.out.println("员工id----》"+emploe.getEid()+"员工名字----》"+emploe.getEname());
			request.getSession().setAttribute("listByPage", listByPage);
			response.sendRedirect("manager/emploe_table.jsp");
		}else if(dname!=null&&!dname.equals("")){
			System.out.println("部门检索执行了");
			ArrayList<Emploe> listByPage = edi.getEmploeByDname(dname);
			request.getSession().setAttribute("listByPage", listByPage);
			response.sendRedirect("manager/emploe_table.jsp");
		}
		
}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
