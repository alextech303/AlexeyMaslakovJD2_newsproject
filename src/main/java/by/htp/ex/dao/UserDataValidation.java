package by.htp.ex.dao;

import java.sql.SQLException;

public interface UserDataValidation {
	
	
       boolean checkAuthUser(String login, String password)throws SQLException;
//       String getRoleUser(String login) throws SQLException;
       boolean checkUserInBD(String login,String email)throws SQLException;
       
       
       
}
