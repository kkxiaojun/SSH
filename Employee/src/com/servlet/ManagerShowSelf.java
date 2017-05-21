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
import com.entity.Dept;
import com.entity.Emploe;
import com.entity.Post;

public class ManagerShowSelf extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eid =request.getParameter("eid");
		EmploeDaoImpl edi = new EmploeDaoImpl();
		Emploe emploe = edi.getEmploeById(Integer.parseInt(eid));
		DeptDaoImpl ddi = new DeptDaoImpl();
		Dept dept1 = ddi.getDeptById(emploe.getDid());
		request.getSession().setAttribute("dept1", dept1);
		ArrayList<Dept> deptList = ddi.getAllDept();
		request.getSession().setAttribute("deptList", deptList);
		PostDaoImpl pdi = new PostDaoImpl();
		Post post1 = pdi.getPostById(emploe.getPid());
		request.getSession().setAttribute("post1", post1);
		ArrayList<Post> postList = pdi.getAllPost();
		request.getSession().setAttribute("postList", postList);
		request.getSession().setAttribute("emploe", emploe);
		response.sendRedirect("manager/emploe_update.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
