package by.htp.ex.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.bean.News;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.INewsDao;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;

public class NewsServiceImpl implements INewsService {

	private final static Logger LOG = LogManager.getLogger(by.htp.ex.service.impl.NewsServiceImpl.class);
	private final INewsDao newsDAO = DaoProvider.getInstance().getNewsDAO();

	@Override
	public boolean save(News news) throws NewsDAOException, SQLException, DaoException, ServiceException {
		boolean saveNews = false;
		try {
			if (newsDAO.addNews(news)) {
				saveNews = true;
			} else {
				throw new ServiceException("News don't save in BD");
			}
		} catch (NewsDAOException e) {
			LOG.error(e);
			throw new NewsDAOException(e);

		} catch (SQLException e) {
			LOG.error(e);
			throw new SQLException(e);
		} catch (DaoException e) {

			LOG.error(e);
			throw new DaoException();
		} catch (ServiceException e) {

			LOG.error(e);
			throw new ServiceException(e);
		}
		return saveNews;
	}

	@Override
	public List<News> listOfNews() throws ServiceException {
		try {
			return newsDAO.getList();
		} catch (NewsDAOException e) {
			LOG.error(e);
			throw new ServiceException(e);
		}
	}

	@Override
	public News findById(int idnews) throws ServiceException {
		try {
			return newsDAO.fetchById(idnews);
		} catch (NewsDAOException e) {
			LOG.error(e);
			throw new ServiceException(e);
		}
	}

}
