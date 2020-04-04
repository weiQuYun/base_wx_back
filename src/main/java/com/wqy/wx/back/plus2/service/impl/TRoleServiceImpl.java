package com.wqy.wx.back.plus2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wqy.wx.back.plus2.entity.TRole;
import com.wqy.wx.back.plus2.mapper.TRoleMapper;
import com.wqy.wx.back.plus2.service.ITRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色权限 服务实现类
 * </p>
 *
 * @author licm
 * @since 2020-04-03
 */
@Service
public class TRoleServiceImpl extends ServiceImpl<TRoleMapper, TRole> implements ITRoleService {


    @Override
    public List<TRole> searchAll() {
        return null;
    }

    @Override
    public void deleteTRole(String id) {

    }

    @Override
    public void insertTRole(TRole tRole) {

    }

    @Override
    public void updateTRole(TRole tRole) {

    }

    @Override
    public void searchAll(int page, int size) {

    }

    @Override
    public void updateTRole(List<TRole> list) {

    }

    @Override
    public void insertTRole(List<TRole> list) {

    }

    @Override
    public void deleteTRole(List<String> id) {

    }
}
