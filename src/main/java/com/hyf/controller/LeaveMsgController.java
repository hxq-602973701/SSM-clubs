package com.hyf.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyf.entity.Comment;
import com.hyf.entity.Leave;
import com.hyf.service.LeaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Controller
public class LeaveMsgController {

    private static ObjectMapper objectMapper = new ObjectMapper();
    @Resource
    private LeaveService leaveService;

    @RequestMapping(value = "/leaveMsg",method = RequestMethod.GET)
    public String leaveMsg(final Model model,HttpServletRequest request) {
        Leave leave = new Leave();
                List<Leave> leaveList = leaveService.select(leave);
                model.addAttribute("leaveList",leaveList);
                return "/temp/leaveMsg";
    }

    @RequestMapping(value = "/goLeaveMsg",method = RequestMethod.POST)
    @ResponseBody
    public Leave goLeaveMsg(final Model model, String dataStr, HttpServletRequest request) throws IOException {

        Leave leave =  objectMapper.readValue(dataStr,Leave.class);
        //发表留言
        leave.setUserIp(request.getRemoteAddr());
        leave.setLeaveDate(new Date());
        leave.setDelFlag(false);
        leaveService.save(leave);
        Leave currentLeave = leaveService.selectBycurrent(leave);
        return currentLeave;
    }

}
