package com.wqy.wx.back.plus2.controller;

import com.wqy.wx.back.common.Constant;
import com.wqy.wx.back.plus2.entity.TProductImage;
import com.wqy.wx.back.plus2.service.ITProductImageService;
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
@RequestMapping(Constant.MAPPING + "/productImage")
public class TProductImageController {
    @Autowired
    private ITProductImageService itProductImageService;

    @GetMapping("/list/{id}")
    @ApiOperation("获取全部")
    public void getProductImageAll(@PathVariable String id) {
        itProductImageService.searchAll(id);
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

    //此方法不存在
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
