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

	@Override
	public boolean checkAuthUser(String login, String password) throws DaoException {
		Statement st = null;
		ResultSet rs = null;
		boolean authUser = false;
		try (Connection connect = ConnectionPool.getInstance().takeConnection()) {

			st = connect.createStatement();
			rs = st.executeQuery("SELECT * FROM users");

			while (rs.next()) {

				if ((login + password).equals(rs.getString(2) + rs.getString(3))) {
					System.out.println("такой пользователь есть в базе");
					authUser = true;
					LOG.info("Аутентификация пользователя по логину и паролю прошла успешно");
				}
			}
		} catch (SQLException | ConnectionPoolException e) {
			LOG.error("Ошибка соединения с БД", e);
			throw new DaoException(e);

		}
		return authUser;
	}

	@Override
	public boolean checkUserInBD(String login, String email) throws DaoException {
		Statement st = null;
		ResultSet rs = null;
		boolean checkUserInBD = true;
		try (Connection connect = ConnectionPool.getInstance().takeConnection()) {

			st = connect.createStatement();
			rs = st.executeQuery("SELECT * FROM users");

			while (rs.next()) {

				if (((login).equals(rs.getString(2))) | rs.getString(4).equals(email)) {
					checkUserInBD = false;
					if ((login).equals(rs.getString(2))) {
						LOG.debug("пользователь не прошел регистрацию");
						throw new DaoException("В базе пользователь с таким логином " + login
								+ " существует - используйте другой логин");

					}

					if (rs.getString(4).equals(email)) {
						LOG.debug("пользователь не прошел регистрацию");
						throw new DaoException("В базе пользователь с таким email " + email
								+ " существует - используйте другой email");
					}
				}
			}

		} catch (SQLException | ConnectionPoolException e) {
			LOG.error("Ошибка соединения с базой данных", e);
			throw new DaoException(e);

		}
		return checkUserInBD;
	}
}
