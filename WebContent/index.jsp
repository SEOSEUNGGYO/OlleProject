<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>


</head>
<body>
<jsp:include page="./navbar.jsp"/>



<div class="container-fluid container py-3">
	<div class="row">
		<div class="col-md-2">        
			<div class="card">
				<div class="card-header">바로가기</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item"><a href="https://www.jejuolle.org/trail/kor/default.asp" target="_blank">공식사이트</a></li>                      
						<li class="list-group-item"><a href="http://kko.to/uFq26fghY" target="_blank">코스정보(카카오맵)</a></li>
						<li class="list-group-item"><a href="https://search.naver.com/search.naver?where=news&sm=tab_jum&query=%EC%A0%9C%EC%A3%BC+%EC%98%AC%EB%A0%88%EA%B8%B8" target="_blank">올레길 뉴스(네이버)</a></li>
					</ul>
				</div>
		</div>

		<div class="col-md-8">
			 <div class="jumbotron">
                  <h1>코스정보</h1>
                  <p>제주올레 공식사이트의 코스별 정보와 사용자들의 코스 평가를 확인할 수 있습니다.</p>
                  <a class="btn btn-success btn-lg" href="olle.jsp">바로가기</a>
              </div>
              <br>
              <div class="jumbotron">
                  <h1>동행정보</h1>
                  <p>코스별 동행 일정을 확인하고 참여할 수 있으며, 직접 동행 일정을 생성할 수 있습니다.</p>
                  <a class="btn btn-success btn-lg" href="accompany.jsp">바로가기</a>
              </div>
              <br>
              <div class="jumbotron">
                  <h1>마이페이지</h1>
                  <p>내 정보, 내 주최 목록, 내 참여 목록 등을 확인할 수 있고 수정할 수 있습니다.</p>
                  <a class="btn btn-success btn-lg" href="myPage.jsp">바로가기</a>
              </div>
        </div>
        <div class="col-md-2">
        <%
        	String user_id = null;
        	if(session.getAttribute("user_id")!=null){
        		user_id = (String) session.getAttribute("user_id");
        	}else{
        %>
			 <form action="loginAction.jsp" method="post">
			 	<div class="row">
			 		<div class="col-12">
			 			<label for="user_id" class="form-label">아이디</label>
			 			<input type="text" class="form-control" id="user_id" name="user_id">
			 		</div>
			 		<div class="col-12">
			 			<label for="user_pw" class="form-label">패스워드</label>
			 			<input type="password" class="form-control" id="user_pw" name="user_pw">
			 		</div>
			 	</div>
			 	<br>
				<button type="submit" class="btn btn-success btn-lg" style="float: right;" >로그인</button>
			 </form>
			 <%} %>
        </div>
	</div>
    </div>
</body>
</html>