package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.DeptDaoImpl;
import com.daoImpl.EmploeDaoImpl;
import com.daoImpl.PostDaoImpl;
import com.entity.Dept;
import com.entity.Emploe;
import com.entity.Post;

public class EmploeDetail extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eid = request.getParameter("eid");
		EmploeDaoImpl edi = new EmploeDaoImpl();
		Emploe emploe = edi.getEmploeById(Integer.parseInt(eid));
		DeptDaoImpl ddi = new DeptDaoImpl();
		Dept dept = ddi.getDeptById(emploe.getDid());
		String dname =dept.getDname();
		request.getSession().setAttribute("dname",dname);
		PostDaoImpl pdi = new PostDaoImpl();
		Post post = pdi.getPostById(emploe.getPid());
		String pname =post.getPname();
		request.getSession().setAttribute("pname",pname);
		request.getSession().setAttribute("emploe", emploe);
		response.sendRedirect("manager/emploe_detail.jsp");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
