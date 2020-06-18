<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>クイズ！！</title>
</head>
<body>
<form action="./JudgeServlet" method="POST">
<% out.print(request.getAttribute("quiz")); %><br />
<% out.print(request.getAttribute("answer")); %><input type="radio" name="answer" value="answer" /><br />
<% out.print(request.getAttribute("miss1")); %><input type="radio" name="answer" value="miss1" /><br />
<% out.print(request.getAttribute("miss2")); %><input type="radio" name="answer" value="miss2" /><br />
<% out.print(request.getAttribute("miss3")); %><input type="radio" name="answer" value="miss3" /><br />
<% out.print(request.getAttribute("hint")); %><br />
<input type="submit" value="回答" />
</form>
</body>
</html>