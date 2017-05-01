<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/foreground/user/css/regist.css'/>">

    <script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
	<script type="text/javascript" src="<c:url value='/foreground/user/js/regist.js'/>"></script>
  </head>
  
  <body>
<div id="divMain">
  <div id="divTitle" style="margin-left: 282px;">
    <span id="spanTitle">新用户注册</span>
  </div>
  <div id="divBody" style="margin-left: 282px;">
<form action="<c:url value='/UserRegister.do'/>" method="post" id="registForm">
	<input type="hidden" name="method" value="regist"/>  
    <table id="tableForm">
      <tr>
        <td class="tdText">用户名：</td>
        <td class="tdInput">
          <input class="inputClass" type="text" name="userName" id="loginname" value="${form.userName }"/>
        </td>
        <td class="tdError">
          <label class="errorClass" id="loginnameError">${errors.loginname }</label>
        </td>
      </tr>
      <tr>
        <td class="tdText">登录密码：</td>
        <td>
          <input class="inputClass" type="password" name="password" id="loginpass" value="${form.password }"/>
        </td>
        <td>
          <label class="errorClass" id="loginpassError">${errors.loginpass }</label>
        </td>
      </tr>
      <tr>
        <td class="tdText">确认密码：</td>
        <td>
          <input class="inputClass" type="password" name="reloginpass" id="reloginpass" value="${form.reloginpass }"/>
        </td>
        <td>
          <label class="errorClass" id="reloginpassError">${errors.reloginpass}</label>
        </td>
      </tr>
      <tr>
        <td class="tdText">Email：</td>
        <td>
          <input class="inputClass" type="text" name="email" id="email" value="${form.email }"/>
        </td>
        <td>
          <label class="errorClass" id="emailError">${errors.email}</label>
        </td>
      </tr>
      <tr>
        <td class="tdText">验证码：</td>
        <td>
          <input class="inputClass" type="text" name="verifyCode" id="verifyCode" value="${form.verifyCode }"/>
        </td>
        <td>
          <label class="errorClass" id="verifyCodeError">${errors.verifyCode}${error}</label>
        </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <div id="divVerifyCode"><img id="imgVerifyCode" src="<c:url value='/VerifyCodeServlet.do'/>"/></div>
        </td>
        <td>
          <label><a href="javascript:_hyz()">换一张</a></label>
        </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <input type="image" src="<c:url value='/foreground/user/images/regist1.jpg'/>" id="submitBtn"/>
        </td>
        <td>
          <label></label>
        </td>
      </tr>
    </table>
</form>    
  </div>
</div>
  </body>
</html>
