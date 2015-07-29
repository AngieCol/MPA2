<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>MOUNTAIN PICK APPLICATION </title>
<link rel="stylesheet" href="<c:url value="/jsp/css/style.css"/>" />
</head>
<body>

<h1>Result Not Found</h1>

<img src="<c:url value="/jsp/images/result error.png" />" alt="" width="50%" height="40%" />



<h3>Sorry, we couldn't find any photo of this mountain </h3>
<h1>${message}</h1> 



<spring:url value="/" var="in"/>
	<form action="${in}" method="post">
		
		
		<input type="submit" value="Return To Home Page"/>
	</form>







<%-- <spring:url value="/MapSearch" var="goToMap"/> --%>
	
	
	
	
</body>
</html>