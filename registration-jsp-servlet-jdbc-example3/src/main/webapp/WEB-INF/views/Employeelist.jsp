<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="net.javaguides.registration.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
</head>
<body>
    <h1>Employee List</h1>
    <table border="1" cellspacing="0" cellpadding="5">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
            <th>Address</th>
            <th>Contact</th>
        </tr>
        <%
            List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");
            if (employeeList != null) {
                for (Employee employee : employeeList) {
                    %>
                    <tr>
                        <td><%= employee.getFirstname() %></td>
                        <td><%= employee.getLastname() %></td>
                        <td><%= employee.getUsername() %></td>
                        <td><%= employee.getAddress() %></td>
                        <td><%= employee.getContact() %></td>
                    </tr>
                    <%
                }
            }
        %>
    </table>
</body>
</html>
