<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyCRM</title>
    <link href="<c:url value='/jquery-ui-1.12.0/jquery-ui.min.css'/>" type="text/css" rel="stylesheet">
    <link href="<c:url value='/jtable.2.4.0/themes/metro/blue/jtable.min.css'/>" type="text/css" rel="stylesheet">
    <link href="<c:url value='/css/main.css'/>" type="text/css" rel="stylesheet">
</head>
<body>


<h2>Welcome to MyCRM</h2>

<div id="MyTableContainer"></div>

</body>
<script type='text/javascript' src="<c:url value='/js/jquery-3.4.1.min.js'/>"></script>
<script type='text/javascript' src="<c:url value='/jquery-ui-1.12.0/jquery-ui.min.js'/>"></script>
<script type='text/javascript' src="<c:url value='/jtable.2.4.0/jquery.jtable.js'/>"></script>
<script type='text/javascript' src="<c:url value='/js/main.js'/>"></script>
</html>
