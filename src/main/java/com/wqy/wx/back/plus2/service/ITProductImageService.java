package com.wqy.wx.back.plus2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wqy.wx.back.plus2.entity.TProductImage;

import java.util.List;

/**
 * <p>
 * 商品图片more 服务类
 * </p>
 *
 * @author licm
 * @since 2020-04-03
 */
public interface ITProductImageService extends IService<TProductImage> {

    List<TProductImage> searchAll();

    void deleteProductImage(String id);

    void insertProductImage(TProductImage tProductImage);

    void updateProductImage(TProductImage tProductImage);

    void searchAll(int page, int size);

    void updateProductImage(List<TProductImage> list);

    void insertProductImage(List<TProductImage> list);

    void deleteProductImage(List<String> id);
}
