<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>没有权限</title>
<style type="text/css">
<!--
body {
	text-align:center;
	margin:0 auto;
}
#border_right {
	height: 404px;
	width: 10px;
	float: left;
	background-image: url(../images/borderright_bg.gif);
}
#cener_top {
	height: 112px;
	width: 914px;
}

body>div {
	margin:0 auto;
	text-align:center;
}
a {
    border:none;
}
#main_body {
	height: 404px;
	width: 934px;
	margin-top: 70px;
}
#border_left {
	float: left;
	height: 404px;
	width: 10px;
	background-image: url(../images/borderleft_bg.gif);
}
#mainbody_center {
	float: left;
	height: 400px;
	width: 914px;
	border-top-width: 2px;
	border-bottom-width: 2px;
	border-top-style: solid;
	border-bottom-style: solid;
	border-top-color: #CCC;
	border-bottom-color: #CCC;
	background-image: url(../images/body_BG.gif);
	background-repeat: no-repeat;
	background-position: 580px 34px;
}
#face {
	float: left;
	height: 112px;
	width: 170px;
	background-image: url(../images/face.gif);
}
#top_center {
	float: left;
	height: 110px;
	width: 640px;
	font-family: "微软雅黑";
	font-size: 24px;
	color: #666;
	text-align: left;
	line-height: 180px;
	border-bottom-width: 2px;
	border-bottom-style: solid;
	border-bottom-color: #999;
}
#mainbody_bottom {
	float: left;
	height: 272px;
	width: 784px;
	text-align: left;
	padding-left: 130px;
	padding-top: 16px;
}

-->
</style>
</head>

<body>
<%
	  request.setAttribute("path",request.getContextPath());
	%>
<div id="main_body">
  <div id="border_left"></div>
  <div id="mainbody_center">
    <div id="cener_top">
      <div id="face"></div>
      <div id="top_center">抱歉，您没有权限访问当前页面</div>
    </div>
    <div id="mainbody_bottom"><img src="${path}/images/centerbottomBG.gif" width="420" height="250" border="0" usemap="#Map" />
<map name="Map" id="Map"><area shape="rect" coords="93,97,141,119" onclick="parent.location.reload(true);" />
<area shape="rect" coords="253,148,379,189" onclick="parent.location.href='login.jsp'" /></map></div>
  </div>
  <div id="border_right"></div>
</div>
</body>
</html>