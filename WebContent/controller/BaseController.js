function addAccount() {
	var search= window.location.search; 
	//var projectId = search.substring(1);
    var formUrl = $("#addAccount").attr("action");
    var email = $("#email")[0].value;
    var pwd = $("#pwd")[0].value;
    
    var data = { 
	            name : email,
	            email : email,
	            password : pwd
			}
    
    
	$.ajax({
	    url: "accounts",
	    type: "POST",
	    contentType: "application/json;charset=UTF-8",
	    data: JSON.stringify(data)
//	})
//	.success(function(data) {
//		//window.location.replace("Details.html"+'?'+ projectId);
//	})
//	.fail(function(data) {
//	    $("#register_form").attr("action", "index.html");
//	})
//	.always(function() {
//                $("#addAccount").submit();
    });
}
    function isPasswordValid(password) {
        var confirmPassword = $("#conf_pwd")[0].value;
        if (password == "" || confirmPassword == "") {
            alert("Please fill both fields for password and try again.");
            return false;
        }
        if (password != confirmPassword) {
            alert("Two passwords do not match. Please correct the values and try again.");
            return false;
        }
        return true;
    }