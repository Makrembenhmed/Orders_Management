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
    <title>books All</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <div class="container-fluid">
   <h1>All Books </h1>
   <a href="/logout">LogOut</a>
   
   </hr>
   <table class="table table-striped">
   <thead >
   <tr>
   <td>ID</td>
   <td>Title</td>
   <td>Author</td>
   <td>Number Of Pages</td>
   <td>Library</td>
   
   <td>Action</td>
   </tr>
   </thead>
   <tbody>
   <c:forEach items="${allbooks}" var="onebook">
   <tr>
   <td>${onebook.id}</td>
   <td>${onebook.title}</td>
   <td>${onebook.author.userName}</td>
   <td>${onebook.pages}</td>
   <td> ${onebook.library.name}</td>
   <td><a href="/edit/${onebook.id}">Edit</a> /
   <form action="/books/${onebook.id}" method="post">
   
   <input type="hidden" name="_method" value="delete" />
   <input type="Submit" value="Delete" />
   </td>
   </form>
   </tr>
   
   
   
   
   </c:forEach>
   
   </tbody>
   </table>
   </hr>
   <h1> New Book   </h1>
   
   
<form:form action="/books" method="post" modelAttribute="book">
    <p>
        
      title:  <form:input path="title"/> 
           <form:errors path="title"/></br>
    </p>
    
    
    <p>
           
       pages: <form:input type="number" path="pages"/> 
       <form:errors path="pages"/></br>
       
    </p> 
    
    <p>
        
       <form:select path="library">
       
       
       <c:forEach items="${listoflib }" var="lib">
       <form:option value="${lib.id }">
       ${lib.name }
       </form:option>
       
       </c:forEach>
       
            <form:errors path="Author"/></br>
    </p>
       
       </form:select> 
     <p>  
    <button>Create</button>
    </p>
</form:form>    
   </div>
</body> 
</html>