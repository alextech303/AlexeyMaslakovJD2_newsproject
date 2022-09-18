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
	private boolean saveNews = false;
	private final static Logger LOG = LogManager.getLogger(by.htp.ex.service.impl.NewsServiceImpl.class);
	private final INewsDao newsDAO = DaoProvider.getInstance().getNewsDAO();

	@Override
	public boolean save(News news) {
		try {
			if (newsDAO.addNews(news)) {
				saveNews = true;
			} else {
				throw new ServiceException("News don't save in BD");
			}
		} catch (NewsDAOException e) {
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (DaoException e) {

			e.printStackTrace();
		} catch (ServiceException e) {

			e.printStackTrace();
		}
		return saveNews;
	}
	
	@Override
	public List<News> listOfNews() throws ServiceException {
		try {
			return newsDAO.getList();
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	

	@Override
	public void find() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<News> latestList(int count) throws ServiceException {

		try {
			return newsDAO.getLatestsList(5);
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	
	@Override
	public News findById(int id) throws ServiceException {
		try {
			return newsDAO.fetchById(id);
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean list() throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
