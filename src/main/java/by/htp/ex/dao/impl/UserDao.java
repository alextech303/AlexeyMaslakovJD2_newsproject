package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.controller.impl.DoSignIn;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IUserDao;
import by.htp.ex.dao.UserDataValidation;
import by.htp.ex.dao.ValidationProvider;
import by.htp.ex.dao.poolconnection.ConnectionPool;
import by.htp.ex.dao.poolconnection.ConnectionPoolException;

public class UserDao implements IUserDao {

	private final static Logger LOG = LogManager.getLogger(by.htp.ex.dao.impl.UserDao.class);
	private final UserDataValidation validationUser = ValidationProvider.getInstance().getUserDataVelidation();

	@Override
	public boolean logination(NewUserInfo user) throws DaoException {
		boolean checkUserlogination = false;
		try {
			if (validationUser.checkAuthUser(user.getLogin(), user.getPassword())) {

				checkUserlogination = true;
			} else {
				LOG.info("Пользователь " + user.getLogin() + " не прошел логинацию!!!");
			}
		} catch (SQLException e) {
			LOG.error(e);
			throw new DaoException(e);

		}

		return checkUserlogination;
	}

	@Override
	public boolean registration(NewUserInfo user) throws DaoException, SQLException {
		boolean checkUserReg = false;
		if (validationUser.checkUserInBD(user.getLogin(), user.getEmail())) {

			checkUserReg = true;
			try (Connection connect = ConnectionPool.getInstance().takeConnection()) {

				String sql = "INSERT INTO users(login,password,email,dateOfRegistration,roles_id) VALUES(?,?,?,?,?)";
				PreparedStatement ps = connect.prepareStatement(sql);

				ps.setString(1, user.getLogin());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getEmail());
				ps.setObject(4, LocalDateTime.now());
				ps.setInt(5, 3);

				ps.executeUpdate();

			} catch (ConnectionPoolException e) {
				LOG.error("Соединение с БД отсутствует", e);
				throw new DaoException(e);
			}

		} else
			return checkUserReg;

		return checkUserReg;
	}

	@Override
	public String getRole(String login) throws DaoException, SQLException {
		ResultSet rs = null;
		Statement st = null;
		String role = "guest";
		String sql;
		try (Connection connect = ConnectionPool.getInstance().takeConnection()) {
			StringBuffer stringBuffer = new StringBuffer("SELECT roles_id FROM users where login='");
			stringBuffer.append(login);
			stringBuffer.append("'");
			sql = stringBuffer.toString();

			st = connect.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int idRole = (rs.getInt(1));
				if (idRole == 1) {
					role = "admin";
				}
				if (idRole == 2) {
					role = "manager";
				}
				if (idRole == 3) {
					role = "user";
				}

			}

		} catch (Exception e) {
			LOG.error(e);
			throw new DaoException(e);

		}

		return role;

	}

}
