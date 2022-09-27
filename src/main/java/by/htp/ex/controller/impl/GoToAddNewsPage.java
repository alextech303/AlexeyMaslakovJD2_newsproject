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

public class GoToAddNewsPage implements Command {
	 

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name;
		String value;
		request.setAttribute("manager", "addingNews");

		request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		System.out.println("execute GoToAddNewsPage");

	}
}
