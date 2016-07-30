package com.hsp;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 获取ServletContext 对象引用
		//1、通过this对象直接获取
		ServletContext servletContext = this.getServletContext();
		//2、通过ServletConfig获取
//		ServletContext servletConext2 = this.getServletConfig().getServletContext();	
		servletContext.setAttribute("uname", "韩顺平");

		out.println("写入一个属性到servletContext");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
