<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.table_wrapper {
	background: url(/resources/img/background-stripe.png)top left #fafafa;
    border-bottom: 1px solid #ccc;
    height: 230px;
    overflow: auto;
}


#sales_items {
	width: 100%;
    background: #fff;
   /*  border-top: 1px solid #b0b0b0; */
    border-bottom: none;
}

#sales_items tr td.quantity {
   min-width: 20px;
}

#sales_items tr td.name {
	font-size: 14px;
    white-space: nowrap;
    max-width: 250px;
    overflow: hidden;
    text-overflow: ellipsis;
}

#sales_items tr td.price {
    font-size: 12px;
    font-weight: 700;
}

#sales_items tr {
	border-bottom: 1px solid #ddd;
}

#sales_items td {
	padding: 5px 0px;
}

#sales_items th {
	text-align: center;
}

.priceTotal {
	text-align: right;
	padding-right: 10px !important;
}

.bold {
	font-weight: bold;
}

.sqr {
	width: 100px;
	height: 100px;
	
}

#pluswrap {
position: fixed;
width: 100%;
height:100%;
display: flex;
align-items: center;
top: 0;
z-index:10000;
}

.plus {
  display: flex;
  margin: 0 auto;
}

</style>

<link href="resources/css/style.css" rel="stylesheet">
<script src="resources/js/jquery.easy-overlay.js"></script>	
	<div class="row">
		<div class="col-lg-7">
			<div class="panel panel-default">
                <div class="panel-heading">
               		<div class="form-group input-group">
               			<input type="text" id="searchPrd" name="states" class="form-control typeahead" placeholder="Search Product" style="height:34px;">
                        <span class="input-group-btn">
                            <button class="btn btn-primary" type="button" id="addProduct">Add</i>
                            </button>
                        </span>
                    </div>
                </div>
                <div class="panel-body" id="sales_items_container">
                	<div class="table-wrapper">
                		 <form name="salesForm" id="salesForm" method="post" action="#">
	                		<table id="sales_items">
	                			<thead>
	                				<tr>
	                					<th width="10%">Quantity</th>
	                					<th width="50%">Description</th>
	                					<th width="20%">Cost per Unit</th>
	                					<th width="15%">Total Cost</th>
	                				</tr>
	                			</thead>
	                			<tbody></tbody>
	                		</table>
	                	</form>
                	</div>
                    <p></p>
                    <hr/>
                    <div>
                    	<form name="orderForm" id="orderForm" method="post" action="#">
	                    	<div class="col-lg-5">
	                    		<div class="form-group input-group">
	                                 <input type="text" class="form-control" placeholder="Search Customer" id="searchCust">
	                                 <span class="input-group-btn" id="searchCustBtn">
	                                     <button type="button" class="btn btn-default" style="height:30px;"><i class="fa fa-search"></i>
	                                     </button>
	                                 </span>
	                             </div>
	                    		<span id="selectedCustomer">No Customer Selected</span>
	                    		<input type="hidden" name="customerId" id ="customerId"/>
	                    	</div>
	                    	<div>
	                    		<table style="width:57%;">
	                    			<tr>
	                    				<td>Subtotal</td>
	                    				<td style="float:right;">
	                    					<input type="text" name="subTotal" id="subTotal" value="0" class="form-control" style="width: 100px; font-weight: bold;text-align:right;" readonly="readonly"/>
	                    				</td>
	                    			</tr>
	                    			<tr>
	                    				<td>Tax %</td>
	                    				<td style="float:right;">
	                    					<input type="text" name="tax" id="tax" value="0" class="form-control" style="width: 100px;text-align:right;" onchange="calcTotal();"/>
	                    				</td>
	                    			</tr>
	                    			<tr>
	                    				<td>Total</td>
	                    				<td style="float:right;" id="totalAmount"></td>
	                    			</tr>
	                    			<tr>
	                    				<td colspan="2"><hr/></td>
	                    			</tr>
	                    			<tr>
	                    				<td>Discount %</td>
	                    				<td style="float:right;">
	                    					<input type="text" name="discount" id="discount" value="0" class="form-control" style="width: 100px;text-align:right;" onchange="calcNetAmount()"/>
	                    				</td>
	                    			</tr>
	                    			<tr>
	                    				<td>Old Balance</td>
	                    				<td style="float:right;">
	                    					<input type="text" name="oldBalance" id="oldBalance" value="0" class="form-control" style="width: 100px;text-align:right;" onchange="calcNetAmount()"/>
	                    				</td>
	                    			</tr>
	                    			<tr>
	                    				<td>To Pay</td>
	                    				<td style="float:right;">
	                    					<input type="text" name="netAmount" id="netAmount" value="0" class="form-control" style="width: 100px; font-weight: bold;text-align:right;" readonly="readonly"/>
	                    				</td>
	                    			</tr>
	                    		</table>
	                    	</div>
                    	</form>
                    </div>
                </div>
                <div class="panel-footer">
                    <button class="btn btn-default">Cancel</button>
                    <button class="btn btn-default" disabled="disabled">Park</button>
                    <button class="btn btn-default">Notes</button>
                   <!--  <button class="btn btn-default" disabled="disabled">Discount</button> -->
				    <button class="btn btn-primary" data-toggle="modal" data-target="#payModal">Pay</button>               
                </div>
            </div>			
		</div>
		<div class="col-lg-5">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Quick Items
                    </div>
                    <!-- /.panel-heading -->
             <div class="panel-body">
                 <!-- Nav tabs -->
                 <ul class="nav nav-tabs">
                 	<c:forEach begin="1" end="${layout.totalTabs}" var="tab">
	                 	<li><a href="#item${tab}" data-toggle="tab">Item${tab}</a>
	                   </li>
                 	</c:forEach>
                 </ul>

                 <!-- Tab panes --><br/>
                 <div class="tab-content">
                 	<c:forEach begin="1" end="${layout.totalTabs}" var="tab">
                 		<div class="tab-pane fade in" id="item${tab}">
                       <%--   <h4>Item${tab} Tab</h4> --%>
	                         <p style="float:left">
	                         	<c:forEach items="${layout.layoutDetailBeans}" var="layoutDetail">
	                         		<c:if test="${layoutDetail.tabNo eq tab}">
	                         			<div style="margin:2px;display: inline-table;">
	                         				<button class="btn btn-${layoutDetail.colorCode} sqr" onclick="addProductBtn(${layoutDetail.productBean.prodId});"><c:out value="${layoutDetail.productBean.prodName}"></c:out></button>
	                         			</div>
	                         		</c:if>	
	                         	</c:forEach>
	                         </p>
	                     </div>
                 	</c:forEach>
                 </div>
             </div>
             <!-- /.panel-body -->
         </div>
         <!-- /.panel -->                
	</div>
	
    <!-- Modal -->
    <div class="modal fade" id="payModal" tabindex="-1" role="dialog" aria-labelledby="payModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="payModalLabel">Payment</h4>
                </div>
                <div class="modal-body">
                	<table>
                		<tr>
                			<td>Payment Mode:</td>
                			<td>
                				<select class="form-control" onchange="showCreditOpts(this.value);">
                					<option value="1">Cash</option>
                					<option value="2">Debit Card</option>
                					<option value="3">Credit Card</option>
                				</select>
                			</td>
                		</tr>
                		<tr id="creditOpts" style="display:none;">
                			<td>
                				Credit Card type
                			</td>
                			<td>
                				<select class="form-control">
                					<option value="1">Visa</option>
                					<option value="2">Master</option>
                				</select>
                			</td>
                		</tr>
                		<tr>
                			<td>Amount to Pay:</td>
                			<td id="totalPay"></td>
                		</tr>
                		<tr>
                			<td>Amount Received:</td>
                			<td><input type="number" class="form-control" name="amtReceived" onchange="calcBalance(this.value);"/></td>
                		</tr>                			
                		<tr>
                			<td>Balance:</td>
                			<td id="balAmt"></td>
                		</tr>
                	</table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="saveForm();">Confirm</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
    <script src="resources/js/order.js" type="text/javascript"></script> 
    <script>
    
    var productNames = new Array();
	var productIds = new Object();
	
	var customerNames = new Array();
	var customerIds = new Object(); 
	
	$(document).ready(function() {
		
		$("#item1").addClass('active');
	    $("a[href='#item1']").parent().addClass('active');
		
		$('#searchPrd').focus(function(){
			$(this).select();
		});
		
		// to load products
		var products = null;//localStorage.getItem("products");
		if (products == null) {
    		products = new Array();        		
   		 	$.get("getAllProduct.sg", function(data, status) {
   		 		jsonString = JSON.stringify(data);
   			 	products = $.parseJSON(jsonString);
   		        //alert("Data: " + data + "\nStatus: " + status);
   			 	//localStorage.setItem("products", products);
   			 	loadProducts (products);
   		    });        		
    	}
		else {
			loadProducts (products);
		}
		
		// to load customers
		var customers = new Array();
		$.get("getAllCustomers.sg", function(data, status){
			jsonString = JSON.stringify(data);
			customers = $.parseJSON(jsonString);
			loadCustomers (customers);
		});
		
		$("#searchPrd").on('keyup', this, function (event) {
	        if (event.keyCode == 13) {
	        	addProduct($(this).val());
	        }
	    });
		
		$('#searchCust').on('keyup', this, function(event){
			if (event.keyCode == 13) {
				addCustomer($(this).val());
			}
		});
		
	});
	
	
	// to load products
	function loadProducts(products) {
		$.each(products, function(index, product) {
				prodName = product.prodName;				
                productNames.push(prodName);
                productIds[prodName] = product.prodId;
            } );
			 
		$('#searchPrd').typeahead({source: substringMatcher(productNames)});
	}
	
	// to load Customer
	function loadCustomers(customers) {
		$.each(customers, function(index, customer){
			custName = customer.custName;
			customerNames.push(custName);
			customerIds[custName] = customer.custId;
		});
		
		$('#searchCust').typeahead({source: substringMatcher(customerNames)});
	}
	
	$("#searchCustBtn").click(function(){
		value = $("#searchCust").val();
		addCustomer(value);
	});
	
	function addCustomer(value) {
		var custId = 0;
		
		if (value != '' && value.length != 0) {
			custId = customerIds[value];
			
			if (custId == '' || custId == undefined || custId == 0) {
				alert("Pls enter valid Customer Name");
				return;
			}
			
			$("#customerId").val(custId);
			$("#selectedCustomer").html("<span class='bold'>"+ value + "</span>");
			
			//addProductBtn(custId);   
		}
	}
	
	
	$("#addProduct").click(function(){
		value = $("#searchPrd").val();
		addProduct(value);
	});
	
	function addProduct(value) {
		var prodId = 0;		
		if (value != '' && value.length != 0) {
			prodId = productIds[value];
			
			if (prodId == '' || prodId == undefined || prodId == 0) {
				alert("Pls enter valid Product Name");
				return;
			}
			
			addProductBtn(prodId);   
		}
		$("#searchPrd").val("");
	}
	
	function showCreditOpts(val) {
		if (val == 3) {
			$("#creditOpts").show();
		}
		else {
			$("#creditOpts").hide();
		}
	}
    	
    </script>
    