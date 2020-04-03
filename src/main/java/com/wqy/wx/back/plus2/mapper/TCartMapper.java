package com.wqy.wx.back.plus2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wqy.wx.back.plus2.entity.TCart;
import org.apache.ibatis.annotations.Delete;

/**
 * <p>
 * 购物车 Mapper 接口
 * </p>
 *
 * @author licm
 * @since 2020-04-03
 */
public interface TCartMapper extends BaseMapper<TCart> {

    @Delete("delete from t_cart where product_id = #{id}")
    void deleteProduct(String id);
}
