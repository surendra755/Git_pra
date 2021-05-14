import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
import java.lang.*;

public class Rsavex extends HttpServlet
{
Connection conn;
Statement stmt;
ResultSet rs;
ResultSet rs1;
HttpSession ses=null;
public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

try
{
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
 conn=DriverManager.getConnection("jdbc:odbc:wipro","scott","tiger");
 stmt=conn.createStatement();
 RequestDispatcher rd;
 ses=req.getSession(true);
 String userid=(String)ses.getAttribute("suserid");
 int s=0;
 rs1=stmt.executeQuery("select result from student where suserid='"+userid+"'");
rs1.next();
String p=rs1.getString("result");
if(p.equals("noexamyet"))
s=1;
if(s==1)
{

    rs=stmt.executeQuery("select qno,ques,ch1,ch2,ch3,ch4,time from key ");
String qno[]=new String[10];
String ques[]=new String[200];
String ch1[]=new String[10];
String ch2[]=new String[10];
String ch3[]=new String[10];
String ch4[]=new String[10];

String sqno[]=new String[10];
String sques[]=new String[10];
String sch1[]=new String[10];
String sch2[]=new String[10];
String sch3[]=new String[10];
String sch4[]=new String[10];

String times="";
 
String xxx[]=new String[12];
int s2[]=new int[12];
int j=0,q=0;
while(rs.next())
{
	    
                req.setAttribute("sqno["+j+"]",rs.getString("qno"));
				req.setAttribute("sques["+j+"]",rs.getString("ques"));
				req.setAttribute("sch1["+j+"]",rs.getString("ch1"));
				req.setAttribute("sch2["+j+"]",rs.getString("ch2"));
				req.setAttribute("sch3["+j+"]",rs.getString("ch3"));
				req.setAttribute("sch4["+j+"]",rs.getString("ch4"));
					times=rs.getString("time");
                                
				j++;
			}
			
			req.setAttribute("cnt",j);






 rs=stmt.executeQuery("select ans from ans");
int i=1;
float x=0,y=0,z=0;
while(rs.next())
	{
	xxx[i]=req.getParameter("r"+i);
 s2[i]=rs.getInt("ans");
	

if(xxx[i]==null)
		{
y++;
xxx[i]="U";
		}
else
		{
	int s1=Integer.parseInt(xxx[i]);
	pw.println(s2[i]+"<br>");
				if(s1==s2[i])
				x++;
               else
	            z++;
		}
	req.setAttribute("key["+i+"]",s2[i]);
	req.setAttribute("res["+i+"]",xxx[i]);
	i++;

}

java.util.Date dt =new java.util.Date();
 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
java.util.Date d = (java.util.Date)formatter.parse(times);
      Format form = new SimpleDateFormat("");
 // pw.println("helllo"+"\t"+form.format(d)); 
//pw.println(d.getTime()+"\t"+dt.getTime());
 
                                            
                                                  if(dt.getTime()>=d.getTime())
				{
				q=1;
		
				pw.println("SUCCESSFUL");
			
				}

if(q==1)
{
float a=(x-(z/4));
req.setAttribute("ct",i);
req.setAttribute("corans",x);
req.setAttribute("wrgans",z);
req.setAttribute("unans",y);
req.setAttribute("result",a);

String qry1="";
qry1="update student set result="+a+" where suserid='"+userid+"'";
pw.println("qry1");
stmt.executeUpdate(qry1);

rd=req.getRequestDispatcher("result.jsp");
				rd.forward(req,res);

}
 

 }
if(s==0)
pw.println("<center><font color=blue size=5>ALREADY UR EXAM IS SUBMITTED</font></center>");
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