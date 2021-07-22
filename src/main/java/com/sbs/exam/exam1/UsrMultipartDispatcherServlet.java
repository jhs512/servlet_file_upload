package com.sbs.exam.exam1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/usr-file/*")
@MultipartConfig(location = "C:/temp")
public class UsrMultipartDispatcherServlet extends UsrDispatcherServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("HI");

		request.setCharacterEncoding("UTF-8");

		Part part = request.getPart("file1");

		String fileName = getFileName(part);

		// String fileName = part.getSubmittedFileName();

		part.write("down-" + fileName);

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		out.print("<html><body>");
		out.print("attr1: " + request.getParameter("attr1") + "<br>");
		out.print("attr2: " + request.getParameter("attr2") + "<br>");
		out.print("fileName : " + fileName + "<br>");
		out.print("fileSize : " + part.getSize() + "<br>");
		out.print("</body></html>");

	}

	private String getFileName(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
