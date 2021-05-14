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
<td align="center" bgcolor=eeffee>
<h3><i>Check Permissions</i></h3>
<table border=0>
<thead>
<tr><th>reason</th><th>Status</th></tr>
</thead>
<tbody>
<%@ page import="java.sql.*,java.text.*" %>
<%
String s1=" ",s2=" ",s3=" ",s4=" ",s5=" ",s6=" ",apdat=" ";
try
{
	
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");
	Statement st=con.createStatement();
	String uid=(String)session.getAttribute("fuserid");
	ResultSet rs=st.executeQuery("select reason,status from leave where fuserid='"+uid+"' and status!='requested'");
	ResultSetMetaData rd=rs.getMetaData();%>
	
<%	
	while(rs.next())
	{
		s1=rs.getString(1);
		s2=rs.getString(2);
		%>
	<tr>
	<td><%=s1%></td>
	<td><%=s2%></td>
	</tr>
	<% }%>
<%
}
	 catch(Exception e)
	 {
	 }
%>
</tbody>
</table>
</td>
</tr>
</table>
</body>

</html>
