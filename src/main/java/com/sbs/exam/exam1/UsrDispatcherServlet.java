package com.sbs.exam.exam1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/usr/*")
@MultipartConfig(location = "C:/temp")
public class UsrDispatcherServlet extends DispatcherServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		System.out.println(request.getParameter("attr1"));

		if (request.getContentType().equals("multipart/form-data")) {
			Part part = request.getPart("file1");

			String fileName = getFileName(part);
			part.write("down-" + fileName);
		}
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
