
<html>
<body bgcolor=#f7f6f9 text=657693>
<form>
<table border="0"  width="100%" cellpadding="3" cellspacing="0" align="center">
<tr>
<td ><h4>name</h4></td>
<td ><h4>course</h4></td>
<td ><h4>suggestions</h4></td>
</tr>
<% Integer x=(Integer)request.getAttribute("cnt");
for( int i=0;i<x;i++)
{%>
<tr>
<td ><%= request.getAttribute("sname["+i+"]")%></td>
<td ><%= request.getAttribute("scourse["+i+"]")%></td>
<td ><%= request.getAttribute("ssuggestions["+i+"]")%></td>
</tr>
<% } %>
</table>
</form>
</body>
</html>
