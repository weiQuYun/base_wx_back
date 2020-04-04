package com.wqy.wx.back.plus2.controller;

import com.wqy.wx.back.common.Constant;
import com.wqy.wx.back.plus2.entity.TProduct;
import com.wqy.wx.back.plus2.entity.TProductContents;
import com.wqy.wx.back.plus2.service.ITProductContentsService;
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
@Api(tags = "商品详情介绍表接口管理")
@RestController
@RequestMapping(Constant.MAPPING + "/tProductContents")
public class TProductContentsController {
    @Autowired
    private ITProductContentsService itProductContentsService;

    @GetMapping("/list")
    @ApiOperation("获取全部")
    public void getProductContentsAll() {
        itProductContentsService.searchAll();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public void deleteProductContents(@PathVariable String id) {
        itProductContentsService.deleteProductContents(id);
    }

    @PostMapping("")
    @ApiOperation("添加")
    public void addProductContents(@RequestParam TProductContents tProductContents) {
        itProductContentsService.insertProductContents(tProductContents);
    }

    @PutMapping("")
    @ApiOperation("修改")
    public void updateProductContents(@RequestParam TProductContents tProductContents) {
        itProductContentsService.updateProductContents(tProductContents);
    }

    @GetMapping("/page/{page}/{size}")
    @ApiOperation("分页查询")
    public void seachProductContentsPage(@PathVariable int page, @PathVariable int size) {
        itProductContentsService.searchAll(page, size);
    }
    @PutMapping("/batch")
    @ApiOperation("批量修改")
    public void updateProductContentsBatch(@RequestParam List<TProductContents> list){
        itProductContentsService.updateProductContents(list);
    }
    @PostMapping("/batch")
    @ApiOperation("批量添加")
    public void addProductContentsBatch(@RequestParam List<TProductContents> list){
        itProductContentsService.insertProductContents(list);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation("批量删除")
    public void deleteProductContentsBatch(@PathVariable List<String> id){
        itProductContentsService.deleteProductContents(id);
    }
}
