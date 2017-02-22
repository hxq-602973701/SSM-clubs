package com.hyf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Controller
public class GoBackController {

    @RequestMapping(value = "/goBack",method = RequestMethod.GET)
    public String goBack(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("currentUser")!=null){
            return "/background/mainTemp";
        }else{
            return "/background/login";
        }

    }

}
