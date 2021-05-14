<html>
<body bgcolor=ivory text=657693>
<form>
<table cellpadding=1 cellspacing=1 border=1><th>Select</th><th>fuserid</th><th>password</th><th>ffname</th><th>flname</th><th>dob</th><th>gender</th><th>graduate</th><th>postgrad</th><th>street</th><th>city</th><th>state</th><th>country</th><th>Zipcode</th><th>email_id</th><th>phoneno</th><th>courseid</th></tr>
<% Integer x=(Integer)request.getAttribute("cnt");
for( int i=0;i<x;i++)
{ 
	String uid=(String)request.getAttribute("s1["+i+"]");
		%>
<tr>
<td><input type="checkbox" name="ch" value="<%=uid%>"></td>
<td><%=uid%></td>
<td><%= request.getAttribute("s2["+i+"]")%></td>
<td><%= request.getAttribute("s3["+i+"]")%></td>
<td><%= request.getAttribute("s4["+i+"]")%></td>
<td><%= request.getAttribute("s5["+i+"]")%></td>
<td><%= request.getAttribute("s6["+i+"]")%></td>
<td><%= request.getAttribute("s7["+i+"]")%></td>
<td><%= request.getAttribute("s8["+i+"]")%></td>
<td><%= request.getAttribute("s9["+i+"]")%></td>
<td><%= request.getAttribute("s10["+i+"]")%></td>
<td><%= request.getAttribute("s11["+i+"]")%></td>
<td><%= request.getAttribute("s12["+i+"]")%></td>
<td><%= request.getAttribute("s13["+i+"]")%></td>
<td><%= request.getAttribute("s14["+i+"]")%></td>
<td><%= request.getAttribute("s15["+i+"]")%></td>
<td><%= request.getAttribute("s16["+i+"]")%></td>
</tr>
<% }
%>
<tr>
<td><input type="submit" name="add" value="add checked faculty"></td>
</tr>
</table>
</form>
</body>
</html>
