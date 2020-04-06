package com.wqy.wx.back.plus2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wqy.wx.back.plus2.entity.TProductImage;
import com.wqy.wx.back.plus2.mapper.TProductImageMapper;
import com.wqy.wx.back.plus2.service.ITProductImageService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品图片more 服务实现类
 * </p>
 *
 * @author licm
 * @since 2020-04-03
 */
@Primary
@Service
public class TProductImageServiceImpl extends ServiceImpl<TProductImageMapper, TProductImage> implements ITProductImageService {


    @Override
    public List<TProductImage> searchAll() {
        return null;
    }

    @Override
    public void deleteProductImage(String id) {

    }

    @Override
    public void insertProductImage(TProductImage tProductImage) {

    }

    @Override
    public void updateProductImage(TProductImage tProductImage) {

    }

    @Override
    public void searchAll(int page, int size) {

    }

    @Override
    public void updateProductImage(List<TProductImage> list) {

    }

    @Override
    public void insertProductImage(List<TProductImage> list) {

    }

    @Override
    public void deleteProductImage(List<String> id) {

    }
}
