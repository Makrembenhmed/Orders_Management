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
<h1>List Of Libraries </h1>

<ul>
<c:forEach items="${listlib}" var="onelib">
<li><a href="/librarie/${onelib.id}/show">${onelib.name}</a>  </li>
</c:forEach>
</ul>
</hr>

<form:form action="/libraries" method="post" modelAttribute="Library">
<form:errors style="color:red" path="*"/>
<p>
	<form:label path="name"> name</form:label>
<form:input path="name"/>
</p>
<p>
<form:label path="location"> location</form:label>
<form:input path="location"/> 

</p>
<button>Create</button>
</form:form>


</div>
   
</body>
</html>