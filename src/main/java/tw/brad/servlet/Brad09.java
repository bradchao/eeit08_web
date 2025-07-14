package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

@WebServlet("/Brad09")
@MultipartConfig( location = "C:\\Users\\User\\eclipse-workspace\\BradWeb\\src\\main\\webapp\\upload")
public class Brad09 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String urip = request.getRemoteAddr();
		try {
			Part part = request.getPart("upload");
			
			String type = part.getContentType();
			long len = part.getSize();
			String fileName = part.getSubmittedFileName();
			System.out.println(type);
			System.out.println(len);
			System.out.println(urip + "_" + fileName);
			
			part.write(urip + "_" + fileName);
		}catch(Exception e) {
			System.out.println(e);
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().print("ERROR");
			response.flushBuffer();
		}
		
	}

}
