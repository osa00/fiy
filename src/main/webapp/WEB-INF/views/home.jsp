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
		<h1>Hello world!</h1>

		<P>The time on the server is ${serverTime}.</P>
		<a href="/fiy/userEntryForm.do">회원가입 페이지</a></br>
		<a href="/fiy/findPassform.do">비밀전호 찾기 페이지</a></br>
		<a href="/fiy/userEditForm.do">회원 수정페이지 페이지</a>
		</br>/주소뒤에 ?m_email=email(email=해당 사용자 이메일)을 입력하면 강제 이동가능</br>
		<a href="/fiy/userDeleteForm.do">회원탈퇴 페이지</a>
		</br>/주소뒤에 ?m_email=email(email=해당 사용자 이메일)을 입력하면 강제 이동가능</br>
		<a href="/fiy/questForm.do">문제 이벤트폼</a><br>
		<a href="/fiy/questlistForm1.do">스토리 1</a>
		<a href="/fiy/questlistForm2.do">스토리 2</a>
		<a href="/fiy/questlistForm3.do">스토리 3</a>
		<a href="/fiy/questlistForm4.do">스토리 4</a>
		<a href="/fiy/questlistForm5.do">스토리 5</a>
		<a href="/fiy/questlistForm6.do">스토리 6</a>
		<iframe src="/fiy/list"  width="100%" height="100%"
   frameborder="0" scrolling="no" name="link">
</iframe>

				
		</center>
</body>
</html>
