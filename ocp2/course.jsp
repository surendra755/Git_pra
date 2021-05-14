<html>
<body>
<table border="0" height=100%  width=100% bgcolor="#eeffee" align="center" scroll="no">
<tr height=20% >
<td><img src="cou.gif"></td>
</tr>
<tr>
		<td align="left"><a href="home.html"><img src="home.jpg"></a></td>
</tr>
<tr>
<td>
<table  border="2" width=80% height=80% align="center">
<tr bgcolor=b0c4de >
<th>Course ID</th>
<th>COURSE NAME</th>
<th>STARTING DATE</th>                                                               
<th>ENDING DATE</th>
<th>DURATION</th>
<th>FEES in Rs</th>
</tr>
<tbody>
<%@ page import="java.sql.*,java.text.*" %>
<%
String s1=" ",s2=" ",s3=" ",s4=" ",s5=" ",s6=" ",sdate=" ",edate=" ";
try
{
	
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select courseid,coursename,sdate,edate,duration,fee from course ");
	ResultSetMetaData rd=rs.getMetaData();%>
	
<%	
	while(rs.next())
	{
		s1=rs.getString(1);
		s2=rs.getString(2);
		sdate=rs.getString(3);
		edate=rs.getString(4);
		Format form=new SimpleDateFormat("dd-MMM-yyyy");
		DateFormat ff=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		s3=form.format(ff.parse(sdate));
		s4=form.format(ff.parse(edate));
		s5=rs.getString(5);
		s6=rs.getString(6);%>
	<tr>
	<td><%=s1%></td>
	<td><%=s2%></td>
	<td><%=s3%></td>
	<td><%=s4%></td>
	<td><%=s5%></td>
	<td><%=s6%></td>
	</tr>
	</tr>
	<% }%>

</tbody>
</table>
<%
}
	 catch(Exception e)
	 {
	 }
%>
<tr>
<td><center>
<pre>
<a href="./stureg.html"><img src="stureg.jpg"></a>        <a href="./facreg.html"><img src="facreg.jpg"></a>
</pre></center></td>
</tr>
</table>

</body>
</html>