<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
   
<fmt:setLocale value="${SessionScope.local }"/>
<fmt:setBundle basename="localization.local" var="loc"/>
<fmt:message bundle="${loc}" key="local.loc.welcome" var="welcome" />



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="script/validation.js"></script>
<title>News Management </title>


<link rel="stylesheet" type="text/css" href="styles/newsStyle.css">

</head>
<body>
	<div class="page">
		<div class="header">
		
			<c:import url="/WEB-INF/pages/tiles/header.jsp" />
			

					
		</div>

		<div class="base-layout-wrapper">
			<div class="menu">

				<c:if test="${not (sessionScope.user eq 'active')}">
				<center><h1>${welcome}</h1></center>
				   <!-- <c:out value="${message}" /> --> 
					<%-- <c:import url=""></c:import> --%>
				</c:if>
				
				<c:if test="${sessionScope.user eq 'manager'}">
				
					<c:import url="/WEB-INF/pages/tiles/menu.jsp" />
					 
				</c:if>
				
				
				<c:if test="${sessionScope.user eq 'active'}">
					<c:import url="/WEB-INF/pages/tiles/menu.jsp" />
				</c:if>
				
				
			</div>

			<div class="content">

				<c:if test="${not (sessionScope.user eq 'active')}">
					<c:import url="/WEB-INF/pages/tiles/guestInfo.jsp" />
					<%System.out.println("class content import guestInfo");%>
				</c:if>
				<c:if test="${sessionScope.user eq 'active'}">
				
					<c:import url="/WEB-INF/pages/tiles/body.jsp" />
					<%System.out.println("class content import body");%>
				</c:if>


			</div>
		</div>

		<div class="footer">

			<c:import url="/WEB-INF/pages/tiles/footer.jsp" />
		</div>
	</div>
</body>
</html>