package org.flow.controller;

import org.flow.entity.Account;
import org.flow.service.AccountService;
import org.flow.utils.common.enums.ErrorCode;
import org.flow.utils.common.exception.ResourceNotFoundException;
import org.flow.utils.common.utils.ResponseResult;
import org.flow.utils.common.utils.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class LoginController extends BaseController {
    @Resource
    private AccountService accountService;

    //根据username查询
    //@PostMapping(value = "/logincheck", produces = { "application/json;charset=UTF-8" })
    @RequestMapping(value = "/logincheck", method = RequestMethod.POST)
    //public ResponseResult<Account> findOneByName(@RequestParam("username") String username,@RequestParam("password") String password){
    public ResponseResult<Account> findOneByName(@RequestBody Account req,Model model){
        ResponseResult<Account> result = new ResponseResult<>();
        Account account;
        try {
            account = accountService.findAccountByName(req.getUsername());
            if (account!=null && req.getPassword().equals(account.getPassword())){
                return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),account);
            }else if (account!=null && !req.getPassword().equals(account.getPassword())){
                return ResultUtil.buildResult(ErrorCode.UNAUTHORIZED.getCode(),"密码错误");
            }else {
                return ResultUtil.buildResult(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
            }
        }catch (ResourceNotFoundException ex){
            logger.info("Account not founded...",ex);
            return ResultUtil.buildErrorResult(ErrorCode.NOT_FOUND.getCode(),ErrorCode.NOT_FOUND.getMessage());
        }
    }
}
