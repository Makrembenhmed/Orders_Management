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

	
			<div class="form-row mt-5 card ">
				<form:form action="/editarticle/${article.id}" method="put"
					modelAttribute="article">

					<div class="form-group col-md-6">
						<label>Designation Article</label>
						<form:input path="designation" type="text" class="form-control" />
						<form:errors path="designation" class="text-danger" />

					</div>

					<div class="form-group col-md-6">
						<label>Quantity</label>
						<form:input path="quantity" type="number" class="form-control" />
						<form:errors path="quantity" class="text-danger" />
					</div>

					<div class="form-group col-md-6">
						<label>Price :</label>
						<form:input path="price" type="number" step="0.01"
							class="form-control" />
						<form:errors path="price" class="text-danger" />
					</div>


				 	<div class="form-group col-md-6">
						<label>Famille Article</label>
						<form:select path="famillearticle" class="form-select">
							  

							<c:forEach items="${familles }" var="onefamille">
								<form:option value="${onefamille.id }">${onefamille.familleart }</form:option>
							</c:forEach>
							<form:errors path="famillearticle" />
							<br>
						</form:select>
					</div>   
					<button class="btn btn-outline-secondary" type="submit">Submit</button>

					<!-- <div class="form-group">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" id="gridCheck">
      <label class="form-check-label" for="gridCheck">
        Check me out
      </label>
    </div>
  </div>
  <button type="submit" class="btn btn-primary">Sign in</button>  -->
  
				</form:form>
			</div>
			</div>
			
   
</body>
</html>