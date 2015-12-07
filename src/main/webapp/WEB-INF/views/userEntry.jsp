<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="./jsp_header.jsp"%>
<HTML>
<HEAD>
<TITLE>회원 등록</TITLE>

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
		
		if (joinForm.m_email.value.length < 1) {
			alert("E-Mail를 입력하세요.");
			joinForm.m_email.focus();
			return false;
		}
		
		if (joinForm.m_password.value.length < 1) {
			alert("비밀번호를 입력하세요.");
			joinForm.m_password.focus();
			return false;
		}
		
		if (joinForm.m_password2.value.length < 1) {
			alert("비밀번호 확인를 입력하세요.");
			joinForm.m_password2.focus();
			return false;
		}
		
		if (joinForm.m_password.value != joinForm.m_password2.value) {
			alert("비밀번호와 비밀번호 확인이 맞지 않습니다.");
			joinForm.m_password.focus();
			return false;
		}
		
		if (joinForm.m_name.value.length < 1) {
			alert("이름을 입력하세요.");
			joinForm.m_name.focus();
			return false;
		}
		
		if (joinForm.m_nic.value.length < 1) {
			alert("닉네임을 입력하세요.");
			joinForm.m_name.focus();
			return false;
		}
		
		if (joinForm.m_email.value != joinForm.re_email.value){
			alert("이메일 중복확인을 해주세요.")
			joinForm.re_email.focus();
			return false;
		}
		

		alert("정상적으로 회원 가입이 완료 되었습니다!!")
		document.joinForm.submit();
	}

	function Check_email() {
		
		if (joinForm.m_email.value.length < 1) {
			alert("이메일 입력하세요.");
			joinForm.m_email.focus();
			return false;
		}
		
		location.href = "checkemailBean?m_email="+document.joinForm.m_email.value;
	}
	
</SCRIPT>

</HEAD>
<BODY>
	<center>
		<font size='3'><b> ${idcheck}회원정보 등록 </b></font>
		<hr size='1' noshade align="center">
		<spring:hasBindErrors name="user">
			<font color="red"> <c:forEach items="${errors.globalErrors}" var="error">
 	 					<spring:message code="${error.code}" />
								</c:forEach>
			</font>
		</spring:hasBindErrors>
		
		<form:form modelAttribute="user" Name='joinForm' Method='post' Action='userEntry'>

			<TABLE border='2' cellSpacing=0 cellPadding=5
				align=center>
                				<TR>
					<TD bgcolor='cccccc' align='center'><font size='2'>E - M a i l</font></TD>
					<TD bgcolor='cccccc'>
					<form:input type='text' maxlength='50' size='20' path='m_email' value='${check}' />
					<input type='button' OnClick='Check_email()' value='중복검사'>
					<span class="fieldError">
					<form:errors path="m_email" />
					</span>
					<input type="hidden" name="re_email" value='${check}'>
					</br>
					<font color="red">${msg}</font> 
					</TD>
				</TR>
				<TR>
					<TD bgcolor='cccccc' align='center'><font size='2'> 비 밀	번 호 </font></TD>
					<TD bgcolor='cccccc'><form:password id="m_password" name="m_password" path="m_password" maxlength="20" size='10' showPassword="true" />
					<span class="fieldError">
							<form:errors path="m_password" />
					</span></TD>
				</TR>
				<TR>
					<TD bgcolor='cccccc' align='center'><font size='2'>비밀번호확인</font></TD>
					<TD bgcolor='cccccc'><form:password id="m_pass2" name="m_password2" path="m_password2"
							maxlength="20" size='10' value="${user.m_password}" showPassword="true" />
						<span class="fieldError"><form:errors path="m_password2" /></span></TD>
				</TR>
				<TR>
					<TD bgcolor='cccccc' align='center'><font size='2'>이 름</font></TD>
					<TD bgcolor='cccccc'><form:input path="m_name" maxlength="20"	size='10' />
					<span class="fieldError"><form:errors path="m_name" /></span></TD>
				</TR>
                <TR>
					<TD bgcolor='cccccc' align='center'><font size='2'>닉 네 임</font></TD>
					<TD bgcolor='cccccc'><form:input path="m_nic" maxlength="20"	size='10' />
					<span class="fieldError"><form:errors path="m_nic" /></span></TD>
				</TR>
			</TABLE>
			<hr size='1' noshade align="center">

			<TABLE>
				<TR>
					<TD colspan='2' align='center'>
					<input type='button' value='등록' OnClick="Check()">
                    <input type="reset"  value="초기화">
					</TD>
				</TR>
			</TABLE>

		</form:form>
</BODY>
</HTML>