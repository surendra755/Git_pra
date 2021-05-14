import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class sendanno extends HttpServlet
{
    	Connection con=null;
	Statement ps=null;	
	ResultSet rs=null;
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
			String recepient=req.getParameter("recepient");
			String announcement=req.getParameter("announcement");
			pw.println(" aghs-"+recepient);
			ps.executeUpdate("insert into announcement values('"+recepient+"','"+announcement+"')");
			con.commit();
			rr= req.getRequestDispatcher("adminhome.html");
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