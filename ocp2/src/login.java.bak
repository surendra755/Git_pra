import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class login extends HttpServlet
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
			int fail=1;
			String s1=req.getParameter("uname");
            String s2=req.getParameter("pwd");
            String s3=req.getParameter("utype");
			String y="student";
			String z="faculty";
			String s4="selected";
			if(s3.equals(y))
			{
				rs=ps.executeQuery("select suserid,password from student");
				while(rs.next())
				{
					String w=rs.getString("suserid");
					String x=rs.getString("password");
					if((s1.equals(w)) && (s2.equals(x)))
					{
						p=1;
						ses.setAttribute("suserid",s1);
						req.setAttribute("sname","uname");
						req.setAttribute("dob","dob");
						req.setAttribute("address","addrress");
						req.setAttribute("email_id","email_id");
						rd= req.getRequestDispatcher("stuhome.html");
						rd.forward(req,res);
					}
					else
					{
						
						rd= req.getRequestDispatcher("logfail.html");
						rd.forward(req,res);
						pw.println("invalid user name & password");
					}
 				}

			}
			else if(s3.equals(z))
			{
				rs=ps.executeQuery("select fuserid,password,status from faculty");
				while(rs.next())
				{
					String w=rs.getString("fuserid");
					String x=rs.getString("password");
					String v=rs.getString("status");
					System.out.println( s$+ " "+v);
					if(s4.equals(v))
					{	pw.println(s1+"     gjh "+w+"  hgsdj   "+s2+"  gff   "+x+"  ss  ");
						if((s1.equals(w)) && (s2.equals(x)))
						{
							pw.println("kaka");
							p=1;
							fail=1;
							ses.setAttribute("fuserid",s1);
							req.setAttribute("fname","uname");
							req.setAttribute("dob","dob");
							req.setAttribute("address","addrress");
							req.setAttribute("email_id","email_id");
							rd= req.getRequestDispatcher("fachome.html");
							rd.forward(req,res);
						}
						else
							fail=0;
							
					}
					else
					{
						pw.println(w+"sjd"+v);
						rd= req.getRequestDispatcher("notsel.html");
						rd.forward(req,res); 
					}
 				}
				if(fail==0)
				{
					rd= req.getRequestDispatcher("logfail.html");
					rd.forward(req,res);
					pw.println("invalid user name & password");
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