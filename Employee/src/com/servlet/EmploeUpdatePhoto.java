package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.EmploeDaoImpl;
import com.entity.Emploe;

public class EmploeUpdatePhoto extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ephoto = request.getParameter("img");
		System.out.println(ephoto);
		EmploeDaoImpl edi = new EmploeDaoImpl();
		Emploe emploe =(Emploe)request.getSession().getAttribute("emploe");
		if(ephoto!=null&&!ephoto.equals("")){
			emploe.setEphoto(ephoto);
			boolean flag = edi.updateEmploe(emploe.getEid(), emploe);
			if(flag){
				request.getSession().setAttribute("emploe", emploe);
				response.sendRedirect("emploe/show_self.jsp");
			}else{
				response.sendRedirect("emploe/showImage.jsp");
			}
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
