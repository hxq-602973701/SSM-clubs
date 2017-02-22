package com.hyf.controller;

import com.hyf.util.DateUtil;
import com.hyf.util.PropertiesUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
@Controller
public class FileUploadController {

    @RequestMapping(value = "/imageUpload",method = RequestMethod.GET)
    public void loginOut(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        FileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        try {
            List<FileItem> list=upload.parseRequest(request);
            for(FileItem fileItem:list){
                String imageName= DateUtil.getCurrentDateStr();
                File file=new File(PropertiesUtil.getValue("imagePath")+imageName+"."+fileItem.getName().split("\\.")[1]);
                String newPath=PropertiesUtil.getValue("imageFile")+"/"+imageName+"."+fileItem.getName().split("\\.")[1];
                fileItem.write(file);
                String callback = request.getParameter("CKEditorFuncNum");
                out.println("<script type=\"text/javascript\">");
                out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + newPath + "',''" + ")");
                out.println("</script>");
                out.flush();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
