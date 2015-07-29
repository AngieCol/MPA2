<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Lista Mountains</title>
<link rel="stylesheet" href="jsp/css/style.css">
</head>
<body>




	
	<spring:url value="/MapSearchInternal" var="map" />
	
	<form method="post" action="${map} ">
		

		<div class="resultTable">

			<c:forEach items="${mountains}" var="mediaIterator">
				<div class="resultPhoto">
					
					<input type="radio" name="name" value="${mediaIterator.mountain.name}" />${mediaIterator.mountain.name}


				</div>
			</c:forEach>
		</div>
		 <input type="submit"
			value="Go To Map" />
	</form>
	
	
	<spring:url value="/" var="in"/>
	<form action="${in}" method="post">
		<input type="submit" value="Return To Home Page"/>
	</form>
	<!-- 	</form> -->

	<%-- <spring:url value="/" var="in" />
	<form action="${in}" method="post">
	<input type="submit" value="Save Media" />
		<input type="submit" value="Return To Home Page" />
	</form> --%>

</body>
</html>