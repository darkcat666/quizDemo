<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="./isChecked.js"></script>
<meta charset="UTF-8">
<title>クイズ！！</title>
</head>
<body>
<form action="./JudgeServlet" method="POST" name="form1">
<% out.print(request.getAttribute("quiz")); %><br />
<% out.print(request.getAttribute("answer")); %><input type="radio" name="answer" onclick="isCheckedRadio();" value="answer" /><br />
<% out.print(request.getAttribute("miss1")); %><input type="radio" name="answer" onclick="isCheckedRadio();" value="miss1" /><br />
<% out.print(request.getAttribute("miss2")); %><input type="radio" name="answer" onclick="isCheckedRadio();" value="miss2" /><br />
<% out.print(request.getAttribute("miss3")); %><input type="radio" name="answer" onclick="isCheckedRadio();" value="miss3" /><br />
<% out.print(request.getAttribute("hint")); %><br />
<input id="checkAns" type="submit" value="回答" disabled="true" />
</form>
</body>
</html>