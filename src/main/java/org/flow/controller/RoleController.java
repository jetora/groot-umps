package org.flow.controller;

import org.flow.dao.mapper.RoleMapper;
import org.flow.entity.Role;
import org.flow.service.RoleService;
import org.flow.utils.common.enums.ErrorCode;
import org.flow.utils.common.exception.ResourceNotFoundException;
import org.flow.utils.common.utils.ResponseResult;
import org.flow.utils.common.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RoleController extends BaseController{
    @Resource
    private RoleService roleService;

    //查询所有
    @GetMapping(value = "/role",produces = { "application/json;charset=UTF-8" })
    public ResponseResult<List<Role>> findAll() {
        List<Role> accountList = new ArrayList<>();
        ResponseResult<List<Role>> result= new ResponseResult<>();
        try {
            accountList = roleService.findRoleAll();
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),accountList);
        }catch (Exception ex){
            logger.error("Account not found...",ex);
            return ResultUtil.buildErrorResult(ErrorCode.NOT_FOUND.getCode(),ErrorCode.NOT_FOUND.getMessage());
        }
    }
    //根据id查询
    @GetMapping(value = "/role/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Role> findOne(@PathVariable Long id){
        ResponseResult<Role> result = new ResponseResult<>();
        Role role;
        try {
            role = roleService.findRoleById(id);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),role);
        }catch (Exception ex){
            logger.info("Account not founded...",ex);
            return ResultUtil.buildErrorResult(ErrorCode.NOT_FOUND.getCode(),ErrorCode.NOT_FOUND.getMessage());
        }
    }
    //创建Account
    @PostMapping(value = "/role", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Role> createAccount(@RequestBody Role role){
        ResponseResult<Role> result = new ResponseResult<>();
        try {
            roleService.createRole(role);
            return ResultUtil.buildResult(ErrorCode.CREATED.getCode(),ErrorCode.CREATED.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.UNPROCESABLE_ENTITY.getCode(),ErrorCode.UNPROCESABLE_ENTITY.getMessage());
        }
    }
    //修改Account
    @PutMapping(value = "/role", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Role> updateAccount(@RequestBody Role role){
        ResponseResult<Role> result = new ResponseResult<>();
        if (role.getId()==null){
            return ResultUtil.buildResult(ErrorCode.NOT_ACCEPTABLE.getCode(),ErrorCode.NOT_ACCEPTABLE.getMessage());
        }
        try {
            roleService.updateRoleById(role);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
    //修改Account
    @PatchMapping(value = "/role", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Role> updatePartAccount(@RequestBody Role role){
        ResponseResult<Role> result = new ResponseResult<>();
        if (role.getId()==null){
            return ResultUtil.buildResult(ErrorCode.NOT_ACCEPTABLE.getCode(),ErrorCode.NOT_ACCEPTABLE.getMessage());
        }
        try {
            roleService.updateRoleById(role);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
    //删除Account
    @DeleteMapping(value = "/role/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Role> deleteAccount(@PathVariable Long id){
        ResponseResult<Role> result = new ResponseResult<>();
        try {
            roleService.deleteRoleById(id);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
}
