<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="./jsp_header.jsp"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" />
<title>유저 등록 완료 화면</title>
</head>
<body>
	<div align="center" class="body">
		<h2>유저 등록 완료 화면</h2>
		<b><font color="red">다음과 같이 유저 등록이 완료되었습니다.</font></b><br>
		
		<form:form modelAttribute="user" Name='joinForm' Method='post' Action='/'> 
			
		<table border='1' cellpadding='0' cellspacing='0'>
			<tr height="40px">
				<td bgcolor='cccccc' width='100' align='center'>E-MAIL:</td>
				<td>${user.m_email}</td>
			</tr>
			<tr height="40px">
				<td bgcolor='cccccc' width='100' align='center'>패스워드:</td>
				<td><input type="password" value="${user.m_password}" readonly='true'></td>
			</tr>
			<tr height="40px">
				<td bgcolor='cccccc' width='100' align='center'>이름:</td>
				<td>${user.m_name}</td>
			</tr>
			<tr height="40px">
				<td bgcolor='cccccc' width='100' align='center'>닉네임:</td>
				<td>${user.m_nic}</td>
			</tr>
		</table>

		<br>
		<p>
		<!-- <ul id="ullog">
			<li id="lilogb"><a href="loginform">로그인</a></li>|
		</ul>
		</p> -->
		 <TABLE>
				<TR>
				<a href="javascript:window.close()">창닫기</A>
					<TD colspan='2' align='center'><input type='submit' value='회원정보로 가기'></TD>
				</TR>
			</TABLE>
		</form:form>
	</div>

</body>
</html>
