package by.htp.ex.controller.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.controller.Command;
import by.htp.ex.dao.poolconnection.ConnectionPool;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoSignOut implements Command {

	private final static Logger LOG = LogManager.getLogger(DoSignOut.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");

		request.getSession().setAttribute("user", "not active");
		LOG.info("Пользователь " + login + " вышел из учетной записи");
		response.sendRedirect("controller?command=go_to_base_page");

	}

}
