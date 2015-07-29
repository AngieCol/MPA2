<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Results of the Search</title>
<%-- <link rel="stylesheet" href="<c:url value="/jsp/css/style.css"/>" /> --%>
</head>
<body>



	
	<h2>
<!-- 		These are the photos of <span style="color: #5935FF"font-weight:bold; font-style:italic;"> -->
			${name} </span> taken from social networks (${isIndb}):
	</h2>

<spring:url value="/MapSearch" var="map" />
<%-- 	<form action="${map}" method="post"> --%>
	<form method="post" action="${map} ">
		<input type="hidden" name="name" value="${name}">
		

		<c:forEach items="${listaMedias}" var="mediaIterator">



			<input type="checkbox" name="selected[]" value="${mediaIterator}"> Title: ${mediaIterator.title}  
<img src=${mediaIterator.url } width="200" height="200">
			<br>
			<br>
			<br>

		</c:forEach>
		
	<input type="submit" value="Save Media" />
	</form>
		
		




		
<!-- 	</form> -->

	<spring:url value="/" var="in" />
	<form action="${in}" method="post">


		<input type="submit" value="Return To Home Page" />
	</form>

</body>
</html>