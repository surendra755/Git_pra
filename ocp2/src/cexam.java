import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class cexam extends HttpServlet
{
    Connection con=null;
	Statement ps=null;	
	ResultSet rs=null;
	ResultSet rs1=null;ResultSet rs3=null;
	HttpSession ses=null;
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException ,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
	    try
		{
	   		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");    	 
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
			int p=0,i=0;
		//	String qno[]=new String[10];
		//	String ques[]=new String[200];
		//	String ch1[]=new String[20];
		//	String ch2[]=new String[20];
		//	String ch3[]=new String[20];
		//	String ch4[]=new String[20];
			String times;
            rs=ps.executeQuery("select qno,ques,ch1,ch2,ch3,ch4,time from key ");
			while(rs.next())
			{
			    //qno[i]=rs.getString("qno");		
//		        ques[i]=rs.getString("ques");	
//				ch1[i]=rs.getString("ch1");
//				ch2[i]=rs.getString("ch2");
//				ch3[i]=rs.getString("ch3");
//				ch4[i]=rs.getString("ch4");
			
                req.setAttribute("sqno["+i+"]",rs.getString("qno"));
				req.setAttribute("sques["+i+"]",rs.getString("ques"));
				req.setAttribute("sch1["+i+"]",rs.getString("ch1"));
				req.setAttribute("sch2["+i+"]",rs.getString("ch2"));
				req.setAttribute("sch3["+i+"]",rs.getString("ch3"));
				req.setAttribute("sch4["+i+"]",rs.getString("ch4"));
					times=rs.getString("time");
				i++;
				java.util.Date dt =new java.util.Date();
			    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.util.Date d = (java.util.Date)formatter.parse(times);
			    Format form = new SimpleDateFormat("");
				if(dt.getTime()>=d.getTime())
				{
					p=1;
				}
			}
			if(p==1)
			{
				req.setAttribute("cnt",i);
				RequestDispatcher rd=req.getRequestDispatcher("exam.jsp");
				rd.forward(req,res);
			}
			else
			{
				pw.println("<html><body ><center>");
				pw.println("<br><br><br><br><br><br><h1><b><font color=blue>Presently no Exam is Activated</font></b></h1>");
				pw.println("<br><h4><font color=red>Click refresh to get the exam paper</font></h4>");
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