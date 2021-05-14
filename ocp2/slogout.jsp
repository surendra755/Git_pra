<html>
<body bgcolor="#eeffee" TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>
<br><br><br><br><br><br><br><br><br><br><br>
<%
HttpSession ses = request.getSession(false); 
session.removeAttribute("suserid");
ses.invalidate();
%>
<center><h1>SUCCESSFULLY LOGGED OUT!!!</h1><br>
<a href="home.html"><img src="home.jpg"></a></center>
</body>
</html>
