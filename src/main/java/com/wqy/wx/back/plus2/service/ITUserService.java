package com.wqy.wx.back.plus2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wqy.wx.back.plus2.entity.TUser;

import java.util.List;

/**
 * <p>
 * 后台用户 服务类
 * </p>
 *
 * @author licm
 * @since 2020-04-03
 */
public interface ITUserService extends IService<TUser> {

    TUser searchAll(TUser tUser);

    Boolean deleteTUser(String id);

    Boolean insertTUser(TUser tUser);

    Boolean updateTUser(TUser tUser);

    Page<TUser> searchAll(int page, int size);

    Boolean insertTUser(List<TUser> list);

    Boolean updateTUser(List<TUser> list);

    Boolean deleteTUser(List<String> id);
}
