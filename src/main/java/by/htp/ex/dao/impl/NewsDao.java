package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.bean.News;
import by.htp.ex.dao.INewsDao;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.dao.poolConnection.ConnectionPool;
import by.htp.ex.dao.poolConnection.ConnectionPoolException;

public class NewsDao implements INewsDao {
	private final static Logger LOG = LogManager.getLogger(by.htp.ex.dao.impl.NewsDao.class);


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
		return new News( "title1", "brief1brief1brief1brief1brief1brief1brief1", "contect1", "2022-10-10");
	}

	@Override
	public int addNews(News news) throws NewsDAOException, SQLException {
		try (Connection connect = ConnectionPool.getInstance().takeConnection()) {

			String sql = "INSERT INTO news(tittle,bref,content,date,users_idusers,users_roles_id) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(sql);

			ps.setString(1, news.getTitle());
			ps.setString(2, news.getBrief());
			ps.setString(3, news.getContent());
			ps.setObject(4, news.getDate());
			ps.setInt(5, 3);
			ps.setInt(6, 3);

			ps.executeUpdate();

		} catch (ConnectionPoolException e) {
			LOG.error("Соединение с БД отсутствует", e);
		
	}
		return 1;
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
