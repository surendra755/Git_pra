import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class upback extends HttpServlet
{
    Connection conn=null;
	Statement ps=null;	
	ResultSet rs=null;
	HttpSession ses=null;
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException ,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
				
 		try
		{
		
     			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");    	 
			pw.println("connection");
			conn=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");
			pw.println("before prep");
			ps=conn.createStatement();
			pw.println("after prep");
			ses=req.getSession(true);
			String fuserid[]=new String[20];
			String password[]=new String[20];
			String ffname[]=new String[20];
			String flname[]=new String[20];
			String dob[]=new String[20];
			String gender[]=new String[20];
			String graduate[]=new String[20];
			String postgrad[]=new String[20];
			String street[]=new String[20];
			String city[]=new String[20];
			String state[]=new String[20];
			String zipcode[]=new String[20];
			String email_id[]=new String[20];
			String phoneno[]=new String[20];
			String courseid[]=new String[20];
			String s1[]=new String[20];
			String s2[]=new String[20];
			String s3[]=new String[20];
			String s4[]=new String[20];
			String s5[]=new String[20];
			String s6[]=new String[20];
			String s7[]=new String[20];
			String s8[]=new String[20];
			String s9[]=new String[20];
			String s10[]=new String[20];
			String s11[]=new String[20];
			String s12[]=new String[20];
			String s13[]=new String[20];
			String s14[]=new String[20];
			String s15[]=new String[20];
			rs=ps.executeQuery("select fuserid,password,ffname,flname,dob,gender,graduate,postgrad,street,city,state,country,zipcode,email_id,phoneno,courseid from faculty");
			RequestDispatcher rd=null;
			pw.println(rs);
			int i=0;
			while(rs.next())
			{
				pw.println("helllllllllllo");
				fuserid[i]=rs.getString("fuserid");
				password[i]=rs.getString("password");
				ffname[i]=rs.getString("ffname");
				flname[i]=rs.getString("flname");
				dob[i]=rs.getString("dob");
				gender[i]=rs.getString("gender");
				graduate[i]=rs.getString("graduate");
				postgrad[i]=rs.getString("postgrad");
				street[i]=rs.getString("street");
				city[i]=rs.getString("city");
				state[i]=rs.getString("state");
				country[i]=rs.getString("country");
				zipcode[i]=rs.getString("zipcode");
				email_id[i]=rs.getString("email_id");
				phoneno[i]=rs.getString("phoneno");
				courseid[i]=rs.getString("courseid");
				req.setAttribute("s1["+i+"]",fuserid[i]);
				req.setAttribute("s2["+i+"]",password[i]);
				req.setAttribute("s3["+i+"]",ffname[i]);
				req.setAttribute("s4"+i+"]",flname[i]);
				req.setAttribute("s5["+i+"]",dob[i]);
				req.setAttribute("s6["+i+"]",gender[i]);
				req.setAttribute("s7["+i+"]",graduate[i]);
				req.setAttribute("s8["+i+"]",postgrad[i]);
				req.setAttribute("s9["+i+"]",street[i]);
				req.setAttribute("s10["+i+"]",city[i]);
				req.setAttribute("s11["+i+"]",state[i]);
				req.setAttribute("s12["+i+"]",country[i]);
				req.setAttribute("s13["+i+"]",email_id[i]);
				req.setAttribute("s14["+i+"]",phoneno[i]);
				req.setAttribute("s15["+i+"]",courseid[i]);
				i++;
			}
			if(i==0)
			{
				pw.println("Has no rows");
			}
			else
			{
				req.setAttribute("cnt",i);
				rd=req.getRequestDispatcher("facregi.jsp");
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