import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class facreg extends HttpServlet
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
			rs=ps.executeQuery("select courseid from course");
			RequestDispatcher rr;
			String userid=req.getParameter("userid");
			String password=req.getParameter("password");
			String repassword=req.getParameter("repassword");
			String secque=req.getParameter("secque");
			String secans=req.getParameter("secans");
			String ffname=req.getParameter("ffname");
        	String flname=req.getParameter("flname");
			String day=req.getParameter("day");
			String month=req.getParameter("month");
			String year=req.getParameter("year");
			String dob=day+month+year;
			String gender=req.getParameter("gender");
			String street=req.getParameter("street");
			String city=req.getParameter("city");
			String state=req.getParameter("state");
			String country=req.getParameter("country");
			String zipcode=req.getParameter("zipcode");
			String email_id=req.getParameter("email_id");
			String phoneno=req.getParameter("phoneno");
			String courseid=req.getParameter("courseid");
			String status="not selected";
			char postgrad='n';
			char graduate;
			int x=1;
			while(rs.next())
			{
				String cid=rs.getString("courseid");
				if(cid.equals(courseid))
				{
  					if (req.getParameter("graduate") != null)
					{
    					graduate = 'y';
						pw.println("insert into faculty values('"+userid+"','"+password+"','"+secque+"','"+secans+"','"+ffname+"','"+flname+"','"+dob+"','"+gender+"','"+graduate+"','"+postgrad+"','"+street+"','"+city+"','"+state+"','"+country+"',"+zipcode+",'"+email_id+"',"+phoneno+",'"+courseid+"','"+status+"')");
						ps.executeUpdate("insert into faculty values('"+userid+"','"+password+"','"+secque+"','"+secans+"','"+ffname+"','"+flname+"','"+dob+"','"+gender+"','"+graduate+"','"+postgrad+"','"+street+"','"+city+"','"+state+"','"+country+"',"+zipcode+",'"+email_id+"',"+phoneno+",'"+courseid+"','"+status+"')");
						con.commit();
						rr= req.getRequestDispatcher("fregsuc.html");
            				rr.forward(req,res);
					} 
					else
					{
						if (req.getParameter("postgrad") != null)
						{
    						postgrad= 'y';
							graduate= 'y';
							pw.println("insert into faculty values('"+userid+"','"+password+"','"+secque+"','"+secans+"','"+ffname+"','"+flname+"','"+dob+"','"+gender+"','"+graduate+"','"+postgrad+"','"+street+"','"+city+"','"+state+"','"+country+"',"+zipcode+",'"+email_id+"',"+phoneno+",'"+courseid+"','"+status+"')");
							ps.executeUpdate("insert into faculty values('"+userid+"','"+password+"','"+secque+"','"+secans+"','"+ffname+"','"+flname+"','"+dob+"','"+gender+"','"+graduate+"','"+postgrad+"','"+street+"','"+city+"','"+state+"','"+country+"',"+zipcode+",'"+email_id+"',"+phoneno+",'"+courseid+"','"+status+"')");
							con.commit();
							rr= req.getRequestDispatcher("fregsuc.html");
            				rr.forward(req,res);
						}	
						else
						{
    						
							postgrad= 'n';
							graduate = 'n';
							rr= req.getRequestDispatcher("facregfail.html");
            				rr.forward(req,res);
						}	
  					}
				}
				else
					x=0;
			}
			if(x==0)
			{
				pw.println("<html>");
				pw.println("<body bgcolor="+"#eeffee"+">");
				pw.println("<table width="+971+" height="+524+" border="+0+">");
				pw.println("<tr>");
				pw.println("<td width="+961+" height="+84+"><img src="+"hom1.JPG"+" width="+959+" height="+80+"></td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td><center><h1>REGISTRATION UNSUCCESSFULL</h1>");
				pw.println("<h3>Sorry,selected course not available</h3>");
				pw.println("<a href="+"home.html"+">");
				pw.println("<img src="+"home.jpg"+">");
				pw.println("</a>");
				pw.println("</p></center>");
				pw.println("</td>");
				pw.println("</tr>");
				pw.println("</table>");
				pw.println("</body>");
				pw.println("</html>");
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