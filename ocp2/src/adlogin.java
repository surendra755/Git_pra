import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class adlogin extends HttpServlet
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
			RequestDispatcher rd;	
			HttpSession ses=req.getSession(true);
			int p=0;
			String s1=req.getParameter("uname");
            String s2=req.getParameter("pwd");
            rs=ps.executeQuery("select auserid,pwd from admin");
			while(rs.next())
			{
				String w=rs.getString("auserid");
				String y=rs.getString("pwd");
				pw.println("hai2");
				if(s1.equals(w) && s2.equals(y))
				{
					p=1;
					ses.setAttribute("auserid",s1);
					rd= req.getRequestDispatcher("adminhome.html");
					rd.forward(req,res);
				}
				else
				{
					rd= req.getRequestDispatcher("logfail.html");
					rd.forward(req,res);
				}
			}
		}	
   		catch(ClassNotFoundException e)
		{
		pw.println("exception"+e);
		}
		catch(SQLException e)
		{
			pw.println("sqlexception"+e);	
		}
		     	catch(Exception e)
		{
		pw.println("can't load driver"+e.getMessage());
		}
	}
}