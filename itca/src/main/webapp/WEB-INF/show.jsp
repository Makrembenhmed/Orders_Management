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
		<div>
			bonjour cher client :
			<p style="color: blue;">${thiscmd.acheteur.userName }</p>
		</div>
		<br />
		<h3>votre commande continet ces articles :</h3>
		<p>${thiscmd.description}</p>

		<p>
			datee le :
			<fmt:formatDate value="${thiscmd.datelivcommande }"
				pattern="dd-MM-yyy" />
		</p>

		<hr />


		<div>
			<button class="btn btn-warning m-1">
				<a href="/logout">Quitter</a>
			</button>
			<a href="/edit/${thiscmd.id}"  class="btn btn-primary m-1"> Edit Commande </a> 
		</div>





	</div>
</body>
</html>