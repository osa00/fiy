<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" />
<style type='text/css'>

@import url(http://fonts.googleapis.com/earlyaccess/alefhebrew.css);

body {
    background-image: url(./resources/mainimages/mainimege.png);
    background-size: cover;
    background-repeat: no-repeat;
}

h2 {
	font-family : "Nanum Gothic";
	font-size: 16px;
	color: #CCC;
}
h1 {
	font-family : 'Nanum Gothic';
	font-size : 12px;
}
<!--
	a:link		{font-family:"";color:black;text-decoration:none;}
	a:visited	{font-family:"";color:black;text-decoration:none;}
	a:hover		{font-family:"";color:black;text-decoration:underline;}
	html, body { width:100%; height:100%;  margin:0px; padding:0px; }
#box { width:100%; height:auto; border:2px solid black; border-collapse:collapse; text-align:left; }
#box tr { border:1px solid gray; background-color:#ffcccc; }
#box td { border:1px solid gray; }
-->
</style>
</head>
<body>
<center>

<c:choose>
<c:when test="${q_no==11}">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<img src="./resources/images/no_1/1-11.png">
</c:when>
<c:when test="${q_no==12}">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<img src="./resources/images/no_1/1-22.png">
</c:when>
<c:when test="${q_no==13}">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<img src="./resources/images/no_1/1-33.png">
</c:when>
<c:when test="${q_no==14}">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<img src="./resources/images/no_1/1-44.png">
</c:when>
<c:when test="${q_no==15}">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<img src="./resources/images/no_1/1-55.png">
</c:when>
<c:otherwise>
조건이 만족하지 않았을 경우 출력될 내용
</c:otherwise>
</c:choose>


	<TABLE border='0' cellSpacing=0 cellPadding=5 align=center>
		<tr>
			<td bgcolor='#3399FF'><h2>one</h2></td>
			<td><h1>${hint1}</h1></td>
		</tr>
		<tr>
			<td bgcolor='#0066CC'><h2>two</h2></td>
			<td><h1>${hint2}</h1></td>
		</tr>
		<tr>
			<td bgcolor='#006699'><h2>three</h2></td>
			<td><h1>${hint3}<h1></td>
		</tr>
	</TABLE>
</center>


</body>
</html>