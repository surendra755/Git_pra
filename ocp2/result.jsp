
<html>
<head>

</head>

<body>
<table border=1 width="100%">
<tr>
<td bgcolor=lavender width="75%">
<center><h1>Question Paper</h1></center>
<table>
<% 
Integer cnt=(Integer)request.getAttribute("cnt");
for( int i=0;i<cnt;i++)
{ %>
<tr>
<td><%= i+1%>)</td><td><%=request.getAttribute("sques["+i+"]")%></td></tr>
<tr><td></td><td>a)<%=request.getAttribute("sch1["+i+"]")%></td></tr>
<tr><td></td><td>b)<%=request.getAttribute("sch2["+i+"]")%></td></tr>
<tr><td></td><td>c)<%=request.getAttribute("sch3["+i+"]")%></td></tr>
<tr><td></td><td>d)<%=request.getAttribute("sch4["+i+"]")%><br><br></td></tr>
		<% } %>
</table>

</td>
<td bgcolor=bisque valign="top" ><center>
<form name=resform method="post" action="./Rsavex">
<table width='100%' border='0' cellpadding='2' bgcolor=#939D9F>
<tr><td bgcolor=cornsilk>QNO</td><td bgcolor=lavender>COR.KEY</td><td bgcolor=cornsilk>ANS.KEY</td></tr>

<% 
cnt=(Integer)request.getAttribute("ct");
for( int i=1;i<cnt;i++)
{ %>

<tr><td bgcolor=cornsilk><%= i%></td><td bgcolor=lavender><%=request.getAttribute("key["+i+"]")%></td><td bgcolor=cornsilk><%=request.getAttribute("res["+i+"]")%></td></tr>
<%}%>
</table><br><br>

<table width='100%' border='0' cellpadding='2' bgcolor=#939D9F>
<tr><td bgcolor=cornsilk>CORRECT ANS:</td><td bgcolor=lavender><%=request.getAttribute("corans")%></td></tr>
<tr><td bgcolor=cornsilk>WRONG ANS:</td><td bgcolor=lavender><%=request.getAttribute("wrgans")%></td></tr>
<tr><td bgcolor=cornsilk>UN ANS:</td><td bgcolor=lavender><%=request.getAttribute("unans")%></td></tr>
<tr><td bgcolor=cornsilk>RESULT:</td><td bgcolor=lavender><%=request.getAttribute("result")%></td></tr>

</table>
</form>
</td>
</tr>
</table>
<!-- End of regpatient FORM -->
</body>
</html>
