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
<td  valign="left">
&nbsp;
<center><h1>Course Material</h1></center>
<table border="0"  width="100%" cellpadding="3" cellspacing="0" align="center">
<tr>
<th ><u><h4>courseid</h4></u></th>
<th align="left"><u><h4>topic</h4></u></th>
</tr>
<% Integer x=(Integer)request.getAttribute("cnt");
for( int i=0;i<x;i++)
{ %>
<tr >
<td align="center"><%= request.getAttribute("newcid["+i+"]")%></td>
<td ><a href="<%= request.getAttribute("finame["+i+"]")%>" target="_blank">
<%= request.getAttribute("newtopic["+i+"]")%></a></td>
</tr>
<% }
%>
</table>
</td></tr>
</FORM></table>

</body></html>