<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p style="float:right; padding-right: 15px;"><button type="button" class="btn btn-primary" onclick="gotourl('addCustomer.sg')">Add Customer</button></p>
<c:if test="${!empty customers}">
	 <div class="col-lg-12">
	    <div class="panel panel-default">
	        <div class="panel-heading">
	        	Customer Listing
			</div>
			 <!-- /.panel-heading -->
	        <div class="panel-body">
	            <div class="dataTable_wrapper">
	                <table class="table table-striped table-bordered table-hover" id="dataTables-customer">
			  		<thead>
		               <tr>
			                <th>#</th>
							<th>Name</th>
							<th>Address</th>
							<th>Email</th>			
							<th>Phone</th>
							<th>Reg Date</th>
							<th>Action</th>
						</tr>
					</thead>
					 <tbody>	
						<c:forEach items="${customers}" var="customer" varStatus="idx">
							<tr>
								<td align="center"><c:out value="${idx.count}"/></td>
								<td><c:out value="${customer.custName}"/></td>
								<td><c:out value="${customer.address}"/></td>				
								<td><c:out value="${customer.email}"></c:out></td>
								<td><c:out value="${customer.phoneNo}"></c:out> </td>
								<td><c:out value="${customer.regDate}"></c:out></td>
								<td align="center">
									<a href="editCustomer.sg?id=${customer.custId}" title="Edit"><i class="fa fa-edit fa-fw"></i></a> | 
									<a href="deleteCustomer.sg?id=${customer.custId}" title="Delete"><i class="fa fa-trash-o"></i></a>
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
        $('#dataTables-customer').DataTable({
                responsive: true
        });
    });
    </script>