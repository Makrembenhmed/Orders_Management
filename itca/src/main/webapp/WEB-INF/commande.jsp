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
<div class="container">
	<!--navbar-->
	<div>
		<h5 style="color: grey;">Bonjour et bienvenue ${user_name} vous
			trouverez la liste de vos commandes et vous pouvez creer Nouvelle
			Commande</h5>
	</div>

	<hr>
	
	<table class="table table-striped m-3">
		<thead>
			<tr>
				<th>ID</th>
				<th>Liste des articles commander</th>
				<th>date liv souhaiter</th>

				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${commandes}" var="onecommande">
			<c:if test="${onecommande.acheteur.id eq user_id }">
				<tr>
					<td>${onecommande.id}</td>
					<td><a href="/commande/show/${onecommande.id}">${onecommande.description}</a></td>


					<td><fmt:formatDate value="${onecommande.datelivcommande}"
							pattern="yyyy-MM-dd" /></td>

					
					<td>
					<div class="row">
					<a href="/edit/${onecommande.id}"
						class="col-4 btn btn-outline-secondary">Edit</a> 
						<form class="col-6" action="/delete/${onecommande.id}" method="post">

							<input type="hidden" name="_method" value="delete" /> <input
								type="Submit" value="Delete" class="btn btn-outline-danger" />
					</form>
					</div> 
					</td>
					
				</tr>


			</c:if>

			</c:forEach>

		</tbody>
	</table>
	
	
	<div class="textcenter"><h3>Create a Order:</h3></div>

<div class="row">
	<div class="col-6 h100">
	<div class=" login-reg-main border-round give-me-space-up-down">
		
		<form:form action="/newcommande" method="post" modelAttribute="newcmd">

			<div class="form-group">
			
				<label>Description:</label>
				<form:textarea row="40" path="description" class="form-control" />
				<form:errors path="description" class="text-danger" />
			</div> <br>

			<div class="form-group">
				<form:label cssClass="control-label" path="datelivcommande"> Date liv demander:</form:label>
				<div class="controls">
					<input type="date" path="datelivcommande" class="date"
						name="datelivcommande"
						value="<fmt:formatDate value="${cForm.datelivcommande }" pattern="dd-mm-yyyy" />" />
				</div>
			</div>

			<br>
			<div>
				<button class="btn btn-warning m-1"> <a href="/logout">Concel</a></button>
				<input type="submit" value="Register" class="btn btn-primary m-1" />
			</div>

		</form:form>

	</div>
	</div>
</div>
</div>
</body>
</html>