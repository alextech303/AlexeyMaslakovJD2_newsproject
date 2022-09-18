<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="body-title">
	
</div>

<form action="command.do?method=delete" method="post">
	<c:forEach var="news" items="${requestScope.news}">
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
				<div class="news-title">
					<c:out value="${news.title}" />
				</div>
				<div class="news-date">
					<c:out value="${news.date}" />
				</div>

				<div class="news-content">
					<c:out value="${news.brief}" />
				</div>
			</div>
		</div>

	</c:forEach>

	<div class="no-news">
		<c:if test="${requestScope.news eq null}">
       <div >
       
        
      <p><img src="images/news2.jpg " width=700px height=370px></p> 
      
      
       </div> 
	</c:if>
	</div>

</form>
