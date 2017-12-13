package com.shopping.service;

import com.shopping.entity.User;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaokai
 * @since 2017-12-01
 */
public interface IUserService extends IService<User> {
	List<User> test();
}
