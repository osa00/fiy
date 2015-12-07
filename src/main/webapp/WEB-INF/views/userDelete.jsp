<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./jsp_header.jsp"%>
<HTML>
<HEAD>
<TITLE>회원 탈퇴</TITLE>

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
		if (DeleteForm.m_password.value.length < 1) {
			alert("비밀번호를 입력하세요.");
			DeleteForm.m_password.focus();
			return false;
		}
		
		if (DeleteForm.m_password2.value.length < 1) {
			alert("비밀번호 확인를 입력하세요.");
			DeleteForm.m_password2.focus();
			return false;
		}
		
		if (DeleteForm.m_password.value != DeleteForm.m_password2.value) {
			alert("비밀번호와 비밀번호 확인이 맞지 않습니다.");
			DeleteForm.m_password.focus();
			return false;
		}
		if (DeleteForm.m_password.value != DeleteForm.re_m_password.value) {
			alert("등록된 정보와 맞지 않습니다.");
			DeleteForm.m_password.focus();
			return false;
		}
		
		alert("회원탈퇴 진행중.")
		document.DeleteForm.submit();
	}
	
</SCRIPT>

</HEAD>
<BODY>
	<center>
		<font size='3'><b> 회원탈퇴 </b></font>
		<hr size='1' noshade align="center">
		<spring:hasBindErrors name="user">
			<font color="red"> <c:forEach items="${errors.globalErrors}"
					var="error">
					<spring:message code="${error.code}" />
				</c:forEach>
			</font>
		</spring:hasBindErrors>
		<font color="red">${deleteUser}</font>
		<form:form modelAttribute="user" Name='DeleteForm' Method='post' Action='/fiy/userDelete'>

			<TABLE border='2' cellSpacing=0 cellPadding=5
				align=center>
				<TR>
					<!-- readonly를 사용하여 사용자가 입력하지 못하게하여 해당 아이디를 DB에 저장시킨다 -->
					<TD bgcolor='cccccc' width='100' align='center'><font size='2'>E - M A I L</font></TD>
					<TD bgcolor='cccccc'>
					<form:input path="m_email" maxLength='20' size='10' readonly='true' value="${m_email}" />
					<span class="fieldError">
							<form:errors path="m_email" /></span></TD>
				</TR>
				<TR>
					<TD bgcolor='cccccc' align='center'><font size='2'> 비 밀	번 호 </font></TD>
					<TD bgcolor='cccccc'> 
					<!-- 유저가 입력하는 pass(비밀번호) 값 -->
					<input type="password" id="m_password" name="m_password" maxlength="20" size='10' showPassword="true" />
					<span class="fieldError">
							<form:errors path="m_password" />
					</span>
					<!-- 유저ID를 비교하여 DB에서 해당 유저의 비밀번호를 hidden으로 처리된 칸에 패스를 불러온다 -->
					<input type="hidden" id="re_m_password" name="re_m_password" value="${user.m_password}" maxlength="20"
							size='10' showPassword="true" /> 
					</TD>
				</TR>
				<TR>
					<TD bgcolor='cccccc' align='center'><font size='2'>비밀번호확인</font></TD>
					<TD bgcolor='cccccc'>
					<input type="password" id="m_password2" name="m_password2" maxlength="20" size='10' value="" showPassword="true" />
					<span class="fieldError"><form:errors path="m_password2" /></span></TD>
				</TR>
			</TABLE>
			<hr size='1' noshade align="center">

			<TABLE>
				<TR>
					<TD colspan='2' align='center'>
					<input type='button' value='탈퇴하기' OnClick="Check()">
					</TD>
				</TR>
			</TABLE>

		</form:form>
</BODY>
</HTML>
