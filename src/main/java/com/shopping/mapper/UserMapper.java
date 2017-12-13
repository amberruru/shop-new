package com.shopping.mapper;

import com.shopping.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zhaokai
 * @since 2017-12-01
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> test();
}