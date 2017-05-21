package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.DeptDaoImpl;
import com.daoImpl.MessageDaoImpl;
import com.entity.Dept;
import com.entity.Emploe;
import com.entity.Manager;
import com.entity.Message;

public class NewsTable extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageDaoImpl mdi = new MessageDaoImpl();
		String pageNow =request.getParameter("n");
		if(pageNow==null||pageNow.equals("")){
			pageNow="1";
		}
		if(Integer.parseInt(pageNow)<1){
			pageNow="1";
		}
		int pageCount =1;
		if(request.getSession().getAttribute("pageCount")!=null&&!request.getSession().getAttribute("pageCount").equals("")){
			pageCount =(Integer)request.getSession().getAttribute("pageCount");
		}
		if(Integer.parseInt(pageNow)>pageCount){
			pageNow = pageCount+"";
		}
		ArrayList<Message> msgList = mdi.getALlMsgByPage(Integer.parseInt(pageNow));
			request.getSession().setAttribute("msgList", msgList);
			pageCount =mdi.getPageCount();
			request.getSession().setAttribute("pageCount", pageCount);
			request.getSession().setAttribute("pageNow", pageNow);
			int lineCount =mdi.getLineCount();
			request.getSession().setAttribute("lineCount", lineCount);
			response.sendRedirect("manager/news_table.jsp");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
