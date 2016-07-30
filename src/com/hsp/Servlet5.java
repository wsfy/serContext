package com.hsp;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// 首先读取文件
		InputStream inputStream = this.getServletContext().getResourceAsStream("dbinfo.properties");

		// 创建Properties
		Properties pp = new Properties();
		pp.load(inputStream);
		
		out.println("name=" + pp.getProperty("username"));
		
		// 如果文件放在src目录下，应该使用类加载器来读取。
//		InputStream is = Servlet5.class.getClassLoader().getResourceAsStream("dbinfo.properties");
		
		// 如何读取到一个文件的全路径
		String path = this.getServletContext().getRealPath("/imgs/tree_mydoc.png");
		out.println("path=" + path);
				
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
