package org.flow.controller;

import org.flow.entity.Privilege;
import org.flow.service.PrivilegeService;
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
public class PrivilegeController extends BaseController{
    @Resource
    private PrivilegeService privilegeService;

    //查询所有
    @GetMapping(value = "/privilege",produces = { "application/json;charset=UTF-8" })
    public ResponseResult<List<Privilege>> findAll() {
        List<Privilege> privilegeList = new ArrayList<>();
        ResponseResult<List<Privilege>> result= new ResponseResult<>();
        try {
            privilegeList = privilegeService.findPrivilegeAll();
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),privilegeList);
        }catch (ResourceNotFoundException ex){
            logger.error("Account not found...",ex);
            return ResultUtil.buildErrorResult(ErrorCode.NOT_FOUND.getCode(),ErrorCode.NOT_FOUND.getMessage());
        }
    }
    //条件查询
    @GetMapping(value = "/privilege/pageInfo",produces = { "application/json;charset=UTF-8" })
    public BootStrapResult<List<Privilege>> pageInfo(HttpServletRequest request){
        Map params = HttpUtil.getParams(request);
        int total = 0;
        String privilegename = "";
        int enabled = -1;
        String  ordername= "id";
        String order = "asc";

        List<Privilege> privilegeList = new ArrayList<>();
        BootStrapResult<List<Privilege>> result= new BootStrapResult<>();

        try {
            if (StringUtils.notNull(params.get("privilegename"))){
                privilegename = String.valueOf(params.get("privilegename"));
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

            privilegeList = privilegeService.findPrivilegeAll(offset,pageSize,ordername,order,privilegename,enabled);
            if (StringUtils.notNull(params.get("username")) || StringUtils.notNull(params.get("enabled"))){
                //total = accountList.size();
                total = privilegeService.findWhereTotal(ordername,order,privilegename,enabled);
            } else {
                total = privilegeService.findTotal();
            }
            result.setCode(HttpStatus.OK.toString());
            result.setMsg("success");
            result.setData(privilegeList);
            result.setTotal(total);
        }catch (Exception ex){
            result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            result.setMsg("failed");
            result.setData(privilegeList);
            result.setTotal(total);
        }

        return result;
    }
    //根据id查询
    @GetMapping(value = "/privilege/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Privilege> findOne(@PathVariable Long id){
        ResponseResult<Privilege> result = new ResponseResult<>();
        Privilege privilege;
        try {
            privilege = privilegeService.findPrivilegeById(id);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),privilege);
        }catch (ResourceNotFoundException ex){
            logger.info("Account not founded...",ex);
            return ResultUtil.buildErrorResult(ErrorCode.NOT_FOUND.getCode(),ErrorCode.NOT_FOUND.getMessage());
        }
    }
    //创建Account
    @PostMapping(value = "/privilege", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Privilege> createPrivilege(@RequestBody Privilege privilege){
        ResponseResult<Privilege> result = new ResponseResult<>();
        try {
            privilegeService.createPrivilege(privilege);
            return ResultUtil.buildResult(ErrorCode.CREATED.getCode(),ErrorCode.CREATED.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.UNPROCESABLE_ENTITY.getCode(),ErrorCode.UNPROCESABLE_ENTITY.getMessage());
        }
    }
    //修改Account
    @PutMapping(value = "/privilege", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Privilege> updatePrivilege(@RequestBody Privilege privilege){
        ResponseResult<Privilege> result = new ResponseResult<>();
        if (privilege.getId()==null){
            return ResultUtil.buildResult(ErrorCode.NOT_ACCEPTABLE.getCode(),ErrorCode.NOT_ACCEPTABLE.getMessage());
        }
        try {
            privilegeService.updatePrivilegeById(privilege);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
    //修改Account
    @PatchMapping(value = "/privilege", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Privilege> updatePartPrivilege(@RequestBody Privilege privilege){
        ResponseResult<Privilege> result = new ResponseResult<>();
        if (privilege.getId()==null){
            return ResultUtil.buildResult(ErrorCode.NOT_ACCEPTABLE.getCode(),ErrorCode.NOT_ACCEPTABLE.getMessage());
        }
        try {
            privilegeService.updatePrivilegeById(privilege);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
    //删除Account
    @DeleteMapping(value = "/privilege/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Privilege> deletePrivilege(@PathVariable Long id){
        ResponseResult<Privilege> result = new ResponseResult<>();
        try {
            privilegeService.deletePrivilegeById(id);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
}
