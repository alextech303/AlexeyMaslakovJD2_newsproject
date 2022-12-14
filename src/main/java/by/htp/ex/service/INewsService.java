package by.htp.ex.service;

import java.sql.SQLException;
import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.NewsDAOException;

public interface INewsService {

	boolean save(News news) throws NewsDAOException, SQLException, DaoException, ServiceException;

	News findById(int id) throws ServiceException;

	List<News> listOfNews() throws ServiceException;

}
