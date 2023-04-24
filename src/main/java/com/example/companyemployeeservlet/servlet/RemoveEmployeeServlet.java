package com.example.companyemployeeservlet.servlet;

import com.example.companyemployeeservlet.manager.EmployeeManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/removeEmployee")
public class RemoveEmployeeServlet extends HttpServlet {

    private EmployeeManager employeeManager = new EmployeeManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        employeeManager.removeById(id);
        resp.sendRedirect("/employees");
    }
}
