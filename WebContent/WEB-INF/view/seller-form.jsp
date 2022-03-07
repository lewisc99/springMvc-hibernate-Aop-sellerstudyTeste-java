<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Seller Form</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg">
				<header>
					<h2>CRM - Customer Relationship Manager</h2>
				</header>
				<h3>Save Seller</h3>
				<form:form action="saveSeller" modelAttribute="seller" method="POST">
					<form:hidden path="id" />
					<table>
						<tbody>
							<tr>
								<td><form:label path="name">Name: </form:label></td>
								<td><form:input path="name" class="form-control" /></td>
							</tr>
							<tr>
								<td><form:label path="email">Email: </form:label></td>
								<td><form:input path="email" type="email"
										class="form-control" /></td>
							</tr>
							<tr>
								<td><form:label path="birthDate">birth Date: </form:label></td>
								<td><form:input path="birthDate" class="form-control" /></td>
							</tr>
							<tr>
								<td><form:label path="baseSalary">base Salary: </form:label></td>
								<td><form:input path="baseSalary" class="form-control" /></td>
							</tr>
							<!--  <tr>
								<td><form:label path="DepartmentId">Department Id: </form:label></td>
								<td><form:input path="DepartmentId" class="form-control" /></td>
							</tr> -->
							<tr>
								<td><form:label path="DepartmentId">Department: </form:label></td>
								<td><select name="DepartmentId" class="form-select">
										<c:forEach var="dep" items="${Dep}">
											<option path="DepartmentId" value="${dep.id}">${dep.name}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td><label></label>
								<td><input type="submit" value="Save"
									class="btn btn-success" />
							</tr>
						</tbody>
					</table>
				</form:form>
				<div class="md-3">
					<p>
						<a href="${pageContext.request.contextPath }/seller/list">Back
							to list</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>