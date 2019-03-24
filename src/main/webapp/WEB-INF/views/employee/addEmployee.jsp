<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="col-lg-6">
		<form:form method="POST" action="saveEmployee.sg">
	   		<table class="table">
			    <tr>
			        <td><form:label path="empId">Employee ID:</form:label></td>
			        <td><form:input path="empId" value="${employee.empId}" readonly="true"  cssClass="form-control"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="name">Full Name:</form:label></td>
			        <td><form:input path="name" value="${employee.name}"  cssClass="form-control"/></td>
			    </tr>
			    <tr>
			    	<td><form:label path="designation">Designation:</form:label></td>
			    	<td><form:input path="designation" value="${employee.designation}"  cssClass="form-control"/></td>
			    </tr>
			    <tr>
			    	<td><form:label path="doj">DOJ:</form:label></td>
			    	<td><form:input path="doj" value="${employee.doj}"  cssClass="form-control" type="date"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="salary">Salary:</form:label></td>
			        <td><form:input path="salary" value="${employee.salary}"  cssClass="form-control"/></td>
			    </tr>
			     <tr>
			    	<td><form:label path="dob">DOB:</form:label></td>
			    	<td><form:input path="dob" value="${employee.dob}"  cssClass="form-control" type="date"/>
			    </tr>
			    <tr>
			        <td><form:label path="age">Age:</form:label></td>
			        <td><form:input path="age" value="${employee.age}"  cssClass="form-control" type="number"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="address">Address:</form:label></td>
                    <td><form:input path="address" value="${employee.address}" cssClass="form-control"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="phoneNo">phoneNo:</form:label></td>
                    <td><form:input path="phoneNo" value="${employee.phoneNo}" cssClass="form-control"  type="number"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"  class="btn btn-primary"/></td>
		      </tr>
			</table> 
		</form:form>
	</div> 
    