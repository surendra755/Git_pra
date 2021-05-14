<html>
<body>
<table border="1" height=25%  width=100% align="center">
<tr height=25% >
<td background="C:\Program Files\Apache Software Foundation\Tomcat 5.5\webapps\anusha\disc.jpeg" colspan="2"  align="right" valign="bottom">
<%
	if(session.getAttribute("fuserid")!=null)
	{%>
		<a href="fachome.html"><img src="home.jpg"></a>
		<a href="./flogout.jsp"><h3>logout</h3></a></td>
	<%}
	else if(session.getAttribute("suserid")!=null)
	{%>
		<a href="stuhome.html"><img src="home.jpg"></a>
		<a href="./slogout.jsp"><h3>logout</h3></a></td>
	<%}%>
	
</tr>
</table>
<blockquote>
  <div>
  </div>
  </FORM>
  <form action="postMess.html" method="get">
	<center><input class="button" type="submit" value="Post a Message" name="postmessage"></center>

    <div>
    </div>
  </form>
  <% Integer x=(Integer)request.getAttribute("cnt");
  for(int i=0;i<x;i++)
  {
	  String msg=(String)request.getAttribute("msg["+i+"]");
	  String qid=(String)request.getAttribute("qid["+i+"]");
	  String cid=(String)request.getAttribute("cid["+i+"]");
	  %>
  <a name="<%=i%>"></a>
  <div class="thread">
    <div class="first_message_div">
      <div class="first_message_header">
        <span class="first_message_span"><a class="article_link" href="respview.jsp?msg=<%=msg%>&qid=<%=qid%>&cid=<%=cid%>"><%=request.getAttribute("sub["+i+"]")%></a>
        —<span class="author_cell">Author:<%=request.getAttribute("aut["+i+"]")%></span>&nbsp;&nbsp;
        <span class="courseid_cell">Course Id:<%=request.getAttribute("cid["+i+"]")%></span>&nbsp;&nbsp;
		<span class="date_cell">Date:<%=request.getAttribute("dt["+i+"]")%></span>&nbsp;&nbsp;
        <span class="questid_cell">Question Id:<%=request.getAttribute("qid["+i+"]")%></span>&nbsp;&nbsp;
        
		</span>
      </div>
    </div>
	
		<div class="responses">
      <ul>
  <%Integer y=(Integer)request.getAttribute("cnt1");
	  String q2=(String)request.getAttribute("qid["+i+"]");
	 for(int j=0;j<y;j++)
  {
		 	String q1=(String)request.getAttribute("qid1["+j+"]");
		 if(q1.equals(q2))
		 {
	  %>

        <li><a class="articlesub_link" href="respview.jsp?msg=<%=request.getAttribute("msg1["+j+"]")%>&qid=<%=q1%>&cid=<%=cid%>"><%=request.getAttribute("sub1["+j+"]")%></a>
        —<span class="authorsub_cell">Author Name:<%=request.getAttribute("aut1["+j+"]")%></span>&nbsp;&nbsp;
		<span class="datesub_cell">Date:<%=request.getAttribute("day["+j+"]")%></span>&nbsp;&nbsp;
        <span class="questidsub_cell"> Question Id:<%=request.getAttribute("qid1["+j+"]")%></span>&nbsp;&nbsp;
        <span class="ansidsub_cell">Answer Id:<%=request.getAttribute("ansid["+j+"]")%></span>&nbsp;&nbsp;
		</span></li>
		<%
		 }
  }
	  %>
      </ul>
    </div>
  </div>
  
	 <br>
  <hr>
  <br>
  <%
  }
	  %>
  <form action="file:///C:/discussion.cgi?disc=238100;article=3;title=course" method="post">
    <input type="hidden" value="238100" name="disc"><input type="hidden" value="1" name="pagemark">
    <div>
    </div>
  </form>
  
  <!-- " -->
  </SCRIPT>
  </NOSCRIPT>
  
</blockquote>
</FORM>
</body>
</html>
