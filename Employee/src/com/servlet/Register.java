package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.EmploeDaoImpl;
import com.entity.Emploe;

public class Register extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eid = request.getParameter("eid");
		String epassword = request.getParameter("password");
		String ename = request.getParameter("trueName");
		String equestion = request.getParameter("question");
		String eanswer = request.getParameter("result");
		EmploeDaoImpl edi = new EmploeDaoImpl();
		Emploe emploe = new Emploe();
		emploe.setEid(Integer.parseInt(eid));
		emploe.setEpassword(epassword);
		emploe.setEname(ename);
			//包含问题和问题答案的注册
			if(equestion!=null&&!equestion.equals("")&&eanswer!=null&&!eanswer.equals("")){
				emploe.setEquestion(equestion);
				emploe.setEanswer(eanswer);
				if(edi.registerEmploe(emploe)){
					response.sendRedirect("failure.jsp?log=success");
				}else{
					response.sendRedirect("failure.jsp?log=fail");
				}
			}else if(equestion==null||equestion.equals("")&&eanswer==null||eanswer.equals("")){
				//不包含问题和问题答案的注册
				if(edi.registerEmploe2(emploe)){
					response.sendRedirect("failure.jsp?log=success");
				}else{
					response.sendRedirect("failure.jsp?log=fail");
				}
			}
	}

}
