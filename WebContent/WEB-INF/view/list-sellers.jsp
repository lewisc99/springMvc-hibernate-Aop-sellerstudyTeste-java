<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>List of Sellers</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
	<header>
		<div id="header">
			<h2>Seller relationship Manager</h2>
		</div>
	</header>
	<div class="container">
		<div class="row">
			<div class="col">
			
			<input type="button" value="Add Customer"
        onclick="window.location.href='showFormForAdd';return false;"
        class="btn btn-primary"/> 

			
			<br><br>
			
				<table class="table table-hover table-striped">
					<thead class="table-dark">
						<tr>
							<th>Name</th>
							<th>Email</th>
							<th>Birth Date</th>
							<th>Base Salary</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tempSeller" items="${sellers}">
							<tr>
							<td>${tempSeller.name }</td>
							<td>${tempSeller.email}</td>
							<td>${tempSeller.birthDate}</td>
							<td>${tempSeller.baseSalary}</td>
							<td><a href="showFormForUpdate?id=${tempSeller.id }">Update</a>|
							<a href="delete?id=${tempSeller.id}"
							onclick="if (!(confirm('Are your sure you want to delete this customer?'))) return false">Delete</a></td>
							</tr>
							</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>