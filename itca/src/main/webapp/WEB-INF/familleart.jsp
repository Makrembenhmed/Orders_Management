<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tacos</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>



	<div class="container-fluid">
	<div class="row mt-5 ">
	<div class="col-8">
		<h1>All Familles D articles</h1>
	</div>
	<div class="col-4">
		<a href="/logout"  class="btn  btn-danger">LogOut</a>
	</div>
	</div>
		</hr>

		<table class="table table-striped mt-3">
			<thead>
				<tr>
					<td>ID</td>
					<td>Famille d'articles</td>

					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listFam}" var="onefam">
					<tr>
						<td>${onefam.id}</td>
						<td>${onefam.familleart}</td>

						<td><a href="#">Edit</a> /
							<form action="#" method="post">

								<input type="hidden" name="_method" value="delete" /> <input
									type="Submit" value="Delete" /></td>
						</form>
					</tr>


				</c:forEach>
			</tbody>
		</table>
		<br />
		<hr>
		<h3>Ajout de famille Article:</h3>
		<form:form action="/newfamille" method="post" modelAttribute="famille">

			<div class="form-group">
				<label>Famille Article:</label>
				<form:input path="familleart" class="form-control" />
				<form:errors path="familleart" class="text-danger" />
			</div>

			<input type="submit" value="Register" class="btn btn-primary mt-2" />
		</form:form>
</body>
</html>