package com.hyf.util;

public class NavUtil {

    public static String genNewsListNavigation(String typeName, int typeId) {
        StringBuffer navCode = new StringBuffer();
        navCode.append("当前位置>&nbsp;&nbsp;");
        navCode.append("<a href='welcome.jsp'>主页</a>&nbsp;&nbsp;>&nbsp;&nbsp;");
        navCode.append("<a href='news.do?action=list&typeId=" + typeId + "'>" + typeName + "</a>");
        return navCode.toString();
    }

    public static String genNewsNavigation(String typeName, String typeId, String newsName) {
        StringBuffer navCode = new StringBuffer();
        navCode.append("当前位置>&nbsp;&nbsp;");
        navCode.append("<a href='index.do'>主页</a>&nbsp;&nbsp;>&nbsp;&nbsp;");
        navCode.append("<a href='news.do?action=list&typeId=" + typeId + "'>" + typeName + "</a>&nbsp;&nbsp;>&nbsp;&nbsp;" + newsName);
        return navCode.toString();
    }

    public static String genNewsManageNavigation(String modName, String actionName) {
        StringBuffer navCode = new StringBuffer();
        navCode.append("当前位置>&nbsp;&nbsp;");
        navCode.append("主页&nbsp;&nbsp;>&nbsp;&nbsp;");
        navCode.append(modName + "&nbsp;&nbsp;>&nbsp;&nbsp;");
        navCode.append(actionName + "&nbsp;&nbsp;");
        return navCode.toString();
    }

}
