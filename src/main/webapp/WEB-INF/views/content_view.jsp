<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body >
<form action="modify" method="post">
<div class="container mt-3" >
  <div class="row" >
     <div class="col-sm-7">
	<input type="hidden" name="bId" value="${content_view.bId}">
	 <table class="table">
  	  <thead>
         <tr class="table-light">
        <th colspan="3"><h5 class="text-center text-dark"><게시판 조회></h5></th>
	</tr>
	 </thead>
    <tbody>
      <tr>
        <td>번호</td>
        <td colspan="3">${content_view.bId}</td>
      </tr>
      <tr>
        <td>히트</td>
		<td>${content_view.bHit}</td>
      </tr>
      <tr>
     	 <td>이름</td>
			<td><input type="text" class="form-control" name="bName" value="${content_view.bName}"></td>
      </tr>
		<tr>
			<td>제목</td>
			<td><input type="text" class="form-control" name="bTitle" value="${content_view.bTitle}"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="5" class="form-control" name="bContent">${content_view.bContent}</textarea></td>
		</tr>	
		 
		<tr><td class="text-center" colspan="3">
		<button type="submit" class="btn btn-outline-info" >&nbsp;수정&nbsp;</button> &nbsp;&nbsp;
		<button type="button" class="btn btn-outline-info" onclick="location.href='list'">&nbsp;목록&nbsp;</button>&nbsp;&nbsp;
		<button type="button" class="btn btn-outline-danger" onclick="location.href='delete?bId=${content_view.bId}'">&nbsp;삭제&nbsp;</button>&nbsp;&nbsp;
		<button type="button" class="btn btn-outline-info" onclick="location.href='reply_view?bId=${content_view.bId}'">&nbsp;답변&nbsp;</button>    
    </tbody>
  </table>
</div>
	
</div></div>
	</form>
</body>
</html>