package com.hyf.controller;


import com.hyf.entity.User;
import com.hyf.service.UserService;
import com.hyf.util.ResponseUtil;
import com.hyf.util.VerifyCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(), user.getPassword());
        Subject subject =  SecurityUtils.getSubject();

        subject.login(token);

        if(currentUser==null){
            model.addAttribute("user",user);
            model.addAttribute("error","用户名或者密码错误!");
            return "/background/login";
        } else if(subject.hasRole("管理员")){
            HttpSession session =  request.getSession();
            session.setAttribute("currentFUser",currentUser);
            model.addAttribute("mainPage","/background/default.jsp");
            return "/background/mainTemp";
        }
        else {
            model.addAttribute("user",user);
            model.addAttribute("error","您没有权限登录后台!");
            return "/background/login";
        }
    }

    @RequestMapping(value = "/loginServlet",method = RequestMethod.POST)
    public String loginForUser(final Model model, User user, HttpServletRequest request) {
        User currentUser = userService.login(user);
        model.addAttribute("currentUser",currentUser);
        String vCode = (String) request.getSession().getAttribute("vCode");
        String reallyCode = vCode.toUpperCase();
        String vCode1 = user.getVerifyCode();
        String reallyvCode = vCode1.toUpperCase();
        if(currentUser==null){
            model.addAttribute("msg","用户名或者密码错误!");
            model.addAttribute("user",user);
            return "/foreground/user/login";
        }else if("".equals(user.getVerifyCode())){
            model.addAttribute("verifyCodeError","验证码不能为空!");
            model.addAttribute("user",user);
            return "/foreground/user/login";
        }else if(!reallyCode.equals(reallyvCode)){
            model.addAttribute("verifyCodeError","验证码错误!");
            model.addAttribute("user",user);
            return "/foreground/user/login";
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", currentUser);
            return "redirect:index.do";
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request) {
            HttpSession session =  request.getSession();
        session.removeAttribute("currentFUser");
            return "/background/login";
    }

    @RequestMapping(value = "/toIndex",method = RequestMethod.GET)
    public String index2(HttpServletRequest request) throws IOException {


        return "/foreground/user/login";
    }

    @RequestMapping(value = "/VerifyCodeServlet",method = RequestMethod.GET)
    public void index2(HttpServletRequest request, HttpServletResponse response,String a) throws IOException {

        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();//获取一次性验证码图片
        // 该方法必须在getImage()方法之后来调用
//		System.out.println(vc.getText());//获取图片上的文本
        VerifyCode.output(image, response.getOutputStream());//把图片写到指定流中

        // 把文本保存到session中，为LoginServlet验证做准备
        request.getSession().setAttribute("vCode", vc.getText());
    }

    @RequestMapping(value = "/UserServlet",method = RequestMethod.POST)
    public void ajaxValidate(User user,Integer type,String verifyCode,HttpServletRequest request,HttpServletResponse response) throws Exception {
       boolean flag = true;
        if(type==1){
             flag = userService.isLogin(user);
            ResponseUtil.write(flag,response);
        }else if(type==2){
             flag = userService.isRegist(user);
            ResponseUtil.write(flag,response);
        }else if(type==3){
          String vCode = (String) request.getSession().getAttribute("vCode");
            String reallyCode = vCode.toUpperCase();
            String reallyVerifyCode = verifyCode.toUpperCase();
            if(reallyCode.equals(reallyVerifyCode)){
                ResponseUtil.write(flag,response);
            }else{
                flag = false;
                ResponseUtil.write(flag,response);
            }
        }
    }

    @RequestMapping(value = "/UserRegister",method = RequestMethod.POST)
    public String regist( Model model,User user,HttpServletRequest request) throws Exception {
        String vCode = (String) request.getSession().getAttribute("vCode");
        String reallyCode = vCode.toUpperCase();
        if(!reallyCode.equals(user.getVerifyCode().toUpperCase())){
            model.addAttribute("error","错误的验证码!");
            model.addAttribute("form",user);
            return "/foreground/user/regist";
        }
        userService.registe(user);
        model.addAttribute("code","success");
        return "/foreground/user/msg";
    }


}
