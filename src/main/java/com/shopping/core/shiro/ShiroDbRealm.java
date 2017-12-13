package com.shopping.core.shiro;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shopping.entity.User;
import com.shopping.service.IUserService;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.roles;


/**
 * @description：shiro权限认证
 * @author：zhixuan.wang
 * @date：2015/10/1 14:51
 */
public class ShiroDbRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroDbRealm.class);

    @Autowired private IUserService userService;
//    @Autowired private IRoleService roleService;

//    public ShiroDbRealm(CacheManager cacheManager, CredentialsMatcher matcher) {
//        super(cacheManager, matcher);
//    }
    
    /**
     * Shiro登录认证(原理：用户提交 用户名和密码
     * --- shiro 封装令牌
     * ---- realm 通过用户名将密码查询返回
     * ---- shiro 自动去比较查询出密码和用户输入密码是否一致
     * ---- 进行登陆控制 )
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        LOGGER.info("Shiro开始登录认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String password = new String((char[]) token.getPassword());
        String username = token.getUsername();
        EntityWrapper<User> ew = new EntityWrapper<User>();
        ew.eq("userName",username);
        List<User> list = userService.selectList(ew);
        // 账号不存在
        if (list == null || list.isEmpty()) {
            return null;
        }
        User user = list.get(0);

        return new SimpleAuthenticationInfo(username, password, getName());

        // 账号未启用
//        if (user.getStatus() == 1) {
//            return null;
//        }
        // 读取用户的url和角色
//        Map<String, Set<String>> resourceMap = roleService.selectResourceMapByUserId(user.getId());
//        Set<String> urls = resourceMap.get("urls");
//        Set<String> roles = resourceMap.get("roles");
//        ShiroUser shiroUser = new ShiroUser(user.getId(), user.getLoginName(), user.getName(), urls);
//        shiroUser.setRoles(roles);
//         认证缓存信息
//        return new SimpleAuthenticationInfo(shiroUser, user.getPassword().toCharArray(),
//                ShiroByteSource.of(user.getSalt()), getName());
    }

    /**
     * Shiro权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
//        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setRoles(shiroUser.getRoles());
//        info.addStringPermissions(shiroUser.getUrlSet());
        
        return info;
    }
    
    @Override
    public void onLogout(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
//        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
//        removeUserCache(shiroUser);
    }

    /**
     * 清除用户缓存
     * @param shiroUser
     */
   /* public void removeUserCache(ShiroUser shiroUser){
        removeUserCache(shiroUser.getLoginName());
    }

    *//**
     * 清除用户缓存
     * @param loginName
     *//*
    public void removeUserCache(String loginName){
        SimplePrincipalCollection principals = new SimplePrincipalCollection();
        principals.add(loginName, super.getName());
        super.clearCachedAuthenticationInfo(principals);
    }*/
}