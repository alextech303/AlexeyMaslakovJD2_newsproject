<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Registration Page</title>

<style>
#td1 {
	color: rgb(83, 65, 247);
	height: 60px;
	font-weight: 900;
	font-family: 'Times New Roman', Times, serif;
	font-size: x-large;
	padding-left: 100px;
}

#td2 {
	height: 762px;
}

#td3 {
	height: 10px;
	font-weight: 700;
	text-align: center;
}

a {
	font-size: small;
}

pre {
	text-align: end;
	font-family: 'Times New Roman', Times, serif;
	font-weight: 700;
}

#div1 {
	background-color: white;
	float: left;
	width: 300px;
	height: 762px;
	/* outline: 2px solid rgb(236, 22, 22); */
	margin-top: 10px;
}

#div1_1 {
	background-color: rgb(187, 187, 192);
	width: 250px;
	height: 150px;
	/* outline: 2px solid rgb(10, 202, 10); */
	margin-left: 25px;
}

#div2 {
	background-color: white;
	width: 760px;
	height: 762px;
	margin-left: 310px;
	outline: 2px solid rgb(139, 137, 137);
	margin-top: 10px;
	margin-right: 5px;
	margin-bottom: 5px;
}
</style>



</head>
<body>

	<table width="1080px" border="1" align="center" cellspacing="0">

		<tr>
			<td id="td1">News Management&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Create Account	</td>

		</tr>
		<tr>
			<td id="td2">
				<div id="div1">
					<div id="div1_1"></div>
				</div>
				<div id="div2">

					<form name="text" action="controller" method="post" target="_blank">
						<fieldset>
							<legend>Регистрация пользователя</legend>
							<br> <input type="text" name="login" placeholder="Login" value=""><br>
							<br> <input type="password" name="password"
								placeholder="Password" value=""> <br>
							<br> <input type="text" name="email" placeholder="email" value="">
							<br> <input type="hidden" name="command"
								value="do_registration" />
							<!-- <input type="checkbox" value="на сайте"> Оставаться в системе<br> -->
							<br> <br> <input type="submit"
								value="Зарегистрироваться"><br>

						</fieldset>
					</form>



				</div>





			</td>

		</tr>
		<tr>
			<td id="td3">Copyright &copy 2022.All rights reserved.</td>

		</tr>
	</table>

</body>
</html>

<!-- width="100"    cellpadding="50"   -->