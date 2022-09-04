package by.htp.ex.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import by.htp.ex.dao.poolConnection.ConnectionPool;
import by.htp.ex.dao.poolConnection.ConnectionPoolException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final CommandProvider provider = new CommandProvider();
       

    public FrontController() {
        super();
    }

    public void init(ServletConfig config) throws ServletException{
    	try {
			ConnectionPool.getInstance().initPoolData();
			ConnectionPool.getInstance().takeConnection();

		} catch (ConnectionPoolException e) {
			
			e.printStackTrace();
		}
    }
    
    public void destroy() {
    	ConnectionPool.getInstance().dispose();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		
//		request.getSession(true).setAttribute("local","en");
		System.out.println("processRequest");
		
		String commandName = request.getParameter("command");

		Command command = provider.getCommand(commandName);
		try {
			command.execute(request, response);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException | ServletException | IOException e) {
			
			e.printStackTrace();
		}
		
		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
//		requestDispatcher.forward(request, response);

	}


}
