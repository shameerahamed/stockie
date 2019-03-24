<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="resources/css/style.css" rel="stylesheet">
<script src="resources/js/jquey.autocomplete.min.js"></script>

		<div class="col-lg-12">
		<form:form method="POST" action="saveOrder.sg" commandName="order">
	   		<table class="table" style="width: 100%;">
	   		<thead>
			    <tr>
			        <td><form:label path="orderId">Order ID:</form:label></td>
			        <td><form:input path="orderId" value="${order.orderId}" readonly="true"  cssClass="form-control"/></td>
			        <td width="20%">&nbsp;</td>
			        <td><form:label path="discount">Discount:</form:label></td>
			        <td><form:input type="number" min="0" max="100" path="discount" value="${order.discount}" cssClass="form-control" onchange="lessDiscount(this.value)" /></td>
			     </tr>
			</thead>
			<tbody>
			    <tr>
			    	<td><form:label path="orderDate">Order Date:</form:label></td>
			        <td><form:input type="date" path="orderDate" value="${order.orderDate}"  cssClass="form-control"/></td>
			        <td width="20%">&nbsp;</td>
			        <td><form:label path="totalAmount">Total Amount:</form:label>
			    	<td><form:input path="totalAmount" value="${order.totalAmount}" cssClass="form-control" id="totalAmt"/> </td>
			    </tr>			    
			    <tr>
			    	<td><form:label path="customerId">Customer:</form:label></td>
			    	<td>
			    		<form:select path="customerId" cssClass="form-control" items="${customers}" itemValue="custId" itemLabel="custName">
			    		</form:select>    	
			    	</td>
			    	<td>&nbsp;</td>
			    	<td><label>Total Amount after Discount:</label></td>
			    	<td><input type="text" name="amtlessDisc" class="form-control" id="amtlessDisc"></td>			    	
			    </tr>
			    <tr>
			    	<td><form:label path="customerId">Customer:</form:label></td>
			    	<td>
			    		<form:select path="customerId" cssClass="form-control" items="${customers}" itemValue="custId" itemLabel="custName">
			    		</form:select>    	
			    	</td>
			    	<td>&nbsp;</td>
			    	<td><label>Total Amount after Discount:</label></td>
			    	<td><input type="text" name="amtlessDisc" class="form-control" id="amtlessDisc"></td>			    	
			    </tr>
			    <tr>
			    	<td><form:label path="status">Order Status:</form:label></td>
			    	<td>
			    		<form:select path="status" cssClass="form-control" items="${status}">
			    		</form:select>    	
			    	</td>
			    	<td>&nbsp;</td>
			    	<td><label>Total Amount after Discount:</label></td>
			    	<td><input type="text" name="amtlessDisc" class="form-control" id="amtlessDisc"></td>			    	
			    </tr>
			</tbody>
			<tfoot>
			    <tr>
			    	<c:if test="${order.orderId == null}">
			      		<td colspan="5"><input type="submit" value="Submit" class="btn btn-primary"/></td>
			      	</c:if>
			      	<c:if test="${order.orderId != null}">
			      		<td colspan="5"><input type="button" value="Print" class="btn btn-warning" onclick="javascript:popupPrint();"/></td>
			      	</c:if>			      
		      	</tr>
		    </tfoot>
			</table>
			<br/>
			
			<table class="table">
				<thead>
				<tr>
					<th>#</th>
					<th>Product</th>
					<th>Cost per unit</th>
					<th>Quantity</th>
					<th>Amount</th>
				</tr>
				</thead>
				<tbody>
				<c:if test="${order.orderId != null}">
					<c:forEach items="${order.orderItems}" var="orderItem" varStatus="idx">
					<tr>
						<td class="index">${idx.count}</td>					
						<td>${orderItem.productBean.prodName}</td>
						<td>${orderItem.productBean.price}</td>
						<td>${orderItem.quantity}</td>
						<td>${orderItem.amount}</td>
					</tr>
					</c:forEach>
				</c:if>
				
				<c:if test="${order.orderId == null}">
					<c:forEach items="${order.orderItems}" var="orderItem" varStatus="idx">
					<tr>
						<td class="index">${idx.count}</td>
						<td>
							<!-- <div id="magicsuggest"></div> -->
							<input name="orderItems[${idx.index}].productBean" class="form-control autocomplete"/>
							<!--  <div class="outputbox">
						        <p class="outputcontent"></p>
						      </div> -->
							
							<%-- <form:select path="orderItems[${idx.index}].productBean" cssClass="form-control" onchange="getProductPrice(this.value, ${idx.index})">
								<form:options items="${products}"/>
							</form:select> --%>
							<input type="hidden" name="orderItems[${idx.index}].productId" value="${orderItem.productId}" id="productId${idx.index}"/>
						</td>
						<td>
							<label class="unitCost${idx.index}"></label>
							<%-- <input name="orderItems[${idx.index}].unitCost" class="form-control" readonly="readonly" class="unitCost${idx.index}"/> --%>
						</td>
						<td>
							<input name ="orderItems[${idx.index}].quantity" class="form-control" value="${orderItem.quantity}" type="number" min="0" max="999" onchange = "calcItemTotal(this.value,${idx.index})"/>
						</td>				
						<td>
							<input name ="orderItems[${idx.index}].amount" class="form-control amount${idx.index}" value="${orderItem.amount}"/>
						</td>
					</tr>					
					</c:forEach>
				</c:if>
				</tbody>
			</table> 
		</form:form>
		</div>
    <script>
    /* $(function() {
        $('#dataTables-order').DataTable({
                responsive: true
        });
    }); */
    
    $(function() {
    	var currencies = [
    	<c:forEach items="${products}" var="product" varStatus="idx">
    		{ value: '${product.value}', data: '${product.key}' },
    	</c:forEach>];
    	
    	// setup autocomplete function pulling from currencies[] array
    	  $('.autocomplete').autocomplete({
    	    lookup: currencies,
    	    onSelect: function (suggestion) {
    	      $(this).parent().siblings().children('input.name').val(suggestion.data);    	      
    	      var fieldName = $(this).parent().siblings().children('input').attr('name');
    	      var idx = [];

    	      fieldName.replace(/\[(.*?)\]/g, function(g0,g1){idx.push(g1);})
    	      getProductPrice(suggestion.data, idx[0]);
    	      $("#productId"+idx[0]).val(suggestion.data); 
    	    }
    	  });

    });
    </script>    
    