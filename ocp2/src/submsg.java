import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
import java.lang.*;
public class submsg extends HttpServlet
{
 Connection con=null;
 Statement ps=null;
 ResultSet rs=null;
 public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
 {
  res.setContentType("text/html");
  PrintWriter pw=res.getWriter();
 
  try
  {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   con=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");		
   ps=con.createStatement();
   RequestDispatcher rd;
   pw.println("Started Insertion");
   rs=ps.executeQuery("select max(quesid)+1 from submitmsg");
   String quesid="";
   if(rs.next())
   {	
  	quesid=rs.getString(1);
   }
   pw.println("Started Insertion");
   String author=req.getParameter("author");
   String mail=req.getParameter("mail");
   String subject=req.getParameter("subject");
   String courseid=req.getParameter("courseid");
   String message=req.getParameter("message");
   java.util.Date day=new java.util.Date();
   Format form = new SimpleDateFormat("dd-MMM-yyyy");
   pw.println("Date:"+ form.format(day));
   String qry="insert into submitmsg values('"+author+"','"+mail+"','"+subject+"','"+courseid+"','"+message+"','"+ form.format(day)+"',disc.NextVal)";
   ps.executeUpdate(qry);
   pw.println("Values Inserted");
   con.commit();
	  
	  rd=req.getRequestDispatcher("./viewnewmsg");
	  rd.forward(req,res);
    }
    catch(ClassNotFoundException e)
    {
     pw.println("exception"+e);
    }
    catch(SQLException e)
    {
     pw.println("SQL EXCEPTION");	
     pw.println("TRY AGAIN");
    }
    catch(Exception e)
    {
     pw.println("can't load driver"+e.getMessage());
    }
}
}