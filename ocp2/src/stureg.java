import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class stureg extends HttpServlet
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
			rs=ps.executeQuery("select creditcard.cardnum ,creditcard.cardpin,creditcard.expdate,course.courseid from creditcard,course");
			RequestDispatcher rr;
			String userid=req.getParameter("userid");
			String password=req.getParameter("password");
			String repassword=req.getParameter("repassword");
			String secque=req.getParameter("secque");
			String secans=req.getParameter("secans");
			String sfname=req.getParameter("sfname");
        			String slname=req.getParameter("slname");
			String day=req.getParameter("day");
			String month=req.getParameter("month");
			String year=req.getParameter("year");
			String dob=day+month+year;
			String gender=req.getParameter("gender");
			String result="noexamyet";
			char graduate;
  			if (req.getParameter("graduate") != null)
			{
    				graduate = 'y';
  				String street=req.getParameter("street");
				String city=req.getParameter("city");
				String state=req.getParameter("state");
				String country=req.getParameter("country");
				String zipcode=req.getParameter("zipcode");
				String email_id=req.getParameter("email_id");
				String phoneno=req.getParameter("phoneno");
				String courseid=req.getParameter("courseid");
				String cardnum=req.getParameter("cardnum");
				System.out.println(" card nu is :"+cardnum);
				String cardpin=req.getParameter("cardpin");
				System.out.println(" pin is : " + cardpin);
				String eday=req.getParameter("eday");
				String emonth=req.getParameter("emonth");
				String eyear=req.getParameter("eyear");
				String expdate=eday+'-'+emonth+'-'+eyear;
				System.out.println(expdate);
				int i=0,x=1,y=0;
				while(rs.next())
				{
					String cnum=rs.getString("CARDNUM");
					String cpin=rs.getString("CARDPIN");
					String s1=rs.getString("EXPDATE");
					String cid=rs.getString(4);
					System.out.println(s1 + "   " + cid);
					Format form=new SimpleDateFormat("dd-MMM-yyyy");
					DateFormat ff=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String exdate=form.format(ff.parse(s1));
					System.out.println(exdate);

					if((cnum.equals(cardnum)) && (cpin.equals(cardpin)) && (exdate.equals(expdate)))
					{
						y=1;
						if(cid.equals(courseid))
						{
							x=1;
							pw.println("insert into student values('"+userid+"','"+password+"','"+secque+"','"+secans+"','"+sfname+"','"+slname+"','"+dob+"','"+gender+"','"+graduate+"','"+street+"','"+city+"','"+state+"','"+country+"',"+zipcode+",'"+email_id+"',"+phoneno+",'"+courseid+"','"+result+"')");
							ps.executeUpdate("insert into student values('"+userid+"','"+password+"','"+secque+"','"+secans+"','"+sfname+"','"+slname+"','"+dob+"','"+gender+"','"+graduate+"','"+street+"','"+city+"','"+state+"','"+country+"',"+zipcode+",'"+email_id+"',"+phoneno+",'"+courseid+"','"+result+"')");
							con.commit();
							pw.println("insert into ccard values('"+cardnum+"','"+cardpin+"','"+expdate+"','"+userid+"')");
							ps.executeUpdate("insert into ccard values('"+cardnum+"','"+cardpin+"','"+expdate+"','"+userid+"')");
							con.commit();
							//pw.println("invalid creditcard details3");
            				rr= req.getRequestDispatcher("sregsuc.html");
            				rr.forward(req,res);
					
						}
						else
							x=0;
					
					}
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
					if(y==0)
					{
						pw.println("<html>");
						pw.println("<body>");
						pw.println("<br><br><br><br><br><br><br>");
						pw.println("<center>");
						pw.println("Ur Card is not found ");

						pw.println("<h1>invalid creditcard details</h1>");
						pw.println("<a href="+"stureg.html"+">");
						pw.println("<h3>TRYAGAIN</h3>");
						pw.println("</a>");
						pw.println("</body>");
						pw.println("</html>");
					}
			} 
			else
			{
    				graduate = 'n';
					rr= req.getRequestDispatcher("sregfail.html");
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