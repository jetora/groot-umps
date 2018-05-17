package org.flow.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import org.flow.entity.Account;
import org.flow.service.AccountService;
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
public class AccountController extends BaseController{

    @Resource
    private AccountService accountService;

    //查询所有
    @GetMapping(value = "/account",produces = { "application/json;charset=UTF-8" })
    public ResponseResult<List<Account>> findAll() {
        List<Account> accountList = new ArrayList<>();
        ResponseResult<List<Account>> result= new ResponseResult<>();
        try {
            accountList = accountService.findAccountAll();
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),accountList);
        }catch (ResourceNotFoundException ex){
            logger.error("Account not found...",ex);
           return ResultUtil.buildErrorResult(ErrorCode.NOT_FOUND.getCode(),ErrorCode.NOT_FOUND.getMessage());
        }
    }
    //条件查询
    @GetMapping(value = "/pageInfo",produces = { "application/json;charset=UTF-8" })
    public BootStrapResult<List<Account>> pageInfo(HttpServletRequest request){

        System.out.println("111111111111111111");
        Map params = HttpUtil.getParams(request);
        List<Account> accounts =accountService.findAccountAll();
        int total = accounts.size();

        //int pageNum = params.get("pageNum");
        //int pageSize = params.get("pageSize");
        //if (StringUtils.notNull(request.getParameter("pageSize")) && StringUtils.notNull(request.getParameter("offset"))) {
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int offset = Integer.parseInt(request.getParameter("offset"));
        //PageHelper.startPage(offset,pageSize);
        //}

        List<Account> accountList = new ArrayList<>();
        BootStrapResult<List<Account>> result= new BootStrapResult<>();

        accountList = accountService.findAccountAll(offset,pageSize);

        result.setCode(HttpStatus.OK.toString());
        result.setMsg("success");
        result.setData(accountList);
        result.setTotal(total);
        return result;
    }
    //根据id查询
    @GetMapping(value = "/account/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Account> findOne(@PathVariable Long id){
        ResponseResult<Account> result = new ResponseResult<>();
        Account account;
        try {
            account = accountService.findAccountById(id);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),account);
        }catch (ResourceNotFoundException ex){
            logger.info("Account not founded...",ex);
            return ResultUtil.buildErrorResult(ErrorCode.NOT_FOUND.getCode(),ErrorCode.NOT_FOUND.getMessage());
        }
    }
    //创建Account
    @PostMapping(value = "/account", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Account> createAccount(@RequestBody Account account){
        ResponseResult<Account> result = new ResponseResult<>();
        try {
            accountService.createAccount(account);
            return ResultUtil.buildResult(ErrorCode.CREATED.getCode(),ErrorCode.CREATED.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.UNPROCESABLE_ENTITY.getCode(),ErrorCode.UNPROCESABLE_ENTITY.getMessage());
        }
    }
    //修改Account
    @PutMapping(value = "/account", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Account> updateAccount(@RequestBody Account account){
        ResponseResult<Account> result = new ResponseResult<>();
        if (account.getId()==null){
            return ResultUtil.buildResult(ErrorCode.NOT_ACCEPTABLE.getCode(),ErrorCode.NOT_ACCEPTABLE.getMessage());
        }
        try {
            accountService.updateAccountById(account);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
    //修改Account
    @PatchMapping(value = "/account", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Account> updatePartAccount(@RequestBody Account account){
        ResponseResult<Account> result = new ResponseResult<>();
        if (account.getId()==null){
            return ResultUtil.buildResult(ErrorCode.NOT_ACCEPTABLE.getCode(),ErrorCode.NOT_ACCEPTABLE.getMessage());
        }
        try {
            accountService.updateAccountById(account);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
    //删除Account
    @DeleteMapping(value = "/account/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Account> deleteAccount(@PathVariable Long id){
        ResponseResult<Account> result = new ResponseResult<>();
        try {
            accountService.deleteAccountById(id);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
}
