function addItem() {
	var formUrl = $("#addItem").attr("action");
	var info = $("#item_info")[0].value;
	var value = $("#item_value")[0].value;
	var type = $("#item_type_selection")[0].value;

	var data = {
		bugetItem : {
			name : info,
			value : value,
			type : type
		}
	}

	$.ajax({
		url : 'user/vboi4eva/addProject',
		type : "POST",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify(data)
	}).success(function(data) {
		$("#register_form").attr("action", "MyProjects.html");
	}).fail(function(data) {
		$("#register_form").attr("action", "MyProjects.html");
	}).always(function() {
		$("#addProject").submit();
	});
}

$(document).ready(function() {

	var table = $("#ProjectsTable");
	$.ajax({
		url : "accounts/2/tables/personal",
		type : "GET",
		dataType : "json",
		success : function(data) {
			renderTable(data.project, table);
		}
	});
	

	function renderTable(data, table) {

		var tableThings = data.length;
		for (var i = 0; i < tableThings; i++) {
			renderRow(data[i], table);
		}
	}
	function renderRow(rowData, table) {
		var row = $("<tr />");
		table.append(row);
		row.append($("<td>" + rowData.id + "</td>"));
		row.append($("<td>" + rowData.topic + "</td>"));
		row.append($("<td>" + rowData.description + "</td>"));
		row.append($("<td>" + rowData.status + "</td>"));
		// if (isUserAuthenticated && rowData.amount > 0) {
		var detailsTd = $("<td />");
		var link = $("<button>details</button>");
		detailsTd.append(link);
		row.append(detailsTd);
		link.click(function() {
			window.location.replace("Details.html" + '?' + rowData.id);
			// window.location.search= rowData.id;
		});
		// link.click(function() {
		// $.ajax({
		// url: 'user',
		// type: "PUT",
		// dataType: "json",
		// success: alert("wooho")
		// });
		// });

	}

	function getPersonalItems() {


	}

});