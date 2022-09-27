package by.htp.ex.controller.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.bean.CryptPassword;
import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoAddNews implements Command {
	private final INewsService service = ServiceProvider.getInstance().getNewsService();
	private final static Logger LOG = LogManager.getLogger(by.htp.ex.controller.impl.DoAddNews.class);

	private static final String JSP_TITLE_PARAM = "title";
	private static final String JSP_DATE_PARAM = "date";
	private static final String JSP_BRIEF_PARAM = "brief";
	private static final String JSP_CONTENT_PARAM = "content";


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		News newNews;
		String title;
		String date;
		String brief;
		String content;

		title = request.getParameter(JSP_TITLE_PARAM);

		date = request.getParameter(JSP_DATE_PARAM);
		brief = request.getParameter(JSP_BRIEF_PARAM);
		content = request.getParameter(JSP_CONTENT_PARAM);
		newNews = new News(title, brief, content, date);

		try {
			if (service.save(newNews)) {
				request.getSession(true).setAttribute("manager", "addNews");
				response.sendRedirect("controller?command=go_to_manager_page");
				LOG.info("Новость успешно добавлена менеджером");

			}
			LOG.info("Новость успешно добавлена менеджером");
		} catch (NewsDAOException e) {
			LOG.debug(e);
			e.printStackTrace();
		} catch (SQLException e) {
			LOG.debug(e);
			e.printStackTrace();
		} catch (DaoException e) {
			LOG.debug(e);
			e.printStackTrace();
		} catch (ServiceException e) {
			LOG.error(e);
			e.printStackTrace();
		}

	}
}
