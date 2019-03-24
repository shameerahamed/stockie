<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p style="float:right; padding-right: 15px;">
	<button type="button" class="btn btn-primary" onclick="gotourl('addProduct.sg')">Add Product</button>
</p>
<c:if test="${!empty products}">
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
        	Product List
		</div>
		 <!-- /.panel-heading -->
        <div class="panel-body">
            <div class="dataTable_wrapper">
                <table class="table table-striped table-bordered table-hover" id="dataTables-product">
                	<thead>
					<tr>
						<th>#</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Quantity Sold</th>
						<th>Total Quantity</th>
						<th>Action</th>
					</tr>
					</thead>
			
					<tbody>
					<c:forEach items="${products}" var="product" varStatus="idx">
						<tr>
							<td align="center"><c:out value="${idx.count}"/></td>
							<td><c:out value="${product.prodName}"/></td>
							<td><c:out value="${product.brandName}"/></td>
							<td><c:out value="${product.quantity}"/></td>
							<td><c:out value="${product.price}"/></td>
							<td><c:out value="${product.quantitySold}"/></td>
							<td><c:out value="${product.totalQuantity}"/></td>
							<td align="center">
								<a href="editProduct.sg?id=${product.prodId}" title="Edit"><i class="fa fa-edit fa-fw"></i></a> | 
								<a href="deleteProduct.sg?id=${product.prodId}" title="Delete"><i class="fa fa-trash-o"></i></a>
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
        $('#dataTables-product').DataTable({
                responsive: true
        });
    });
    </script>