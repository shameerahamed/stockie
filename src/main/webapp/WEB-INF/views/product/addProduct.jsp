<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- 	<h2>Add Product Data</h2> -->
	<div class="col-lg-6">
		<form:form method="POST" action="saveProduct.sg">
	   		<table class="table">
			    <tr>
			        <td><form:label path="prodId">Product ID:</form:label></td>
			        <td><form:input path="prodId" value="${product.prodId}" readonly="true"  cssClass="form-control"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="prodName">Product Name:</form:label></td>
			        <td><form:input path="prodName" value="${product.prodName}" cssClass="form-control"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="brandName">Brand Name:</form:label></td>
			        <td><form:input path="brandName" value="${product.brandName}" cssClass="form-control"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="quantity">Quantity:</form:label></td>
			        <td><form:input path="quantity" value="${product.quantity}" cssClass="form-control"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="price">Price:</form:label></td>
			        <td><form:input path="price" value="${product.price}" cssClass="form-control"/></td>
			    </tr>			    
			    <tr>
			        <td><form:label path="quantitySold">Quantity Sold:</form:label></td>
			        <td><form:input path="quantitySold" value="${product.quantitySold}" cssClass="form-control"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="totalQuantity">Total Quantity:</form:label></td>
                    <td><form:input path="totalQuantity" value="${product.totalQuantity}" cssClass="form-control"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit" class="btn btn-primary"/></td>
		      </tr>
			</table> 
		</form:form>
	</div>	