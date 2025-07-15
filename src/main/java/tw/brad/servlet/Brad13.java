package tw.brad.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.apis.Bike;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Brad13")
public class Brad13 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Brad14?name=Brad");
		
		request.setAttribute("x", 10);
		request.setAttribute("y", 3);
		
		Bike b1 = new Bike();
		b1.upSpeed().upSpeed().upSpeed().upSpeed();
		request.setAttribute("bike", b1);
		
		//-----------------
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>Brad Big Company</h1>");
		out.println("<hr />");
		out.println("<div>Hello, World</div>");
		dispatcher.include(request, response);
		out.println("<hr />");
		response.flushBuffer();
	}


}
