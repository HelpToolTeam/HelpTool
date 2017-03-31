<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
		#idSqlArea {
		float: left;
		height:1280px;
	    width: 49%;
	    background-color:rgb(200,150,200);
	}
		#idOracleArea {
		float: right;
		height: 1280px;
	    width: 49%;
	    background-color:rgb(200,150,200);
	}
	#p1{
		float: left;
	}
	#p2{
		float: right;
	}
	
</style>
</head>
<body>
	<p id="p1">SQLscript</p>
	<p id="p2">ORACLEscript</p>
	<br><br><br>
	<textarea id = "idSqlArea" name="SqlArea">${resultsql}</textarea>
	<textarea id = "idOracleArea"name="OracleArea">${resultoracle}</textarea>
</body>
</html>