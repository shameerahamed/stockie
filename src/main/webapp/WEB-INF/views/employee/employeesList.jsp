<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p style="float:right; padding-right: 15px;"><button type="button" class="btn btn-primary" onclick="gotourl('addEmployee.sg')">Add Employee</button></p>
<c:if test="${!empty employees}">
	 <div class="col-lg-12">
	    <div class="panel panel-default">
	        <div class="panel-heading">
	        	Employee Listing
			</div>
			 <!-- /.panel-heading -->
	        <div class="panel-body">
	            <div class="dataTable_wrapper">
	                <table class="table table-striped table-bordered table-hover" id="dataTables-employee">
			  		<thead>
			            <tr>
			                <th>#</th>
							<th>Name</th>
							<th>Designation</th>
							<th>DOJ</th>			
							<th>Salary</th>
							<th>DOB</th>
							<th>Age</th>	
							<th>Address</th>	
							<th>Phone</th>
							<th>Action</th>	
						</tr>
					</thead>
					 <tbody>	
						<c:forEach items="${employees}" var="employee" varStatus="idx">
							<tr>
								<td align="center"><c:out value="${idx.count}"/></td>
								<td><c:out value="${employee.name}"/></td>
								<td><c:out value="${employee.designation}"/></td>				
								<td><c:out value="${employee.doj}"></c:out></td>
								<td><c:out value="${employee.salary}"/></td>
								<td><c:out value="${employee.dob}"></c:out></td>
								<td><c:out value="${employee.age}"/></td>
								<td><c:out value="${employee.address}"/></td>
								<td><c:out value="${employee.phoneNo}"></c:out> </td>
								<td align="center">
									<a href="editEmployee.sg?id=${employee.empId}" title="Edit"><i class="fa fa-edit fa-fw"></i></a> | 
									<a href="deleteEmployee.sg?id=${employee.empId}" title="Delete"><i class="fa fa-trash-o"></i></a>
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