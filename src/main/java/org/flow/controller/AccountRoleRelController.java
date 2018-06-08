package org.flow.controller;

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

    //条件查询
    @GetMapping(value = "/accrole/pageInfo",produces = { "application/json;charset=UTF-8" })
    public BootStrapResult<List<AccountRoleRelationship>> pageInfo(HttpServletRequest request){
        Map params = HttpUtil.getParams(request);
        //List<Account> accounts =accountService.findAccountAll();
        //int total = accounts.size();
        /*
        int total = 0;
        Long accountid = 0L;
        String username = "";
        Long roleid = 0L;
        String rolename = "";
        int enabled = -1;
        String  ordername= "id";
        String order = "asc";
        */
        List<AccRole> accRoleList = new ArrayList<>();
        BootStrapResult<List<AccRole>> result= new BootStrapResult<>();

        //try {
            /*
            if (params.get("accountid")!=null){
                accountid = (Long) params.get("accountid");
            }
            if (StringUtils.notNull(params.get("username"))){
                username = String.valueOf(params.get("username"));
            }
            if (params.get("roleid")!=null){
                roleid = (Long) params.get("roleid");
            }
            if (StringUtils.notNull(params.get("rolename"))){
                rolename = String.valueOf(params.get("rolename"));
            }
            if (StringUtils.notNull(params.get("order"))){
                order = String.valueOf(params.get("order"));
            }
            if (StringUtils.notNull(params.get("ordername"))){
                ordername = String.valueOf(params.get("ordername"));
            }
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            int offset = Integer.parseInt(request.getParameter("offset"));
            */
            accRoleList = accountRoleRelService.findRelPager(params);
            System.out.println("222222222222222222222222");
            System.out.println(accRoleList);
/*
            if (StringUtils.notNull(params.get("username")) || StringUtils.notNull(params.get("enabled"))){
                //total = accountList.size();
                total = accountRoleRelService.findWhereTotal(ordername,order,username,enabled);
            } else {
                total = accountRoleRelService.findTotal();
            }
            result.setCode(HttpStatus.OK.toString());
            result.setMsg("success");
            result.setData(accountList);
            result.setTotal(total);
        }catch (Exception ex){
            result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            result.setMsg("failed");
            result.setData(accountList);
            result.setTotal(total);
        }

        return result;
        */
        return null;
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

}
