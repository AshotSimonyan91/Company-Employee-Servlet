package com.example.companyemployeeservlet.servlet;

import com.example.companyemployeeservlet.manager.CompanyManager;
import com.example.companyemployeeservlet.manager.EmployeeManager;
import com.example.companyemployeeservlet.model.Company;
import com.example.companyemployeeservlet.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/createEmployee")
public class CreateEmployeeServlet extends HttpServlet {
    private EmployeeManager employeeManager = new EmployeeManager();
    private CompanyManager companyManager = new CompanyManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> allCompany = companyManager.getAll();
        req.setAttribute("companies", allCompany);
        req.getRequestDispatcher("WEB-INF/createEmployee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        int companyID = Integer.parseInt(req.getParameter("company"));
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setEmail(email);
        employee.setCompany(companyManager.getById(companyID));
        employeeManager.save(employee);
        resp.sendRedirect("/employees");
    }
}
