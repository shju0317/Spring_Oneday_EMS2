<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Spring Framework~!!</title>
</head>
<body>
<h3>Helloooooooooooooo :)</h3>
<form method="POST">
	<div>
		<label>보내는 Email</label>
		<input name="from_email"/>
	</div>
	<div>
		<label>받는 Email</label>
		<input name="to_email"/>
	</div>
	<div>
		<label>보내는 날짜</label>
		<input name="s_date"/>
	</div>
	<div>
		<label>보내는 시각</label>
		<input name="s_time"/>
	</div>
	<div>
		<label>제목</label>
		<input name="s_subject"/>
	</div>
	<div>
		<label>내용</label>
		<textarea name="s_content"></textarea>
	</div>
	<div>
		<label>첨부파일</label>
		<input name="file1"/>
		<input name="file2"/>
	</div>
	<div>
		<button>저장</button>
	</div>
</form>
</body>
</html>