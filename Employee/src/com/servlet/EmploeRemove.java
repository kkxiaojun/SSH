package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.EmploeDaoImpl;
import com.entity.Emploe;
import com.entity.Manager;

public class EmploeRemove extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eid = request.getParameter("eid");
		EmploeDaoImpl edi = new EmploeDaoImpl();
		boolean flag = edi.remove(Integer.parseInt(eid));
		if(flag){
			response.sendRedirect("EmploeTable");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
