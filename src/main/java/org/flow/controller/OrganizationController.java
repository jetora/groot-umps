package org.flow.controller;

import org.flow.entity.Organization;
import org.flow.entity.OrganizationTree;
import org.flow.service.OrganizationService;
import org.flow.utils.common.enums.ErrorCode;
import org.flow.utils.common.exception.ResourceNotFoundException;
import org.flow.utils.common.utils.ResponseResult;
import org.flow.utils.common.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrganizationController extends BaseController{

    @Resource
    private OrganizationService organizationService;
    //查询所有
    @GetMapping(value = "/organization",produces = { "application/json;charset=UTF-8" })
    public ResponseResult<List<Organization>> findAll() {
        List<Organization> organizationList = new ArrayList<>();
        ResponseResult<List<Organization>> result= new ResponseResult<>();
        try {
            organizationList = organizationService.findOrganizationAll();
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),organizationList);
        }catch (ResourceNotFoundException ex){
            logger.error("Account not found...",ex);
            return ResultUtil.buildErrorResult(ErrorCode.NOT_FOUND.getCode(),ErrorCode.NOT_FOUND.getMessage());
        }
    }
    @GetMapping(value = "/organizationtree",produces = { "application/json;charset=UTF-8" })
    public ResponseResult<List<OrganizationTree>> findOraTree() {
        List<OrganizationTree> orgTree = new ArrayList<>();
        orgTree = organizationService.selectOrganiationTree(new Long((long)0));
        return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),orgTree);
    }
    //根据id查询
    @GetMapping(value = "/organization/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Organization> findOne(@PathVariable Long id){
        ResponseResult<Organization> result = new ResponseResult<>();
        Organization organization;
        try {
            organization = organizationService.findOrganizationById(id);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),organization);
        }catch (ResourceNotFoundException ex){
            logger.info("Account not founded...",ex);
            return ResultUtil.buildErrorResult(ErrorCode.NOT_FOUND.getCode(),ErrorCode.NOT_FOUND.getMessage());
        }
    }
    //创建Account
    @PostMapping(value = "/organization", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Organization> createAccount(@RequestBody Organization organization){
        ResponseResult<Organization> result = new ResponseResult<>();
        try {
            organizationService.createOrganization(organization);
            return ResultUtil.buildResult(ErrorCode.CREATED.getCode(),ErrorCode.CREATED.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.UNPROCESABLE_ENTITY.getCode(),ErrorCode.UNPROCESABLE_ENTITY.getMessage());
        }
    }
    //修改Account
    @PutMapping(value = "/organization", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Organization> updateAccount(@RequestBody Organization organization){
        ResponseResult<Organization> result = new ResponseResult<>();
        if (organization.getId()==null){
            return ResultUtil.buildResult(ErrorCode.NOT_ACCEPTABLE.getCode(),ErrorCode.NOT_ACCEPTABLE.getMessage());
        }
        try {
            organizationService.updateOrganizationById(organization);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
    //修改Account
    @PatchMapping(value = "/organization", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Organization> updatePartAccount(@RequestBody Organization organization){
        ResponseResult<Organization> result = new ResponseResult<>();
        if (organization.getId()==null){
            return ResultUtil.buildResult(ErrorCode.NOT_ACCEPTABLE.getCode(),ErrorCode.NOT_ACCEPTABLE.getMessage());
        }
        try {
            organizationService.updateOrganizationById(organization);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
    //删除Account
    @DeleteMapping(value = "/organization/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<Organization> deleteAccount(@PathVariable Long id){
        ResponseResult<Organization> result = new ResponseResult<>();
        try {
            organizationService.deleteOrganizationById(id);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
}
