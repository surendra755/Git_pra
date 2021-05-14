<html>
<script language="Javascript">
function submitOne() { 
	
	document.f2.action="./acccou";
                        document.f2.submit();
						return true;
						}
 
 function submitTwo() { document.f2.action="./rejcou";
                        document.f2.submit(); }
 
</script>
<body bgcolor=eeffee>
<table border="0" height=22%  width=100% align="center" bgcolor=eeffee>
<tr>
<td colspan="3" background="C:\Program Files\Apache Software Foundation\Tomcat 5.5\webapps\anusha\adminhome.jpeg" align="right" valign="bottom"><a href="./alogout.jsp"><h3>logout</h3></a></td>
</tr>
</table>
<table width=100%>
<tr>
<td width=25% bgcolor=9999cc>
<table align="center"><br>
<tr align="center"><a href="./announcement.html"><h3>Announcements</h3></a></tr><br>
<tr align="center"><a href="./inscourse.html"><h3>Add course</h3></a></tr><br>
<tr align="center"><a href="./aexam.html"><h3>Activate exam</h3></a></tr><br>
<tr align="center"><a href="./selfac.jsp"><h3>Add faculty</h3></a></tr><br>
<tr align="center"><a href="./viewlea.jsp"><h3>Grant Leave</h3></a></tr><br>
<tr align="center"><a href="./viewshe.jsp"><h3>viewfeedback</h3></a></tr><br>
<tr align="center"><a href="./upback.jsp"><h3>Material&Exam</h3></a></tr><br>
<tr align="center"><a href="./adminhome.html"><h3>Home</h3></a></tr>
</table>
</td>
<td align="center" bgcolor=eeffee>
<h3><i>accept or reject the following files from faculty</i></h3>
<form name=f2 method="get">
<table border=1>
<thead>
<tr><th>facultyid</th><th>courseid</th><th>topic</th><th>accept/reject</th></tr>
</thead>
<tbody>
<%@ page import="java.sql.*" %>
<%
String s1=" ",s2=" ",s3=" ",s4=" ",s5=" ";
try
{
	
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from upload where status='uploaded'");
	ResultSetMetaData rd=rs.getMetaData();%>
	
<%	
	while(rs.next())
	{
		s1=rs.getString(1);
		s2=rs.getString(2);
		s3=rs.getString(3);
		s4=rs.getString(4);
		s5=rs.getString(6);%>
	<tr>
	<td><%=s1%></td>
	<td><%=s2%></td>
	<td><a href="<%=s4%>" target="_blank"><%=s3%></a></td>
	<td align="center"><input type=checkbox name="sta" value="<%=s5%>"></a></td></tr>
	</tr>
	<% }%>

</tbody>
</table>
<input type="submit" value="accept" onClick="submitOne()">
<input type="submit" value="reject" onClick="submitTwo()">
</form>
<%
}
	 catch(Exception e)
	 {
	 }
%>

<pre>       <a href="adminhome.html">HOME..</a></pre>
</td>
</tr>
</table>
</body>

</html>
