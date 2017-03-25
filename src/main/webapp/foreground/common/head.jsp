<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function setDateTime(){
		var date=new Date();
		var day=date.getDay();
		var week;
		switch(day){
			case 0:week="星期日";break;
			case 1:week="星期一";break;
			case 2:week="星期二";break;
			case 3:week="星期三";break;
			case 4:week="星期四";break;
			case 5:week="星期五";break;
			case 6:week="星期六";break;
		}
		var today=date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日  "+week+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
		document.getElementById("today").innerHTML=today;
	}

	window.setInterval("setDateTime()", 1000);

</script>
<div class="row-fluid">
	<div class="span12">
		<img src="${pageContext.request.contextPath}/images/logo1.png" style="text-align: center">
	</div>
	<div class="headRight">
		<font id="today" class="currentDateTime"></font>
	</div>
</div>
<div class="row-fluid">
	<div class="span12">
		<div class="navbar">
		  <div class="navbar-inner">
		    <a class="brand" href="index.do">首页</a>
		    <ul class="nav">
				<c:forEach var="newsType" items="${newsTypeList}">
					<li><a href="news.do?action=list&typeId=${newsType.newsTypeId }">${newsType.typeName }</a></li>
				</c:forEach>
		    </ul>
			  <a class="brand" href="goBack.do">进入后台</a>
			  <a class="brand" href="sendMsg.do">发布信息</a>
			  <a class="brand" href="leaveMsg.do">发布留言</a>
		  </div>
		</div>
	</div>
</div>