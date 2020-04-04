package com.wqy.wx.back.plus2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wqy.wx.back.plus2.entity.TProductCates;
import com.wqy.wx.back.plus2.mapper.TProductCatesMapper;
import com.wqy.wx.back.plus2.service.ITProductCatesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品分类表 服务实现类
 * </p>
 *
 * @author licm
 * @since 2020-04-03
 */
@Service
public class TProductCatesServiceImpl extends ServiceImpl<TProductCatesMapper, TProductCates> implements ITProductCatesService {

    @Override
    public void searchAll() {

    }

    @Override
    public void deleteProductCates(String id) {

    }

    @Override
    public void insertProductCates(TProductCates tProductCates) {

    }

    @Override
    public void updateProductCates(TProductCates tProductCates) {

    }

    @Override
    public void searchAll(int page, int size) {

    }

    @Override
    public void updateProductCates(List<TProductCates> list) {

    }

    @Override
    public void insertProductCates(List<TProductCates> list) {

    }

    @Override
    public void deleteProductCates(List<String> id) {

    }
}
