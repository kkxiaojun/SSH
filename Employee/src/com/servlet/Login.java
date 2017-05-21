package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.DeptDaoImpl;
import com.daoImpl.EmploeDaoImpl;
import com.daoImpl.PostDaoImpl;
import com.entity.Dept;
import com.entity.Emploe;
import com.entity.Post;

public class Login extends HttpServlet {

	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eid = request.getParameter("username");
		String epassword = request.getParameter("password");
		String cookie = request.getParameter("autologin");
		if(cookie.equals("auto")&&cookie!=null){
			Cookie c1 = new Cookie("username",eid);
			Cookie c2 = new Cookie("password",epassword);
			c1.setMaxAge(60*60*24);
			c2.setMaxAge(60*60*24);
			response.addCookie(c1);
			response.addCookie(c2);
		}
			EmploeDaoImpl edi =new EmploeDaoImpl();
			int n =edi.emploeLogin(Integer.parseInt(eid), epassword);
			Emploe emploe =	edi.getEmploeById(Integer.parseInt(eid));
			if(n==1){
				DeptDaoImpl ddi = new DeptDaoImpl();
				ArrayList<Dept> deptList = ddi.getAllDept();
				request.getSession().setAttribute("deptList", deptList);
				PostDaoImpl pdi = new PostDaoImpl();
				ArrayList<Post> postList = pdi.getAllPost();
				request.getSession().setAttribute("postList", postList);
				request.getSession().setAttribute("emploe",emploe);
				response.sendRedirect("EmploeShowSelf");
			}else if(n==2){
				response.sendRedirect("login.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
