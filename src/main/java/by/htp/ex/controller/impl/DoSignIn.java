package by.htp.ex.controller.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.bean.CryptPassword;
import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.controller.Command;
import by.htp.ex.dao.UserDataValidation;
import by.htp.ex.dao.ValidationProvider;
import by.htp.ex.dao.poolConnection.ConnectionPool;
import by.htp.ex.dao.poolConnection.ConnectionPoolException;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoSignIn implements Command {

	private final static Logger LOG = LogManager.getLogger(DoSignIn.class);

	private static final String JSP_LOGIN_PARAM = "login";
	private static final String JSP_PASSWORD_PARAM = "password";
	public  NewUserInfo newUserInfo;
	

	private final IUserService service = ServiceProvider.getInstance().getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("execute DoSignIn");
		String login;
		String password;

		
		login = request.getParameter(JSP_LOGIN_PARAM);
		CryptPassword cryptPassword = new CryptPassword(request.getParameter(JSP_PASSWORD_PARAM));
		password = cryptPassword.toString() ;
		System.out.println("создаем объект user");
		newUserInfo = new NewUserInfo(login,password);
		
			try {
				String role = service.signIn(newUserInfo);
			
			
			switch(role) {
			
                case "manager":
				
				request.getSession(true).setAttribute("user", "manager");
				
				request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
				System.out.println("case manager");
				break;
		
			case "user":
				request.getSession(true).setAttribute("user", "active");
				request.getSession(true).setAttribute("role", role);
				response.sendRedirect("controller?command=go_to_news_list");
				System.out.println("case user");
				break;
				
			case "admin":
				request.getSession(true).setAttribute("user", "active");
				request.getSession(true).setAttribute("role", role);
				request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp").forward(request, response);
				System.out.println("case admin");
				break;
				
			case "guest":
				
				request.getSession(true).setAttribute("user", "not active");
				request.setAttribute("AuthenticationError", "wrong login or password");
				request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
				System.out.println("case guest");
				break;
				
				
			}

			}catch (Exception e) {
				// TODO: handle exception
			}

}
}