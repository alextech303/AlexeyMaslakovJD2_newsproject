package by.htp.ex.controller.impl;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.controller.Command;
import by.htp.ex.dao.DaoException;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoRegistration implements Command {
	private final IUserService service = ServiceProvider.getInstance().getUserService();
	private final static Logger LOG = LogManager.getLogger(by.htp.ex.controller.impl.DoRegistration.class);

	private static final String JSP_LOGIN_PARAM = "login";
	private static final String JSP_PASSWORD_PARAM = "password";
	private static final String JSP_EMAIL_PARAM = "email";
	private static NewUserInfo newUserInfo;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login;
		String password;
		String email;

		
		login = request.getParameter(JSP_LOGIN_PARAM);
		password = request.getParameter(JSP_PASSWORD_PARAM);
		email = request.getParameter(JSP_EMAIL_PARAM);
		
		newUserInfo = new NewUserInfo(login,password,email);
		try {
			if(service.registration(newUserInfo)) {
				LOG.info("Пользователь  "+newUserInfo.getLogin()+" успешно зарегистрирован!!!");
				request.getSession(true).setAttribute("user","active");
				
				response.sendRedirect("controller?command=go_to_news_list");
			}else {
				LOG.info("Пользователь "+newUserInfo.getLogin()+"не прошел регистрацию!!!");
				request.getSession(true).setAttribute("user","not active");
				response.sendRedirect("controller?command=go_to_base_page");
				
			}
		} catch (ServiceException e) {
			LOG.debug(e);
			
		} catch (DaoException e) {
			LOG.debug(e);
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("произошла ошибка",e);
		} catch (IOException e) {
			LOG.error(e);
		}
		
	}

}
