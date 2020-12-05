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
  

<!--   <div ng-repeat="animal in animals"> {{animal.name}} </div> -->
<div class="pageContent">
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
<ul class="navbar-nav">
    <li class="nav-item"><a href="/Dashboard" class="nav-link">DashBoard</a></li>
    <li class="nav-item active"><a href="#" class="nav-link">Add Pen</a></li>
    <li class="nav-item"><a href="/addAnimal" class="nav-link">Add Animal</a></li>
  </ul>
</nav>
<div><h1>Pen List</h1></div>
  <hr>
<div class="row form-group" style="font-size: 20px;font-weight: 600;">
  	<div class="col-sm-2">Pen Name</div>
  	<div class="col-sm-2">Pen Type</div>
  	<div class="col-sm-2">Action</div>
  </div>
  <hr>
  <c:forEach  var="pen" items="${pens}">
  <div class="row form-group">
  	<div class="col-sm-2">${pen.penName}</div>
  	<div class="col-sm-2">${pen.penType}</div>
  	<div class="col-sm-2"><input type="button" name="Action" value="Edit" class="btn btn-danger"></div>
  </div>
  </c:forEach>
  <hr>
  <h1>Add Pens</h1>
  <hr>
  <form:form action="${pageContext.request.contextPath}/savePen" id="savePen" modelAttribute="pen"  method="post">
  	<div class="row form-group">
		<div class="col-sm-3">Pen Name</div>
		<div class="col-sm-3">
				<form:input path="penName" class="form-control" title="Pen Name" required="true" maxlength="50"/>
		</div>
	</div>	
	<div class="row form-group">
		<div class="col-sm-3">Pen Type</div>
		<div class="col-sm-3">
			<form:select path="penType" class="form-control" title="Please Select Pen Type" required="true">
				<form:option value="">Select Pen Type</form:option>
				<c:forEach var="pen" items="${penMap}">
					<form:option value="${pen.key}">${pen.value}</form:option>
				</c:forEach>
			</form:select>
		</div>
	</div>	
	<div class="row form-group">
	<div class="col-sm-3"></div>
		<div class="col-sm-3">
			<input type="submit" name="savepen" value="Save" class="btn btn-success">
		</div>
	</div>		
  </form:form>
 </div>

</body>
</html>