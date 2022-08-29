package by.htp.ex.dao;

import by.htp.ex.dao.impl.NewsDao;
import by.htp.ex.dao.impl.UserDao;

public final class DaoProvider{
	
	
	private static final DaoProvider instance = new DaoProvider();

	private final IUserDao userDAO = new UserDao();
	
	private final INewsDao newsDAO = new NewsDao();
	
	
	private DaoProvider() {
	}
	
	
	public IUserDao getIUserDao() {
		return userDAO;
	}
	
	public INewsDao getNewsDAO() {
		return newsDAO;
	}

	public static DaoProvider getInstance() {
		return instance;
	}
}
