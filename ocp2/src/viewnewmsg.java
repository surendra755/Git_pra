import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
import java.lang.*;
public class viewnewmsg extends HttpServlet
{
 Connection con=null;
 Statement ps=null;
 ResultSet rs=null;
 public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
 {
  res.setContentType("text/html");
  PrintWriter pw=res.getWriter();
 
  try
  {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   con=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");		
   ps=con.createStatement();
   RequestDispatcher rd;
   int i=0;
  int j=0; 
   rs=ps.executeQuery("select * from submitmsg");
	while(rs.next())
	  {
   req.setAttribute("aut["+i+"]",rs.getString(1));
   req.setAttribute("ml["+i+"]",rs.getString(2));
   req.setAttribute("sub["+i+"]",rs.getString(3));
   req.setAttribute("cid["+i+"]",rs.getString(4));
   req.setAttribute("msg["+i+"]",rs.getString(5));
   req.setAttribute("dt["+i+"]",rs.getString(6));
   req.setAttribute("qid["+i+"]",rs.getString(7));
//pw.println(rs.getString(1)+"&nbsp;"+rs.getString(2)+"&nbsp;"+rs.getString(3)+"&nbsp;"+rs.getString(4)+"&nbsp;"+rs.getString(5)+"&nbsp;"+rs.getString(6)+"&nbsp;"+rs.getString(7)+"&nbsp;"+i+"<br><br><br>");
	   i++;
	  }
	req.setAttribute("cnt",i);
    // pw.println(rs.getString(1)+"&nbsp;"+rs.getString(2)+"&nbsp;"+rs.getString(3)+"&nbsp;"+rs.getString(4)+"&nbsp;"+rs.getString(5)+"&nbsp;"+rs.getString(6)+"&nbsp;"+rs.getString(7)+"<br>");
    j=0;
	rs=ps.executeQuery("select * from responsemsg");
  while(rs.next())
	 {
		 req.setAttribute("aut1["+j+"]",rs.getString(1));
		 req.setAttribute("ml1["+j+"]",rs.getString(2));
		 req.setAttribute("sub1["+j+"]",rs.getString(3));
		 req.setAttribute("cid1["+j+"]",rs.getString(4));
		 req.setAttribute("msg1["+j+"]",rs.getString(5));
		 req.setAttribute("day["+j+"]",rs.getString(6));
		 req.setAttribute("ansid["+j+"]",rs.getString(7));
		 req.setAttribute("qid1["+j+"]",rs.getString(8));
 //   pw.println(rs.getString(1)+"&nbsp;"+rs.getString(2)+"&nbsp;"+rs.getString(3)+"&nbsp;"+rs.getString(4)+"&nbsp;"+rs.getString(5)+"&nbsp;"+rs.getString(6)+"&nbsp;"+rs.getString(7)+"&nbsp;"+rs.getString(8)+"<br>");
   j++;
	  }
	 req.setAttribute("cnt1",j);
	  rd=req.getRequestDispatcher("postnew.jsp");
	  rd.forward(req,res);
	}
    catch(ClassNotFoundException e)
    {
     pw.println("exception"+e);
    }
    catch(SQLException e)
    {
    pw.println("SQL EXCEPTION"+e);	
     pw.println("TRY AGAIN");
    }
    catch(Exception e)
    {
     pw.println("can't load driver"+e.getMessage());
    }
}
}