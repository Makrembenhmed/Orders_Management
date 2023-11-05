<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   <div class="container">
   
   
   
	<div class="textcenter"><h3>Edit a Order:</h3></div>

<div class="row">
	<div class="col-6">
	<div class=" login-reg-main border-round give-me-space-up-down">
		
		<form:form action="/edit/${cmd.id }" method="put" modelAttribute="cmd">

			<div class="form-group">
			
				<label>Description:</label>
				<form:textarea row="20" path="description" class="form-control" />
				<form:errors path="description" class="text-danger" />
			</div> <br>

			<div class="form-group">
			
				<label>Date:</label>
				<form:input type="date"  path="datelivcommande"  />
				<form:errors path="datelivcommande" class="text-danger" />
			</div> <br>
			
			
			
			
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