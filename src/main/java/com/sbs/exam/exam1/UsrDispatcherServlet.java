package com.sbs.exam.exam1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usr/*")
public class UsrDispatcherServlet extends DispatcherServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getContentType().startsWith("multipart/form-data;")) {
			String forwardUri = request.getRequestURI();
			forwardUri = forwardUri.replace("/usr/", "/usr-file/");
			forwardUri = forwardUri.replace(request.getContextPath(), "");

			RequestDispatcher rd = request.getRequestDispatcher(forwardUri);
			rd.forward(request, response);
		}
		else {
			super.doPost(request, response);
		}
	}
}
