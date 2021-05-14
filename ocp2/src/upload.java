import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class upload extends HttpServlet
{
Connection con;
Statement stmt;
ResultSet rs;
public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
con=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");
stmt=con.createStatement();
HttpSession ses=req.getSession();
RequestDispatcher rd;
String uid=(String)ses.getAttribute("fuserid");
pw.println("select courseid from faculty where fuserid='"+uid+"'");
String query="select courseid from faculty where fuserid='"+uid+"'";
rs=stmt.executeQuery(query);
rs.next();
pw.println("hello");
String s4=rs.getString(1);
pw.println("hello");
String s1=req.getParameter("upload");
String s2=req.getParameter("topic");
String xx[]=s1.split("anusha");
String s3=xx[xx.length-1];
String s5="uploaded";
pw.println("insert into upload values('"+uid+"','"+s4+"','"+s2+"','"+s3+"','"+s5+"')");
String qry="insert into upload values('"+uid+"','"+s4+"','"+s2+"','"+s3+"','"+s5+"')";
stmt.executeUpdate(qry);
con.commit();
rd=req.getRequestDispatcher("./materialsuc.html");
rd.forward(req,res);
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