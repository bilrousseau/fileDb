package com.m2i.filedbee.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.m2i.filedbee.beans.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/registerUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/registeruser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		
		user.setFirstname((String) request.getParameter("firstname")); 
		user.setLastname((String) request.getParameter("lastname")); 
		user.setBirthDate((String) request.getParameter("birthDate")); 
		user.setEmail((String) request.getParameter("email")); 
		System.out.println("POST MOFO");
		if (user.getErrors().isEmpty()) {
			request.setAttribute("newUser", user);
			user.writeToFile("/Users/billrouseeau/dev/jee/FileHandling/WebContent/WEB-INF/users.csv");
		} else {
			for (Map.Entry<String, String> error : user.getErrors().entrySet()) {
				request.setAttribute(error.getKey(), error.getKey());
				request.setAttribute(error.getKey()+"_content", error.getValue());
			}
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/registeruser.jsp").forward(request, response);
	}

}
