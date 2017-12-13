<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<script src="${basePath}/static/js/jquery-1.8.3.js" type="text/javascript"></script>
<script src="${basePath}/static/layui/layui.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ajaxError(function(XMLHttpRequest, textStatus, errorThrown){
        alert("操作失败!");
        console.log(textStatus.responseText);
    });
</script>