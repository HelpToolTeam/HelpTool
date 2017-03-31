<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Help text</title>
<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css"> -->
<style>
#d1 {
	float: left;
	height: 180px;
	background-color: rgb(200, 200, 200);
	border: 2px solid #CDCDCD;
	margin-bottom: 5px;
	width: 25%;
}

#d2 {
	float: right;
	height: 180px;
	background-color: rgb(200, 200, 200);
	border: 1px solid #CDCDCD;
	margin-bottom: 5px;
	width: 74%;
}

#idhelpline {
	border: 2px solid;
	padding: 20px;
	height: 120px;
	width: 90%;
	resize: vertical;
	overflow: auto;
}

#idbipSQL {
	float: left;
}

#idbipOracle {
	float: right;
}

</style>

</head>
<body>
	<form:form action="helptext" method="post" modelAttribute="helptext">
		<div id="d1">
			<label>HELPPROG:</label> <br>
			<form:input type="text" path="HELPPROG" />
			<br> <label>HELPITEM:</label> <br>
			<form:input type="text" path="HELPITEM" />
			<br> <label>Number split :</label> <br>
			<form:input type="number" path="SPLIT" min="1" max="60" />
		</div>
		<div id="d2">
			<label>HELPLINE:</label><br>
			<form:textarea id="idhelpline" rows="4" cols="50" path="HELPLINE" />
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<input id="idipSQL" type="submit" value="SQLScript" name="SQLScript">
		<br>
		<input id="idbipOracle" type="submit" value="OracleScript"
			name="OracleScript">
		<br>
		</form:form>
	<%-- <textarea id="idSqlArea" name="SqlArea" form="form">${resultsql}</textarea>
	<textarea id="idOracleArea" name="OracleArea" form="form">${resultoracle}</textarea>
	 --%>
</body>
</html>