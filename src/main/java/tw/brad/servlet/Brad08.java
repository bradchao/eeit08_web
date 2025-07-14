package tw.brad.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Brad08")
public class Brad08 extends HttpServlet {
	public Brad08() {
		System.out.println("Brad08()");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(ServletConfig)");
		super.init(config);
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service(ServletRequest,ServletResponse)");
		if (request instanceof HttpServletRequest) {
			System.out.println("Y");
		}else {
			System.out.println("N");
		}
		super.service(request, response);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service(HttpServletRequest,HttpServletResponse)");
		//super.service(arg0, arg1);
		
		String method =  request.getMethod();
		System.out.println(method);
		if (method.equals("POST")) {
			
		}
		
	}


	@Override
	public void init() throws ServletException {
		System.out.println("init()");
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
	}
}
