package com.wqy.wx.back.plus2.controller;

import com.wqy.wx.back.common.Constant;
import com.wqy.wx.back.plus2.entity.TProduct;
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
@Api(tags = "商品表接口管理")
@RestController
@RequestMapping(Constant.MAPPING + "/tProduct")
public class TProductController {
    @Autowired
    private ITProductService itProductService;

    @GetMapping("/list")
    @ApiOperation("获取全部")
    public void getProductAll() {
        itProductService.searchAll();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public void deleteProduct(@PathVariable String id) {
        itProductService.deleteProduct(id);
    }

    @PostMapping("")
    @ApiOperation("添加")
    public void addProduct(@RequestParam TProduct tProduct) {
        itProductService.insertProduct(tProduct);
    }

    @PutMapping("")
    @ApiOperation("修改")
    public void updateProduct(@RequestParam TProduct tProduct) {
        itProductService.updateProduct(tProduct);
    }

    @GetMapping("/page/{page}/{size}")
    @ApiOperation("分页查询")
    public void searchProductPage(@PathVariable int page, @PathVariable int size) {
        itProductService.searchAll(page, size);
    }
    @PutMapping("/batch")
    @ApiOperation("批量修改")
    public void updateProductBatch(@RequestParam List<TProduct> list){
        itProductService.updateProduct(list);
    }
    @PostMapping("/batch")
    @ApiOperation("批量添加")
    public void addProductBatch(@RequestParam List<TProduct> list){
        itProductService.insertProduct(list);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation("批量删除")
    public void deleteProductBatch(@PathVariable List<String> id){
        itProductService.deleteProduct(id);
    }
}
