package by.htp.ex.dao.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.dao.INewsDao;
import by.htp.ex.dao.NewsDAOException;

public class NewsDao implements INewsDao {

	@Override
	public List<News> getList() throws NewsDAOException {
		List<News> result = new ArrayList<News>();


		return result;
	}

	@Override
	public List<News> getLatestsList(int count) throws NewsDAOException {
		List<News> result = new ArrayList<News>();

		
		
		return result;
	}

	@Override
	public News fetchById(int id) throws NewsDAOException {
		return new News(1, "title1", "brief1brief1brief1brief1brief1brief1brief1", "contect1", LocalDateTime.now());
	}

	@Override
	public int addNews(News news) throws NewsDAOException {
		
		return 0;
	}

	@Override
	public void updateNews(News news) throws NewsDAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNewses(String[] idNewses) throws NewsDAOException {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
