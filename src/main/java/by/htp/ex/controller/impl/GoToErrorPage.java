package by.htp.ex.controller.impl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import by.htp.ex.controller.Command;
import by.htp.ex.dao.NewsDAOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToErrorPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NoSuchAlgorithmException, InvalidKeySpecException, NewsDAOException {
		request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
		
	}

}
