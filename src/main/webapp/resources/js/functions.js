function gotourl(url) {
	location.href = url;
}

function getProductPrice(prodId, idx) {
	var holder = '.unitCost'+idx;	
	$(holder).html('<span>Loading ...</span>');
	
	$.ajax({
		   url: 'getProductPrice.sg',
		   data: "prodId=" + prodId,
		   success: function(response) {
			   $('.unitCost'+idx).html('<span>' + response + '</span>');			 
		   },
		   error : function(e) {  
		      alert('Error in Processing your request : Pls try again' + e);   
		     }  
		});
}

var totalAmt = 0;
function calcItemTotal(quantity, idx) {
	var subTotal;
	if (quantity != "" && quantity.length != 0) {
		subTotal = (quantity * parseFloat($('.unitCost'+idx).text()));
		var oldVal  =  $('.amount'+idx).val();
		
		$('.amount'+idx).val(subTotal);
		totalAmt = totalAmt - oldVal + subTotal;
		
		$('#totalAmt').val(totalAmt);
	}
}

function lessDiscount(val) {
	var total = $('#totalAmt').val();
	var lessDiscount = total - (total * val /100);
	$("#amtlessDisc").val(lessDiscount);
}

function popupPrint(orderId) {
	window.open('printOrder.sg?id=' + orderId, 'View Order', 'menubar=no,height=400,width=450');
}