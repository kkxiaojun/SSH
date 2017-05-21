package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

public class EmploeUpdateSelf extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String esalary = request.getParameter("esalary");
		String esex = request.getParameter("esex");
		String ebir = request.getParameter("ebir");
		String emarry = request.getParameter("emarry");
		String eedu = request.getParameter("eedu");
		String did = request.getParameter("did");
		DeptDaoImpl ddi = new DeptDaoImpl();
		Dept dept = ddi.getDeptById(Integer.parseInt(did));
		request.getSession().setAttribute("dept", dept);
		String pid = request.getParameter("pid");
		PostDaoImpl pdi = new PostDaoImpl();
		Post post = pdi.getPostById(Integer.parseInt(pid));
		request.getSession().setAttribute("post", post);
		String ephone = request.getParameter("ephone");
		String eaddr = request.getParameter("eaddr");
		String equestion = request.getParameter("equestion");
		String eanswer = request.getParameter("eanswer");
		Emploe emploe = (Emploe)request.getSession().getAttribute("emploe");
		emploe.setEid(Integer.parseInt(eid));
		emploe.setEname(ename);
		emploe.setEsalary(esalary);
		emploe.setEsex(esex);
		SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			emploe.setEbir(sfd.parse(ebir));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		emploe.setEmarry(emarry);
		emploe.setEedu(eedu);
		emploe.setDid(Integer.parseInt(did));
		emploe.setPid(Integer.parseInt(pid));
		emploe.setEphone(ephone);
		emploe.setEaddr(eaddr);
		emploe.setEquestion(equestion);
		emploe.setEanswer(eanswer);
		EmploeDaoImpl edi = new EmploeDaoImpl();
		boolean flag = edi.updateEmploe(Integer.parseInt(eid), emploe);
		if(flag){
			request.getSession().setAttribute("username", ename);
			request.getSession().setAttribute("emploe", emploe);
			response.sendRedirect("emploe/show_self.jsp");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
