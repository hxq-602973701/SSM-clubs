<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="/js/layui/css/layui.css" rel="stylesheet">
<script src="\js\layui\layui.js"></script>
<div class="data_list">
	<div class="dataHeader navi">
		${navCode}
	</div>
	<div>
		<div class="news_title"><h3>${news.title }</h3></div>
		<div class="news_info">
			发布时间：[<fmt:formatDate value="${news.publishDate }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>]&nbsp;&nbsp;作者：${news.author }
			&nbsp;&nbsp;车友动态类别：[${news.typeName }]&nbsp;&nbsp;阅读次数：${news.click }
		</div>
		<div class="news_content">
			${news.content }
		</div>
	</div>
	<div class="upDownPage">
		${pageCode }
	</div>
</div>

<div class="data_list comment_list">
    <div class="dataHeader">用户评论</div>
    <div class="commentDatas">
        <c:forEach var="comment" items="${commentList }">
            <div class="comment">
                <font>${comment.userIP }：</font>${comment.content }&nbsp;&nbsp;&nbsp;[&nbsp;<fmt:formatDate value="${comment.commentDate }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;]
            </div>
        </c:forEach>
    </div>
    <div class="comment1">
    </div>
</div>

<div class="publish_list">
    <form action="comment.do?action=save" method="get">
        <div>
            <input type="hidden" value="${news.newsId }" id="newsId" name="newsId"/>
            <textarea style="width: 98%" rows="3" id="content" name="content"></textarea>
        </div>
        <div class="publishButton">
            <input type="button" id="save" class="btn btn-primary" value="发表评论"/>
            <%--<button class="btn btn-primary" type="submit">发表评论</button>--%>
        </div>
    </form>
</div>
<script type="application/javascript">
    $(function(){
        var index;
        layui.use('layedit', function(){
            var layedit = layui.layedit;
            index =  layedit.build('content');//建立编辑器

        });

        Date.prototype.toLocaleString = function() {
            return this.getFullYear() + "-" + (this.getMonth() + 1) + "-" + this.getDate() + " " + this.getHours() + ":" + this.getMinutes() + ":" + this.getSeconds() + "";
        };

        $("#save").on("click",function () {
            var data = {};
            var layedit = layui.layedit;

            var leaveContent  = layedit.getContent(index);
            if(!leaveContent){
                alert("评论内容不能为空!")
                return;
            }
            data.content = leaveContent;
            data.newsId = '${news.newsId }';
            var dataStr = JSON.stringify(data);
            $.ajax({
                url:"/comment.do",
                type:"post",
                data:{dataStr:dataStr},
                dataType:'json',
                success:function(data){
                    console.log(data)
                    var unixTimestamp = new Date(data.commentDate) ;
                    commonTime = unixTimestamp.toLocaleString();
                    var html = [];
                    html.push('<div>用户IP:'+data.userIP+":"+data.content+"&nbsp;&nbsp;&nbsp;[&nbsp;"+commonTime+']</div>');

                    $(".comment1").append(html.join(""));
                },
                error:function(e){
                    alert("错误！！");
                }
            });
        })
    })
</script>