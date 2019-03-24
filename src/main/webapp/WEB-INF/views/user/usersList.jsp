<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p style="float:right; padding-right: 15px;">
	<button type="button" class="btn btn-primary" onclick="gotourl('addUser.sg')">Add User</button>
</p>

<c:if test="${!empty users}">
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            User List
        </div>
        <!-- /.panel-heading -->
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover">
                    <thead>                                        
					<tr>
						<th>#</th>
						<th>User Name</th>
						<th>isEnabled</th>
						<th>Action</th>
					</tr>
                    </thead>
                    <tbody>
					<c:forEach items="${users}" var="user" varStatus="idx">
					<tr>
						<td align="center"><c:out value="${idx.count}"/></td>
						<td><c:out value="${user.username}"/></td>
						<td><c:out value="${user.enabled}"/></td>
						<td align="center">						
							<a href="editUser.sg?id=${user.userId}" title="Edit"><i class="fa fa-edit fa-fw"></i></a> | 
							<a href="deleteUser.sg?id=${user.userId}" title="Delete"><i class="fa fa-trash-o"></i></a>
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
