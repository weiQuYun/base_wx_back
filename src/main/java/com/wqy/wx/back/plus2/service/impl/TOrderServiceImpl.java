package com.wqy.wx.back.plus2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wqy.wx.back.common.util.ParamUtils;
import com.wqy.wx.back.common.util.page.PageDTO;
import com.wqy.wx.back.plus2.entity.TOrder;
import com.wqy.wx.back.plus2.mapper.TOrderMapper;
import com.wqy.wx.back.plus2.service.ITOrderService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单页面 服务实现类
 * </p>
 *
 * @author licm
 * @since 2020-04-03
 */
@Primary
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

    @Override
    public List<TOrder> getList(TOrder tOrder) {
        QueryWrapper<TOrder>  query = new QueryWrapper<>();
        query = ParamUtils.reflect(tOrder,query);
        return this.list(query);
    }

    @Override
    public Page<TOrder> getPage(TOrder tOrder, PageDTO pageDTO) {
        QueryWrapper<TOrder>  query = new QueryWrapper<>();
        query = ParamUtils.reflect(tOrder,query);
        Page<TOrder> page = new Page<>(pageDTO.getPageIndex(),pageDTO.getPageSize());
        return this.page(page,query);
    }
}
