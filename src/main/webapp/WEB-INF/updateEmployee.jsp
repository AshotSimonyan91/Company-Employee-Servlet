<%@ page import="com.example.companyemployeeservlet.model.Employee" %>
<%@ page import="com.example.companyemployeeservlet.model.Company" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% Employee employee = (Employee) request.getAttribute("employee"); %>
<% List<Company> companies = (List<Company>) request.getAttribute("companies");%>
<a href="/employees"> Back </a>

<h2>Update Company</h2>
<form action="/updateEmployee" method="post">
  <input name="id" type="hidden" value="<%=employee.getId()%>">
  name: <input type="text" name="name" value="<%=employee.getName()%>"><br>
  surname: <input type="text" name="surname" value="<%=employee.getSurname()%>"> <br>
  email: <input type="email" name="email" value="<%=employee.getEmail()%>"> <br>
  company:
  <select name="company">
    <% for (Company company : companies) { %>
    <option value="<%=company.getId()%>"><%=company.getName()%></option>
    <% }%>
  </select><br>
  <input type="submit" value="update">
</form>
</body>
</html>
