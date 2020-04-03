package com.wqy.wx.back.plus2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wqy.wx.back.plus2.entity.TUser;
import com.wqy.wx.back.plus2.mapper.TUserMapper;
import com.wqy.wx.back.plus2.service.ITUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户 服务实现类
 * </p>
 *
 * @author licm
 * @since 2020-04-03
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
