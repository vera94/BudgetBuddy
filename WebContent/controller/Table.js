function filter() {
	// Declare variables
	var input, filter, table, tr, td, i;
	input = document.getElementById("filterValue");
	filter = input.value.toUpperCase();
	table = document.getElementById("PersonalBudgetTable");
	tr = table.getElementsByTagName("tr");

	// Loop through all table rows, and hide those who don't match the search
	// query
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[1];
		if (td) {
			if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}

function addItem(event) {
	var tableid = this.window.model.id;
	var search = window.location.search;
	var taskId = document.getElementById("item_infoid03");
	var formUrl = $("#addItem").attr("action");
	var info = $("#item_info")[0].value;
	var value = $("#item_value")[0].value;
	var type = $("#item_type_selection")[0].value;

	var data = {
		"name" : info,
		"value" : Number(value),
		"type" : type
	}

	$
			.ajax(
					{
						url : "http://localhost:8080/BudgetBuddy/items/"
								+ tableid + "/add",
						type : "POST",
						contentType : "application/json",
						data : JSON.stringify(data)
					})
			.success(
					function(data) {
						$("#addItem")
								.attr("action",
										"http://localhost:8080/BudgetBuddy/view/PersonalTable.html");
					}).fail(function(data) {
				// $("#register_form").attr("action",
				// "http://localhost:8080/BudgetBuddy/view/PersonalTable.html");
			}).always(function() {
				$("#addItem").submit();
			});
}

$(document).ready(
		function() {
			var that = this;
			var thiswindow = window;
			var table = $("#PersonalBudgetTable");
			$.ajax({
				url : "http://localhost:8080/BudgetBuddy/tables/personal",
				type : "GET",
				dataType : "json",
				success : function(data) {
					thiswindow.model = data;
					renderTable(data.items, table);
				}
			});

			function renderTable(data, table) {

				var tableThings = data.length;
				for (var i = 0; i < tableThings; i++) {
					renderRow(data[i], table);
				}
			}
			function renderRow(rowData, table) {
				var tableId = this.window.model.id;
				var row = $("<tr />");
				table.append(row);
				row.append($("<td>" + rowData.id + "</td>"));
				row.append($("<td>" + rowData.name + "</td>"));
				row.append($("<td>" + rowData.value + "</td>"));
				row.append($("<td>" + rowData.type + "</td>"));
				// if (isUserAuthenticated && rowData.amount > 0) {
				var detailsTd = $("<td />");
				var link = $("<button>remove</button>");
				detailsTd.append(link);
				row.append(detailsTd);

				link.click(function() {
					$.ajax({
						url : "http://localhost:8080/BudgetBuddy/items/"
								+ tableId + "/delete/" + rowData.id,
						type : "DELETE",
						success : function(data) {
							window.location.reload();
							//("http://localhost:8080/BudgetBuddy/view/PersonalTable.html");
							alert("Item deleted successfuly");
						}
					});
				});

			}

			function getPersonalItems() {

			}

		});