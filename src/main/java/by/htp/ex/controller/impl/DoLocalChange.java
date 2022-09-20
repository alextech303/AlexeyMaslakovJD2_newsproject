package by.htp.ex.controller.impl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import by.htp.ex.controller.Command;
import by.htp.ex.dao.NewsDAOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoLocalChange implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NoSuchAlgorithmException, InvalidKeySpecException, NewsDAOException {

		String local = request.getParameter("local");
		HttpSession getSession = request.getSession(true);
		getSession.setAttribute("local", local);

	}

}
