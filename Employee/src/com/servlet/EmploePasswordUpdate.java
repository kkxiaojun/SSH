package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.EmploeDaoImpl;
import com.entity.Emploe;

public class EmploePasswordUpdate extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eid = request.getParameter("eid");
		String epassword = request.getParameter("epassword");
		String newpsw = request.getParameter("newpsw");
		String newpsw2 = request.getParameter("newpsw2");
		String code = request.getParameter("randcode");
		String trueCode =(String)request.getSession().getAttribute("code");
		EmploeDaoImpl edi = new EmploeDaoImpl();
		if(code.equalsIgnoreCase(trueCode)){
			int n =edi.emploeLogin(Integer.parseInt(eid), epassword);
			if(n==1){
				if(newpsw!=null||newpsw.equals("")&&newpsw.equals(newpsw2)){
					Emploe emploe = edi.getEmploeById(Integer.parseInt(eid));
					emploe.setEpassword(newpsw);
					if(edi.updateEmploe(Integer.parseInt(eid), emploe)){
						request.getSession().setAttribute("emploe", emploe);
						response.sendRedirect("emploe/show_self.jsp");
					}else{
						response.sendRedirect("emploe/password_update.jsp");
					}
				}else{
					response.sendRedirect("emploe/password_update.jsp");
				}
			}else{
				response.sendRedirect("emploe/password_update.jsp");
			}
		}else{
			response.sendRedirect("emploe/password_update.jsp?msg=1");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
