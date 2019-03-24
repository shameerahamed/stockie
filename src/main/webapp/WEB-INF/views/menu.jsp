<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">           
            <li>
                <a href="home.sg"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Reports<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="#">Retail Dashboard</a>
                    </li>
                    <li>
                        <a href="#">Sales Report</a>
                    </li>
                    <li>
                        <a href="#">Inventory Report</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="sellOrder.sg"><i class="fa fa-shopping-cart fa-fw"></i> Sales</a>
            </li>
            <li>
                <a href="listOrder.sg"><i class="fa fa-history fa-fw"></i> History</a>
            </li>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li>
                <a href="#"><i class="fa fa-gift fa-fw"></i> Products<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="listProduct.sg">List of Products</a>
                    </li>
                    <li>
                       <a href="addProduct.sg">Add Product</a>
                    </li>                  
                </ul>
                <!-- /.nav-second-level -->
            </li>
            </sec:authorize>
            <li>
                <a href="#"><i class="fa fa-group fa-fw"></i> Customers<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="listCustomer.sg">List of Customers</a>
                    </li>
                    <li>
                       	<a href="addCustomer.sg">Add Customer</a>
                    </li>                  
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="fa fa-sitemap fa-fw"></i> Employees<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                	<li>
                         <a href="listEmployee.sg">List of Employees</a>
                     </li>
                     <li>
                         <a href="addEmployee.sg">Add Employee</a>
                     </li>
                </ul>
            </li>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
           	<li>
                  <a href="#"><i class="fa fa-user fa-fw"></i> Users <span class="fa arrow"></span></a> 
                  <ul class="nav nav-second-level">
                      <li>
                          <a href="listUser.sg">List of Users</a>
                      </li>
                      <li>
                          <a href="addUser.sg">Add User</a>
                      </li>
                  </ul>
                <!-- /.nav-second-level -->
            </li>
            </sec:authorize>
            <li>
                <a href="#"><i class="fa fa-wrench fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="blank.html">Blank Page</a>
                    </li>
                    <li>
                        <a href="login.sg">Login Page</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
        </ul>
    </div>
    <!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->