package com.hsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 取出ServletContext的某个属性
		// 1、首先获取ServletContext
		ServletContext servletContext = this.getServletContext();
		// 2、取出属性，这个属性值对应什么类型就应当转成什么类型。
		String val = (String) servletContext.getAttribute("uname");
		
		out.println("未删除前 val=" + val);
		
		// 3、删除属性
		servletContext.removeAttribute("uname");
		
		// 取出
		String val2 = (String) servletContext.getAttribute("uname");
		out.println("删除后 val2=" + val2);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
