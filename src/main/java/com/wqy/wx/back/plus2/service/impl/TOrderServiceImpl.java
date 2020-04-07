package com.wqy.wx.back.plus2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wqy.wx.back.common.util.ParamUtils;
import com.wqy.wx.back.common.util.UUIDUtils;
import com.wqy.wx.back.common.util.page.PageDTO;
import com.wqy.wx.back.plus2.entity.TCart;
import com.wqy.wx.back.plus2.entity.TOrder;
import com.wqy.wx.back.plus2.entity.TOrderInfo;
import com.wqy.wx.back.plus2.entity.TProduct;
import com.wqy.wx.back.plus2.mapper.TOrderInfoMapper;
import com.wqy.wx.back.plus2.mapper.TOrderMapper;
import com.wqy.wx.back.plus2.mapper.TProductMapper;
import com.wqy.wx.back.plus2.service.ITOrderService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Autowired
    private TProductMapper tProductMapper;
    @Autowired
    private TOrderInfoMapper tOrderInfoMapper;
    @Autowired
    private TOrderMapper tOrderMapper;
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

    @Override
    public boolean insertOrder(List<TCart> tCartList) {
        //获取了所有的购物车信息即商品iD
        //判断下是不是垃圾数据
        if (tCartList.size()<1) {
            return false;
        }
        //1.生成唯一的订单ID 此ID 赋予订单详情用于查询具体商品
        String orderUUID = UUIDUtils.getCharAndNumr();
        //2.生成一张订单表
        TOrder tOrder = new TOrder();
        tOrder.setOrderNumber(orderUUID);//设置唯一订单号
        tOrder.setMenberId(tCartList.get(0).getMenberId());//注入menberID
        tOrder.setPayStatus(0);
        tOrder.setSendStatus(0);
        tOrder.setAliOrderId(0l);
        //已经生成了一个订单 返回给前端填写剩下的数据
        //生成订单详情页面
        for (TCart tCart : tCartList) {
            //拉取每一个购物车生成订单详情
            String procuteId = tCart.getProcuteId();//获取商品ID 通过商品ID 查询商品详情填充详情页
            TProduct tProduct = tProductMapper.selectById(procuteId);
            TOrderInfo tOrderInfo = new TOrderInfo();//填充详情页
            tOrderInfo.setOrderId(orderUUID);
            tOrderInfo.setProductId(procuteId);
            tOrderInfo.setProduct_number(tCart.getProcuteNumber());
            tOrderInfo.setReceivableAmount(tProduct.getPriceOld().multiply(new BigDecimal(tCart.getProcuteNumber())));//...........这尼玛有毒填入实际价格即原价
            tOrderInfo.setReceivedAmount(tProduct.getPriceNew().multiply(new BigDecimal(tCart.getProcuteNumber())));//填入实收金额
            tOrderInfo.setDiscountAmount(tProduct.getPriceOld().multiply(new BigDecimal(tCart.getProcuteNumber()))
                    .subtract(tProduct.getPriceNew().multiply(new BigDecimal(tCart.getProcuteNumber()))));//优惠金额
            tOrderInfoMapper.insert(tOrderInfo);//保存详情页
        }
        //保存订单页
        tOrderMapper.insert(tOrder);
        return true;
    }
}
