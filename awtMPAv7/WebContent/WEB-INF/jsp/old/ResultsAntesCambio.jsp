<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Results of the Search</title>
<link rel="stylesheet" href="jsp/css/style.css">
</head>
<body>




	<h2>
		<!-- 		These are the photos of <span style="color: #5935FF"font-weight:bold; font-style:italic;"> -->
		${name} taken from social networks (${isIndb}):
	</h2>

	<spring:url value="/MapSearch" var="map" />
	
	<form method="post" action="${map} ">
		<input type="hidden" name="name" value="${name}" />

		<div class="resultTable">

			<c:forEach items="${listaMedias}" var="mediaIterator">
				<div class="resultPhoto">
					<img class="img" src="${mediaIterator.url }"/>
					<input type="checkbox" name="selected" value="${mediaIterator}" />
					<input type="hidden" name="titles" value="${mediaIterator.title}" />
					<input type="hidden" name="urls" value="${mediaIterator.url}" />
				</div>
			</c:forEach>
		</div>
		<input type="submit" value="Save Media" /> <input type="submit"
			value="Return To Home Page" />
	</form>
	<!-- 	</form> -->

	<%-- <spring:url value="/" var="in" />
	<form action="${in}" method="post">
	<input type="submit" value="Save Media" />
		<input type="submit" value="Return To Home Page" />
	</form> --%>

</body>
</html>