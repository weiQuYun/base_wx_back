package com.wqy.wx.back.plus2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wqy.wx.back.common.util.ParamUtils;
import com.wqy.wx.back.common.util.page.PageDTO;
import com.wqy.wx.back.plus2.entity.TCart;
import com.wqy.wx.back.plus2.mapper.TCartMapper;
import com.wqy.wx.back.plus2.service.ITCartService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 购物车 服务实现类
 * </p>
 *
 * @author licm
 * @since 2020-04-03
 */
@Primary
@Service
public class TCartServiceImpl extends ServiceImpl<TCartMapper, TCart> implements ITCartService {

    @Override
    public List<TCart> getList(TCart tCart) {
        QueryWrapper<TCart>  query = new QueryWrapper<>();
        query = ParamUtils.reflect(tCart,query);
        return this.list(query);
    }

    @Override
    public Page<TCart> getPage(TCart tCart, PageDTO pageDTO) {
        QueryWrapper<TCart>  query = new QueryWrapper<>();
        query = ParamUtils.reflect(tCart,query);
        Page<TCart> page = new Page<>(pageDTO.getPageIndex(),pageDTO.getPageSize());
        return this.page(page,query);
    }
}
