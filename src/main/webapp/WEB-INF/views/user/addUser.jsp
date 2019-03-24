<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <h2>Add User Data</h2> -->
<form:form method="POST" action="saveUser.sg">
	<div class="col-lg-6">
  		<table class="table">
	    <tr>
	        <td><form:label path="userId">User ID:</form:label></td>
	        <td><form:input path="userId" cssClass="form-control" value="${user.userId}" readonly="true"/></td>
	    </tr>
	    <tr>
	        <td><form:label path="username">User Name:</form:label></td>
	        <td><form:input path="username" cssClass="form-control" value="${user.username}"/></td>
	    </tr>
	    <tr>
	        <td><form:label path="password">Password:</form:label></td>
	        <td><form:password path="password" cssClass="form-control" value="${user.password}"/></td>
	    </tr>			  
	    <tr>
	      <td colspan="2"><input type="submit" value="Submit" class="btn btn-primary"/></td>
      </tr>
	</table> 
	</div>
</form:form>
	
