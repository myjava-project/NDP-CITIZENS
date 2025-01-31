<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Citizens</title>
</head>
<body>
    <h1>Citizen List</h1>
    <table border="1">
        <tr>
            <th>Serial Number</th>
            <th>Name</th>
            <th>Aadhaar Number</th>
            <th>Mobile Number</th>
            <th>Address</th>
        </tr>
        <c:forEach items="${citizens}" var="citizen">
        <tr>
            <td>${citizen.serialNumber}</td>
            <td>${citizen.name}</td>
            <td>${citizen.aadhaarNumber}</td>
            <td>${citizen.mobileNumber}</td>
            <td>${citizen.address}</td>
        </tr>
        </c:forEach>
    </table>
    <a href="add-citizen.jsp">Add New Citizen</a>
</body>
</html>