$(function() {
	$("#placeOrder-btn").click(function(e) {
		e.preventDefault();
		$.ajax({
			type : "POST",
			url : "/placeOrder",
			contentType : "application/json; charset=utf-8",
			success : function() {
			}
		});
	});
	$(".btn-remove-shopping-cart").click(function(e) {
		e.preventDefault();
		var self = $(this);
		var productId = self.attr("productId");
		$.ajax({
			type : "DELETE",
			url : "/shopping-cart/" + productId,
			contentType : "application/json; charset=utf-8",
			success : function() {
				location.reload();
			}
		});
	});
});