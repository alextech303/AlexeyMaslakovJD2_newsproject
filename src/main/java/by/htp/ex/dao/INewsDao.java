package by.htp.ex.dao;

import java.sql.SQLException;
import java.util.List;

import by.htp.ex.bean.News;

public interface INewsDao {

	List<News> getList() throws NewsDAOException;
	
	
	
	List<News> getLatestsList(int count) throws NewsDAOException;
	
	
	
	News fetchById(int id) throws NewsDAOException;
	int addNews(News news) throws NewsDAOException, SQLException;
	void updateNews(News news) throws NewsDAOException;
	void deleteNewses(String[] idNewses)throws NewsDAOException;
	
	
}
