import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
import java.lang.String.*;
public class Forgot extends HttpServlet
{	String emailidee=null;
        String userid=null;
        String password=null;
	String x=null;
        Connection con=null;
	Statement ps=null;	
	ResultSet rs=null;
	int flag,row;
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
	     
 		try
		{
			pw.println("hello");		
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        		pw.println("connection");
	    		con=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");		
			pw.println("before prep");
                	ps=con.createStatement();
			pw.println("after prep");
			RequestDispatcher rr;	
			String utype=req.getParameter("utype");
			pw.println("  "+utype);
			emailidee=req.getParameter("email");
			String sques=req.getParameter("secque");
			String sans=req.getParameter("secans");
			String s16=req.getParameter("month");
			String s17=req.getParameter("day");
			String s18=req.getParameter("year");
			String p=s17.concat("-");
			String q=p.concat(s16);
			p=q.concat("-");
			String dob1=p.concat(s18);
			int p1=0;

			if(utype.equals("faculty"))
			{
				
				pw.println("select fuserid,password,secque,secans,dob from faculty where email_id='"+emailidee+"'");
               			ResultSet rs=ps.executeQuery("select fuserid,password,secque,secans,dob from faculty where email_id='"+emailidee+"'");
				pw.println("test0");	
				while(rs.next())
				{		
					userid=rs.getString(1);
					password=rs.getString(2);
					String s1=rs.getString(3);
					String s2=rs.getString(4);
					String s3=rs.getString(5);
					Format form=new SimpleDateFormat("dd-MMM-yyyy");
					DateFormat ff=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dt=form.format(ff.parse(s3));
					pw.println("  "+dob1);
					pw.println("  "+dt);
				pw.println("  "+sques);
					pw.println("  "+s1);
				pw.println("  "+sans);
					pw.println("  "+s2);
				
					//pw.println("if((sques.equals(s1)) && (sans.equals(s2))&&(dob1.equals(s3)))");
					if((sques.equals(s1))  && (sans.equals(s2)) && (dob1.equals(dt)))				
						{
						p1=1;
						pw.println("test2");
                                     		pw.println("  "+userid);
						pw.println("  "+password);
					}
  			         }
			 }
			else if(utype.equals("student"))
			{
				pw.println("select suserid,password,secque,secans,dob from student where email_id='"+emailidee+"'");
               			ResultSet rs=ps.executeQuery("select suserid,password,secque,secans,dob from student where email_id='"+emailidee+"'");
				pw.println("test0");	
				while(rs.next())
				{		
					userid=rs.getString(1);
					password=rs.getString(2);
					String s1=rs.getString(3);
					String s2=rs.getString(4);
					String s3=rs.getString(5);
					Format form=new SimpleDateFormat("dd-MMM-yyyy");
					DateFormat ff=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dt=form.format(ff.parse(s3));
					pw.println("  "+dob1);
					pw.println("  "+dt);
				pw.println("  "+sques);
					pw.println("  "+s1);
				pw.println("  "+sans);
					pw.println("  "+s2);
				
					//pw.println("if((sques.equals(s1)) && (sans.equals(s2))&&(dob1.equals(s3)))");
					if((sques.equals(s1))  && (sans.equals(s2)) && (dob1.equals(dt)))				
						{
						p1=1;
						pw.println("test2");
                                     		pw.println("  "+userid);
						pw.println("  "+password);
					}
  			         }
			 }	
			if(p1==0)
			{
				pw.println("<html><body>");
				pw.println("<center><br><br><br><br><br><br><h1><b>Invalid details entered</b></h1><br>");
				pw.println("<a href='forgotpwd.htm'><b>TRY AGAIN</b></a>");
				pw.println("</center></body></html>");	
				pw.close();
		
			}
		}	
   
		catch(ClassNotFoundException e)
		{
		pw.println("exception"+e);
		}
		catch(Exception e)
		{
		pw.println("can't load driver"+e.getMessage());
		}
	}
}