package com.wqy.wx.back.plus2.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wqy.wx.back.common.Constant;
import com.wqy.wx.back.common.util.dozer.IGenerator;
import com.wqy.wx.back.plus2.entity.TUser;
import com.wqy.wx.back.plus2.service.ITUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author licm
 * @since 2020-04-03
 */
@Api(tags = "后台用户接口管理")
@RestController
@RequestMapping(Constant.MAPPING + "/user")
public class TUserController {
    @Autowired
    private ITUserService itUserService;

    @GetMapping("/list")
    @ApiOperation("获取全部")
    public TUser getTUserAll(TUser tUser) {
        return itUserService.searchAll(tUser);

    }



    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public Boolean deleteTUser(@PathVariable String id) {
        return itUserService.deleteTUser(id);
    }

    @PostMapping("")
    @ApiOperation("添加")
    public Boolean addTUser(@RequestBody TUser tUser) {
        return itUserService.insertTUser(tUser);
    }

    @PutMapping("")
    @ApiOperation("修改")
    public Boolean updateTUser(@RequestBody TUser tUser) {
        return itUserService.updateTUser(tUser);
    }

    @GetMapping("/page/{page}/{size}")
    @ApiOperation("分页查询")
    public Page<TUser> searchTUserPage(@PathVariable int page, @PathVariable int size)  {
        return itUserService.searchAll(page, size);
    }
    //以下不存在
    @PutMapping("/batch")
    @ApiOperation("批量修改")
    public Boolean updateTUserBatch(@RequestBody List<TUser> list){
        return itUserService.updateTUser(list);
    }
    @PostMapping("/batch")
    @ApiOperation("批量添加")
    public Boolean addTUserBatch(@RequestBody List<TUser> list){
        return itUserService.insertTUser(list);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation("批量删除")
    public Boolean deleteTUserBatch(@PathVariable List<String> id){
        return itUserService.deleteTUser(id);
    }
}
