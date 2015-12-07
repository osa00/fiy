<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./jsp_header.jsp"%>
<HTML>
<HEAD>

<TITLE>^^</TITLE>

<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" />
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
<SCRIPT LANGUAGE="JavaScript">
	function Check() {

		if (joinForm.answer.value.length < 1) {
			alert("문제의 답을 입력하세요.");
			joinForm.answer.focus();
			return false;
		}
		
		if (joinForm.answer.value.length != joinForm.re_answer.value.length)
		{
			alert("답이 맞지 않습니다ㅠㅠ..")
			joinForm.answer.focus();
			return false;
		}
		
		alert("답을 채점중 입니다.");
		document.joinForm.m_no.value = joinForm.m_no.value;
		alert("포인트 1점을 획득하셨습니다.");
		document.joinForm.submit();
	}
</SCRIPT>
</head>
<body>
	<center>
	
	
		<form:form modelAttribute="user" Name='joinForm' Method='post' Action='quest_event'>
			<TABLE border='0' cellSpacing=0 cellPadding=5 align=center>
				<TR>
					<TD bgcolor='#3399FF' align='center'>
					<font size='2'><h2>문제</h2> </font></TD>
					<TD>
						${q_name}
					</TD>
				</TR>
				<TR>
					<TD bgcolor='#0066CC' align='center'>
					<font size='2'><h2>답</h2></font>
					<input type="hidden" id="re_answer" name="re_answer" value="${q_answer}">
					</TD>
					<TD>
					<input type='text' maxlength='50' size='20' id='answer' name='answer' path='answer' /></TD>
				</TR>
			</TABLE>

			<hr size='1' noshade align="center">

			<TABLE>
				<TR>
					<TD colspan='2' align='center'>
					<input type='button' value='확인하기' OnClick="Check()">
					<input type="reset" value="초기화">
					<input type="hidden" path="m_no" id="m_no" name="m_no" value='101'/>
					</TD>
				</TR>
			</TABLE>
		</form:form>
	</center>

</body>
</html>