package com.transbit.server.controller;


import com.transbit.server.pojo.Joblevel;
import com.transbit.server.pojo.RespBean;
import com.transbit.server.service.IJoblevelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Gavin
 * @since 2024-08-10
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {

    @Autowired
    private IJoblevelService joblevelService;

    @ApiOperation(value = "获取所有职称")
    @GetMapping("/listAll")
    public List<Joblevel> getAllJoblevels(){
        return joblevelService.list();
    }

    @ApiOperation(value = "添加职称")
    @PostMapping("add")
    public RespBean addJoblevel(@RequestBody Joblevel joblevel){
        joblevel.setCreateDate(LocalDateTime.now());
        if(joblevelService.save(joblevel)){
            return RespBean.success("添加成功！");
        }
        return RespBean.success("添加失败！");
    }

    @ApiOperation(value = "更新职称")
    @PutMapping("/update")
    public RespBean updateJoblevel(@RequestBody Joblevel joblevel){
        if(joblevelService.updateById(joblevel)){
            return RespBean.success("更新成功！");
        }
        return RespBean.success("更新失败！");
    }

    @ApiOperation(value="删除职称")
    @DeleteMapping("delete/{id}")
    public RespBean deleteJoblevel(@PathVariable Integer id){
        if(joblevelService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.success("删除失败！");
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("deleteBatch")
    public RespBean deleteJoblevelsByIds(Integer[] ids){
        if(joblevelService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功！");
        }
        return RespBean.success("删除失败！");
    }
}
