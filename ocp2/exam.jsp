
<html>
<head>
<script>
function bclick()
			{
				var x=window.confirm("Answers Can be Submitted only Once.Do U want to Submit");
				if(x)
				document.resform.submit();
				else 
				return;
			}
			function tFunc()
			{
				document.resform.submit();
			}
			function tFunc2()
			{
				alert ("One more Min Left");
			}
			function setFunc()
			{
			
			document.resform.times.value=document.resform.times.value - 1; 
			if(document.resform.times.value == 0)
			{
				
				if(document.resform.timem.value==0)
				{
					if(document.resform.timeh.value != 0)
					{
					document.resform.timeh.value=document.resform.timeh.value - 1;
					document.resform.timem.value=59;
					document.resform.times.value=59;
					}
					else
					{
						//return;
						document.resform.fla.value='S';
						document.resform.submit();
					}	
				
				}
				document.resform.timem.value=document.resform.timem.value -1;
				document.resform.times.value=59;
			}	
			
			setTimeout('setFunc();', 1000 );
			
			}
			
</script>
</head>

<body onload="setFunc(),setTimeout('tFunc2();', 522000),setTimeout('tFunc();', 582000);">
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
<form name=resform method="post" action="./Rsavex"><input type='hidden' name='n' value='10' readonly='true' align='right'>Time Left <input type='text' name='timeh' value='0' size=1 readonly='true'>:<input type='text' name='timem' value='9' size=1 readonly='true'>:<input type='text' name='times' value='42' size=1 readonly='true'><table width='100%' border='0' cellpadding='2' bgcolor=#939D9F>
<tr bgcolor=cornsilk><td>1</td><td>A.<input type='radio' name=r1 value=1></td><td>B.<input type='radio' name=r1 value=2></td><td>C.<input type='radio' name=r1 value=3></td><td>D.<input type='radio' name=r1 value=4></td></tr>
<tr bgcolor=lavender><td>2</td><td>A.<input type='radio' name=r2 value=1></td><td>B.<input type='radio' name=r2 value=2></td><td>C.<input type='radio' name=r2 value=3></td><td>D.<input type='radio' name=r2 value=4></td></tr><tr bgcolor=cornsilk><td>3</td><td>A.<input type='radio' name=r3 value=1></td><td>B.<input type='radio' name=r3 value=2></td><td>C.<input type='radio' name=r3 value=3></td><td>D.<input type='radio' name=r3 value=4></td></tr>
<tr bgcolor=lavender><td>4</td><td>A.<input type='radio' name=r4 value=1></td><td>B.<input type='radio' name=r4 value=2></td><td>C.<input type='radio' name=r4 value=3></td><td>D.<input type='radio' name=r4 value=4></td></tr><tr bgcolor=cornsilk><td>5</td><td>A.<input type='radio' name=r5 value=1></td><td>B.<input type='radio' name=r5 value=2></td><td>C.<input type='radio' name=r5 value=3></td><td>D.<input type='radio' name=r5 value=4></td></tr><tr bgcolor=lavender><td>6</td><td>A.<input type='radio' name=r6 value=1></td><td>B.<input type='radio' name=r6 value=2></td><td>C.<input type='radio' name=r6 value=3></td><td>D.<input type='radio' name=r6 value=4></td></tr><tr bgcolor=cornsilk><td>7</td><td>A.<input type='radio' name=r7 value=1></td><td>B.<input type='radio' name=r7 value=2></td><td>C.<input type='radio' name=r7 value=3></td><td>D.<input type='radio' name=r7 value=4></td></tr><tr bgcolor=lavender><td>8</td><td>A.<input type='radio' name=r8 value=1></td><td>B.<input type='radio' name=r8 value=2></td><td>C.<input type='radio' name=r8 value=3></td><td>D.<input type='radio' name=r8 value=4></td></tr><tr bgcolor=cornsilk><td>9</td><td>A.<input type='radio' name=r9 value=1></td><td>B.<input type='radio' name=r9 value=2></td><td>C.<input type='radio' name=r9 value=3></td><td>D.<input type='radio' name=r9 value=4></td></tr><tr bgcolor=lavender><td>10</td><td>A.<input type='radio' name=r10 value=1></td><td>B.<input type='radio' name=r10 value=2></td><td>C.<input type='radio' name=r10 value=3></td><td>D.<input type='radio' name=r10 value=4></td></tr></table><br><br><center><input type='Button' value='Submit' onClick='bclick();'></center></form>
</td>
</tr>
</table>
<!-- End of exam FORM -->
</body>
</html>
