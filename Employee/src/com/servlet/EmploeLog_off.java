package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.EmploeDaoImpl;

public class EmploeLog_off extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmploeDaoImpl edi = new EmploeDaoImpl();
		String eid = request.getParameter("eid");
		boolean flag = edi.remove(Integer.parseInt(eid));
		if(flag){
			response.sendRedirect("index.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
