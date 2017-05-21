package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.EmploeDaoImpl;
import com.entity.Emploe;

public class FindPassword extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eid = request.getParameter("eid");
		String equestion= request.getParameter("equestion");
		String eanswer = request.getParameter("eanswer");
		EmploeDaoImpl edi = new EmploeDaoImpl();
		Emploe emploe = edi.getEmploeById(Integer.parseInt(eid));
		if(emploe!=null){
			if(equestion.equals(emploe.getEquestion())&&eanswer.equals(emploe.getEanswer())){
				request.getSession().setAttribute("emploe", emploe);
				response.sendRedirect("failure.jsp?log=epassword");
			}else{
				response.sendRedirect("findpassword.jsp");
			}
		}else{
			response.sendRedirect("findpassword.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
