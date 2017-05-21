package com.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Code extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","No-cache");
		response.setHeader("Expires","0");
		response.setContentType("image/jpeg");
		Random r = new Random();
		BufferedImage bi = new BufferedImage(68, 22, BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = bi.getGraphics();
		Color c = new Color(200,150,255);
		g.setColor(c);
		g.fillRect(0, 0, 68, 22);
		char[] ch="ABCDEFGHIJKMNOPQRSTUVWXYZ0123456789".toCharArray();
		int len=ch.length,index;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<4;i++){
			index=r.nextInt(len);
			g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
			g.drawString(ch[index]+"",(i*15)+3,18);
			sb.append(ch[index]);
		}
		request.getSession().setAttribute("code",sb.toString());
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.drawLine(r.nextInt(68),r.nextInt(22),r.nextInt(68),r.nextInt(22));
		ImageIO.write(bi, "JPEG", response.getOutputStream());
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
