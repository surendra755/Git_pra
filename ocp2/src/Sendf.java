import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class Sendf extends HttpServlet
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
 String s0=(String)ses.getAttribute("suserid");
 String s1=req.getParameter("uname");
 String s2=req.getParameter("course");
 String s3=req.getParameter("suggestions");
 String s4=req.getParameter("day");
 String s5=req.getParameter("month");
 String s6=req.getParameter("year");
 String s7=s4+'-'+s5+'-'+s6;
 String s8="sent";
 int p=0;
String cid="";
ResultSet rs=stmt.executeQuery("select courseid from course");
int xx=0;
while(rs.next())
{
 cid=rs.getString(1);

 if(s2.equals(cid))
	{
	 xx=1;
 	}
}
if(xx==1)
{
String qry="insert into feedback values('"+s0+"','"+s1+"','"+s2+"','"+s3+"','"+s7+"','"+s8+"',feed.NextVal)";
stmt.executeUpdate(qry);
conn.commit();
rd=req.getRequestDispatcher("feedsuc.html");
rd.forward(req,res);
}
else
{
rd=req.getRequestDispatcher("feedfail.html");
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