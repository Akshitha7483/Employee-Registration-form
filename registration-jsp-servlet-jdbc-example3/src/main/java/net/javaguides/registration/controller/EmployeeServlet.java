
package net.javaguides.registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.registration.dao.EmployeeDao;
import net.javaguides.registration.model.Employee;

import java.io.IOException;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao = new EmployeeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Employeeregister.jsp");
		dispatcher. forward (request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName= request.getParameter("firstName");
		String lastName =request.getParameter("lastName");
		String username =request.getParameter("username");
		String password= request.getParameter("password");
		String address= request.getParameter("address");
		String contact= request.getParameter("contact");
		
		System.out.println("First Name: " + firstName); 
		System.out.println("Last Name: " + lastName);
		
		Employee employee= new Employee();
		employee.setFirstname(firstName);
		employee.setLastname(lastName);
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setAddress(address);
		employee.setContact(contact);
		
		try {
			employeeDao.registerEmployee (employee);
				} 
	          catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	}
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/views/Employeedetails.jsp");
		dispatcher.forward(request, response);
}

}


