package com.wqy.wx.back.plus2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author licm
 * @since 2020-04-03
 */
@Api(tags = {"购物车"})
@RestController
@RequestMapping("/tCart")
public class TCartController {

    @GetMapping("/getList")
    @ApiOperation("获取数据")
    public boolean getList() {
        return true;
    }
}
