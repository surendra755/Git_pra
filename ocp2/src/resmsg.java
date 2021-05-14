 import javax.servlet.*;
 import java.io.*;
 import javax.servlet.http.*;
 import java.util.*;
 import java.text.*;
 import java.sql.*;
 import java.lang.*;
 public class resmsg extends HttpServlet
 {
  Connection con=null;
  Statement stmt=null;
  ResultSet rs=null;
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
  {
  res.setContentType("text/html");
  PrintWriter pw=res.getWriter();
 
  try
  {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   con=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");		
   stmt=con.createStatement();
   RequestDispatcher rd;
   pw.println("OK done");
   String ansid;
   String quesid=req.getParameter("quesid");
   pw.println(" "+quesid);
   //pw.println(" "+ansid);
   rs=stmt.executeQuery("select max(ansid)+1 from responsemsg where quesid='"+quesid+"'");
   pw.println("OK DONE");
   rs.next();
   String x=rs.getString(1);
   if(x!=null)
	 ansid=x;
   else
	 ansid="1";
   pw.println("OK done1"+ansid); 

   pw.println("Started Insertion");
   String author=req.getParameter("author");
   String mail=req.getParameter("mail");
   String subject=req.getParameter("subject");
   String courseid=req.getParameter("courseid");
   String message=req.getParameter("message");
   java.util.Date day=new java.util.Date();
   Format form = new SimpleDateFormat("dd-MMM-yyyy");
   pw.println("OK done2"); 
   pw.println("Date:"+ form.format(day));
   pw.println("insert into responsemsg values('"+author+"','"+mail+"','"+subject+"','"+courseid+"','"+message+"','"+ form.format(day)+"','"+ansid+"','"+quesid+"')");
   stmt.executeUpdate("insert into responsemsg values('"+author+"','"+mail+"','"+subject+"','"+courseid+"','"+message+"','"+ form.format(day)+"','"+ansid+"','"+quesid+"')");
   pw.println("Values Inserted");
   con.commit();
   
   rd=req.getRequestDispatcher("res.jsp");
   rd.forward(req,res);
	

  }
  catch(ClassNotFoundException e)
  {
     pw.println("exception"+e);
  }
  catch(SQLException e)
  {
     pw.println("SQL EXCEPTION");	
     pw.println("TRY AGAIN"+e);
  }
  catch(Exception e)
  {
     pw.println("can't load driver"+e.getMessage());
  }
}
}