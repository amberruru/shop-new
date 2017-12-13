<%@ include file="/static/common/taglibs.jsp"%>
<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
    <jsp:include page="/static/common/header.jsp"  flush="true"/>
    <script type="text/javascript">
        function goaja() {
            $.ajax({
                url: "${basePath}test",
                type: 'post',
                dataType: 'json',
                success:function(data){
                    alert("成功");
                    console.info(data);
                }
            });
        }
    </script>
</head>
<body>
<h2>Hello World!</h2>
<button onclick="goaja();">aa</button>
</body>
<jsp:include page="/static/common/footer.jsp"  flush="true"/>
</html>
