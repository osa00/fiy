<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ include file="./jsp_header.jsp"%>
<HTML>
<HEAD>
<TITLE> 비밀번호 찾기 </TITLE> 
<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" />
<style type='text/css'>
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
	<div align="center" class="body">
		<h2>비밀번호 찾기</h2>
		<br>
		${name}님의 비밀번호는 ${findPass.m_password} 입니다.
		<br><br><br>
	<a href="javascript:window.close()">창닫기</A>
	</div>	
	
</body>
</html>
