package by.htp.ex.controller.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import by.htp.ex.controller.Command;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GoToAddNewsPage implements Command{
	String name;
	String value;
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setAttribute("manager", "addingNews");
//		request.setAttribute("user", "manager");
//		request.setAttribute("role", "manager");
		request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		System.out.println("execute GoToAddNewsPage");
		
//		System.out.println("-------");
//		
//		HttpSession session = request.getSession();
////		PrintWriter out = response.getWriter();
//		
//		System.out.println(session.getId());
//		
//		Enumeration<String> sessionParams = session.getAttributeNames();
//		while (sessionParams.hasMoreElements()) {
//			
//			name = sessionParams.nextElement();
//			value = (String) session.getAttribute(name);
//			System.out.println(name + " - " + value);
//			System.out.println("");
//			
//		}
		
		
//		System.out.println("-------");
//		
		
	}
}
