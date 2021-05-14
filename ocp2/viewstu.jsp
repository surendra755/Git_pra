<html>
<head>
</head>
<body bgcolor="#eeffee">
<table border="0"  height=25%  width=100% bgcolor="#eeffee" align="center">
<tr>
<td background="C:\Program Files\Apache Software Foundation\Tomcat 5.5\webapps\anusha\studhome.jpg" colspan="2"  align="right" valign="bottom"><a href="./slogout.jsp"><h3>logout</h3></a></td>
</tr>
</table>
<table width=100%>
<tr>
<td width=25% bgcolor=9999cc>
<table align="center"><br><br>
<tr align="center"><h3><a href="./download">CourseMaterial</h3></a></tr><br>
<tr align="center"><a href="./exampaper.html"><h3>Exam Paper</h3></a></tr><br>
<tr align="center"><a href="./viewnewmsg "><h3>DiscussionBoard</h3></a></tr><br>
<tr align="center"><a href="./feedback.html"><h3>FeedBack</h3></a></tr><br>
<tr align="center"><a href="./Vsan"><h3>Announcements</h3></a></tr><br>
<tr align="center"><a href="./stuhome.html"><h3>Home</h3></a></tr>
</table>
</td>
<td>
<table border="0"  width="10%" cellpadding="3" cellspacing="0" align="center">
<tr valign="top">
<td align="center"><u><h2>ANNOUNCEMENTS</h2></u></td>
</tr>
<% Integer x=(Integer)request.getAttribute("cnt");
for( int i=0;i<x;i++)
{ %>
<tr>
<td align="center"><%= request.getAttribute("sannouncements["+i+"]")%><br></td>
</tr>
<% } %>
</table>
</td>
</tr>
</table>
</form>
</td></tr></table>
</body></html>



