package com.shopping.service.impl;

import com.shopping.entity.User;
import com.shopping.mapper.UserMapper;
import com.shopping.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaokai
 * @since 2017-12-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> test() {
        return userMapper.test();
    }
}
