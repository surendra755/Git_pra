import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class Sendaf extends HttpServlet
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
 ResultSet rs=stmt.executeQuery("select fannouncement  from afac");
 while(rs.next())
 {
 if((s1.equals(rs.getString("fannouncement"))))
{
p=1;
rd=req.getRequestDispatcher("fasent.html");
rd.forward(req,res);
}
}

if(p==0)
{
String qry="insert into afac values('"+s1+"','"+s2+"')";
stmt.executeUpdate(qry);
rd=req.getRequestDispatcher("fasuc.html");
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