<%--
  User: zhaokai
  Date: 2017/12/4
  Time: 14:05
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>后台登录</title>
    <jsp:include page="/static/common/header.jsp"/>
    <link rel="stylesheet" href="${basePath}/static/css/login.css">
</head>
<body>
    <div class="layui-carousel video_mask" id="login_carousel" >
        <div carousel-item>
            <div class="carousel_div1"></div>
            <div class="carousel_div2"></div>
            <div class="carousel_div3"></div>
        </div>
        <div class="login layui-anim layui-anim-up">
            <h1>管理后台</h1></p>
            <form class="layui-form" action="" method="post">
                <div class="layui-form-item">
                    <input type="text" name="username" lay-verify="required" placeholder="请输入账号" autocomplete="off"  value="" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <input type="password" name="password" lay-verify="required" placeholder="请输入密码" autocomplete="off" value="" class="layui-input">
                </div>
                <div class="layui-form-item form_code">
                    <input class="layui-input" name="code" placeholder="验证码" lay-verify="required" type="text" autocomplete="off">
                    <div class="code"><img src="${basePath}/getCode" width="116" height="36"></div>
                </div>

                <button class="layui-btn login_btn" lay-submit="" lay-filter="login">登陆系统</button>
            </form>
        </div>
    </div>
</body>
</html>
<jsp:include page="/static/common/footer.jsp"/>
<script>
    layui.config({
        base : "static/"
    }).use(['form','layer','jquery','carousel', 'element'], function () {
        var $ = layui.jquery,
            form = layui.form,
            carousel = layui.carousel;

        /**背景图片轮播*/
        carousel.render({
            elem: '#login_carousel',
            width: '100%',
            height: '100%',
            interval:8000,
            arrow: 'none',
            anim: 'updown',
            indicator:'none'
        });

        function refeshCode() {
            var url = "${basePath}/getCode?nocache=" + new Date().getTime()
            $('.code img').attr("src",url)
        }

        /**点击验证码重新生成*/
        $('.code img').on('click', function () {
            refeshCode();
        });

        /**监听登陆提交*/
        form.on('submit(login)', function (data) {
            //弹出loading
            var loginLoading = top.layer.msg('登陆中，请稍候', {icon: 16, time: false, shade: 0.8});
            //记录ajax请求返回值
            var ajaxReturnData;

            //登陆验证
            $.ajax({
                url: '${basePath}/loginCheck',
                type: 'post',
                async: false,
                data: data.field,
                success: function (data) {
                    ajaxReturnData = data;
                }
            });
            //登陆成功
            if (ajaxReturnData.code == 0) {
                window.location.href="/main/index.do";
                top.layer.close(loginLoading);
                return false;
            } else {
                top.layer.close(loginLoading);
                refeshCode();
                return false;
            }
        });

    });
</script>