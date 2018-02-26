<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<h2>Hello</h2>
	<form:form method="post" modelAttribute="orderDetail" action="/spring/save">
		<form:label path="">UnitPrice</form:label>
		<form:input path="unitPrice" type="number" title="UnitPrice"/>
		<form:label path="">Quantity</form:label>
		<form:input path="quantity" type="number" title="Quantity"/>
		<form:label path="">Discount</form:label>
		<form:input path="discount" type="number" title="Discount"/>
		<form:hidden path="product.productID"/>
		<form:hidden path="product.productName"/>
		<form:hidden path="orderID"/>
		<form:button>Submit</form:button>
		<a href="/spring/">Home</a>
	</form:form>
</body>
</html>
