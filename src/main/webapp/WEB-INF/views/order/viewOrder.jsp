<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.stockie.util.DateUtil"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="resources/css/style.css" rel="stylesheet">
<script src="resources/js/jquey.autocomplete.min.js"></script>
	<style>
		table {
			padding : 5px;
			spacing : 2px;
			table-layout: auto;
			width: 100%;
		}
		
		.tb-head, .tb-head th {
			text-align : center;
		}
		
		.amt {
			text-align : right;
		}
	</style>
		<c:if test="${screen eq 'print' }">
			<table class="tb-head">
				<tr>
					<td>----------------------------------</td>
				</tr>
				<tr>
					<th>RAINBOW PLATICS</th>
				</tr>
				<tr>
					<td>Mobile : +919840043359</td>
				</tr>
				<tr>
					<td>47, Loganathan Street, Krishnamoorthy Nagar</td>
				</tr>
				<tr>
					<td>Chennai - 600118</td>
				</tr>
				<tr>
					<td>-------------------------------</td>
				</tr>
				<tr>
					<th>${order.orderDate}</th>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>
		</c:if>
		
		<div class="col-lg-12">
		<c:if test="${screen ne 'print'}">
			<p style="float:right;">				
				<input type="button" value="Print" class="btn btn-warning" onclick="javascript:popupPrint(${order.orderId});"/>
			</p>
			<c:set var="total" value="${order.subTotal + (order.subTotal * order.tax/100)}"></c:set>
	   		<table class="table" style="width: 100%;">	   		
			<tbody>
				 <tr>
			        <td><label>Order ID:</label></td>
			        <td>${order.orderId}</td>
			      	<td width="5">|</td>
			        <td><label path="discount">Discount (${order.discount}%):</label></td>
			        <td><c:out value="${total * order.discount/100}"/></td>
			     </tr>
			    <tr>
			    	<td><label>Order Date:</label></td>
			        <td>${order.orderDate}</td>
			        <td width="5">|</td>
			        <td><label>Total Amount:</label>
			    	<td>${order.subTotal}</td>
			    </tr>			    
			    <tr>
			    	<td><label>Customer:</label></td>
			    	<td>${order.customerBean.custName}</td>
			    	<td width="5">|</td>
			    	<td><label>Total Amount after Diff:</label></td>
			    	<td>${ order.netAmount}</td>			
			    </tr>
			</tbody>
			</table>
			<br/>
			</c:if>
			<table class="tb-head">
				<thead>
				<tr>
					<th>#</th>
					<th>Product</th>
					<th>Cost / unit</th>
					<th>Quantity</th>
					<th>Amount</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach items="${order.orderItems}" var="orderItem" varStatus="idx">
					<tr>
						<td class="index">${idx.count}.</td>					
						<td>${orderItem.productBean.prodName}</td>
						<td>${orderItem.productBean.price}</td>
						<td>${orderItem.quantity}</td>
						<td>${orderItem.amount}</td>
					</tr>
					</c:forEach>
				</tbody>
				<c:if test="${screen eq 'print' }">
				<tfoot>
					<tr>
						<td colspan="5">======================================</td>
					</tr>
					<tr>
						<td colspan="3" style="text-align:left;">Sub Total : </td>
						<td colspan="2">${order.subTotal}</td>
					</tr>
					<tr>
						<td colspan="3" style="text-align:left;">Tax : (${order.tax}%) </td>
						<td colspan="2"><c:out value="${order.subTotal * order.tax/100}"/></td>
					</tr>					
					<tr>
						<td colspan="3" style="text-align:left;">Discount : (${order.discount}%)</td>
						<td colspan="2">-<c:out value="${total * order.discount/100}"/></td>
					</tr>
					<tr>
						<td colspan="3" style="text-align:left;">Old Balance :</td>
						<td colspan="2">
							<c:out value="${ order.oldBalance}"></c:out>
						</td>
					</tr>
					<tr>
						<td colspan="3" style="text-align:left;"><b>Total Amount :</b></td>
						<td colspan="2">
							<b><c:out value="${ order.netAmount}"></c:out></b>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="5">* Thank You! Please Come Again *</td>
					</tr>
					<tr>
						<th  colspan="5">
							<input type="button" value="Print" class="btn btn-warning" onclick="javascript:window.print();"/>
						</th>
					</tr>
				</tfoot>
				</c:if>
			</table> 
		</div>  