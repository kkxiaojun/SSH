package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.EmploeDaoImpl;
import com.entity.Emploe;

public class ManagerEmploeAdd extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eid =request.getParameter("eid");
		String ename =request.getParameter("ename");
		String esalary =request.getParameter("esalary");
		String esex =request.getParameter("esex");
		String ebir =request.getParameter("ebir");
		String emarry =request.getParameter("emarry");
		String eedu =request.getParameter("eedu");
		String did =request.getParameter("did");
		String pid =request.getParameter("pid");
		String eaddr =request.getParameter("eaddr");
		String ephone =request.getParameter("ephone");
		Emploe emploe = new Emploe();
		emploe.setEid(Integer.parseInt(eid));
		emploe.setEname(ename);
		emploe.setEsalary(esalary);
		emploe.setEsex(esex);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			emploe.setEbir(sdf.parse(ebir));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		emploe.setEmarry(emarry);
		emploe.setEedu(eedu);
		emploe.setDid(Integer.parseInt(did));
		emploe.setPid(Integer.parseInt(pid));
		emploe.setEaddr(eaddr);
		emploe.setEphone(ephone);
		EmploeDaoImpl edi = new EmploeDaoImpl();
		boolean flag = edi.addEmploe(emploe);
		if(flag){
			response.sendRedirect("EmploeTable");
		}else{
			response.sendRedirect("ManagerEmploeTable_add");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
