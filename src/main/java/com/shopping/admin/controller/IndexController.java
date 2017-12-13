package com.shopping.admin.controller;

import com.shopping.core.base.AjaxJson;
import com.shopping.core.base.BaseController;
import com.shopping.entity.User;
import com.shopping.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhaokai on 2017/11/30.
 */
@Controller
public class IndexController extends BaseController{

	private static Logger _log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private IUserService userService;

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody()
	@ApiOperation("日志测试")
    public Object test(HttpServletRequest request, HttpServletResponse response){
		AjaxJson ajaxJson = new AjaxJson();
		List<User> list = userService.test();
    	ajaxJson.success("success");
    	return ajaxJson;
    }
}
