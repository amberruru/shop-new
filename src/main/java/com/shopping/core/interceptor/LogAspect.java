package com.shopping.core.interceptor;

import com.alibaba.fastjson.JSON;
import com.shopping.core.utils.RequestUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.ObjectUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 日志记录AOP实现
 * Created by ZhangShuzheng on 2017/3/14.
 */
@Aspect
public class LogAspect {

	private static Logger _log = LoggerFactory.getLogger(LogAspect.class);

	// 开始时间
	private long startTime = 0L;
	// 结束时间
	private long endTime = 0L;


	@Before("execution(* com.shopping.*.controller..*.*(..))")
	public void doBeforeInServiceLayer(JoinPoint joinPoint) {
//		_log.debug("doBeforeInServiceLayer");
		startTime = System.currentTimeMillis();
	}

	@After("execution(* com.shopping.*.controller..*.*(..))")
	public void doAfterInServiceLayer(JoinPoint joinPoint) {
		_log.debug("doAfterInServiceLayer");
	}

	@Around("execution(* com.shopping.*.controller..*.*(..))")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		// 获取request
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
		HttpServletRequest request = servletRequestAttributes.getRequest();

		// 从注解中获取操作名称、获取响应结果
		Object result = pjp.proceed();
		Signature signature = pjp.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		if (method.isAnnotationPresent(ApiOperation.class)) {
			ApiOperation log = method.getAnnotation(ApiOperation.class);
			_log.info("执行方法"+log.value());
		}
		endTime = System.currentTimeMillis();
		if (request.getMethod().equalsIgnoreCase("GET")) {
			_log.info("参数"+request.getQueryString());
		} else {
			_log.info("参数"+ObjectUtils.toString(request.getParameterMap()));
		}
		_log.info("结果"+JSON.toJSONString(result));
		_log.info("用时"+(int) (endTime - startTime)+"");
		_log.info("用户："+ObjectUtils.toString(request.getUserPrincipal()));
		return result;
	}

}
