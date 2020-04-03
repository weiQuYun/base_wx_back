package com.wqy.wx.back.plus2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wqy.wx.back.plus2.entity.TProductCates;
import org.apache.ibatis.annotations.Delete;

/**
 * <p>
 * 商品分类表 Mapper 接口
 * </p>
 *
 * @author licm
 * @since 2020-04-03
 */
public interface TProductCatesMapper extends BaseMapper<TProductCates> {

    @Delete("delete from t_product_cates where product_id = #{id}")
    void deleteProduct(String id);
}
