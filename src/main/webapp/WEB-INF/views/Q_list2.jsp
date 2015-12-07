<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!doctype html>
<html>
<head>
<style>
body {
    background-image: url(./resources/mainimages/mainimege.png);
    background-size: cover;
    background-repeat: no-repeat;
}
</style>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" />
<!--모바일페이지크기조절메타태그-->
<title>Q_list</title>
<SCRIPT LANGUAGE="JavaScript">
	function Check() {
		alert("확인 = " + joinForm.qnum1.value);
			document.joinForm.sam.value = joinForm.qnum1.value;
			document.joinForm.action = 'next_dquest';
		document.joinForm.submit();
	}
	function Check2() {
		alert("확인 = " + joinForm.qnum2.value);
			document.joinForm.sam.value = joinForm.qnum2.value;
			document.joinForm.action = 'next_dquest';
		document.joinForm.submit();
	}
	function Check3() {
		alert("확인 = " + joinForm.qnum3.value);
			document.joinForm.sam.value = joinForm.qnum3.value;
			document.joinForm.action = 'next_dquest';
		document.joinForm.submit();
	}
	function Check4() {
		alert("확인 = " + joinForm.qnum4.value);
			document.joinForm.sam.value = joinForm.qnum4.value;
			document.joinForm.action = 'next_dquest';
		document.joinForm.submit();
	}
	function Check5() {
		alert("확인 = " + joinForm.qnum5.value);
			document.joinForm.sam.value = joinForm.qnum5.value;
			document.joinForm.action = 'next_dquest';
		document.joinForm.submit();
	}
	

</SCRIPT>

</head>
<BODY>
<center>
	<form id="user" Method="post" Name="joinForm"
		action="/doc/checkid?id=1" method="post">

		<input type="hidden" name="sam" id="sam">

		<TABLE border='0'>
			<TR>
				<TD><input id="qnum1" name="qnum1" value="11" type="hidden" />
				<img src="./resources/images/no_2/2-11.png" onclick="Check()"></TD>
			</TR>
		</TABLE>
		<br>
		<TABLE border='0'>
			<TR>
				<TD><input id="qnum2" name="qnum2" value="12" type="hidden" />
				<img src="./resources/images/no_2/2-22.png" onclick="Check2()"/></TD>
			</TR>
		</TABLE>
		<br>
		<TABLE border='0'>
			<TR>
				<TD><input id="qnum3" name="qnum3" value="13" type="hidden" />
				<img src="./resources/images/no_2/2-33.png" onclick="Check3()" /></TD>
			</TR>
		</TABLE>
		<br>
		<TABLE border='0'>
			<TR>
				<TD><input id="qnum4" name="qnum4" value="14" type="hidden" />
				<img src="./resources/images/no_2/2-44.png" onclick="Check4()" /></TD>
			</TR>
		</TABLE>
		<br>
		<TABLE border='0'>
			<TR>
				<TD><input id="qnum5" name="qnum5" value="15" type="hidden" />
				<img src="./resources/images/no_2/2-55.png" onclick="Check5()" /></TD>
			</TR>
		</TABLE>
		<br>
		

	</form>
</center>
</BODY>
</html>