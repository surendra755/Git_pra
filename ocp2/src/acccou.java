import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.text.*;
import javax.servlet.http.*;
public class acccou extends HttpServlet
{
    Connection con=null; 
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    PrintWriter out = res.getWriter();    
    res.setContentType("text/html");
    try
    {
		out.println("one is ");
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
        con=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger"); 
		RequestDispatcher rd;
		Statement s=con.createStatement();
	    String st1="",st2="",st3=""; 
		int i,j=0,k=0;
		if((req.getParameterValues("sta"))!=null)
        {
			String id[]=req.getParameterValues("sta");
            int n=id.length; 
            for(i=0;i<n;i++)
	     	{
				out.println("update upload set status='accepted' where upid="+id[i]+"");
	  			s.executeUpdate("update upload set status='accepted' where upid="+id[i]+"");
				con.commit();
            }
		} 
        rd=req.getRequestDispatcher("upback.jsp");
      	rd.forward(req,res);     
	 }
	catch(Exception e)
	{
		//out.println("can't load driver"+e.getMessage());
	}
	out.close();
	}
}

