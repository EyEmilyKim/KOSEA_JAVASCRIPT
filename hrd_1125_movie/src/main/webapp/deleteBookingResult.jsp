<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String rslt = request.getParameter("R");
	if(rslt.equals("OK")){
%>
	<script type="text/javascript">
		alert("예매 정보가 삭제되었습니다.");
	</script>
<%
	}else {
%>
	<script type="text/javascript">
		alert("예매 정보가 삭제되지 않았습니다. 관리자에게 문의해주세요.");
	</script>
<%
	}
%>
</body>
<script type="text/javascript">
	location.href = "listBooking.do"
</script>
</body>
</html>