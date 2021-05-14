import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class Vfback extends HttpServlet
{
        Connection conn=null;
	Statement stmt=null;	
	ResultSet rs=null;
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException ,ServletException
	{
			res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
				
 		try
		{
			pw.println("connection");
     		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");    	 
	pw.println("connection");

conn=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");
		
		pw.println("before prep");
                stmt=conn.createStatement();
		pw.println("after prep");


			HttpSession ses=req.getSession(true);
	pw.println("after sess");

String name[]=new String[10];
String course[]=new String[10];
String suggestions[]=new String[10];


pw.println("values");

String sname[]=new String[10];
String scourse[]=new String[10];
String ssuggestions[]=new String[10];
RequestDispatcher rd=null;

 rs=stmt.executeQuery("select * from feedback");
pw.println(rs);

int i=0;
		while(rs.next())
			{
pw.println("helllllllllllo");
		
				name[i]=rs.getString("name");
				course[i]=rs.getString("course");	
				suggestions[i]=rs.getString("suggestions");
				pw.println("values"+name[i]+"\t"+course[i]+"\t"+suggestions[i]);

				
				    req.setAttribute("sname["+i+"]",name[i]);				
				req.setAttribute("scourse["+i+"]",course[i]);
				req.setAttribute("ssuggestions["+i+"]",suggestions[i]);
				

				 
i++;

				}
             if(i==0)
				{
	pw.println("Has no rows");
					rd=req.getRequestDispatcher("nofeed.html");
					rd.forward(req,res);
				}
				else
				{
				req.setAttribute("cnt",i);
				rd=req.getRequestDispatcher("viewshe.jsp");
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