<%@ page import="java.util.List" %>
<%@ page import="com.example.companyemployeeservlet.model.Company" %><%--
  Created by IntelliJ IDEA.
  User: karen
  Date: 23.04.23
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Company</title>
</head>
<%List<Company> companies = (List<Company>) request.getAttribute("countryList"); %>
<body>
<a href="/companies"> Back </a>

<h2>Create Company</h2>
<form action="/createCompany" method="post">
    name: <input type="text" name="name"><br>
    country:
    <select name="country">
        <% for (Company company : companies) { %>
        <option value="<%=company.getCountry()%>"><%=company.getCountry()%></option>
        <% }%>
    </select>
    <input type="submit" value="create">
</form>
</body>
</html>
