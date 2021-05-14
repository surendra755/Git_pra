import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class Vleave extends HttpServlet
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
				String fuserid[]=new String[10];
				String name[]=new String[10];
				String mail[]=new String[10];
				String reason[]=new String[10];
				String appdate[]=new String[10];
				String nname[]=new String[10];
				String nfuserid[]=new String[10];
				String nmail[]=new String[10];
				String nreason[]=new String[10];
				String nappdate[]=new String[10];
				rs=stmt.executeQuery("select * from leave");
				int i=0;
				while(rs.next())
				{
					fuserid[i]=rs.getString("fuserid");
					name[i]=rs.getString("name");
					mail[i]=rs.getString("mail");	
					reason[i]=rs.getString("reason");
					appdate[i]=rs.getString("appdate");
					req.setAttribute("nfuserid["+i+"]",fuserid[i]);
				    req.setAttribute("nname["+i+"]",name[i]);				
					req.setAttribute("nmail["+i+"]",mail[i]);
					req.setAttribute("nreason["+i+"]",reason[i]);
					req.setAttribute("nappdate["+i+"]",appdate[i]);	
					i++;
				}
				req.setAttribute("cnt",i);
				RequestDispatcher rd=req.getRequestDispatcher("viewlea.jsp");
				rd.forward(req,res);
			  }	
	          catch(Exception e)
			  {
				  pw.println("can't load driver"+e.getMessage());
			  }
		}
}