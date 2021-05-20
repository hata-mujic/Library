<%@ include file="main-page.jsp"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>

<script type="text/javascript">
	let newFirstName = '<div class="inputForm"><input type="text" name="firstName" placeholder="Author FirstName"><input type="text" name="lastName" placeholder="Author LastName"><input type="text" name="aboutAuthor" placeholder="About Author"><button class="removeButton">Remove</button></div>';

	$(document).ready(function() {
		$('.add').click(function() {
			$('.newDiv').append(newFirstName);
		});

		$('.save').click(function() {
			$('.form').attr("action", "tamo");
		});

	});

	$(document).on('click', '.removeButton', function() {
		$(this).closest('.inputForm').remove();
	});
</script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-left">
			<form action="addBook" method="post" id="form">
				<div>
					<input type="text" name="bookName" placeholder="Book's Name">
					<input type="text" name="bookUrl" placeholder="Book's Url" required>
					<input type="text" name="aboutBook" placeholder="About Book">

					<div class="inputForm">
						<input type="text" name="firstName" placeholder="Author FirstName">
						<input type="text" name="lastName" placeholder="Author LastName">
						<input type="text" name="aboutAuthor" placeholder="About Author">
					</div>

					<div class="newDiv"></div>
				</div>
				<button type="submit" class="btn btn-primary">Save</button>
			</form>
			<button class="add">Add</button>
		</div>
	</div>
</body>
</html>