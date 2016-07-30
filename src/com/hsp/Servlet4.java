package com.hsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 目前我们跳转到下一个页面
//		1、response.sendRedirect("/Web应用名/资源名");
//		2、request.getRequestDispatcher("/资源名").forward(request, response);
		/*
		 * 区别：
		 * 1、sendRedirect 发生在浏览器，getRequestDispatcher 发生在Web服务器。
		 * 2、如果request.setAttribute("name", "顺平")，希望下一个页面可以使用属性值，则使用getRequestDispatcher。
		 * 3、如果session.setAttribute("name2", "顺平3")，希望下一个页面可以使用属性值，则两个方法均可以使用，但是建议使用getRequestDispatcher。
		 * 4、如果我们希望跳转到本Web应用外的一个url，此时只能使用sendRedirect。
		 */
		// 3、这种方法和2一眼
		this.getServletContext().getRequestDispatcher("/资源url").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
