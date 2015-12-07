<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<head>
	<title>Sorcier</title>
	<link rel="stylesheet" type="text/css" href="<c:url value=" /resources/style.css " />">
</head>

<body>
	<!--div class="spittleForm">
		<h1>Spit it out...</h1>
		<form method="POST" name="spittleForm">
			<input type="hidden" name="latitude">
			<input type="hidden" name="longitude">
			<textarea name="message" cols="80" rows="5"></textarea>
			<br/>
			<input type="submit" value="Add" />
		</form>
	</div-->
	<div class="listTitle">
		<h1>Recent Sorciers</h1>
		<ul class="sorcierList">
			<c:forEach items="${sorcierList}" var="sorcier">
				<li id="spittle_<c:out value=" sorcier.id "/>">
					<div class="sorcierMessage">
						<c:out value="${sorcier.message}" />
					</div>
					<div>
						<span class="sorcierTime"><c:out value="${sorcier.time}" /></span>
						<span class="sorcierLocation">(<c:out value="${sorcier.latitude}" />, <c:out value="${sorcier.longitude}" />)</span>
					</div>
				</li>
			</c:forEach>
		</ul>
		<!--c:if test="${fn:length(spittleList) gt 20}">
			<hr />
			<s:url value="/spittles?count=${nextCount}" var="more_url" />
			<a href="${more_url}">Show more</a>
		</c:if-->
	</div>
</body>

</html>