<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>   
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>
		<tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
	</title>
	 <!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="resources/css/metisMenu.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- DataTables CSS -->
    <link href="resources/css/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="resources/css/dataTables.responsive.css" rel="stylesheet">
    
    <!-- Loading -->
    <link href="resources/css/loadingbar.css" rel="stylesheet"/>
    
    <!--  Custom style -->
    <link href="resources/css/style.css" rel="stylesheet"/>
    
    <!-- jQuery -->
    <script src="resources/js/jquery.min.js"></script>
   	<script src="resources/js/jquery.dataTables.min.js"></script>
   	
   	 <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>
    
    <!-- Auto suggest -->
    <script type="text/javascript" src="resources/js/bootstrap3-typeahead.js"></script>
    
    <!-- <script type="text/javascript" src="resources/js/typeahead.bundle.js"></script> -->
	<!-- Loading Bar -->
    <!-- <script src="resources/js/jquery.loadingbar.js"></script> -->    

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script>
    /* $(function() {
    	$("body").loadingbar({
  	      done: function(data) {
  	        $.each( data.items, function( i, item ) {
  	          $( "<img/>" ).attr( "src", item.media.m ).prependTo( $("#wrapper") );
  	          if ( i === 2 ) {
  	            return false;
  	          }
  	        });
  	      }
  	    });

    }); */
    </script>

</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-blue navbar-static-top" role="navigation" style="margin-bottom: 0">
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
			<tiles:insertAttribute name="menu"></tiles:insertAttribute>
		</nav>
	
	 	<!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                	<div class="col-lg-12">
                	 	<h3 class="page-header"><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></h3>
                	 	<tiles:insertAttribute name="body"></tiles:insertAttribute>
                	 </div>
               <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="col-lg-8" style="position: fixed; z-index: 10000;">
	                 <div class="alert alert-info alert-dismissable" style="display: none;">
				        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
				        Order has been saved successfully.<a href="#" class="alert-link">Alert Link</a>.
				    </div>
				     <div class="alert alert-danger alert-dismissable" style="display: none;">
				        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
				        Oops !! There is some error in saving Order. <a href="#" class="alert-link">Alert Link</a>.
				    </div>
			    </div>
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    
    <!-- Metis Menu Plugin JavaScript -->
    <script src="resources/js/metisMenu.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="resources/js/sb-admin-2.js"></script>
    
	<!-- DataTables JavaScript --> 
    <script src="resources/js/dataTables.bootstrap.min.js"></script>
    
    <!--  Functions -->
    <script src="resources/js/functions.js"></script>
    
	<%-- <tiles:insertAttribute name="footer"></tiles:insertAttribute> --%>
<%-- 
<table border="0" cellpadding="0" cellspacing="1" align="left" width="100%" style="vertical-align: top; background: lime;">
    <tr style="background:#FFFFFF">
        <td colspan="2" align="center">
        	<tiles:insertAttribute name="header"></tiles:insertAttribute>
        </td>
    </tr>
    <tr style="background:#FFFFFF">
        <td width="20%">
        	<tiles:insertAttribute name="menu"></tiles:insertAttribute>
        </td>
        <td>
        	<tiles:insertAttribute name="body"></tiles:insertAttribute>
        </td>
    </tr>
    <tr style="background:#FFFFFF">
        <td colspan="2"  align="center">
        	
        </td>
    </tr>
</table> --%>
</body>
</html>