$(function() {
	$("#updateMyAccount").click(function(e) {
		e.preventDefault();
		$.ajax({
			type : "POST",
			url : "/my-account",
			contentType : "application/json; charset=utf-8",
			success : function() {
				console.log("success");
			}
		});
	});
});