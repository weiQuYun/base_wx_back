package com.wqy.wx.back.plus2.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wqy.wx.back.common.util.UUIDUtils;
import com.wqy.wx.back.plus2.entity.TUser;
import com.wqy.wx.back.plus2.mapper.TUserMapper;
import com.wqy.wx.back.plus2.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public List<TUser> searchAll(TUser tUser) {
        return null;
    }

    @Override
    public Boolean deleteTUser(String id) {
        if (id.isEmpty()){
            return false;
        }
        tUserMapper.deleteById(id);
        return true;
    }

    @Override
    public Boolean insertTUser(TUser tUser) {
        tUser.setId(UUIDUtils.getCharAndNumr());
        tUserMapper.insert(tUser);
        return true;
    }

    @Override
    public Boolean updateTUser(TUser tUser) {
        tUserMapper.updateById(tUser);
        return true;
    }

    @Override
    public Page<TUser> searchAll(int page, int size) {
        Page<TUser> tUserPage = tUserMapper.selectPage(new Page<>(page, size), null);
        return tUserPage;
    }

    @Override
    public Boolean insertTUser(List<TUser> list) {
        return true;
    }

    @Override
    public Boolean updateTUser(List<TUser> list) {
        return true;
    }

    @Override
    public Boolean deleteTUser(List<String> id) {
        return true;
    }
}
