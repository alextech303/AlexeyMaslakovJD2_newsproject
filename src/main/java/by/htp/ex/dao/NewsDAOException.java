package by.htp.ex.dao;

public class NewsDAOException extends Exception {

	public NewsDAOException(String message) {
		super(message);
	}

	public NewsDAOException(String message, Exception exception) {
		super(message, exception);
	}

	public NewsDAOException(Exception message) {
		super(message);
	}

}
