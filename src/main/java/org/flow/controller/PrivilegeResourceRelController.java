package org.flow.controller;

import org.flow.service.PrivilegeResourceRelService;
import org.flow.utils.common.utils.BootStrapResult;
import org.flow.utils.common.utils.HttpUtil;
import org.flow.vo.PriRes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PrivilegeResourceRelController extends BaseController{
    @Resource
    private PrivilegeResourceRelService privilegeResourceRelService;

    //条件查询
    @GetMapping(value = "/prires/pageInfo",produces = { "application/json;charset=UTF-8" })
    public BootStrapResult<List<PriRes>> pageInfo(HttpServletRequest request){
        Map params = HttpUtil.getParams(request);

        List<PriRes> accRoleList = new ArrayList<>();
        BootStrapResult<List<PriRes>> result= new BootStrapResult<>();

        int total = 0;
        try {
            accRoleList = privilegeResourceRelService.findRelPager(params);
            total = privilegeResourceRelService.findWhereTotal(params);
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
}
