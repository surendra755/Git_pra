import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class Regs extends HttpServlet
{
    Connection con=null;
	Statement ps=null;	
	ResultSet rs=null;
	int flag=0;

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
	    	RequestDispatcher rd;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
        		con=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");		
			ps=con.createStatement();
			RequestDispatcher rr;
			String sfname=req.getParameter("sfname");
        		String slname=req.getParameter("slname");
			String dob=req.getParameter("dob");
			String gender=req.getParameter("gender");
			String street=req.getParameter("street");
			String area=req.getParameter("area");
			String city=req.getParameter("city");
			String state=req.getParameter("state");
			String country=req.getParameter("country");
			String zipcode=req.getParameter("zipcode");
			String email_id=req.getParameter("email_id");
			String phoneno=req.getParameter("phoneno");
			String userid=req.getParameter("userid");
			String password=req.getParameter("password");
			String repassword=req.getParameter("repassword");
			String courseid=req.getParameter("courseid");
			char graduate;
  			if (req.getParameter("graduate") != null)
			{
    			graduate = 'y';
  			} 
			else {
    			graduate = 'n';
  			}
			if(password.equals(repassword))
			{ 
				pw.println("entered");
				flag=1;
			}
			else
			{
	
			pw.println("<html><body>");
			pw.println("PASSWORD ENTERED DID NOT MATCH");
			pw.println("<a href=reg.htmL>PLEASE REGISTER AGAIN</a>");
			pw.println("</body></html>");
			}

			if(flag==1)
			{		
					pw.println("SUCCESS");
					ps.executeUpdate("insert into stureg values('"+sfname+"','"+slname+"','"+dob+"','"+gender+"','"+street+"','"+area+"','"+city+"','"+state+"','"+country+"',"+zipcode+",'"+email_id+"',"+phoneno+",'"+userid+"','"+password+"','"+courseid+"','"+graduate+"')");
					pw.println("TEST");
					con.commit();
            				rr= req.getRequestDispatcher("sregsuc.html");
            				rr.forward(req,res);
			}

		
             
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