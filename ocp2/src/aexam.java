import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class aexam extends HttpServlet
{
	Connection con=null;
	Statement ps=null;	
	ResultSet rs=null;
	
public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
{			PrintWriter pw=res.getWriter();

			String dt=req.getParameter("date");
			String tim=req.getParameter("time");
			String pap=req.getParameter("paper");
			String dur=req.getParameter("duration");
			String ky=req.getParameter("key");
			String paper=pap.replace("\\","\\\\");
			pw.println(dt+"<br>"+tim+"<br>"+pap+"<br>"+dur+"<br>"+ky+"<br>"+paper);
	FileReader f1=new FileReader(paper);
	BufferedReader br1=new BufferedReader(f1);
res.setContentType("text/html");
int i=0;
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
        	con=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");		
			ps=con.createStatement();
//pw.println("hello");
String s=br1.readLine();
//pw.println(s);
String sfname=req.getParameter("sfname");
        	
do
	{
	i++;
	//pw.println(i);
		
		String ans[]=s.split(",");
		//pw.println("insert into key(qno,ques,ch1,ch2,ch3,ch4) values ("+i+",'"+ans[0]+"','"+ans[1]+"','"+ans[2]+"','"+ans[3]+"','"+ans[4]+"')");
		ps.executeUpdate("insert into key values ("+i+",'"+ans[0]+"','"+ans[1]+"','"+ans[2]+"','"+ans[3]+"','"+ans[4]+"',to_date('"+dt+":"+tim+"','DD.MM.YYYY:HH24:MI:SS'))");
	
	}while((s=br1.readLine())!=null);
con.commit();
pw.println("<html><head></head><body><center><h1>Thank You</h1></center></body></html>");
}
catch(Exception e)
{
System.out.println(e);
}
}
}
