<html>
<body bgcolor="#CCCCCC" TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>
<%
HttpSession ses = request.getSession(false); 
session.removeAttribute("fuserid");
ses.invalidate();
%>
<b><center>SUCCESSFULLY LOGGED OUT!!!</center></b>
</body>
</html>
