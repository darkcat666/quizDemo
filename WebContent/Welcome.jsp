<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ようこそ画面</title>
</head>
<body>
<form action="../test666/LogoutServlet" method="POST">
<% String name = (String)session.getAttribute("user"); %>
<p>ようこそ<%= name %>さん！</p>
<p><input type="submit" value="ログアウト" /></p>
</form>
<form action="../test666/QuizServlet" method="POST">
<input type="submit" value="クイズをやる？？" />
</form>
</body>
</html>