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
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ITCA </title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
<style >
html {
    position: relative;
    min-height: 100%;
}
 
.footer {
    position: absolute;
    bottom: 0;
    width: 100%;
    height: 60px;
    background: ;
    color: #FFFFFF;
}

</style>

</head>
<body class="bg-image"
	style="background-image: url('https://w.forfun.com/fetch/70/703e3aefd9500eff0f63294bc383ac2a.jpeg'); height: 100vh">
	<!--navbar-->
	<div class="row">
	
		<h3 class="col m-3" style="color: green;">Bonjour et bienvenue ${user_name}</h3>
			<%
	java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
	%>
	
		
		
	</div>


	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand text-warning" href="#">ITCA</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item text-white"><a class="nav-link active text-white"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link active text-white"
						href="/newarticle">Ajouter un Article</a></li>
					<li class="nav-item"><a class="nav-link active text-white"
						href="/newcmd">Commander</a></li>
					<li class="nav-item"><a class="nav-link active text-white"
						href="/pages/1">Pagination</a></li>
					<li class="nav-item"><a class="nav-link active text-white"
						href="/newfamille">Familles Article</a></li>


					<li class="nav-item dropdown "><a
						class="nav-link dropdown-toggle text-white" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Articles </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Papier</a></li>
							<li><a class="dropdown-item" href="#">Fournitures </a></li>
							<li><a class="dropdown-item" href="#">Aiguilles </a></li>
							<li><a class="dropdown-item" href="#">Pieces Pour
									Machines A coudre </a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Autres</a></li>
						</ul>
				</ul>
			</div>
		</div>
		<div>
			<a href="/logout" class="btn btn-danger " style="margin-right: 10px">Quitter</a>
		</div>

	</nav>

<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>
		
		<%=df.format(new java.util.Date())%>
	</h1>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
