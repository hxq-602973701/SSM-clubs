package com.hyf.controller;

import com.hyf.entity.Link;
import com.hyf.entity.User;
import com.hyf.service.LinkService;
import com.hyf.service.UserService;
import com.hyf.util.NavUtil;
import com.hyf.util.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Controller
public class LinkController {

    @Resource
    private LinkService linkService;

    @RequestMapping(value = "/link", method = RequestMethod.GET)
    public String preSaveLink(final Model model, Link link) {
        if (link.getLinkId() == null) {
            model.addAttribute("navCode", NavUtil.genNewsManageNavigation("友情链接管理", "友情链接添加"));
        } else {
            link = linkService.selectLinkById(link);
            model.addAttribute("link", link);
            model.addAttribute("navCode", NavUtil.genNewsManageNavigation("友情链接管理", "友情链接修改"));
        }
        model.addAttribute("mainPage", "/background/link/linkSave.jsp");
        return "/background/mainTemp";
    }

    @RequestMapping(value = "/linkSave", method = RequestMethod.POST)
    public String SaveLink(final Model model, Link link) {
        if (link.getLinkId() == null) {
            linkService.save(link);
        } else {
            linkService.updateByLinkId(link);
        }
        return "redirect:linkList.do";
    }


    @RequestMapping(value = "/linkList", method = RequestMethod.GET)
    public String LnkList(final Model model) {
        List<Link> linkBackList = linkService.selectAll();
        model.addAttribute("navCode", NavUtil.genNewsManageNavigation("友情链接管理", "友情链接维护"));
        model.addAttribute("linkBackList", linkBackList);
        model.addAttribute("mainPage", "/background/link/linkList.jsp");
        return "/background/mainTemp";
    }

    @RequestMapping(value = "/linkDelete", method = RequestMethod.POST)
    public void LinkDelete(final Model model, Link link, HttpServletResponse response) throws Exception {
        int delNums = linkService.deleteLinkById(link);
        boolean flag;
        if (delNums > 0) {
            flag = true;
        } else {
            flag = false;
        }
        ResponseUtil.write(flag, response);
    }


}
