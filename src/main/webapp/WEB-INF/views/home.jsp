<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Sorcier</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Welcome to Sorcier</h1>

    <a href="<c:url value="/sorciers" />">Spittles</a> | 
    <a href="<c:url value="/sorcier/register" />">Register</a>
  </body>
</html>
