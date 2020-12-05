<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>My AngularJS App</title>
  <base href="/">
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
<%--   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app2.css"> --%>
  <link	href="${pageContext.request.contextPath}/css/bootstrap.min.css"	rel="stylesheet">
  <link	href="${pageContext.request.contextPath}/css/animations.css"	rel="stylesheet">
</head>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/js/angular.ng-modules.js"></script> --%>
<script src="${pageContext.request.contextPath}/js/angular-route.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/js/angular-ui-router.min.js"></script> --%>
<script src="${pageContext.request.contextPath}/js/angular-animate.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"></script>
<script src="${pageContext.request.contextPath}/js/angularjs/controllers/myAppController.js"></script>
<script src="${pageContext.request.contextPath}/js/angularjs/services/myAppService.js"></script>

<body  ng-app="myApp" ng-controller="myAppController" >
  
<div class="pageContent">
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
<ul class="navbar-nav">
    <li class="nav-item active"><a href="#" class="nav-link">DashBoard</a></li>
    <li class="nav-item"><a href="/addPen" class="nav-link">Add Pen</a></li>
    <li class="nav-item"><a href="/addAnimal" class="nav-link">Add Animal</a></li>
  </ul>
</nav>
<div><h1>Animal List( Count :: ${animalCount})</h1></div>
  <hr>
<div class="row form-group" style="font-size: 20px;font-weight: 600;">
  	<div class="col-sm-2">Name</div>
  	<div class="col-sm-2">Pen Name</div>
  	<div class="col-sm-2">Species</div>
  	<div class="col-sm-2">Special Attribute</div>
  	<div class="col-sm-2 align-items-center">Action</div>
  </div>
  <hr>
  <c:forEach  var="animal" items="${animals}">
  <div class="row form-group">
  	<div class="col-sm-2">${animal.name}</div>
  	<div class="col-sm-2">${animal.pen.penName}</div>
  	<div class="col-sm-2">${animal.pen.penType}</div>
  	<div class="col-sm-2">
  	<c:choose>
	  	<c:when test="${animal.pen.penType=='Bird'}">
			${animal.fly} 
	  	</c:when>
	  	<c:when test="${animal.pen.penType=='Mammal'}">
	  	${animal.suckle}
	  	</c:when>
	  	<c:when test="${animal.pen.penType=='Reptile'}">
	  	${animal.crawl}
	  	</c:when>
	  	<c:otherwise>Nothing Special</c:otherwise>
  	</c:choose>
  		
  	</div>
  	<div class="col-sm-2">
  		<a href="/EditAnimal?id=${animal.ID}"><input type="button" name="Action" value="Edit" class="btn btn-success"></a>
  		<a href="/DeleteAnimal?id=${animal.ID}"><input type="button" name="Action" value="Delete" class="btn btn-danger"></a>
  	</div>
  </div>
  
  </c:forEach>
  
 </div>
</body>
</html>
