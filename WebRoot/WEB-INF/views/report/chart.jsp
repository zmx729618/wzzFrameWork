<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="${ctx}/static/amcharts/swfobject.js"></script>
	</head>
	<body>
	<div id="report1Content"></div>

	<script type="text/javascript">
	// <![CDATA[
	var so = new SWFObject("${ctx}/static/amcharts/amline.swf", "report1", "640","420", "8", "#FFFFFF");
	so.addVariable("settings_file",encodeURIComponent("${ctx}/static/amcharts/report1-settings.xml"));
	so.addVariable("data_file",encodeURIComponent("${ctx}/chart/data"));
	so.write("report1Content");
	// ]]>
</script>
	</body>
</html>