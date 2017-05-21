package com.filter;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class EncodingFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest)req;
		HttpServletResponse response =(HttpServletResponse)res;
		request.setCharacterEncoding("gb2312");
		MyRequest mr=new MyRequest(request);
		chain.doFilter(mr, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
class MyRequest extends HttpServletRequestWrapper{
	HttpServletRequest request=null;
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}
	
	public String getParameter(String name) {
		String str=request.getParameter(name);
		if(!request.getMethod().equalsIgnoreCase("post")){
			try { 
					if(str!=null&&!str.equals("")){
						str=new String(str.getBytes("ISO-8859-1"),"gb2312");
					}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
	
}
