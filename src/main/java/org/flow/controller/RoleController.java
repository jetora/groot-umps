package org.flow.controller;

import org.flow.dao.mapper.RoleMapper;
import org.flow.entity.Role;
import org.flow.service.RoleService;
import org.flow.utils.common.enums.ErrorCode;
import org.flow.utils.common.exception.ResourceNotFoundException;
import org.flow.utils.common.utils.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
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
    //条件查询
    @GetMapping(value = "/role/pageInfo",produces = { "application/json;charset=UTF-8" })
    public BootStrapResult<List<Role>> pageInfo(HttpServletRequest request){
        Map params = HttpUtil.getParams(request);
        //List<Account> accounts =accountService.findAccountAll();
        //int total = accounts.size();
        int total = 0;
        String rolename = "";
        int enabled = -1;
        String  ordername= "id";
        String order = "asc";

        List<Role> roleList = new ArrayList<>();
        BootStrapResult<List<Role>> result= new BootStrapResult<>();

        try {
            if (StringUtils.notNull(params.get("rolename"))){
                rolename = String.valueOf(params.get("rolename"));
            }
            if (StringUtils.notNull(params.get("enabled"))){
                enabled = Integer.parseInt((String)params.get("enabled"));
            }
            if (StringUtils.notNull(params.get("order"))){
                order = String.valueOf(params.get("order"));
            }
            if (StringUtils.notNull(params.get("ordername"))){
                ordername = String.valueOf(params.get("ordername"));
            }
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            int offset = Integer.parseInt(request.getParameter("offset"));

            roleList = roleService.findAccountAll(offset,pageSize,ordername,order,rolename,enabled);
            if (StringUtils.notNull(params.get("rolename")) || StringUtils.notNull(params.get("enabled"))){
                //total = accountList.size();
                total = roleService.findWhereTotal(ordername,order,rolename,enabled);
            } else {
                total = roleService.findTotal();
            }
            result.setCode(HttpStatus.OK.toString());
            result.setMsg("success");
            result.setData(roleList);
            result.setTotal(total);
        }catch (Exception ex){
            result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            result.setMsg("failed");
            result.setData(roleList);
            result.setTotal(total);
        }

        return result;
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
