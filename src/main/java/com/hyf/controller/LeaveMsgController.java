package com.hyf.controller;

import com.hyf.entity.Comment;
import com.hyf.entity.Leave;
import com.hyf.service.LeaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Controller
public class LeaveMsgController {

    @Resource
    private LeaveService leaveService;

    @RequestMapping(value = "/leaveMsg",method = RequestMethod.GET)
    public String leaveMsg(final Model model,HttpServletRequest request) {
                List<Leave> leaveList = leaveService.select();
                model.addAttribute("leaveList",leaveList);
                return "/temp/leaveMsg";
    }

    @RequestMapping(value = "/goLeaveMsg",method = RequestMethod.GET)
    public String goLeaveMsg(final Model model, Leave leave, HttpServletRequest request) {

        //发表留言
        leave.setUserIp(request.getRemoteAddr());
        leave.setLeaveDate(new Date());
        leave.setDelFlag(false);
        leaveService.save(leave);
        List<Leave> leaveList = leaveService.select();
        model.addAttribute("leaveList",leaveList);
        return "/temp/leaveMsg";
    }

}
