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
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<link href="${pageContext.request.contextPath}/style/news.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">

<link href="/js/layui/css/layui.css" rel="stylesheet">
<script src="\js\layui\layui.js"></script>


<style>
    .comment{border-color:transparent;}
</style>
<html>
<head>
    <title>南阳市车友俱乐部</title>
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
        <div class="comment1" style="text-align: center">

        </div>
    </div>
</div>

<div class="publish_list">
        <div>
            <textarea style="display: none;" id="leaveContent" name="leaveContent"></textarea>
        </div>
        <div class="publishButton" style="position:relative;top:20px;">
            <input type="button" id="save" class="btn btn-primary" value="发表留言"/>
            <input type="button" id="canal" class="btn btn-primary"  value="返回"/>
            <%--<button class="btn btn-primary" onclick="go()">发表留言</button>--%>
        </div>
</div>
<script type="application/javascript">
    $(function(){
            var index;
        layui.use('layedit', function(){
            var layedit = layui.layedit;
            index =  layedit.build('leaveContent');//建立编辑器

        });

        $("#canal").on("click",function () {
            window.history.go(-1);
        })

        function getLocalTime(nS) {
            return new Date(parseInt(nS) * 1000000).toLocaleString().replace(/:\d{1,2}$/,' ');
        }

        Date.prototype.toLocaleString = function() {
            return this.getFullYear() + "-" + (this.getMonth() + 1) + "-" + this.getDate() + " " + this.getHours() + ":" + this.getMinutes() + ":" + this.getSeconds() + "";
        };

        $("#save").on("click",function () {
            var data = {};
            var layedit = layui.layedit;

            var leaveContent  = layedit.getContent(index);
            if(!leaveContent){
                alert("留言内容不能为空!")
                return;
            }
            data.leaveContent = leaveContent;
            var dataStr = JSON.stringify(data);
            console.log(data)
            $.ajax({
                url:"/goLeaveMsg.do",
                type:"post",
                data:{dataStr:dataStr},
                dataType:'json',
                success:function(data){
                    console.log(data)
                    var unixTimestamp = new Date(data.leaveDate) ;
                    commonTime = unixTimestamp.toLocaleString();
                    var html = [];
                    html.push('<div>用户IP:'+data.userIp+":"+data.leaveContent+"&nbsp;&nbsp;&nbsp;[&nbsp;"+commonTime+']</div>');

                    $(".comment1").append(html.join(""));
                },
                error:function(e){
                    alert("错误！！");
                }
            });
        })
    })

</script>
</body>
</html>
