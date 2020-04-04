package com.wqy.wx.back.plus2.controller;

import com.wqy.wx.back.common.Constant;
import com.wqy.wx.back.plus2.entity.TProduct;
import com.wqy.wx.back.plus2.entity.TProductImage;
import com.wqy.wx.back.plus2.service.ITProductImageService;
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
@Api(tags = "商品图片more接口管理")
@RestController
@RequestMapping(Constant.MAPPING + "/tProductImage")
public class TProductImageController {
    @Autowired
    private ITProductImageService itProductImageService;

    @GetMapping("/list")
    @ApiOperation("获取全部")
    public void getProductImageAll() {
        itProductImageService.searchAll();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public void deleteProductImage(@PathVariable String id) {
        itProductImageService.deleteProductImage(id);
    }

    @PostMapping("")
    @ApiOperation("添加")
    public void addProductImage(@RequestParam TProductImage tProductImage) {
        itProductImageService.insertProductImage(tProductImage);
    }

    @PutMapping("")
    @ApiOperation("修改")
    public void updateProductImage(@RequestParam TProductImage tProductImage) {
        itProductImageService.updateProductImage(tProductImage);
    }

    @GetMapping("/page/{page}/{size}")
    @ApiOperation("分页查询")
    public void searchProductImagePage(@PathVariable int page, @PathVariable int size) {
        itProductImageService.searchAll(page, size);
    }
    @PutMapping("/batch")
    @ApiOperation("批量修改")
    public void updateProductImageBatch(@RequestParam List<TProductImage> list){
        itProductImageService.updateProductImage(list);
    }
    @PostMapping("/batch")
    @ApiOperation("批量添加")
    public void addProductImageBatch(@RequestParam List<TProductImage> list){
        itProductImageService.insertProductImage(list);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation("批量删除")
    public void deleteProductImageBatch(@PathVariable List<String> id){
        itProductImageService.deleteProductImage(id);
    }
}
