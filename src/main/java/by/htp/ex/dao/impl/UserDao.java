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
import by.htp.ex.dao.poolConnection.ConnectionPool;
import by.htp.ex.dao.poolConnection.ConnectionPoolException;

public class UserDao implements IUserDao {

	private final static Logger LOG = LogManager.getLogger(by.htp.ex.dao.impl.UserDao.class);
	private final UserDataValidation validationUser = ValidationProvider.getInstance().getUserDataVelidation();
	private boolean checkUserlogination = false;
	private boolean checkUserReg = false;

	Statement st = null;
	ResultSet rs = null;
	private boolean authUser = false;
	private boolean checkUserInBD = true;
	private String role = "guest";
	private String sql;

	@Override
	public boolean logination(NewUserInfo user) throws DaoException {
		System.out.println("logination UserDao");
		try {
			if (validationUser.checkAuthUser(user.getLogin(), user.getPassword())) {

				checkUserlogination = true;
			} else {
				LOG.info("Пользователь " + user.getLogin() + " не прошел логинацию!!!");
			}
		} catch (SQLException e) {

			LOG.error(e);
		}

		return checkUserlogination;
	}

//		

	@Override
	public boolean registration(NewUserInfo user) throws DaoException, SQLException {
		System.out.println("registration  UserDao");
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
			}

		} else
			return checkUserReg;

		return checkUserReg;
	}

	@Override
	public String getRole(String login) throws DaoException, SQLException {
		System.out.println("getRole UserDao:");

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
			e.printStackTrace();
		}

		return role;

	}

}
