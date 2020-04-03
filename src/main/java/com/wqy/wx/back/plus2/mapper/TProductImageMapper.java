package com.wqy.wx.back.plus2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wqy.wx.back.plus2.entity.TProductImage;
import org.apache.ibatis.annotations.Delete;

/**
 * <p>
 * 商品图片more Mapper 接口
 * </p>
 *
 * @author licm
 * @since 2020-04-03
 */
public interface TProductImageMapper extends BaseMapper<TProductImage> {

    @Delete("delete from t_product_image where product_id = @{id}")
    void deleteProduct(String id);
}
