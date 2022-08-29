package by.htp.ex.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.dao.INewsDao;
import by.htp.ex.dao.NewsDAOException;

public class NewsDao implements INewsDao {

	@Override
	public List<News> getList() throws NewsDAOException {
		List<News> result = new ArrayList<News>();

		result.add(new News(1,"tittle1","jkjjkjkjkjjjjjjjjjjjjjjjjjjjjjjjjjjj","content1","11/11/22"));
		result.add(new News(2,"tittle1","jkjjkjkjkjjjjjjjjjjjjjjjjjjjjjjjjjjj","content2","11/11/22"));
		result.add(new News(3,"tittle1","jkjjkjkjkjjjjjjjjjjjjjjjjjjjjjjjjjjj","content3","11/11/22"));
		result.add(new News(4,"tittle1","jkjjkjkjkjjjjjjjjjjjjjjjjjjjjjjjjjjj","content4","11/11/22"));
		result.add(new News(5,"tittle1","jkjjkjkjkjjjjjjjjjjjjjjjjjjjjjjjjjjj","content5","11/11/22"));

		return result;
	}

	@Override
	public List<News> getLatestsList(int count) throws NewsDAOException {
		List<News> result = new ArrayList<News>();

		result.add(new News(1,"tittle1","jkjjkjkjkjjjjjjjjjjjjjjjjjjjjjjjjjjj","content1","11/11/22"));
		result.add(new News(2,"tittle1","jkjjkjkjkjjjjjjjjjjjjjjjjjjjjjjjjjjj","content2","11/11/22"));
		result.add(new News(3,"tittle1","jkjjkjkjkjjjjjjjjjjjjjjjjjjjjjjjjjjj","content3","11/11/22"));
		result.add(new News(4,"tittle1","jkjjkjkjkjjjjjjjjjjjjjjjjjjjjjjjjjjj","content4","11/11/22"));
		result.add(new News(5,"tittle1","jkjjkjkjkjjjjjjjjjjjjjjjjjjjjjjjjjjj","content5","11/11/22"));
		
		return result;
	}

	@Override
	public News fetchById(int id) throws NewsDAOException {
		return new News(1, "title1", "brief1brief1brief1brief1brief1brief1brief1", "contect1", "11/11/22");
	}

	@Override
	public int addNews(News news) throws NewsDAOException {
		// TODO Auto-generated method stub
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
