<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">

    function reloadyemian()//最好不要用reload这个关键字,因为很容易和其它函数冲突
    {
        window.location.href="welcome.jsp";
    }
    window.setTimeout("reloadyemian();",3000);
</script>
<div align="center" style="padding-top: 30px;font-size: 20px;"><font color="red">信息发布成功，等待审核通过后才能正常显示！</font></div>
</br><div align="center" style="padding-bottom: 30px;font-size: 20px;"><font color="red">三秒后自动跳转...</font></div>
</body>

</html>