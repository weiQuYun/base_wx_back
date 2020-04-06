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
    public List<TProductImage> getProductImageAll(@PathVariable String id) {
        return itProductImageService.searchAll(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public Boolean deleteProductImage(@PathVariable String id) {
        return itProductImageService.deleteProductImage(id);
    }

    @PostMapping("")
    @ApiOperation("添加")
    public Boolean addProductImage(@RequestBody TProductImage tProductImage) {
        return itProductImageService.insertProductImage(tProductImage);
    }

    @PutMapping("")
    @ApiOperation("修改")
    public Boolean updateProductImage(@RequestBody TProductImage tProductImage) {
        itProductImageService.updateProductImage(tProductImage);
        return true;
    }

    //此方法不存在
    @GetMapping("/page/{page}/{size}")
    @ApiOperation("分页查询")
    public void searchProductImagePage(@PathVariable int page, @PathVariable int size) {
        itProductImageService.searchAll(page, size);
    }

    @PutMapping("/batch")
    @ApiOperation("批量修改")
    public Boolean updateProductImageBatch(@RequestBody List<TProductImage> list) {
        itProductImageService.updateProductImage(list);
        return true;
    }

    @PostMapping("/batch")
    @ApiOperation("批量添加")
    public Boolean addProductImageBatch(@RequestBody List<TProductImage> list) {
        itProductImageService.insertProductImage(list);
        return true;
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("批量删除")
    public Boolean deleteProductImageBatch(@PathVariable List<String> id) {
        itProductImageService.deleteProductImage(id);
        return true;
    }
}
