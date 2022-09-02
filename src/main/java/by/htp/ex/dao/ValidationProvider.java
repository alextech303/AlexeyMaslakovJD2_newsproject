package by.htp.ex.dao;

import by.htp.ex.dao.impl.UserDataValidationImpl;

public class ValidationProvider {
	
	private static final ValidationProvider instance = new ValidationProvider();
	private static final UserDataValidation userDataValidation = new UserDataValidationImpl();
	
	
	public static ValidationProvider getInstance() {
		return instance;
		
	}

	public UserDataValidation getUserDataVelidation() {
		
		return userDataValidation ;
	}

}
