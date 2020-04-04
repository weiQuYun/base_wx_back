package com.wqy.wx.back.plus2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wqy.wx.back.plus2.entity.TProductContents;
import com.wqy.wx.back.plus2.mapper.TProductContentsMapper;
import com.wqy.wx.back.plus2.service.ITProductContentsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品详情介绍表 服务实现类
 * </p>
 *
 * @author licm
 * @since 2020-04-03
 */
@Service
public class TProductContentsServiceImpl extends ServiceImpl<TProductContentsMapper, TProductContents> implements ITProductContentsService {

    @Override
    public void searchAll() {

    }

    @Override
    public void deleteProductContents(String id) {

    }

    @Override
    public void insertProductContents(TProductContents tProductContents) {

    }

    @Override
    public void updateProductContents(TProductContents tProductContents) {

    }

    @Override
    public void searchAll(int page, int size) {

    }

    @Override
    public void updateProductContents(List<TProductContents> list) {

    }

    @Override
    public void insertProductContents(List<TProductContents> list) {

    }

    @Override
    public void deleteProductContents(List<String> id) {

    }
}
