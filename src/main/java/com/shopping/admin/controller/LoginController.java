package com.shopping.admin.controller;

import com.alibaba.fastjson.JSON;
import com.shopping.core.base.AjaxJson;
import com.shopping.core.base.BaseController;
import com.shopping.core.utils.CreateImageCode;
import com.shopping.core.utils.IpInfoUtil;
import com.shopping.core.utils.MD5Util;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by zhaokai on 2017/12/4.
 */
@Controller
public class LoginController extends BaseController {

    private Logger log = LoggerFactory.getLogger(LoginController.class);

    /**
     * 生成验证码
     */
    @RequestMapping("/getCode")
    public void Captcha(HttpServletResponse response, HttpSession session)throws IOException {
        CreateImageCode vCode = new CreateImageCode(116,36,5,10);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
    }

    /**
     *  登录验证处理
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping("/loginCheck")
    @ResponseBody
    @ApiOperation("后台登录验证")
    public AjaxJson loginCheck(String username, String password, String code, HttpServletRequest request){
        AjaxJson ajaxJson = new AjaxJson();
        try {
            //1.用户名不能为空
            if (StringUtils.isEmpty(username)) {
                log.info("登陆验证失败,原因:用户名不能为空");
                ajaxJson.fail("用户名不能为空");
                return ajaxJson;
            }
            //2.密码不能为空
            if (StringUtils.isEmpty(password)) {
                log.info("登陆验证失败,原因:密码不能为空");
                ajaxJson.fail("密码不能为空");
                return ajaxJson;
            }
            //3.验证码不能为空
            if (StringUtils.isEmpty(code)) {
                log.info("登陆验证失败,原因:验证码不能为空");
                ajaxJson.fail("验证码不能为空");
                return ajaxJson;
            }
            //4.验证码输入错误
            String sessionCode = (String) request.getSession().getAttribute("code");
            if(!code.toLowerCase().equals(sessionCode)) {
                log.info("登陆验证失败,原因:验证码错误：code:"+code+",sessionCode:"+sessionCode);
                ajaxJson.fail("验证码错误");
                return ajaxJson;
            }

            UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Util.getMD5(password));
            token.setRememberMe(true);
            Subject currentUser = SecurityUtils.getSubject();

            currentUser.login(token);
            if (currentUser.isAuthenticated()) {
                ajaxJson.success("登录成功");
                return ajaxJson;
            }
            ajaxJson.fail("用户名或密码不匹配");
            return ajaxJson;
        } catch (IncorrectCredentialsException ice) {
            log.info("登陆验证失败,原因:用户名或密码不匹配");
            ajaxJson.fail("用户名或密码不匹配");
            return ajaxJson;
        }catch (AccountException e){
            log.info("登陆验证失败,原因:用户名或密码不匹配");
            ajaxJson.fail("用户名或密码不匹配");
            return ajaxJson;
        }catch (Exception e) {
            log.error("登陆验证失败,原因:系统登陆异常", e.getLocalizedMessage());
            ajaxJson.fail("系统登陆异常");
            return ajaxJson;
        }
    }
}
