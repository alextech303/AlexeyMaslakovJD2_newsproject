<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="wrapper">
	<div class="newstitle">News management</div>


	<div class="local-link">

		<div align="right"></div>

		<c:if test="${not (sessionScope.user eq 'active')}">

			<div align="right">



				<form action="controller" method="post">

					<input type="hidden" name="command" value="do_sign_in" /> Enter
					login: <input type="text" name="login" value="" /><br /> Enter
					password: <input type="password" name="password" value="" /><br />



					<c:if test="${not (requestScope.AuthenticationError eq null)}">
						<font color="red"> <c:out
								value="${requestScope.AuthenticationError}" />
						</font>
					</c:if>

					<input type="submit" value="Sign In" /><br />
				</form>

				<form action="controller" method="post">

					<input type="hidden" name="command" value="go_to_registration_page" />



					<input type="submit" value="Create Account" /><br />
			  	</form>

				<!--<form action="Controller" method="post">
					<input type="hidden" name="local" value="en" /> <input
						type="submit" value="${en_button}" /><br />
				</form>-->

			</div>

		</c:if>

		<c:if test="${sessionScope.user eq 'active'}">

			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_out" /> 
					<input type="hidden" name="login" value = "${sessionScope.login}" />
						<input type="submit" value="Sign Out" /><br />
				</form>
			</div>

		</c:if>
		
		<c:if test="${sessionScope.user eq 'manager'}">

			<div align="right">
			
			</div>
			
			<div align="left">
			
		
			</div>

		</c:if>
		
	</div>

</div>
