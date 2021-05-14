import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class upback extends HttpServlet
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
			ses=req.getSession(true);
			String filename[]=new String[100];
			String courseid[]=new String[100];
			String topic[]=new String[100];
			String fuserid[]=new String[100];
			String finame[]=new String[100];
			String newcid[]=new String[100];
			String newtopic[]=new String[100];
			String newfuserid[]=new String[100];
			rs=stmt.executeQuery("select * from upload");
			RequestDispatcher rd=null;
			pw.println(rs);

			int i=0;
			while(rs.next())
			{
				pw.println("helllllllllllo");
				fuserid[i]=rs.getString("fuserid");
				courseid[i]=rs.getString("courseid");
				topic[i]=rs.getString("topic");
				filename[i]=rs.getString("filename");
				req.setAttribute("newfuserid["+i+"]",fuserid[i]);
				req.setAttribute("newcid["+i+"]",courseid[i]);
				req.setAttribute("newtopic["+i+"]",topic[i]);
				req.setAttribute("finame["+i+"]",filename[i]);
				i++;

			}
			if(i==0)
			{
				pw.println("Has no rows");
				rd=req.getRequestDispatcher("nocou.html");
				rd.forward(req,res);
			}
			else
			{
				req.setAttribute("cnt",i);
				rd=req.getRequestDispatcher("upback.jsp");
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