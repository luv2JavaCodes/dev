package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/fileuploadservlet")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part filePart = req.getPart("file");
	    String fileName = filePart.getSubmittedFileName();
	    for (Part part : req.getParts()) {
	      part.write("C:\\Users\\Manjul Dwivedi\\eclipse-workspace\\Student_Profiles\\src\\main\\webapp\\files" + fileName);
	    }
	    resp.getWriter().print("The file uploaded sucessfully.");
	  
	}

}
