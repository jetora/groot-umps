package org.flow.controller;

import org.flow.entity.Account;
import org.flow.entity.ResourceTree;
import org.flow.service.ResourceService;
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
public class ResourceController extends BaseController{

    @Resource
    private ResourceService resourceService;

    //查询所有
    @GetMapping(value = "/resource",produces = { "application/json;charset=UTF-8" })
    public ResponseResult<List<org.flow.entity.Resource>> findAll() {
        List<org.flow.entity.Resource> resourceList = new ArrayList<>();
        ResponseResult<List<org.flow.entity.Resource>> result= new ResponseResult<>();
        try {
            resourceList = resourceService.findResourceAll();
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),resourceList);
        }catch (ResourceNotFoundException ex){
            logger.error("Account not found...",ex);
            return ResultUtil.buildErrorResult(ErrorCode.NOT_FOUND.getCode(),ErrorCode.NOT_FOUND.getMessage());
        }
    }
    //条件查询
    @GetMapping(value = "/resource/pageInfo",produces = { "application/json;charset=UTF-8" })
    public BootStrapResult<List<org.flow.entity.Resource>> pageInfo(HttpServletRequest request){
        Map params = HttpUtil.getParams(request);
        //List<Account> accounts =accountService.findAccountAll();
        //int total = accounts.size();
        int total = 0;
        String resource_name = "";
        int resource_type = -1;
        int enabled = -1;
        String  ordername = "id";
        String order = "asc";

        List<org.flow.entity.Resource> resourceList = new ArrayList<>();
        BootStrapResult<List<org.flow.entity.Resource>> result= new BootStrapResult<>();

        try {
            if (StringUtils.notNull(params.get("resource_name"))){
                resource_name = String.valueOf(params.get("resource_name"));
            }
            if (StringUtils.notNull(params.get("resource_type"))){
                resource_type = Integer.parseInt((String)params.get("resource_type"));
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

            resourceList = resourceService.findResourceAll(offset,pageSize,ordername,order,resource_name,resource_type,enabled);
            if (StringUtils.notNull(params.get("resource_name")) || StringUtils.notNull(params.get("resource_type"))|| StringUtils.notNull(params.get("enabled"))){
                //total = accountList.size();
                total = resourceService.findWhereTotal(ordername,order,resource_name,resource_type,enabled);
            } else {
                total = resourceService.findTotal();
            }
            result.setCode(HttpStatus.OK.toString());
            result.setMsg("success");
            result.setData(resourceList);
            result.setTotal(total);
        }catch (Exception ex){
            result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            result.setMsg("failed");
            result.setData(resourceList);
            result.setTotal(total);
        }
        return result;
    }
    @GetMapping(value = "/resourcetree",produces = { "application/json;charset=UTF-8" })
    public ResponseResult<List<ResourceTree>> findOraTree() {
        List<ResourceTree> resourceTrees = new ArrayList<>();
        resourceTrees = resourceService.selecteResourceTree(new Long((long)0));
        return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),resourceTrees);
    }
    @GetMapping(value = "/menutree",produces = { "application/json;charset=UTF-8" })
    public ResponseResult<List<ResourceTree>> findMuneTree() {
        List<ResourceTree> resourceTrees = new ArrayList<>();
        resourceTrees = resourceService.selecteMenuTree(new Long((long)0));
        return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),resourceTrees);
    }
    //根据id查询
    @GetMapping(value = "/resource/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<org.flow.entity.Resource> findOne(@PathVariable Long id){
        ResponseResult<org.flow.entity.Resource> result = new ResponseResult<>();
        org.flow.entity.Resource resource;
        try {
            resource = resourceService.findResourceById(id);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage(),resource);
        }catch (ResourceNotFoundException ex){
            logger.info("Account not founded...",ex);
            return ResultUtil.buildErrorResult(ErrorCode.NOT_FOUND.getCode(),ErrorCode.NOT_FOUND.getMessage());
        }
    }
    //创建Account
    @PostMapping(value = "/resource", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<org.flow.entity.Resource> createAccount(@RequestBody org.flow.entity.Resource resource){
        ResponseResult<org.flow.entity.Resource> result = new ResponseResult<>();
        try {
            resourceService.createResource(resource);
            return ResultUtil.buildResult(ErrorCode.CREATED.getCode(),ErrorCode.CREATED.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.UNPROCESABLE_ENTITY.getCode(),ErrorCode.UNPROCESABLE_ENTITY.getMessage());
        }
    }
    //修改Account
    @PutMapping(value = "/resource", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<org.flow.entity.Resource> updateAccount(@RequestBody org.flow.entity.Resource resource){
        ResponseResult<org.flow.entity.Resource> result = new ResponseResult<>();
        if (resource.getId()==null){
            return ResultUtil.buildResult(ErrorCode.NOT_ACCEPTABLE.getCode(),ErrorCode.NOT_ACCEPTABLE.getMessage());
        }
        try {
            resourceService.updateResourceById(resource);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
    //修改Account
    @PatchMapping(value = "/resource", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<org.flow.entity.Resource> updatePartAccount(@RequestBody org.flow.entity.Resource resource){
        ResponseResult<org.flow.entity.Resource> result = new ResponseResult<>();
        if (resource.getId()==null){
            return ResultUtil.buildResult(ErrorCode.NOT_ACCEPTABLE.getCode(),ErrorCode.NOT_ACCEPTABLE.getMessage());
        }
        try {
            resourceService.updateResourceById(resource);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
    //删除Account
    @DeleteMapping(value = "/resource/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseResult<org.flow.entity.Resource> deleteAccount(@PathVariable Long id){
        ResponseResult<org.flow.entity.Resource> result = new ResponseResult<>();
        try {
            resourceService.deleteResourceById(id);
            return ResultUtil.buildResult(ErrorCode.OK.getCode(),ErrorCode.OK.getMessage());
        }catch (Exception ex){
            logger.info("Account not created...",ex);
            return ResultUtil.buildResult(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
}
