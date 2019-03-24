function addProductBtn(prodId) {
	//alert (prodId);
	$.ajax({
		url : "getProduct.sg?prodId=" + prodId,
		success : function(product) {
			createProdRow(product.prodId, product.prodName, product.price);
			calSubTotal();
		}
	});
}

function createProdRow(prodId, prodName, price) {
	$("#sales_items tbody")
			.prepend(
					"<tr class='multi_row'><td class='quantity'><input type='hidden' name='productId' value='"
							+ prodId
							+ "'/><input type='text' name='quantity' class='form-control stxt' style='width:50px;' value='1' onchange=\"updateRow('quantity',$(this))\"/></td><td class='name'>"
							+ prodName
							+ "</td><td class='price'><input type='text' name='unitCost' class='pricetxt form-control' style='width:70%;' value='"
							+ price
							+ "' onchange=\"updateRow('price',$(this))\"/></td><td class='priceTotal'>"
							+ price
							+ "</td><td class='action'><button class=\"btn btn-warning btn-danger btn-circle\" type=\"button\" onclick=\"deleteRow($(this))\"><i class=\"fa fa-times\"></i></button></td></tr>");
	$('#searchPrd').focus(function() {
		$(this).select();
	});
}

function deleteRow($this) {
	var $row = $this.parent().parent();
	$row.remove();
	calSubTotal();
}

function updateRow(type, $this) {
	var val = $this.val();
	var $row = $this.parent().parent();
	//alert($row.html());

	price = $row.find('.pricetxt').val();
	if (type == 'quantity') {
		newPrice = val * price;
		//$row.find('.pricetxt').val(newPrice);
	} else if (type == 'price') {
		newPrice = price;
		$row.find("input[name='quantity']").val(1);
	}

	$row.find('.priceTotal').html(newPrice);
	calSubTotal();
}

function calSubTotal() {
	var subtotal = 0;
	$('.priceTotal').each(function() {
		$val = $(this).text();
		//alert($val);
		subtotal += parseFloat($val);
	});
	$("#subTotal").val(subtotal);
	calcTotal();
}

function calcTotal() {
	tax = $("#tax").val();
	total = $("#subTotal").val();

	//alert(tax + total);

	if (tax != 0) {
		total = parseFloat(total) + parseFloat(total * parseFloat(tax) / 100);
	}
	$('#totalAmount').html("<span class='bold'>" + total + "</span>");
	calcNetAmount();
}

function calcNetAmount() {
	totalAmt = parseFloat($('#totalAmount').text());
	discount = $('#discount').val();
	oldBal = $('#oldBalance').val();
	
	if(discount != 0) {
		totalAmt = totalAmt - (totalAmt * parseFloat(discount)/100);
	}
	
	netAmount = parseFloat(totalAmt) + parseFloat(oldBal);
	$('#netAmount').val(netAmount.toFixed(2));
	$('#totalPay').html("<span class='bold'>" + netAmount.toFixed(2) + "</span>");
}

$(".stxt").on("focus", function(e) {
	var $this = $(this);
	$this.select();
	var keycode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
	if (keycode === 9 || !keycode) {
		// Hacemos select
		var $this = $(this);
		$this.select();
		alert('1');

		// Para Chrome's que da problema
		$this.on("mouseup", function() {
			// Unbindeamos el mouseup
			$this.off("mouseup");
			return false;
		});
	}
});

function saveForm() {
	//validate empty Order & customer
	if (!validateForm()) {
		return false;
	}
	
	//console.log(ConvertFormToJSON($("#salesForm")));
	$("body").overlay();
	var orderData = $('#orderForm').serializeObject();
	var rawData = $('#salesForm').serializeFormJSON();
	
	orderData['orderItems'] = rawData;
	
	var formData = JSON.stringify(orderData);
	//formData = formData.replace('[','');
	//formData = formData.replace(']','');
	console.log(formData);
	
	$.ajax({
		type : "post",
		url : "saveOrder.sg",
		contentType : "application/json",
		data : formData,
		success : function(result) {
			$("body").overlayout();
			showAlert('alert-info');
			
			setTimeout(function(){
					gotourl('viewOrder.sg?id=' + result);
					  }, 2000);
		},
		error : function() {
			$("body").overlayout();
			showAlert('alert-danger');
		}
	});
	
}

function validateForm() {
	$custId = $('#customerId').val();
	
	$tot = $('#subTotal').val();
	
	if($custId == undefined || $custId == "" || $custId.length == 0 ) {
		alert('Please Enter the valid Customer Name to proceed .. ');
		return false;
	} else if ($tot == undefined || $tot == "" || $tot.length == 0) {
		alert('Please Enter the valid Order');
		return false;
	}
	return true;
}

(function($) {
	$.extend({
		toDictionary : function(query) {
			var parms = {};
			var items = query.split("&"); // split
			for (var i = 0; i < items.length; i++) {
				var values = items[i].split("=");
				var key = decodeURIComponent(values.shift());
				var value = values.join("=")
				parms[key] = decodeURIComponent(value);
			}
			return (parms);
		}
	})
})(jQuery);

(function($) {
	$.fn.serializeFormJSON = function() {
		var o = [];
		$(this).find('tr').each(
				function() {
					var elements = $(this).find('input, textarea, select');
					//console.log($(this));
					if (elements.size() > 0) {
						var serialized = $(this)
								.find('input, textarea, select').serialize();
						var item = $.toDictionary(serialized);
						o.push(item);
					}
				});
		return o;
	};
})(jQuery);

$.fn.serializeObject = function()
{
   var o = {};
   var a = this.serializeArray();
   $.each(a, function() {
       if (o[this.name]) {
           if (!o[this.name].push) {
               o[this.name] = [o[this.name]];
           }
           o[this.name].push(this.value || '');
       } else {
           o[this.name] = this.value || '';
       }
   });
   return o;
};

var substringMatcher = function(strs) {
	return function findMatches(q, cb) {
		var matches, substringRegex;

		// an array that will be populated with substring matches
		matches = [];

		// regex used to determine if a string contains the substring `q`
		substrRegex = new RegExp(q, 'i');

		// iterate through the pool of strings and for any string that
		// contains the substring `q`, add it to the `matches` array
		$.each(strs, function(i, str) {
			if (substrRegex.test(str)) {
				matches.push(str);
			}
		});

		cb(matches);
	};
};

function calcBalance(val) {
	var total = parseFloat($('#netAmount').val());
	bal = val - total;
	$('#balAmt').html("<span class='bold'>" + bal.toFixed(2) + "</span>");
}

function showAlert(altClass) {
	$('.'+ altClass).fadeIn();
}