package com.bjc.lcp.app1222.controller;
import com.bjc.lcp.app1222.vo.AdminVo;
import com.bjc.lcp.app1222.dto.AdminDto;
import com.bjc.lcp.app1222.mapper.AdminMapper;
import com.bjc.lcp.app1222.entity.AdminEntity;
import com.bjc.lcp.app1222.service.AdminService;
//import com.bjc.lcp.common.cnt.enums.CntTableNameEnum;
//import com.bjc.lcp.common.cnt.service.CntService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.servlet.ModelAndView;
import com.jun.plugin.common.Result;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
* @Version666
* @description 管理员
* @author Wujun
* @date 2023-09-05
*/
@Api(tags = "管理员-管理")
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;
    
    @Resource
    private AdminMapper adminMapper;
    
    @ApiOperation(value = "管理员-新增")
    @PostMapping("/add")
    //@RequiresPermissions("admin:add")
    public Result add(@Validated(AdminVo.Create.class) @RequestBody AdminVo vo) {
    	AdminDto dto = new AdminDto();
    	BeanUtils.copyProperties(vo, dto);
        if (ObjectUtils.isEmpty(dto.getUsername())) {
            return Result.fail("参数[username]不能为空");
        }
        if (ObjectUtils.isEmpty(dto.getPassword())) {
            return Result.fail("参数[password]不能为空");
        }
        if (ObjectUtils.isEmpty(dto.getLastLoginDate())) {
            return Result.fail("参数[lastLoginDate]不能为空");
        }
        if (ObjectUtils.isEmpty(dto.getCreateDate())) {
            return Result.fail("参数[createDate]不能为空");
        }
        LambdaQueryWrapper<AdminEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(AdminEntity::getId, dto.getId());
        List<AdminEntity> list = adminService.list(queryWrapper);
        if (list.size() > 0) {
            return Result.fail("数据已存在");
        }
        AdminEntity entity = new AdminEntity();
        
        BeanUtils.copyProperties(dto, entity);
        return Result.success(adminService.save(entity));
    }
    
    @ApiOperation(value = "管理员-删除")
    @DeleteMapping("/remove")
    //@RequiresPermissions("admin:remove")
    public Result delete(@Validated(AdminVo.Delete.class) @RequestBody AdminVo vo) {
    	AdminDto dto = new AdminDto();
    	BeanUtils.copyProperties(vo, dto);
         if (ObjectUtils.isEmpty(dto.getId())) {
              return Result.fail("参数[id]不能为空");
         }
        LambdaQueryWrapper<AdminEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(AdminEntity::getId, dto.getId());
        return Result.success(adminService.remove(queryWrapper));
    }

    @ApiOperation(value = "管理员-删除")
    @DeleteMapping("/delete")
    //@RequiresPermissions("admin:delete")
    public Result delete(@RequestBody @ApiParam(value = "id集合") List<String> ids) {
        return Result.success(adminService.removeByIds(ids));
    }


    @ApiOperation(value = "管理员-更新")
    @PutMapping("/update")
    //@RequiresPermissions("admin:update")
    public Result update(@Validated(AdminVo.Update.class) @RequestBody AdminVo vo) {
    	AdminDto dto = new AdminDto();
    	BeanUtils.copyProperties(vo, dto);
         if (ObjectUtils.isEmpty(dto.getId())) {
              return Result.fail("参数[id]不能为空");
         }
        LambdaQueryWrapper<AdminEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(AdminEntity::getId, dto.getId());
        AdminEntity entity = adminService.getOne(queryWrapper);;
        if (entity == null) {
            //return Result.fail("数据不存在");
            entity = new AdminEntity();
        }
        BeanUtils.copyProperties(dto, entity);
        return Result.success(adminService.saveOrUpdate(entity));
    }
    


    @ApiOperation(value = "管理员-查询单条")
    @RequestMapping(value = "/getOne",method = {RequestMethod.GET,RequestMethod.POST})
    //@RequiresPermissions("admin:getOne")
    public Result getOne(@RequestBody AdminVo vo) {
    	AdminDto dto = new AdminDto();
    	BeanUtils.copyProperties(vo, dto);
         if (ObjectUtils.isEmpty(dto.getId())) {
              return Result.fail("参数[id]不能为空");
         }
        LambdaQueryWrapper<AdminEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(AdminEntity::getId, dto.getId());
        AdminEntity entity = adminService.getOne(queryWrapper);;
        return Result.success(entity);
    }
    
    


    @ApiOperation(value = "管理员-查询列表分页数据")
    @RequestMapping(value = "/listByPage",method = {RequestMethod.GET,RequestMethod.POST})
    //@RequiresPermissions("admin:listByPage")
    public Result listByPage(@RequestBody AdminVo admin) {
        Page page = new Page(admin.getPage(), admin.getLimit());
        AdminDto dto = new AdminDto();
    	BeanUtils.copyProperties(admin, dto);
        LambdaQueryWrapper<AdminEntity> queryWrapper = Wrappers.lambdaQuery();
        if (!ObjectUtils.isEmpty(admin.getId())) {
            queryWrapper.eq(AdminEntity::getId, dto.getId());
        }
        if (!ObjectUtils.isEmpty(admin.getUsername())) {
            queryWrapper.eq(AdminEntity::getUsername, dto.getUsername());
        }
        if (!ObjectUtils.isEmpty(admin.getPassword())) {
            queryWrapper.eq(AdminEntity::getPassword, dto.getPassword());
        }
        if (!ObjectUtils.isEmpty(admin.getLastLoginDate())) {
            queryWrapper.eq(AdminEntity::getLastLoginDate, dto.getLastLoginDate());
        }
        if (!ObjectUtils.isEmpty(admin.getCreateDate())) {
            queryWrapper.eq(AdminEntity::getCreateDate, dto.getCreateDate());
        }
        IPage<AdminEntity> iPage = adminService.page(page, queryWrapper);
        return Result.success(iPage);
    }
    
    @ApiOperation(value = "管理员-查询全部列表数据")
    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    //@RequiresPermissions("admin:list")
    public Result findListByPage(@RequestBody AdminVo admin) {
        LambdaQueryWrapper<AdminEntity> queryWrapper = Wrappers.lambdaQuery();
        if (!ObjectUtils.isEmpty(admin.getId())) {
            queryWrapper.eq(AdminEntity::getId, admin.getId());
        }
        if (!ObjectUtils.isEmpty(admin.getUsername())) {
            queryWrapper.eq(AdminEntity::getUsername, admin.getUsername());
        }
        if (!ObjectUtils.isEmpty(admin.getPassword())) {
            queryWrapper.eq(AdminEntity::getPassword, admin.getPassword());
        }
        if (!ObjectUtils.isEmpty(admin.getLastLoginDate())) {
            queryWrapper.eq(AdminEntity::getLastLoginDate, admin.getLastLoginDate());
        }
        if (!ObjectUtils.isEmpty(admin.getCreateDate())) {
            queryWrapper.eq(AdminEntity::getCreateDate, admin.getCreateDate());
        }
        List<AdminEntity> list = adminService.list(queryWrapper);
        return Result.success(list);
    }


}

