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
<script type="text/javascript" >

function take_value(){
	var n =document.forms["myform"]["qte"].value;
	
	alert(n);
}



</script>
<!-- change to match your file/naming structure -->

</head>
<body>

	<div class="container" >
		<div style="background: #ffc107;">
			<h4 class=" m-4 ">Bonjour ${name } veuillez trouver ci apres la
				liste des Articles : merci de passer votre commande</h4>


		</div>

		</hr>
		<a class="btn btn-warning" href="/dashboard"> Retour</a> </br>

		<table class="table table-striped table-dark mt-3 "			>
			<thead >
				<tr>


					<th scope="col">Designation Article</th>
					<th scope="col">Famille Article</th>
				
					<th scope="col" class="text-center">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${articles}" var="onearticle">

					<c:set var="val" value="f" />
					<tr>
						<td><a href="/show/${onearticle.id}">${onearticle.designation}</a></td>
						<td>${onearticle.famillearticle.familleart}</td>
						

						<c:forEach items="${lignescmd}" var="oneligne">

							<c:if test="${oneligne.article.id == onearticle.id }">
								<c:if test="${oneligne.commande.id == numcmd}">

									<c:set var="val" value="y" />
								</c:if>


							</c:if>

						</c:forEach>

						<c:if test="${val eq 'y'}">

							<td class="text-center">



								<form action="/commander/${onearticle.id}/${numcmd}/delete"
									method="post">

									<input type="hidden" name="_method" value="delete" /> <input
										type="Submit" value="Delete" class="btn btn-outline-danger" />

								</form>
							</td>




						</c:if>
						<c:if test="${val != 'y'}">

							<td class="text-center"><form:form
									action="/commander/${onearticle.id}/${numcmd}" method="post">
									<input type="submit" value="Commander"
										class="btn btn-success text-center" />
								</form:form></td>

						</c:if>

					</tr>
				</c:forEach>

			</tbody>
		</table>
<div class="fixed">
	
		<c:if test="${lignescmd != null }">
			<div class="card text-dark bg-info mb-3 center"
				style="max-width: 50rem;">
				<div class="card-header">Nouvelle Commande</div>
				<div class="card-body">

					<ul class="mt-5">
						<c:forEach items="${lignescmd}" var="oneligne">

							<c:if test="${oneligne.commande.id eq numcmd }">

								<li style="color: Blue;" class="row mt-3">
									<div class="col">${oneligne.article.designation }</div>
									<div class="col">
									<form name="myform">
									
									Quantiter : <input type="number" name=""  >
									
									<input type ="button" value = "valider" onclick="return take_value()">
									
									</form>
										
									</div>

								</li>

							</c:if>
						</c:forEach>
					</ul>
				</div>

			</div>
		</c:if>
		</div>
		
		</div>
</body>
</html>