<html>
<body bgcolor="#eeffee">
<table border="0" height=25%  width=100% bgcolor="#eeffee" align="center">
<tr height=25% >
<td background="C:\Program Files\Apache Software Foundation\Tomcat 5.5\webapps\anusha\fachome.jpg" colspan="2"  align="right" valign="bottom"><a href="./flogout.jsp"><h3>logout</h3></a></td>
</tr>
</table>
<table width=100%>
<tr>
<td width=25% bgcolor=9999cc>
<table align="center"><br>
<tr align="center"><h3><a href="./upload.html">SendCourseMaterial</h3></a></tr><br>
<tr align="center"><a href="./upload.html"><h3>SendExamPaper</h3></a></tr><br>
<tr align="center"><a href="./viewnewmsg"><h3>DiscussionBoard</h3></a></tr><br>
<tr align="center"><a href="./Vfan"><h3>Annoucement</h3></a></tr><br>
<tr align="center"><a href="./leave.html"><h3>Apply For Leave</h3></a></tr><br>
<tr align="center"><a href="./permi.jsp"><h3>ViewPermissions</h3></a></tr><br>
<tr align="center"><a href="./fachome.html"><h3>Home</h3></a></tr>
</table>
</td>
<td>
<table border="0"  width="100%" cellpadding="3" cellspacing="0" align="center">
<tr>
<td align="center" valign="top"><u><h2>ANNOUNCEMENTS</h2></u></td>
</tr>
<% Integer x=(Integer)request.getAttribute("cnt");
for( int i=0;i<x;i++)
{ %>
<tr>
<td align="center"><%= request.getAttribute("fannouncements["+i+"]")%></td>
</tr>
<% } %>
</table>
</td></tr></table>
</body>
</html>

