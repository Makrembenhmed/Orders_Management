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

		 <div class="text-center m-5">

            <h3>Pictures</h3> 
            <p>detaills of Item : ${thisart.designation}</p>

        </div>

		
		<hr />
		<div class="row">
			<c:forEach items="${pics}" var="pic">
				<div class="col-lg-4 col-md-6 col-12 p-1">
				<div class="card " >
					
					<img src="${pic.img_url}" alt="..." class="card-img-top" height="200" width="100" />
					<div class="card-body">
                      <h5 class="card-title">${pic.article.designation}</h5>
                      <p class="card-text">${pic.description}</p>
                     
                    </div>
					<p></p>
				</div>
				</div>

			</c:forEach>
		</div>



		<div>
			<button class="btn btn-warning m-1">
				<a href="/logout">Quitter</a>
			</button>

		</div>





	</div>
</body>
</html>