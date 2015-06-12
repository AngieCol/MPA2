
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Panoramio</title>
</head>
<body>


<c:forEach items="${listaUrlsPanoramio}" var="listaUrlsPanoramio">     
		<img src=${listaUrlsPanoramio} width="200" height="200"><p></p> 
</c:forEach>


</body>
</html>