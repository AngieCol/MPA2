<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>index-1</title>
</head>
<body>



<spring:url value="/flickr" var="flickrHome"/>
	<form action="${flickrHome}" method="post">
		keyword:    <input type="text" name="name"/>	<br/>
		
		<input type="submit" value="Search"/>
	</form>
</body>




comidaaaaa
  	<spring:url value="/twitter" var="home">
		
	</spring:url>
	<a href="${home}"> click</a>


	
	
	<spring:url value="/panoramio" var="panoramioHome">
		
	</spring:url>
	<a href="${panoramioHome}"> panoramio</a>
	
	
	<spring:url value="/showMountain" var="showMountainView">
		
	</spring:url>
	<a href="${showMountainView}"> mountain</a>
	
	
	
</body>
</html>