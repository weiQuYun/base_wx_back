package com.wqy.wx.back.plus2.controller;

import com.wqy.wx.back.common.Constant;
import com.wqy.wx.back.plus2.entity.TProduct;
import com.wqy.wx.back.plus2.entity.TProductCates;
import com.wqy.wx.back.plus2.service.ITProductCatesService;
import com.wqy.wx.back.plus2.service.ITProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author licm
 * @since 2020-04-03
 */
@Api(tags = "商品分类表接口管理")
@RestController
@RequestMapping(Constant.MAPPING + "/tProductCates")
public class TProductCatesController {
    @Autowired
    private ITProductCatesService itProductCatesService;

    @GetMapping("/list")
    @ApiOperation("获取全部")
    public void getProductAll() {
        itProductCatesService.searchAll();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public void deleteProductCates(@PathVariable String id) {
        itProductCatesService.deleteProductCates(id);
    }

    @PostMapping("")
    @ApiOperation("添加")
    public void addProductCates(@RequestParam TProductCates tProductCates) {
        itProductCatesService.insertProductCates(tProductCates);
    }

    @PutMapping("")
    @ApiOperation("修改")
    public void updateProductCates(@RequestParam TProductCates tProductCates) {
        itProductCatesService.updateProductCates(tProductCates);
    }

    @GetMapping("/page/{page}/{size}")
    @ApiOperation("分页查询")
    public void seachProductCatesPage(@PathVariable int page, @PathVariable int size) {
        itProductCatesService.searchAll(page, size);
    }
    @PutMapping("/batch")
    @ApiOperation("批量修改")
    public void updateProductCatesBatch(@RequestParam List<TProductCates> list){
        itProductCatesService.updateProductCates(list);
    }
    @PostMapping("/batch")
    @ApiOperation("批量添加")
    public void addProductCatesBatch(@RequestParam List<TProductCates> list){
        itProductCatesService.insertProductCates(list);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation("批量删除")
    public void deleteProductCatesBatch(@PathVariable List<String> id){
        itProductCatesService.deleteProductCates(id);
    }
}
