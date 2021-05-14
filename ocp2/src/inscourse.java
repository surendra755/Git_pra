import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class inscourse extends HttpServlet
{
    	Connection con=null;
	Statement ps=null;	
	ResultSet rs=null;
	int flag=0;
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
	    	try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
        		con=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");		
			ps=con.createStatement();
			RequestDispatcher rr;
			String courseid=req.getParameter("courseid");
			String couname=req.getParameter("couname");
			String s1=req.getParameter("sday");
			String s2=req.getParameter("smonth");
			String s3=req.getParameter("syear");
			String sdate=s1+'-'+s2+'-'+s3;
			String s4=req.getParameter("eday");
			String s5=req.getParameter("emonth");
			String s6=req.getParameter("eyear");
			String edate=s4+'-'+s5+'-'+s6;
			String duration=req.getParameter("duration");
			String fee=req.getParameter("fee");
			pw.println("insert into course values('"+courseid+"','"+couname+"','"+sdate+"','"+edate+"','"+duration+"',"+fee+")");
			ps.executeUpdate("insert into course values('"+courseid+"','"+couname+"','"+sdate+"','"+edate+"','"+duration+"',"+fee+")");
			con.commit();
			rr= req.getRequestDispatcher("incousuc.html");
            		rr.forward(req,res);
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