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
    <li class="nav-item"><a href="/addPen" class="nav-link">Add Pen</a></li>
    <li class="nav-item active"><a href="#" class="nav-link">Add Animal</a></li>
  </ul>
</nav>
<div><h1>Add Animal</h1></div>
  <hr>
<form:form action="${pageContext.request.contextPath}/saveAnimal" id="saveanimal" modelAttribute="animal"  method="post">
  	<div class="row form-group">
		<div class="col-sm-3">Animal Name</div>
		<div class="col-sm-3">
				<form:input path="name" class="form-control" title="Animal Name" required="true" maxlength="50"/>
		</div>
	</div>	
	<div class="row form-group">
		<div class="col-sm-3">Pen Name</div>
		<div class="col-sm-3">
				<form:select path="penName" class="form-control" title="Please Select Pen Name" required="true">
					<form:option value="">Select Pen Name</form:option>
					<c:forEach var="pen" items="${penNameMap}">
						<form:option value="${pen.key}">${pen.value}</form:option>
					</c:forEach>
				</form:select>
		</div>
	</div>
	<div class="row form-group">
		<div class="col-sm-3">Animal Type</div>
		<div class="col-sm-3">
				<form:select path="penType" class="form-control" title="Please Select Animal Type" required="true">
					<form:option value="">Select Animal Type</form:option>
					<c:forEach var="pen" items="${animalMap}">
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
