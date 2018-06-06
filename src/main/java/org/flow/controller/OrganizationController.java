package org.flow.controller;

import org.flow.pojo.Organization;
import org.flow.pojo.OrganizationTree;
import org.flow.service.OrganizationService;
import org.flow.utils.common.enums.ErrorCode;
import org.flow.utils.common.exception.ResourceNotFoundException;
import org.flow.utils.common.utils.*;
import org.flow.vo.OrganizationVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
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
    //条件查询
    /*
    @GetMapping(value = "/organization/pageInfo",produces = { "application/json;charset=UTF-8" })
    public BootStrapResult<List<Organization>> pageInfo(HttpServletRequest request){
        Map params = HttpUtil.getParams(request);
        //List<Account> accounts =accountService.findAccountAll();
        //int total = accounts.size();
        int total = 0;
        String search_org_name = "";
        Long search_org_id = 0L;
        int enabled = -1;
        String  ordername= "id";
        String order = "asc";

        List<Organization> organizationList = new ArrayList<>();
        BootStrapResult<List<Organization>> result= new BootStrapResult<>();

        try {
            if (StringUtils.notNull(params.get("search_org_name"))){
                search_org_name = String.valueOf(params.get("name"));
            }
            if (StringUtils.notNull(params.get("search_org_id"))){
                search_org_id = Long.parseLong((String)params.get("organizationId"));
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

            organizationList = organizationService.findOrganizationAll(offset,pageSize,ordername,order,search_org_name,search_org_id,enabled);
            if (StringUtils.notNull(params.get("username")) || StringUtils.notNull(params.get("enabled"))){
                //total = accountList.size();
                total = organizationService.findWhereTotal(ordername,order,search_org_name,search_org_id,enabled);
            } else {
                total = organizationService.findTotal();
            }
            result.setCode(HttpStatus.OK.toString());
            result.setMsg("success");
            result.setData(organizationList);
            result.setTotal(total);
        }catch (Exception ex){
            result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            result.setMsg("failed");
            result.setData(organizationList);
            result.setTotal(total);
        }

        return result;
    }*/
    @GetMapping(value = "/organization/pageInfo",produces = { "application/json;charset=UTF-8" })
    public BootStrapResult<List<Organization>> pageInfo(OrganizationVO organizationVO){
        int total = 0;
        String search_org_name = "";
        Long search_org_id = 0L;
        int enabled = -1;
        String  ordername= "id";
        String order = "asc";

        List<Organization> organizationList = new ArrayList<>();
        BootStrapResult<List<Organization>> result= new BootStrapResult<>();

        try {
            if (StringUtils.notNull(organizationVO.getName())){
                search_org_name = String.valueOf(organizationVO.getName());
            }
            if (organizationVO.getOrganizationId()!=null){
                search_org_id = organizationVO.getOrganizationId();
            }
            if (organizationVO.getEnabled()!=null){
                enabled = organizationVO.getEnabled().intValue();
            }
            if (StringUtils.notNull(organizationVO.getOrder())){
                order = String.valueOf(organizationVO.getOrder());
            }
            if (StringUtils.notNull(organizationVO.getOrdername())){
                ordername = String.valueOf(organizationVO.getOrdername());
            }
            int pageSize = organizationVO.getPageSize();
            int offset = organizationVO.getOffset();

            organizationList = organizationService.findOrganizationAll(offset,pageSize,ordername,order,search_org_name,search_org_id,enabled);
            if (StringUtils.notNull(organizationVO.getName()) || organizationVO.getOrganizationId()!=null ||organizationVO.getEnabled()!=null){
                //total = accountList.size();
                total = organizationService.findWhereTotal(ordername,order,search_org_name,search_org_id,enabled);
            } else {
                total = organizationService.findTotal();
            }
            result.setCode(HttpStatus.OK.toString());
            result.setMsg("success");
            result.setData(organizationList);
            result.setTotal(total);
        }catch (Exception ex){
            result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            result.setMsg("failed");
            result.setData(organizationList);
            result.setTotal(total);
        }

        return result;
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
