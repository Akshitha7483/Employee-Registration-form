package net.javaguides.registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.registration.dao.EmployeeDao;
import net.javaguides.registration.dao.EmployeeDao2;
import net.javaguides.registration.model.Employee;

import java.io.IOException;
import java.util.List;

@WebServlet("/viewEmployees")
public class EmployeeServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDao2 employeeDao = new EmployeeDao2();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Employee> employees = employeeDao.getAllEmployees();
            request.setAttribute("employeeList", employees);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeelist.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
