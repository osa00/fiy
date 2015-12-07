<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./jsp_header.jsp"%>
<html>
<head>
<title>Home</title>
<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" />
<style type='text/css'>
<!--
a:link {
	font-family: "";
	color: black;
	text-decoration: none;
}

a:visited {
	font-family: "";
	color: black;
	text-decoration: none;
}

a:hover {
	font-family: "";
	color: black;
	text-decoration: underline;
}

html, body {
	width: 100%;
	height: 100%;
	margin: 0px;
	padding: 0px;
}

#box {
	width: 100%;
	height: auto;
	border: 2px solid black;
	border-collapse: collapse;
	text-align: left;
}

#box tr {
	border: 1px solid gray;
	background-color: #ffcccc;
}

#box td {
	border: 1px solid gray;
}
-->
</style>
</head>
<body>
<center>
		<h2>----- 회원 DB 데이터 ----</h2>
	<form:form name="sampleVo" method="post">
		<input type="hidden" name="sampleNo" />
		<table border="1">
				<tr>
					<td>회원번호</td>
					<td>이메일</td>
					<td>이름</td>
					<td>비밀번호</td>
				</tr>
				<c:forEach var="result" items="${list}" varStatus="status">
					<tr>
						<td>${result.m_no}</td>
						<td>${result.m_email}</td>
						<td>${result.m_name}</td>
						<td>${result.m_password}</td>
					</tr>
				</c:forEach>
		</table>
	</form:form>
	</center>

</body>
</html>
