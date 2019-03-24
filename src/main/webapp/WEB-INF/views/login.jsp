<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
<title>Login</title>
<style>  
.errorblock {  
 color: #ff0000;  
 background-color: #ffEEEE;  
 border: 3px solid #ff0000;  
 padding: 8px;  
 margin: 16px;  
}  
</style>
<!-- Bootstrap -->
    <!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="resources/css/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>	
	 <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                    	<c:if test="${not empty error}">  
						  <div class="errorblock">  
						   Your login attempt was not successful, try again.  Caused :  
						   ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}  
						  </div>  
						 </c:if> 
                    	<form action="<c:url value='/j_spring_security_check' />" method="POST">
                    		 <fieldset>
                                <div class="form-group">
                                	<input type="text" name="j_username" Class="form-control" placeholder="Username" required="true" autofocus="true">                            
                                </div>
                                <div class="form-group">
                                	<input type="password" name="j_password" Class="form-control" placeholder="Password" required="true">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                 <button class="btn btn-lg btn-success btn-block" type="submit">Login</button>	
                            </fieldset>
                    	</form>
                       <%--  <form:form method="POST" action="validateLogin.sg" role="form">
                            <fieldset>
                                <div class="form-group">                                
                                	<form:input path="username" value="${user.username}" cssClass="form-control" placeholder="Username" required="true" autofocus="true"/>
                                </div>
                                <div class="form-group">
                                	<form:password path="password" value="${user.password}" cssClass="form-control" placeholder="Password" required="true"/>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                 <button class="btn btn-lg btn-success btn-block" type="submit">Login</button>	
                            </fieldset>
    					</form:form> --%>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="resources/js/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="resources/js/metisMenu.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="resources/js/sb-admin-2.js"></script>

</body>
</html>
<%-- <table width="100%">
<tr>
	<td><font color="red">${errMsg}</font></td>
</tr>
<tr>
<td>


	<table width="32%" cellspacing="1" cellpadding="5" class="tbl" align="center" border="0">
	<form:form method="POST" action="validateLogin.sg">	
	<tr bgcolor="#A9CDED">
		<td colspan="2" align="center"><b>Login</b></td>
	</tr>
	<tr>
		<td width="50%" class="label">Username : </td>
		<td>
			<form:input path="username" value="${user.username}"/>
		</td>
	</tr>
	<tr>
		<td class="label">Password : </td>
		<td>
			<form:password path="password" value="${user.password}"/>
		</td>
	</tr>
	<tr>
		<td align="right"><input type="submit" value="Submit"/></td>
		<td align="left"><input class="btn" type="reset" name="frmreset" value="Reset"></td>
	</tr>
	</form:form>
	</table>
</td>
</tr>
	</table> --%>