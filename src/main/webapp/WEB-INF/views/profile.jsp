<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Your Profile</h1>
    <c:out value="${sorcerer.username}" /><br/>
    <c:out value="${sorcerer.firstName}" /> <c:out value="${sorcerer.lastName}" /><br/>
    <c:out value="${sorcerer.email}" />
  </body>
</html>
