package by.htp.ex.controller.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	
	private final static Logger LOG = LogManager.getLogger(by.htp.ex.controller.impl.GoToViewNews.class);

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		News news;

		String idnews;

		idnews = request.getParameter("idnews");

		try {
			news = newsService.findById(Integer.parseInt(idnews));
			request.setAttribute("news", news);
			request.setAttribute("presentation", "viewNews");

			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		} catch (ServiceException e) {
			LOG.error(e);
			response.sendRedirect("controller?command=go_to_error_page");
		}

	}
}
