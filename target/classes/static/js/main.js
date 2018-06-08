$(function() {
    $(".add-to-car").click(function(e) {
    	console.log("clicked3")
        e.preventDefault();
        var self = $(this);
        $.ajax({
            url: "/cart",
            type: "POST",
            data: self.attr("productId"),
            contentType: "application/json; charset=utf-8",
            success: function() {
            	console.log("response success")
            }
        });
    });
});