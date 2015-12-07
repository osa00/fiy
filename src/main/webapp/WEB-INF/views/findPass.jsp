<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./jsp_header.jsp"%>
<HTML>
<HEAD>
<TITLE>비밀번호 찾기</TITLE>
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
<SCRIPT LANGUAGE="JavaScript">
	function Check() {
		alert("Check()스크립트 시작");
		
		if (findPassForm.m_email.value.length < 1) {
			alert("E-Mail를 입력하세요.");
			findPassForm.m_email.focus();
			return false;
		}

		if (findPassForm.m_name.value.length < 1) {
			alert("이름을 입력하세요.");
			findPassForm.m_name.focus();
			return false;
		}

		alert("진행중!!")
		document.findPassForm.submit();
	}
	
</SCRIPT>

</head>

<body>
	<center>
		<font size='3'><b> 비밀번호 찾기 </b></font>
		<TABLE border='0' cellpadding='0' cellspacing='0'>
			<TR>
				<TD><hr size='1' noshade></TD>
			</TR>
		</TABLE>
		<spring:hasBindErrors name="user">
			<font color="red"><c:forEach items="${errors.globalErrors}"
					var="error">
					<spring:message code="${error.code}" />
				</c:forEach> </font>
		</spring:hasBindErrors>
		<form:form modelAttribute="user" Name='findPassForm' Method='post'
			Action='findPass'>

			<TABLE border='2' cellSpacing=0 cellPadding=5
				align=center>

				<TR>
					<TD bgcolor='cccccc' align='center'><font size='2'>E - M a i l</font></TD>
						<TD bgcolor='cccccc'>
							<form:input type='text' maxlength='50' size='20' path='m_email' />
							<span class="fieldError">
						<form:errors path="m_email" />
						</span>
					</TD>
				</TR>

				<TR>
					<TD bgcolor='cccccc' align='center'>
						<font size='2'>이 름</font>
					</TD>
					<TD bgcolor='cccccc'>
						<form:input path="m_name" maxlength="20" cssClass="m_name" size='10' />
							<span class="fieldError">
						<form:errors path="m_name" />
							</span>
					</TD>
				</TR>
			</TABLE>

			<TABLE border='0' width='600' cellpadding='0' cellspacing='0'>
				<TR>
					<TD><hr size='1' noshade></TD>
				</TR>
			</TABLE>

			<TABLE>
				<TR>
					<TD colspan='2' align='center'>
					<input type='button' value='찾기' OnClick="Check()">
                    <input type="reset"  value="초기화">
					</TD>
				</TR>
			</TABLE>

		</form:form>
</body>
</html>
