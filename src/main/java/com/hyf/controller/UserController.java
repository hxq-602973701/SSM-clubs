package com.hyf.controller;

import com.hyf.entity.User;
import com.hyf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String loginUser(final Model model, User user, HttpServletRequest request) {
        User currentUser = userService.login(user);
        model.addAttribute("currentUser",currentUser);
        if(currentUser==null){
            model.addAttribute("error","用户名或者密码错误!");
            return "/background/login";
        }else{
           HttpSession session =  request.getSession();
           session.setAttribute("currentUser",currentUser);
            model.addAttribute("mainPage","/background/default.jsp");
            return "/background/mainTemp";
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request) {
            HttpSession session =  request.getSession();
        session.removeAttribute("currentUser");
            return "/background/login";
    }

}
