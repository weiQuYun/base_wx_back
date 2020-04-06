package com.wqy.wx.back.plus2.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
@RequestMapping(Constant.MAPPING + "/product")
public class TProductController {
    @Autowired
    private ITProductService itProductService;

    @GetMapping("/list")
    @ApiOperation("获取全部")
    public List<TProduct> getProductAll(TProduct tProduct) {
        return itProductService.searchAll(tProduct);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public Boolean deleteProduct(@PathVariable String id) {
        itProductService.deleteProduct(id);
        return true;
    }

    @PostMapping("")
    @ApiOperation("添加")
    public Boolean addProduct(@RequestBody TProduct tProduct) {
        itProductService.insertProduct(tProduct);
        return true;
    }

    @PutMapping("")
    @ApiOperation("修改")
    public Boolean updateProduct(@RequestBody TProduct tProduct) {
        itProductService.updateProduct(tProduct);
        return true;
    }

    @GetMapping("/page/{page}/{size}")
    @ApiOperation("分页查询")
    public Page<TProduct> searchProductPage(@PathVariable int page, @PathVariable int size) {
       return itProductService.searchAll(page, size);
    }
    @PutMapping("/batch")
    @ApiOperation("批量修改")
    public Boolean updateProductBatch(@RequestBody List<TProduct> list){
        itProductService.updateProduct(list);return true;
    }
    @PostMapping("/batch")
    @ApiOperation("批量添加")
    public Boolean addProductBatch(@RequestBody List<TProduct> list){
        itProductService.insertProduct(list);return true;
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation("批量删除")
    public Boolean deleteProductBatch(@PathVariable List<String> id){
        itProductService.deleteProduct(id);return true;
    }
}
