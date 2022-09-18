<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="menu-wrapper">
	<div class="menu-title-wrapper">
		<div class="menu-title">
			<c:if test="${requestScope.role eq 'manager'}">
				<p>
					<strong>Manager menu</strong>
				<p>
			</c:if>

			<c:if test="${sessionScope.role eq 'user'}">
				<p>
					<strong>News</strong>
				<p>
			</c:if>

		</div>
	</div>

	<div class="list-menu-invisible-wrapper">
		<div class="list-menu-wrapper" style="float: right;">
			<ul style="list-style-image: url(images/img.jpg); text-align: left;">


				<li style="padding-left: 15px;">
				
				
				
			<form action="controller" method="post">
							<input type="hidden" name="command" value="go_to_news_list" /> <input
								type="submit" value="news list" />

						</form> <br />


				</li>

				<c:if test="${requestScope.role eq 'manager'}">

					<li style="padding-left: 15px;">
						<form action="controller" method="post">
							<input type="hidden" name="command" value="go_to_add_newspage" /> <input
								type="submit" value="add news" />

						</form> <br />
					<li style="padding-left: 15px;"><a href="">remove news </a> <br />
					</li>
				</c:if>


				<c:if test="${requestScope.manager eq 'addingNews'}">

					<li style="padding-left: 15px;">
						<form action="controller" method="post">
							<input type="hidden" name="command" value="go_to_manager_page" />

							<input type="submit" value="back page" />

						</form>
				</c:if>


			</ul>
		</div>
		<div class="clear"></div>
	</div>
	<!--  grey free space at the bottom of menu -->
	<div style="height: 25px;"></div>
</div>

