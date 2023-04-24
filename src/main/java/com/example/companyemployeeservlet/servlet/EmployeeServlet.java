package com.example.companyemployeeservlet.servlet;

import com.example.companyemployeeservlet.manager.EmployeeManager;
import com.example.companyemployeeservlet.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    private EmployeeManager employeeManager = new EmployeeManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> all = employeeManager.getAll();
        req.setAttribute("employees", all);
        req.getRequestDispatcher("WEB-INF/employees.jsp").forward(req, resp);
    }
}
