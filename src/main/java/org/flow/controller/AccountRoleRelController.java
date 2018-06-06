package org.flow.controller;

import org.flow.pojo.AccountRoleRelationship;
import org.flow.service.AccountRoleRelService;
import org.flow.utils.common.enums.ErrorCode;
import org.flow.utils.common.exception.ResourceNotFoundException;
import org.flow.utils.common.utils.ResponseResult;
import org.flow.utils.common.utils.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

}
