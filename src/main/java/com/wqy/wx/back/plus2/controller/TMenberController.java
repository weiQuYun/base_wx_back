package com.wqy.wx.back.plus2.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wqy.wx.back.common.Constant;
import com.wqy.wx.back.common.util.page.PageDTO;
import com.wqy.wx.back.plus2.entity.TMenber;
import com.wqy.wx.back.plus2.service.ITMenberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author licm
 * @since 2020-04-03
 */
@Api(tags = "会员表i接口管理")
@RestController
@RequestMapping(Constant.MAPPING + "/tMenber")
public class TMenberController {
    @Autowired
    private ITMenberService itMenberService;

    @GetMapping("/list")
    @ApiOperation("条件获取数据")
    public List<TMenber> getList( TMenber tMenber) {
        return itMenberService.getList( tMenber);
    }
    @GetMapping("/page")
    @ApiOperation("条件获取分页数据")
    public Page<TMenber> getPage( TMenber tMenber,  PageDTO pageDTO) {
        return itMenberService.getPage( tMenber,pageDTO);
    }
    @PostMapping("")
    @ApiOperation("保存数据")
    public boolean save(@RequestBody TMenber tMenber) {
        return itMenberService.save( tMenber);
    }
    @PostMapping("/batch")
    @ApiOperation("批量保存")
    public boolean saveBatch(@RequestBody List<TMenber> tMenbers) {
        return itMenberService.saveBatch( tMenbers);
    }
    @PutMapping("")
    @ApiOperation("修改")
    public boolean update(@RequestBody TMenber tMenbers) {
        return itMenberService.updateById( tMenbers);
    }
    @PutMapping("/batch")
    @ApiOperation("批量修改")
    public boolean updateBatch(@RequestBody List<TMenber> tMenbers) {
        return itMenberService.updateBatchById(tMenbers);
    }
    @DeleteMapping
    @ApiOperation("删除")
    public boolean delete(@RequestBody TMenber tMenbers) {
        return itMenberService.removeById( tMenbers);
    }
    @DeleteMapping("/batch")
    @ApiOperation("批量删除")
    public boolean deleteBatch(@RequestBody List<TMenber> tMenbers) {
        return itMenberService.removeByIds(tMenbers);
    }
}
