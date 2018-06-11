package org.flow.controller;

import org.flow.dto.AccountRoleDTO;
import org.flow.pojo.AccountRoleRelationship;
import org.flow.service.AccountRoleRelService;
import org.flow.utils.common.enums.ErrorCode;
import org.flow.utils.common.exception.ResourceNotFoundException;
import org.flow.utils.common.utils.*;
import org.flow.vo.AccRole;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class AccountRoleRelController extends BaseController{

    @Resource
    private AccountRoleRelService accountRoleRelService;

    //根据id查询
    @GetMapping(value = "/accountrolerel/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<List<AccountRoleRelationship>> findOne(@PathVariable Long id){
        ResponseResult<AccountRoleRelationship> result = new ResponseResult<>();
        List<AccountRoleRelationship> accounts;
        try {
            accounts = accountRoleRelService.findAccountRoleRelByAccountId(id);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),accounts);
        }catch (ResourceNotFoundException ex){
            logger.info("Account not founded...",ex);
            return ResultUtil.buildErrorResult(ErrorCode.NOT_FOUND.getCode(),ErrorCode.NOT_FOUND.getMessage());
        }
    }
    //根据id查询
    @GetMapping(value = "/roleids/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<List<AccountRoleDTO>> findRoleByRelId(@PathVariable Long id){
        ResponseResult<AccountRoleDTO> result = new ResponseResult<>();
        List<AccountRoleDTO> accountRoleDTOS;
        try {
            accountRoleDTOS = accountRoleRelService.findGrantRole(id);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),accountRoleDTOS);
        }catch (ResourceNotFoundException ex){
            logger.info("Account not founded...",ex);
            return ResultUtil.buildErrorResult(ErrorCode.NOT_FOUND.getCode(),ErrorCode.NOT_FOUND.getMessage());
        }
    }

    //条件查询
    @GetMapping(value = "/accrole/pageInfo",produces = { "application/json;charset=UTF-8" })
    public BootStrapResult<List<AccRole>> pageInfo(HttpServletRequest request){
        Map params = HttpUtil.getParams(request);

        List<AccRole> accRoleList = new ArrayList<>();
        BootStrapResult<List<AccRole>> result= new BootStrapResult<>();

        int total = 0;
        try {
            accRoleList = accountRoleRelService.findRelPager(params);
            //if (StringUtils.notNull(params.get("username")) || StringUtils.notNull(params.get("enabled"))){
            //    total = accountRoleRelService.findWhereTotal(ordername,order,username,enabled);
            //} else {
            //    total = accountRoleRelService.findTotal();
           // }
            total = accountRoleRelService.findWhereTotal(params);
            //total = accRoleList.size();
            result.setCode(HttpStatus.OK.toString());
            result.setMsg("success");
            result.setData(accRoleList);
            result.setTotal(total);
        }catch (Exception ex){
            logger.error("internal error...",ex);
            result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            result.setMsg("failed");
            result.setData(accRoleList);
            result.setTotal(total);
        }

        return result;
    }

    @GetMapping(value = "/accrole", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<List<AccRole>> findRelAll(){
        ResponseResult<AccRole> result = new ResponseResult<>();
        List<AccRole> accRoles;
        try {
            accRoles = accountRoleRelService.findRelAll();
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),accRoles);
        }catch (ResourceNotFoundException ex){
            logger.info("Account not founded...",ex);
            return ResultUtil.buildErrorResult(ErrorCode.NOT_FOUND.getCode(),ErrorCode.NOT_FOUND.getMessage());
        }
    }

    @GetMapping(value = "/grantedrole", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<List<AccRole>> findGrantRole(){
        ResponseResult<AccRole> result = new ResponseResult<>();
        List<AccRole> accRoles;
        try {
            accRoles = accountRoleRelService.findRelAll();
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),accRoles);
        }catch (ResourceNotFoundException ex){
            logger.info("Account not founded...",ex);
            return ResultUtil.buildErrorResult(ErrorCode.NOT_FOUND.getCode(),ErrorCode.NOT_FOUND.getMessage());
        }
    }

}
