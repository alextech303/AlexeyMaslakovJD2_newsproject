package by.htp.ex.controller.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.controller.Command;
import by.htp.ex.dao.poolConnection.ConnectionPool;
import by.htp.ex.dao.poolConnection.ConnectionPoolException;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.impl.UserServiceImpl;
import by.htp.ex.util.validation.UserDataValidation;
import by.htp.ex.util.validation.ValidationProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoSignIn implements Command {

	private final static Logger LOG = LogManager.getLogger(DoSignIn.class);

	private static final String JSP_LOGIN_PARAM = "login";
	private static final String JSP_PASSWORD_PARAM = "password";

	private final IUserService service = ServiceProvider.getInstance().getUserService();
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login;
		String password;

		
		login = request.getParameter(JSP_LOGIN_PARAM);
		password = request.getParameter(JSP_PASSWORD_PARAM);
		
//		try {
			//
						boolean result = service.logination(login, password);
			//
//						if (result) {
//							// go to main.jsp
//						} else {
//							// go to index-logination with message
//						}
			//
//					} catch (ServiceException e) {
//						// logging e
//						// go-to error page
			//
//					}
		
		

	}
}


//			try {
//				String role = service.signIn(login, password);
//			
//			
//			switch(role) {
////			
//			case "liginationUser":
//				request.getSession(true).setAttribute("user", "active");
//				request.getSession(true).setAttribute("role", role);
//				response.sendRedirect("controller?command=go_to_news_list");
////				break;
//////				
//			case "admin":
//				request.getSession(true).setAttribute("user", "active");
//				request.getSession(true).setAttribute("role", role);
//				response.sendRedirect("controller?command=go_to_news_list");
//				break;
//				
//			case "guest":
//				
//				request.getSession(true).setAttribute("user", "not active");
//				request.setAttribute("AuthenticationError", "wrong login or password");
//				request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
//			}
////
//			}catch (Exception e) {
//				// TODO: handle exception
//			}

//			
//			
//		} catch (ServiceException e) {
//			// logging e
//			// go-to error page
//

// response.getWriter().print("do logination");

//		login = request.getParameter("login");
//		password = request.getParameter("password");
//
//		// small validation
//
//		

// response.getWriter().print("do logination");
