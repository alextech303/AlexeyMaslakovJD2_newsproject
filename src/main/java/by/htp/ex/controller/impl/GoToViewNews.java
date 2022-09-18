package by.htp.ex.controller.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GoToViewNews implements Command {

	
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
News news;
		
		String idnews;

		idnews = request.getParameter("idnews");
		
		System.out.println("-------");
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		System.out.println(session.getId());
		
		Enumeration<String> sessionParams = session.getAttributeNames();
		while (sessionParams.hasMoreElements()) {
			
			String name = sessionParams.nextElement();
			String value = (String) session.getAttribute(name);
			System.out.println(name + " - " + value);
			System.out.println("");
		
		}
		
		
		System.out.println("-------");
		
		System.out.println("----------------");
		System.out.println(idnews);
		System.out.println("----------------");
		
		try {
			news  = newsService.findById(Integer.parseInt(idnews));
			request.setAttribute("news", news);
			request.setAttribute("presentation", "viewNews");

			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}


