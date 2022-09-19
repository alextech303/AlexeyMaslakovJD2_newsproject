package by.htp.ex.dao;

import java.sql.SQLException;

public interface UserDataValidation {

	boolean checkAuthUser(String login, String password) throws SQLException, DaoException;

	boolean checkUserInBD(String login, String email) throws SQLException, DaoException;

}
