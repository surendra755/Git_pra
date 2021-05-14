import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class Vsan extends HttpServlet
{
        Connection conn=null;
	Statement stmt=null;	
	ResultSet rs=null;
	HttpSession ses=null;
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException ,ServletException
	{
			res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
				
 		try
		{
		
     		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");    	 
	pw.println("connection");

conn=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");
		
		pw.println("before prep");
                stmt=conn.createStatement();
		pw.println("after prep");
			}
		catch(ClassNotFoundException e)
		{
		pw.println("exception"+e);
		}
		catch(SQLException e)
		{
			pw.println("exception"+e);	
		}
	    	try
	      	{

				ses=req.getSession(true);
				String announcements[]=new String[10];
				String sannouncements[]=new String[10];
				rs=stmt.executeQuery("select * from astu");
				int i=0;
				while(rs.next())
				{
					announcements[i]=rs.getString("sannouncement");
				    req.setAttribute("sannouncements["+i+"]",announcements[i]);				
					i++;
				}
	            req.setAttribute("cnt",i);
				RequestDispatcher rd=req.getRequestDispatcher("viewstu.jsp");
				rd.forward(req,res);
			}	
        	catch(Exception e)
			{
				pw.println("can't load driver"+e.getMessage());
			}
		}
}