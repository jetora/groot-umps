package org.flow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController extends BaseController {

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/fixed_footer")
    public String plainPage(){
        return "/fixed_footer";
    }

    @GetMapping("/account")
    public String AccountManage(){
        return "account/account";
    }

    @GetMapping("/role")
    public String RoleManage(){
        return "role/role";
    }

    @GetMapping("/resource")
    public String ResourceManage(){
        return "resource/resource";
    }

    @GetMapping("/organization")
    public String OrganizationManage(){
        return "organization/organization";
    }

    @GetMapping("/orgman")
    public String OrgMan(){
        return "organization/orgman";
    }

    @GetMapping("/orgtree")
    public String OrgTree(){
        return "organization/orgtree";
    }

    @GetMapping("/demo")
    public String demo(){
        return "demo";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public String home(){
        return "home/home";
    }
}
