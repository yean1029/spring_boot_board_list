<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
ul{
 margin-left: 230px;
}
h2{
	margin-bottom: 20px; 
	margin-top: 20px;
}



</style>
</head>
<body>
	<div class="container">
		<h2>MVC_BOARD</h2>
	
		<table class="table table-bordered" >
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<c:forEach items="${list}" var="dto">
			<tbody>
				<tr>
					<td>${dto.bId}</td>
					<td>${dto.bName}</td>
					<td><c:forEach begin="1" end="${dto.bIndent}">-[RE]</c:forEach>
					<a href="content_view?bId=${dto.bId}">${dto.bTitle}</a></td>
					<td>${dto.bDae}</td>
					<td>${dto.bHit}</td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
		<button type="button" class="btn btn-info" onclick="location.href='write_view'">글작성</button>
		
	 <ul id="ul" class="pagination">	
	 <c:if test="${page.prev}">
		 <li class="page-item"><a class="page-link" href="list${page.makeQuery(page.startPage - 1)}">Prev</a></li>
      </c:if>

      <c:forEach begin="${page.startPage}" end="${page.endPage}" var="idx">
       <li class="page-item "><a class="page-link" href="list${page.makeQuery(idx)}">${idx}</a></li>
      </c:forEach>
      
      <c:if test="${page.next && page.endPage > 0}">
         <li class="page-item"><a class="page-link" href="list${page.makeQuery(page.endPage +1) }">Next</a></li>
      </c:if>
      </ul>
	</div>
</body>
</html>