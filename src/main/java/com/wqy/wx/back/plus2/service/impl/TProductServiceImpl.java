package com.wqy.wx.back.plus2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wqy.wx.back.common.util.UUIDUtils;
import com.wqy.wx.back.common.util.dozer.IGenerator;
import com.wqy.wx.back.plus2.entity.TProduct;
import com.wqy.wx.back.plus2.entity.TProductCates;
import com.wqy.wx.back.plus2.entity.TProductImage;
import com.wqy.wx.back.plus2.mapper.*;
import com.wqy.wx.back.plus2.service.ITProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author licm
 * @since 2020-04-03
 */
@Primary
@Service
public class TProductServiceImpl extends ServiceImpl<TProductMapper, TProduct> implements ITProductService {
    @Autowired
    private TProductMapper tProductMapper;
    @Autowired
    private TCartMapper tCartMapper;
    @Autowired
    private THotelMapper tHotelMapper;
    @Autowired
    private TProductImageMapper tProductImageMapper;
    @Autowired
    private TCommentMapper tCommentMapper;
    @Autowired
    private TProductCatesMapper tProductCatesMapper;
    @Autowired
    IGenerator generator;

    /**
     * 查询所有
     * **/
    @Override
    public List<TProduct> searchAll(TProduct tProduct) {
        return tProductMapper.selectList(null);
    }

    /**
     * 删除商品
     **/
    @Override
    @Transactional
    public void deleteProduct(String id) {
        List list = new ArrayList();
        list.add(id);
        deleteProduct_(list);
    }

    /**
     * 批量删除
     **/
    @Override
    @Transactional
    public void deleteProduct(List<String> list) {
        deleteProduct_(list);
    }

    /**
     * 添加
     **/
    @Override
    @Transactional
    public void insertProduct(TProduct tProduct) {
        List list = new ArrayList();
        list.add(tProduct);
        insertProduct_(list);
    }

    /**
     * 批量添加
     **/
    @Override
    public void insertProduct(List<TProduct> list) {
        insertProduct_(list);
    }

    /**
     * 修改
     * **/
    @Override
    public void updateProduct(TProduct tProduct) {
        List<TProduct> list = new ArrayList<>();
        list.add(tProduct);
        updateProduct_(list);
    }

    /**
     * 批量修改
     * **/
    @Override
    public void updateProduct(List<TProduct> list) {
        updateProduct_(list);
    }

    /**
     * 分页查询
     * **/
    @Override

    public Page<TProduct> searchAll(int page, int size) {
        return tProductMapper.selectPage(new Page<>(page, size), null);
    }

    private Boolean deleteProduct_(List<String> list) {
        //判断是否存在
        if (list.size() == 0) return true;
        for (int i = 0; i < list.size(); i++) {
            //删除购物车中的本商品
            tCartMapper.deleteProduct(list.get(i));
            //删除店铺中的本商品
            tHotelMapper.deleteProduct(list.get(i));
            //删除商品图片
            tProductImageMapper.deleteProduct(list.get(i));
            //删除详情描述
            tProductCatesMapper.deleteProduct(list.get(i));
            //删除评论投诉
            tCommentMapper.deleteProduct(list.get(i));
            //删除商品
            TProduct tProduct = new TProduct();
            tProduct.setId(list.get(i));
            tProduct.setStatus(false);
            tProductMapper.updateById(tProduct);
        }
        return true;
    }

    private Boolean insertProduct_(List<TProduct> list) {
        if (list.size() == 0) return true;
        for (int i = 0; i < list.size(); i++) {
            //添加店铺商品
            list.get(i).setId(UUIDUtils.getCharAndNumr());//此处生成UUID
            tProductMapper.insert(list.get(i));
            if (list.get(i).getProduct_image().size()>0){
                //添加图片
                for (TProductImage tProductImage : list.get(i).getProduct_image()) {
                    tProductImageMapper.insert(tProductImage);
                }
            }
        }
        return true;
    }

    private Boolean updateProduct_(List<TProduct> list) {
        if (list.size() == 0) return true;
        for (int i = 0; i < list.size(); i++) {
            //修改商品信息
            tProductMapper.updateById(list.get(i));
        }
        return true;
    }
}
