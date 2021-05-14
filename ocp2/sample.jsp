<%!String msg="hello";%>
<%
msg=request.getAttribute("x")+request.getParameter("aa");
%>
<%=msg%>
<%request.setAttribute("x",msg);%>
<html>
<head>

</head>
<body>
<form name="f1" action="sample.jsp" onsubmit="fun()">
<textarea name="aa"></textarea><br>

<input type="Submit">
</form>
</body>
</html>
