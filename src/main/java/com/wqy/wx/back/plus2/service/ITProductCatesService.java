package com.wqy.wx.back.plus2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wqy.wx.back.plus2.entity.TProductCates;

import java.util.List;

/**
 * <p>
 * 商品分类表 服务类
 * </p>
 *
 * @author licm
 * @since 2020-04-03
 */
public interface ITProductCatesService extends IService<TProductCates> {

    void searchAll();

    void deleteProductCates(String id);

    void insertProductCates(TProductCates tProductCates);

    void updateProductCates(TProductCates tProductCates);

    void searchAll(int page, int size);

    void updateProductCates(List<TProductCates> list);

    void insertProductCates(List<TProductCates> list);

    void deleteProductCates(List<String> id);
}
