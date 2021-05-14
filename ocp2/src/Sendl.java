import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class Sendl extends HttpServlet
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
 String s0=(String)ses.getAttribute("fuserid");
 String s1=req.getParameter("name");
 String s2=req.getParameter("mail");
 String s3=req.getParameter("reason");
 String s4=req.getParameter("day");
 String s5=req.getParameter("month");
 String s6=req.getParameter("year");
 String s7=s4+'-'+s5+'-'+s6;
 String s8="requested";
 int p=0;
 ResultSet rs=stmt.executeQuery("select fuserid,name,mail,reason,appdate from leave");
 while(rs.next())
 {
 if((s0.equals(rs.getString("fuserid"))) && (s1.equals(rs.getString("name")))&&(s2.equals(rs.getString("mail")))&&(s3.equals(rs.getString("reason"))) && (s7.equals(rs.getString("appdate")))) 
 {
p=1;
rd=req.getRequestDispatcher("reqfail.html");
rd.forward(req,res);
}
}

if(p==0)
{
	pw.println("insert into leave values('"+s0+"','"+s1+"','"+s2+"','"+s3+"','"+s7+"','"+s8+"',lea.NextVal)");
String qry="insert into leave values('"+s0+"','"+s1+"','"+s2+"','"+s3+"','"+s7+"','"+s8+"',lea.NextVal)";
stmt.executeUpdate(qry);
rd=req.getRequestDispatcher("reqsuc.html");
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