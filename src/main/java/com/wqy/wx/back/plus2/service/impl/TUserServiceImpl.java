package com.wqy.wx.back.plus2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wqy.wx.back.plus2.entity.TUser;
import com.wqy.wx.back.plus2.mapper.TUserMapper;
import com.wqy.wx.back.plus2.service.ITUserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户 服务实现类
 * </p>
 *
 * @author licm
 * @since 2020-04-03
 */
@Primary
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

    @Override
    public List<TUser> searchAll() {
        return null;
    }

    @Override
    public void deleteTUser(String id) {

    }

    @Override
    public void insertTUser(TUser tUser) {

    }

    @Override
    public void updateTUser(TUser tUser) {

    }

    @Override
    public List<TUser> searchAll(int page, int size) {
        return null;
    }

    @Override
    public void insertTUser(List<TUser> list) {

    }

    @Override
    public void updateTUser(List<TUser> list) {

    }

    @Override
    public void deleteTUser(List<String> id) {

    }
}
