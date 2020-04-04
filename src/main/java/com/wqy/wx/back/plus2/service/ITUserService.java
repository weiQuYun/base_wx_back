package com.wqy.wx.back.plus2.service;

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

    List<TUser> searchAll();

    void deleteTUser(String id);

    void insertTUser(TUser tUser);

    void updateTUser(TUser tUser);

    List<TUser> searchAll(int page,int size);

    void insertTUser(List<TUser> list);

    void updateTUser(List<TUser> list);

    void deleteTUser(List<String> id);
}
