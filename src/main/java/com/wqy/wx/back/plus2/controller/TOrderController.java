package com.wqy.wx.back.plus2.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wqy.wx.back.common.Constant;
import com.wqy.wx.back.common.util.page.PageDTO;
import com.wqy.wx.back.plus2.entity.TOrder;
import com.wqy.wx.back.plus2.service.ITOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author licm
 * @since 2020-04-03
 */
@Api(tags = "订单页面接口管理")
@RestController
@RequestMapping(Constant.MAPPING + "/tOrder")
public class TOrderController {
    @Autowired
    private ITOrderService itOrderService;

    @GetMapping("/list")
    @ApiOperation("条件获取数据")
    public List<TOrder> getList(TOrder tOrder) {
        return itOrderService.getList( tOrder);
    }
    @GetMapping("/page")
    @ApiOperation("条件获取分页数据")
    public Page<TOrder> getPage(TOrder tOrder, PageDTO pageDTO) {
        return itOrderService.getPage( tOrder,pageDTO);
    }
    @PostMapping("")
    @ApiOperation("保存数据")
    public boolean save(@RequestBody TOrder tOrder) {
        return itOrderService.save( tOrder);
    }
    @PostMapping("/batch")
    @ApiOperation("批量保存")
    public boolean saveBatch(@RequestBody List<TOrder> tOrders) {
        return itOrderService.saveBatch( tOrders);
    }
    @PutMapping("")
    @ApiOperation("修改")
    public boolean update(@RequestBody TOrder tOrders) {
        return itOrderService.updateById( tOrders);
    }
    @PutMapping("/batch")
    @ApiOperation("批量修改")
    public boolean updateBatch(@RequestBody List<TOrder> tOrders) {
        return itOrderService.updateBatchById(tOrders);
    }
    @DeleteMapping
    @ApiOperation("删除")
    public boolean delete(@RequestBody TOrder tOrders) {
        return itOrderService.removeById( tOrders);
    }
    @DeleteMapping("/batch")
    @ApiOperation("批量删除")
    public boolean deleteBatch(@RequestBody List<TOrder> tOrders) {
        return itOrderService.removeByIds(tOrders);
    }
}
