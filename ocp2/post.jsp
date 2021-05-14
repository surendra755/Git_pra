<html>
<body>

<blockquote>
  <div>
  </div>
  </FORM>
  <form action="postMess.html" method="post">
  
    <center><input class="button" type="submit" value="Post a Message" name="postmessage"></center>
    <div>
    </div>
  </form>
  <% Integer x=(Integer)request.getAttribute("cnt");
   for(int i=0;i<x;i++)
  {
	  %>
  <a name="<%=i%>"></a>
  <div class="thread">
    <div class="first_message_div">
      <div class="first_message_header">
        <span class="first_message_span"><a class="article_link" href="PostMess.html"><%=request.getAttribute("sub["+i+"]")%></a>
        —<span class="author_cell"><%=request.getAttribute("aut["+i+"]")%></span>
		<span class="date_cell"><%=request.getAttribute("dt["+i+"]")%></span>
        <span class="questid_cell"><%=request.getAttribute("qid["+i+"]")%></span>
		</span>
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
