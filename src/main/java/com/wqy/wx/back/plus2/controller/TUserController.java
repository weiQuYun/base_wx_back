package com.wqy.wx.back.plus2.controller;

import com.wqy.wx.back.common.Constant;
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
@RequestMapping(Constant.MAPPING + "/tUser")
public class TUserController {
    @Autowired
    private ITUserService itUserService;

    @GetMapping("/list")
    @ApiOperation("获取全部")
    public List<TUser> getTUserAll() {
        return itUserService.searchAll();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public void deleteTUser(@PathVariable String id) {
        itUserService.deleteTUser(id);
    }

    @PostMapping("")
    @ApiOperation("添加")
    public void addTUser(@RequestParam TUser tUser) {
        itUserService.insertTUser(tUser);
    }

    @PutMapping("")
    @ApiOperation("修改")
    public void updateTUser(@RequestParam TUser tUser) {
        itUserService.updateTUser(tUser);
    }

    @GetMapping("/page/{page}/{size}")
    @ApiOperation("分页查询")
    public void searchTUserPage(@PathVariable int page, @PathVariable int size) {
        itUserService.searchAll(page, size);
    }
    @PutMapping("/batch")
    @ApiOperation("批量修改")
    public void updateTUserBatch(@RequestParam List<TUser> list){
        itUserService.updateTUser(list);
    }
    @PostMapping("/batch")
    @ApiOperation("批量添加")
    public void addTUserBatch(@RequestParam List<TUser> list){
        itUserService.insertTUser(list);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation("批量删除")
    public void deleteTUserBatch(@PathVariable List<String> id){
        itUserService.deleteTUser(id);
    }
}
