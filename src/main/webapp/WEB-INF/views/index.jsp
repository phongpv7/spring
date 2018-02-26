<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<h2>Hello</h2>
	<form:form method="post" modelAttribute="searchOrder" action="/spring/search">
		<form:input path="orderID" type="number" />
		<form:button>Submit</form:button>
	</form:form>
	<table border="1">
		<tr>
			<th>OrderID</th>
			<th>Product Name</th>
			<th>UnitPrice</th>
			<th>Quantity</th>
			<th>Discount</th>
			<th>Total</th>
			<th>Action</th>
		</tr>
		<c:forEach var="item" items="${orders}">
			<tr>
				<td>${item.orderID}</td>
				<td>${item.product.productName}</td>
				<td>${item.unitPrice}</td>
				<td>${item.quantity}</td>
				<td>${item.discount}</td>
				<td>${(item.unitPrice * item.quantity * (100-item.discount))/100}</td>
				<td><a href="/spring/delete?oid=${item.orderID}&pid=${item.product.productID}">Delete</a>
				<a href="/spring/edit?oid=${item.orderID}&pid=${item.product.productID}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
