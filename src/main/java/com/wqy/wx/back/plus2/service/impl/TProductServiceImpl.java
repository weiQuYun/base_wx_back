package com.wqy.wx.back.plus2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wqy.wx.back.plus2.entity.TProduct;
import com.wqy.wx.back.plus2.mapper.TProductMapper;
import com.wqy.wx.back.plus2.service.ITProductService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author licm
 * @since 2020-04-03
 */
@Service
public class TProductServiceImpl extends ServiceImpl<TProductMapper, TProduct> implements ITProductService {

}
