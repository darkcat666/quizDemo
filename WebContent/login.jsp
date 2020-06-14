<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<%
String user = (String) session.getAttribute("user");
String isLogin = (String) session.getAttribute("isLogin");

if (isLogin != null) {
	if (isLogin.equals("true")){
		if ((user != null) && (isLogin.equals("true"))) {
			out.print("ユーザー名：" + user + "さん");
		}
	} else {
		out.print("初めまして！ゲストさん");
	}
} else {
	out.print("初めまして！ゲストさん");
}
%>
	<form action="../test666/LoginServlet" method="POST">
		ユーザー名：<input type="text" value="" name="user" />
		<br />
		パスワード：<input type="text" value="" name="password" />
		<hr />
		<input type="submit" value="ログイン" />
	</form>
</body>
</html>