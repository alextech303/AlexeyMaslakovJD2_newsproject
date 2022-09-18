<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:if test="${requestScope.presentation eq 'newsList' }">
	<c:import url="/WEB-INF/pages/tiles/newsList.jsp" />
</c:if>


<c:if test="${requestScope.presentation eq 'viewNews' }">
	<c:import url="/WEB-INF/pages/tiles/viewNews.jsp" />
</c:if>

<c:if test="${sessionScope.manager eq 'addNewsTrue' }">
<%System.out.println("body -  addNewsTrue ");%>
	<c:out value="Новость добавлена"  />
</c:if>

<c:if test="${requestScope.manager eq 'addingNews' }">
<%System.out.println("body - import addNews ");%>
	<c:import url="/WEB-INF/pages/tiles/addNews.jsp" />
</c:if>

<c:if test="${requestScope.role eq 'manager' }">
<%System.out.println("body - Welcome manager ");%>
	<h2  align="center">Welcome Manager!!!</h2>
	<img src="images/redaktorNews.jpg" width=650px height=370px>
</c:if>

