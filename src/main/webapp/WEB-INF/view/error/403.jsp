
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="403"/></title>
</head>
<body>
<% Exception e = (Exception)request.getAttribute("ex"); %>
<h2>错误: <%= e.getClass().getSimpleName()%></h2>
<hr />
<h5>错误描述：</h5>
<%= e.getMessage()%>
</body>
</html>