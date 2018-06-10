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
});