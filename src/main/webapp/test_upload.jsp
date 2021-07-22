<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 테스트</title>
</head>
<body>
	<h1>파일 업로드</h1>

	<form action="usr/genFile/doUpload" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="attr1" value="값1" />
		<input type="hidden" name="attr2" value="값2" />
		<div>
			<span>파일1</span>
			<input type="file" name="file1" />
		</div>
		<div>
			<span>업로드</span>
			<input type="submit" value="전송" />
		</div>
	</form>
	
	<h1>일반 폼 전송</h1>

	<form action="usr/genFile/doUpload" method="POST">
		<input type="hidden" name="attr1" value="값1" />
		<input type="hidden" name="attr2" value="값2" />
		<div>
			<span>업로드</span>
			<input type="submit" value="전송" />
		</div>
	</form>
</body>
</html>