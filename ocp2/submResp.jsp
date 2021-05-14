<html>
<head>
<head>
	<script type="text/javascript">
		function check_submit()
		{	
			var author=document.getElementById("author");
			var mail=document.getElementById("mail");
			var subject=document.getElementById("subject");
			var courseid=document.getElementById("courseid");
			var message=document.getElementById("message");
			if(author.value=="")
			{
				alert("Enter Author Name");
				author.focus();
				return false;
			}
			if(mail.value=="")
			{
				alert("Enter the email");
				mail.focus();
				return false;
			}
			if(mail.value!="")
			{	var posi=mail.value;
				apos=posi.indexOf("@")
				dotpos=posi.lastIndexOf(".")
				if (apos<1||dotpos-apos<2) 
				{
					alert("not A Valid EMAIL Address");
					mail.focus();
					return false;
				}
			}
			if(subject.value=="")
			{
				alert("Enter the subject");
				subject.focus();
				return false;
			}
			if(courseid.value=="")
			{
				alert("Enter the courseid");
				courseid.focus();
				return false;
			}
			if(message.value=="")
			{
				alert("Enter the message");
				message.focus();
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
<div class="post_message_form">
<form name="submitresponse" onsubmit="return check_submit()" action="./resmsg" method="Get">
<%
String qid=request.getParameter("qid");%>
 <input type="hidden" maxLength="60" size="30" name="quesid" value="<%=qid%>">

  <table>
    <tbody>
      <tr>
        <td class="entries_header">Author</td>
        <td><input maxLength="50" size="30" name="author" id="author"></td>
      </tr>
      <tr>
        <td class="entries_header">Email</td>
        <td><input maxLength="60" size="30" name="mail" id="mail"></td>
      </tr>
      <tr>
        <td class="entries_header">Subject</td>
        <td><input maxLength="60" size="30" name="subject" id="subject"></td>
      </tr>
      <tr>
        <td class="entries_header">CourseID</td>
        <td><input maxLength="60" size="30" name="courseid" id="courseid"></td>
      </tr>
 	</tbody>
  </table>
  <div>
    <span class="entries_header">Message (16 KB max)</span>
  </div>
  <div>
    <textarea name="message" id="message" rows="12" cols="60"></textarea>
  </div>
    <div class="buttons">
    <input class="button" type="submit" value="Submit Response" name="submitresponse">
    <a href="./viewnewmsg">Return to Messages</a>
  </div>
</div>
</div>
</form>
</body>
</html>
