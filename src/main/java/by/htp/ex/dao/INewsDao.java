package by.htp.ex.dao;

import java.sql.SQLException;
import java.util.List;

import by.htp.ex.bean.News;

public interface INewsDao {

	List<News> getList() throws NewsDAOException;

	News fetchById(int id) throws NewsDAOException;

	boolean addNews(News news) throws NewsDAOException, SQLException, DaoException;

}
