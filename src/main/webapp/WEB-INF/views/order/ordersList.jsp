<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p style="float:right; padding-right: 15px;"><button type="button" class="btn btn-success" onclick="gotourl('sellOrder.sg')">New Order</button></p>
<c:if test="${!empty orders}">
	 <div class="col-lg-12">
	    <div class="panel panel-default">
	        <div class="panel-heading">
	        	Order Listing
			</div>
			 <!-- /.panel-heading -->
	        <div class="panel-body">
	            <div class="dataTable_wrapper">
	                <table class="table table-striped table-bordered table-hover" id="dataTables-order">
			  		<thead>
			            <tr>
			                <th>#</th>
							<th>Order Id</th>
							<th>Order Date</th>
							<th>Customer Name</th>										
							<th>Discount</th>
							<th>Total Amount</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					 <tbody>	
						<c:forEach items="${orders}" var="order" varStatus="idx">
							<tr>
								<td><c:out value="${idx.count}"/></td>
								<td><c:out value="${order.orderId}"/></td>
								<td><c:out value="${order.orderDate}"/></td>				
								<td><c:out value="${order.customerBean.custName}"></c:out></td>
								<td><c:out value="${order.discount}"></c:out></td>
								<td><c:out value="${order.netAmount}"/></td>
								<td>
									<c:if test="${order.status eq 'CANCELLED' }">
										<span class="btn btn-danger">&nbsp;&nbsp;</span>
									</c:if>
									<c:if test="${order.status eq 'COMPLETE' }">
										<span class="btn btn-success">&nbsp;&nbsp;</span>
									</c:if>
									<c:if test="${order.status eq 'INCOMPLETE' }">
										<span class="btn btn-warning">&nbsp;&nbsp;</span>
									</c:if>
								</td>
								<td align="center">
									<a href="viewOrder.sg?id=${order.orderId}" title="View"><i class="fa fa-eye"></i></a> | 
									<a href="deleteOrder.sg?id=${order.orderId}" title="Delete"><i class="fa fa-trash-o"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</c:if>
    <script>
    $(function() {
        $('#dataTables-employee').DataTable({
                responsive: true
        });
    });
    </script>