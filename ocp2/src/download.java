import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class download extends HttpServlet
{
Connection con;
Statement stmt;
ResultSet rs,rs1;
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
con=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");
stmt=con.createStatement();
HttpSession ses=req.getSession();
String filename[]=new String[100];
String courseid[]=new String[100];
String topic[]=new String[100];
String suserid[]=new String[100];
String finame[]=new String[100];
String newcid[]=new String[100];
String newtopic[]=new String[100];
String newsuserid[]=new String[100];
RequestDispatcher rd;
String uid=(String)ses.getAttribute("suserid");
pw.println("select courseid from student where suserid='"+uid+"'");
String query="select student.suserid,student.courseid,upload.courseid,upload.topic,upload.filename from student,upload where student.suserid='"+uid+"' and student.courseid=upload.courseid and upload.status='accepted'";
rs=stmt.executeQuery(query);
int i=0;
	while(rs.next())
	{
		suserid[i]=rs.getString("suserid");
		courseid[i]=rs.getString("courseid");
		topic[i]=rs.getString("topic");
		filename[i]=rs.getString("filename");
		req.setAttribute("newsuserid["+i+"]",suserid[i]);
		req.setAttribute("newcid["+i+"]",courseid[i]);
		req.setAttribute("newtopic["+i+"]",topic[i]);
		req.setAttribute("finame["+i+"]",filename[i]);
		i++;
	}
	if(i==0)
	{
		pw.println("no student available");
		rd=req.getRequestDispatcher("nostucou.html");
		rd.forward(req,res);

	}
	else
	{
		req.setAttribute("cnt",i);
		rd=req.getRequestDispatcher("downback.jsp");
		rd.forward(req,res);
	}
}
catch(ClassNotFoundException e)
{
pw.println("exception"+e);
}
catch(SQLException e)
{
pw.println("exception"+e);
}
catch(Exception e)
{
pw.println("can't load driver"+e.getMessage());
}
}
}