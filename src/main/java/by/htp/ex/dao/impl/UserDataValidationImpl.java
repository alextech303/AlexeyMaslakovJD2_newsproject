package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.UserDataValidation;
import by.htp.ex.dao.poolConnection.ConnectionPool;
import by.htp.ex.dao.poolConnection.ConnectionPoolException;

public class UserDataValidationImpl implements UserDataValidation {
	private final static Logger LOG = LogManager.getLogger(by.htp.ex.dao.impl.UserDataValidationImpl.class);
	

	Statement st = null;
	ResultSet rs = null;
	private boolean authUser = false;
	private boolean checkUserInBD = true;
	private String role = "guest";
	private String sqlRequest;

	@Override
	public boolean checkAuthUser(String login, String password) {
		try (Connection connect = ConnectionPool.getInstance().takeConnection()) {
//			 
			st = connect.createStatement();
			rs = st.executeQuery("SELECT * FROM users");

			while (rs.next()) {

				if ((login + password).equals(rs.getString(2) + rs.getString(3))) {
					authUser = true;
					LOG.info("Аутентификация пользователя по логину и паролю прошла успешно");
				} else {
					if (!((login + password).equals(rs.getString(2) + rs.getString(3)))) {
						LOG.info("Аутентификация пользователя выполнена с ошибкой");
					}

				}
			}
		} catch (SQLException | ConnectionPoolException e) {
			LOG.error("Ошибка соединения с БД", e);
			e.printStackTrace();

		}
		return authUser;
	}

	@Override
	public String getRoleUser(String login) throws SQLException {
		sqlRequest="SELECT roles_id FROM users where login='";
		try (Connection connect = ConnectionPool.getInstance().takeConnection()) {

			st = connect.createStatement();
			StringBuilder stringBuffer = new StringBuilder(sqlRequest);
			stringBuffer.append(login).append("'");
					
			rs = st.executeQuery(stringBuffer.toString());

			
				
				if(rs.getString(6).equals("1")) {
					return "admin";
				}else { if(rs.getString(6).equals("2")) {
					return "manager";
				}else if(rs.getString(6).equals("3")) {
					return "user";
				}
			}
			
			
		} catch (SQLException | ConnectionPoolException e) {
			LOG.error("Ошибка при подключении к БД",e);
		}
		return role;
	}

	@Override
	public boolean checkUserInBD(String login, String email) throws SQLException {
		try (Connection connect = ConnectionPool.getInstance().takeConnection()) {
//			 
			st = connect.createStatement();
			rs = st.executeQuery("SELECT * FROM users");

			while (rs.next()) {

				if (((login).equals(rs.getString(2))) | rs.getString(4).equals(email)) {
					checkUserInBD = false;
					if ((login).equals(rs.getString(2))) {
						LOG.debug("пользователь не прошел регистрацию");
								new DaoException("В базе пользователь с таким логином " + login
										+ " существует - используйте другой логин");
					}
					
					if (rs.getString(4).equals(email)) {
						LOG.debug("пользователь не прошел регистрацию");
								new DaoException("В базе пользователь с таким email " + email
										+ " существует - используйте другой email");
					}
				}
			}

		} catch (SQLException | ConnectionPoolException e) {
			LOG.error("Ошибка соединения с базой данных", e);

		}
		return checkUserInBD;
	}
}
