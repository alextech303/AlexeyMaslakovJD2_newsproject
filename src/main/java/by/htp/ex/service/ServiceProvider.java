package by.htp.ex.service;

import by.htp.ex.service.impl.NewsServiceImpl;
import by.htp.ex.service.impl.UserServiceImpl;

public final class ServiceProvider {
	
	private static final ServiceProvider instance = new ServiceProvider();
	
	private ServiceProvider() {}
	
	private final IUserService iUserService = new UserServiceImpl();
	
	private final INewsService newsService = new NewsServiceImpl();
	
	public IUserService getUserService() {
		return iUserService;
	}
	
	
	public INewsService getNewsService() {
		return newsService;
	}
	
	public static ServiceProvider getInstance() {
		return instance;
	}

}
