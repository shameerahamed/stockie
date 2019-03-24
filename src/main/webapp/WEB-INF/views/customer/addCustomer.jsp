<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="col-lg-6">
		<form:form method="POST" action="saveCustomer.sg">
	   		<table class="table">
			    <tr>
			        <td><form:label path="custId">Customer ID:</form:label></td>
			        <td><form:input path="custId" value="${customer.custId}" readonly="true"  cssClass="form-control"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="custName">Name:</form:label></td>
			        <td><form:input path="custName" value="${customer.custName}"  cssClass="form-control"/></td>
			    </tr>
			    <tr>
			    	<td><form:label path="address">Address:</form:label></td>
			    	<td><form:input path="address" value="${customer.address}"  cssClass="form-control"/></td>
			    </tr>
			    <tr>
			    	<td><form:label path="email">Email Address:</form:label></td>
			    	<td><form:input path="email" value="${customer.email}"  cssClass="form-control" type="email"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="phoneNo">Phone No:</form:label></td>
			        <td><form:input path="phoneNo" value="${customer.phoneNo}"  cssClass="form-control" type="number"/></td>
			    </tr>
			     <tr>
			    	<td><form:label path="regDate">Reg Date:</form:label></td>
			    	<td><form:input path="regDate" value="${customer.regDate}"  cssClass="form-control" type="date"/>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"  class="btn btn-primary"/></td>
		      </tr>
			</table> 
		</form:form>
	</div>   
    