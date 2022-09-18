package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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

public class NewsDaoImpl implements INewsDao {
	private final static Logger LOG = LogManager.getLogger(by.htp.ex.dao.impl.NewsDaoImpl.class);
	private boolean addNews = true;
	
	private Statement st = null;
	private ResultSet rs = null;
	private List<News> listOfNews = new ArrayList<News>();
	@Override
	public List<News> getList() throws NewsDAOException {
		
		System.out.println("getList NewsDaoImpl");
		try (Connection connect = ConnectionPool.getInstance().takeConnection()) {
			 
			st = connect.createStatement();
			rs = st.executeQuery("SELECT * FROM news");

			while (rs.next()) {
        Integer idnews = rs.getInt(1);
		String title = 	rs.getString(2); 
		String brief = 	rs.getString(3); 
		String content = rs.getString(4);
		String date = rs.getString(5);
	
		listOfNews.add(new News(idnews,title,brief,content,date));
					
			}
			
			
		
	}catch (Exception e) {
		// TODO: handle exception
	}

		return listOfNews;
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
	public boolean addNews(News news) throws NewsDAOException, SQLException {
		try (Connection connect = ConnectionPool.getInstance().takeConnection()) {

			String sql = "INSERT INTO news(title,brief,content,date,users_idusers,users_roles_id) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(sql);

			ps.setString(1, news.getTitle());
			ps.setString(2, news.getBrief());
			ps.setString(3, news.getContent());
			ps.setObject(4, news.getDate());
			ps.setInt(5, 3);
			ps.setInt(6, 3);

			ps.executeUpdate();
System.out.println("addNews In BD");
		} catch (ConnectionPoolException e) {
			LOG.error("Соединение с БД отсутствует", e);
		
	}
		return addNews;
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
