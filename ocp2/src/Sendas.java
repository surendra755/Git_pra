import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class Sendas extends HttpServlet
{
Connection conn;
Statement stmt;
ResultSet rs;
HttpSession ses=null;
public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

try
{
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
 conn=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");
 stmt=conn.createStatement();
 RequestDispatcher rd;
 ses=req.getSession();
 String s1=req.getParameter("announcements");
 String s2=(String)ses.getAttribute("auserid");
int p=0;
ResultSet rs=stmt.executeQuery("select sannouncement from astu");
pw.println("hello");
while(rs.next())
{
	pw.println("hello1");
	if((s1.equals(rs.getString("sannouncement"))))
	{
		pw.println("hello3");
		p=1;
		rd=req.getRequestDispatcher("sasent.html");
		rd.forward(req,res);
	}
}
if(p==0)
{
	pw.println("hello2");
	String qry="insert into astu values('"+s1+"','"+s2+"')";
	pw.println("hello4");
	stmt.executeUpdate(qry);
	rd=req.getRequestDispatcher("sasuc.html");
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