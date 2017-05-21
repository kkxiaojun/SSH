package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.EmploeDaoImpl;
import com.entity.Emploe;

public class InitPassword extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Emploe emploe = (Emploe)request.getSession().getAttribute("emploe");
		emploe.setEpassword(emploe.getEid()+"");
		EmploeDaoImpl edi = new EmploeDaoImpl();
		PrintWriter out = response.getWriter();
		boolean flag = edi.updateEmploe(emploe.getEid(), emploe);
		if(flag){
			out.print("<font color='green'>¡Ì</font>");
			request.getSession().setAttribute("emploe", emploe);
			response.sendRedirect("EmploeDetail?eid="+emploe.getEid());
		}
	}	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
