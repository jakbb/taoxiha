<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>404</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
</head>      
<body>
<!--common header begin-->
<%--@include file="/pages/user/include/header.jsp" --%>
<!--common header end-->
<!--common content begin-->
<div class="main_wrap">
	<div class="box">
		<div class="title">
			<h2></h2>
		</div>
	  <div class="box_cnt">
	  		<div id="error">
				<img src="${baseStaticUrl}images/android.jpg" alt="" />
				<p>对不起，您所查看的页面未找到【<a href="javascript:history.back();">返回</a>】</p>
			</div>
	  </div>
	</div>
</div>
<!--common content end-->
<!--common footer begin-->
<c:import url="/pages/user/include/footer.jsp"/>
<!--common footer end-->
</body>
</html>
