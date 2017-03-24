<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/13 0013
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="${pageContext.request.contextPath}/style/news.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<style>
    .comment{border-color:transparent;}
</style>
<html>
<head>
    <title>Title</title>
</head>
<body style="width:1100px;margin:0 auto;">
<div class="data_list comment_list" style="border-color:transparent;">
    <div class="dataHeader" style="border-color:transparent;">用户留言</div>
    <div class="commentDatas" style="border-color:transparent;">
        <div class="comment" style="text-align: center">
            <c:forEach var="comment" items="${leaveList }">
                <div class="comment">
                   用户IP： <font>${comment.userIp }：</font>${comment.leaveContent }&nbsp;&nbsp;&nbsp;[&nbsp;<fmt:formatDate value="${comment.leaveDate }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;]
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<div class="publish_list">
    <form action="goLeaveMsg.do" method="get">

        <div style="height:200px;">
            <textarea style="width: 98%" rows="10" id="leaveContent" name="leaveContent"></textarea>
        </div>
        <div class="publishButton" style="position:relative;top:20px;">
            <button class="btn btn-primary" onclick="go()">发表留言</button>
        </div>
    </form>
</div>
<script type="application/javascript">
    function go(){
        var data = {};
        data.leaveTitle = $("#leaveTitle").val();
        data.leaveContent = $("#leaveContent").val();

        $.ajax({
            url:"/goLeaveMsg.do",
            type:"post",
            data:data,
            processData:false,
            contentType:true,
            success:function(data){
                console.log("over..");
//                $(".comment").append(data);
            },
            error:function(e){
                alert("错误！！");
            }
        });
    }
</script>
</body>
</html>
