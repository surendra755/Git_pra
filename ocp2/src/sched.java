import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;

import java.util.*;
import java.text.*;
import java.sql.*;
public class sched extends HttpServlet
{
        Connection con=null;
	Statement ps=null;	
	ResultSet rs=null;
	HttpSession ses=null;
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException ,ServletException
	{
			res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
				
 		
      try
		{
		
     		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");    	 
	//pw.println("connection");

con=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");
		
		
                ps=con.createStatement();
		
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
			String s2=req.getParameter("T1");
             String s3=req.getParameter("T2");
		int p=0;
                rs=ps.executeQuery("select qno,ques,ch1,ch2,ch3,ch4,time from key");
					
		while(rs.next())
			{
			
				String qno=rs.getString("qno");
				//pw.println("qno is ok"+qno);
							String ques=rs.getString("ques");	
				
				String ch1=rs.getString("ch1");
				
				String ch2=rs.getString("ch2");
				
				String ch3=rs.getString("ch3");
				
				String ch4=rs.getString("ch4");

				String times=rs.getString("time");
			
			java.util.Date dt =new java.util.Date();
			
	   DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.util.Date d = (java.util.Date)formatter.parse(times);
      Format form = new SimpleDateFormat("");
 // pw.println("helllo"+"\t"+form.format(d)); 
//pw.println(d.getTime()+"\t"+dt.getTime());
				if(dt.getTime()>=d.getTime())
				{
				p=1;
pw.println("LOGIN SUCCESSFUL");
			
				ses.setAttribute("qno",qno);
				ses.setAttribute("ques",ques);
				ses.setAttribute("ch1",ch1);
				ses.setAttribute("ch2",ch2);
				ses.setAttribute("ch3",ch3);
				ses.setAttribute("ch4",ch4);
				ses.setAttribute("msg","Successfully entered");
				pw.println("SUCCESSFUL");
				RequestDispatcher rd=req.getRequestDispatcher("tms1.html");
				rd.forward(req,res);
				}
				}
 

			if(p==0)
				{
				pw.println("<html><body>");
	pw.println("<center><br><br><br><br><br><br><h1><b>Presently no Exam is Activated</b></h1>");
			pw.println("</center></body></html>");
			pw.close();
		
				}
		
               
}	

        	catch(Exception e)
		{
		pw.println("can't load driver"+e.getMessage());
		}

}
}