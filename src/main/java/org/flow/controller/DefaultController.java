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

    @GetMapping("/accountmanage")
    public String AccountManage(){
        return "accountmanage";
    }

}
