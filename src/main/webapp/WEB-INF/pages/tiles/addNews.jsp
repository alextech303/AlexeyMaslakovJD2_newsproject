<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
input[id="title"] {
	width: 75%;
}

input[id="brief"] {
	box-sizing: border-box;
	width: 83%;
	height: 70px;
}

input:invalid {
	border-color: red;
}
</style>


<form name="text" action="controller" method="post">
	
		<legend>Добавление новостей</legend>

		<br />
		<div>
			<label for="title">News Title &emsp;&emsp;</label> <input type="text"
				id="title" name="title" value="">
		</div>
		<br />
		<div>
			<label for="date">News Date &emsp;&emsp;</label> <input type="text"
				name="date"
				pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])"
				title="При внесении даты используйте следующий формат: YYYY-MM-DD"
				value="">
		</div>
		<br> <label for="brief">Brief </label>
		<div>
			
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<textarea rows="6" cols="65" name="brief" value=""></textarea>
		</div>

		 <label for="content">Content </label>
		<div>
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<textarea rows="9" cols="65" name="content" value=""></textarea>
		</div>
 <input	type="hidden" name="command" value="do_add_news" /> </br>
			<input type="submit" value="SAVE">

	
</form>