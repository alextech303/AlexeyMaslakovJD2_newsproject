package by.htp.ex.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.htp.ex.bean.News;
import by.htp.ex.dao.INewsDao;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.dao.poolconnection.ConnectionPool;
import by.htp.ex.dao.poolconnection.ConnectionPoolException;

public class NewsDaoImpl implements INewsDao {
	private final static Logger LOG = LogManager.getLogger(by.htp.ex.dao.impl.NewsDaoImpl.class);

	@Override
	public List<News> getList() throws NewsDAOException {
		List<News> listOfNews = new ArrayList<News>();
		Statement st = null;
		ResultSet rs = null;

		try (Connection connect = ConnectionPool.getInstance().takeConnection()) {

			st = connect.createStatement();
			rs = st.executeQuery("SELECT * FROM news");

			while (rs.next()) {
				Integer idnews = rs.getInt(1);
				String title = rs.getString(2);
				String brief = rs.getString(3);
				String content = rs.getString(4);
				String date = rs.getString(5);

				listOfNews.add(new News(idnews, title, brief, content, date));

			}

		} catch (Exception e) {
			LOG.error(e);
			throw new NewsDAOException(e);
		}

		return listOfNews;
	}

	@Override
	public News fetchById(int idnews) throws NewsDAOException {
		Statement st = null;
		ResultSet rs = null;
		String content = null;
		String title = null;
		String brief = null;
		String date = null;
		try (Connection connect = ConnectionPool.getInstance().takeConnection()) {
			StringBuffer stringBuffer = new StringBuffer("SELECT * FROM news WHERE idnews=");
			stringBuffer.append(String.valueOf(idnews));
			String sql = stringBuffer.toString();
			st = connect.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				title = rs.getString(2);
				brief = rs.getString(3);
				content = rs.getString(4);
				date = rs.getString(5);
			}

		} catch (Exception e) {
			LOG.error(e);
			throw new NewsDAOException(e);

		}
		return new News(title, brief, content, date);
	}

	@Override
	public boolean addNews(News news) throws NewsDAOException, SQLException {
		boolean addNews = true;
		try (Connection connect = ConnectionPool.getInstance().takeConnection()) {

			String sql = "INSERT INTO news(title,brief,content,date,users_idusers,users_roles_id) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(sql);

			ps.setString(1, news.getTitle());
			ps.setString(2, news.getBrief());
			ps.setString(3, news.getContent());
			ps.setString(4, news.getDate());
			ps.setInt(5, 3);
			ps.setInt(6, 3);

			ps.executeUpdate();

		} catch (ConnectionPoolException e) {
			LOG.error("Соединение с БД отсутствует", e);
			throw new NewsDAOException(e);

		}
		return addNews;
	}

}
