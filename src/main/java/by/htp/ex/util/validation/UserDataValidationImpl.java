package by.htp.ex.util.validation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.poolConnection.ConnectionPool;
import by.htp.ex.dao.poolConnection.ConnectionPoolException;



public class UserDataValidationImpl implements UserDataValidation{
	private final static Logger LOG = LogManager.getLogger(by.htp.ex.util.validation.UserDataValidationImpl.class);
	
	Statement st = null;
	ResultSet rs = null;
    private boolean authUser = false;
    private boolean checkUserInBD = true;

	@Override
	public boolean checkAuthUser(String login, String password)  {
		try (Connection connect = ConnectionPool.getInstance().takeConnection()){
//			 
			 st = connect.createStatement();
			 rs = st.executeQuery("SELECT * FROM users");
			 
			  while (rs.next()) { 
				  
				  if((login+password).equals(rs.getString(2)+rs.getString(3))) {
					 authUser=true; 
					 
				  }
			  }
			  
			 
	} catch (SQLException | ConnectionPoolException e ) {
		// TODO Auto-generated catch block   
		e.printStackTrace();
	
}
		return authUser;
}

	@Override
	public String getRoleUser(String login) throws SQLException {
		try (Connection connect = ConnectionPool.getInstance().takeConnection()){
//			 
			 st = connect.createStatement();
			 rs = st.executeQuery("SELECT * FROM role");
			 
			  while (rs.next()) { 
				  
				  
			  }
			  
			 
	} catch (SQLException | ConnectionPoolException e ) {
		// TODO Auto-generated catch block   
		e.printStackTrace();
	}
		return login;
}

	@Override
	public boolean checkUserInBD(String login, String email) throws SQLException {
		try (Connection connect = ConnectionPool.getInstance().takeConnection()){
//			 
			 st = connect.createStatement();
			 rs = st.executeQuery("SELECT * FROM users");
			 
			  while (rs.next()) { 
				  
				  if(((login).equals(rs.getString(2)))|rs.getString(4).equals(email)) {
					  checkUserInBD=false; 
					 if((login).equals(rs.getString(2))) {
					 LOG.debug("пользователь не прошел регистрацию",new DaoException("В базе пользователь с таким логином "+login +" существует - используйте другой логин"));
				  }else if(rs.getString(4).equals(email)) {
					  LOG.debug("пользователь не прошел регистрацию",new DaoException("В базе пользователь с таким email "+email +" существует - используйте другой email"));
				  }
				  }
			  }
			 
	} catch (SQLException | ConnectionPoolException e ) {
		LOG.error("Ошибка соединения с базой данных", e);
	
}
		return checkUserInBD;
	}
}
	