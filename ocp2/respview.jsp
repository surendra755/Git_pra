<html>


<body>

<div class="message_and_thread">
  <div class="message">
    <div class="message_text">
<%String qq=request.getParameter("qid");
String cc=request.getParameter("cid");
%>

<b>Course:</b>&nbsp;&nbsp;&nbsp;&nbsp;<%=cc%><br>
<b>QuestionId:</b>&nbsp;&nbsp;&nbsp;&nbsp;<%=qq%><br>
<b>Message:</b>&nbsp;&nbsp;&nbsp;&nbsp;<%=request.getParameter("msg")%>

	</div>
    <br>
    <div class="buttons">
      <form method="post" action="submResp.jsp?qid=<%=qq%>">
        <input class="button" type="submit" value="Post a Response" name="postresponse">
        <a href="./viewnewmsg">Return to Messages</a>
      </form>
    </div>
  </div>
  
</body>

</html>
