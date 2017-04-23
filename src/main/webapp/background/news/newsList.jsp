<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<script type="text/javascript">
	function newsDelete(newsId){
		if(confirm("确认要删除这条信息吗？")){
			$.post("newsDelete.do?action=delete",{newsId:newsId},
					function(delFlag){
						var flag=eval('('+delFlag+')');
						if(flag){
							alert("删除成功!");
							window.location.href="${pageContext.request.contextPath}/newsList.do?action=backList";
						}else{
							alert("删除失败");
						}
					}
			);
		}
	}
//审核
	function newsVerify(newsId){
		$.post("info/check-info.do",{newsId:newsId},
				function(checkFlag){
					var flag=JSON.parse(checkFlag);
					if(flag){
						alert("审核成功！");
						window.location.reload();
					}else{
						alert("审核失败！");
					}
				}
		);
	}
</script>
<body>
<div class="data_list backMain">
	<div class="dataHeader navi">
		${navCode}
	</div>
	<div class="search_content" style="vertical-align: middle;">
		<form action="newsListA.do" method="get">
			信息标题：<input type="text" id="title" name="title" style="width:180px" value="${news.title }"/>&nbsp;&nbsp;
			发布日期：<input type="text" id="s_bPublishDate" name="s_bPublishDate" class="Wdate" onclick="WdatePicker()" style="width: 100px;" value="${news.s_bPublishDate }"/>
			&nbsp;到&nbsp;<input type="text" id="s_aPublishDate" name="s_aPublishDate" class="Wdate" onclick="WdatePicker()" style="width: 100px;" value="${news.s_aPublishDate }"/>
			&nbsp;&nbsp;<button class="btn btn-mini btn-primary" type="submit" style="margin-top: -8px;">查询</button>
		</form>
	</div>
	<div class="data_content">
		<table class="table table-hover table-bordered">
			<tr>
				<th><input type="checkbox" id="checkedAll"/></th>
				<th>序号</th>
				<th>信息标题</th>
				<th>信息类别</th>
				<th>发布时间</th>
				<th>操作</th>
			</tr>
			<c:forEach var="newsBack" items="${newsBackList }" varStatus="status">
				<tr>
					<td><input type="checkbox" name="newsIds" value="${newsBack.newsId}"/></td>
					<td>${status.index+1 }</td>
					<td>${newsBack.title }</td>
					<td>${newsBack.typeName }</td>
					<td><fmt:formatDate value="${newsBack.publishDate }" type="date" pattern="yyyy-MM-dd"/></td>
					<td>
					<button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location.href='newsPre.do?action=preSave&newsId=${newsBack.newsId}'">修改
					</button>&nbsp;<button class="btn btn-mini btn-danger" type="button" onclick="newsDelete(${newsBack.newsId})">删除</button>
					</button>&nbsp;	<input type="button" class="btn btn-mini btn-danger" onclick="newsVerify('${newsBack.newsId}')" value="√通过审核" ${newsBack.state==1?"disabled":"" }/>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div class="pagination pagination-centered">
  		<ul>
  			${pageCode }
  		</ul>
  	</div>
</div>
</body>
</html>