package com.transbit.server.controller;


import com.transbit.server.pojo.Position;
import com.transbit.server.pojo.RespBean;
import com.transbit.server.service.IPositionService;
import io.swagger.annotations.Api;
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
@RequestMapping("system/basic/pos")
public class PositionController {

    @Autowired
    private IPositionService positionService;

    @ApiOperation(value="获取所有职位相关信息")
    @GetMapping("listAll")
    public List<Position> getAllPositions(){
        return positionService.list();
    }

    @ApiOperation(value="添加职位信息")
    @PostMapping("add")
    public RespBean addPosition(@RequestBody Position position){
        position.setCreateDate(LocalDateTime.now());
        if(positionService.save(position)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value="更新职位信息")
    @PostMapping("update")
    public RespBean updatePostion(@RequestBody Position position){
        if(positionService.updateById(position)){
            return RespBean.success("更新成功");
        }
        return RespBean.success("更新失败！");
    }

    @ApiOperation(value="delete position info")
    @DeleteMapping("delete/{id}")
    public RespBean deletePosition(@PathVariable Integer id){
        if(positionService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value="批量删除职位信息")
    @DeleteMapping("deleteBatch")
    public RespBean deletePositionByIds(Integer[] ids){
        if(positionService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}
