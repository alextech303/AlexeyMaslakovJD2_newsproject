package by.htp.ex.controller.impl;

import java.io.IOException;
import java.util.Enumeration;

import by.htp.ex.controller.Command;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoAddNews implements Command{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("addNews", "press");
		request.setAttribute("user", "manager");
		request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		System.out.println("execute DoAddNews");
		
		System.out.println("-------");
		
		HttpSession session = request.getSession();
		Enumeration<String> sessionParams = session.getAttributeNames();
		while (sessionParams.hasMoreElements()) {
			
		}
		
		
		System.out.println("-------");
		
		
	}
}
