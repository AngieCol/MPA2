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

<h1>WELCOME TO THE MOUNTAIN PICK APPLICATION</h1>

<img src="<c:url value="/jsp/images/volcan_nevado_del_ruiz.jpg" />" alt="mountaingImage" width="70%" height="50%" />



<h3>Please select if you want to do a search of photos in the social networks or in the local database</h3>


<h4>Please introduce the name of a mountain that you want to search.</h4>

<spring:url value="/ResultExternalSearch" var="resExtSearch"/>
	<form action="${resExtSearch}" method="post">
		keyword:    <input type="text" name="name"/>	<br/>
		
		<input type="submit" value="Search"/>
	</form>



<spring:url value="/MapSearch" var="map"/>
	<form action="${map}" method="post">
	<input type="submit" value="Go to Map"/>
	</form>



<%-- <spring:url value="/MapSearch" var="goToMap"/> --%>
	
	
	
	
</body>
</html>