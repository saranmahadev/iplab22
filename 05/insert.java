import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class insert extends HttpServlet {
 Connection conn=null;
 Statement stmt=null;
 ResultSet rs=null;
 
 
 @Override
 public void init(ServletConfig config)throws ServletException
 {
 super.init(config);
 try
 {
 String database="D:/ex5/StudExamDB.accdb";
 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
conn=DriverManager.getConnection("jdbc:ucanaccess://"+database); 
 stmt=conn.createStatement();
 }
 catch(ClassNotFoundException | SQLException e)
 {
 System.out.println("Driver not connected Error :"+e);
 }
 }
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException, SQLException 
 {
 response.setContentType("text/html;charset=UTF-8");
 PrintWriter out = response.getWriter();
 String str1=request.getParameter("ans1");
 String str2=request.getParameter("ans2");
 String str3=request.getParameter("ans3");
 try
 {
 rs=stmt.executeQuery("SELECT * FROM examans");
 int mark=0;
 int i=1;
 while(rs.next())
 {
 if(i==1)
 {
 String dbans1=rs.getString(1);
 if(str1.equals(dbans1))
 {
 mark=mark+5;
 }
 
 }
 if(i==2)
 {
 String dbans2=rs.getString(1);
 if(str2.equals(dbans2))
 {
 mark=mark+5;
}
 
 }
 if(i==3)
 {
 String dbans3=rs.getString(1);
 if(str3.equals(dbans3))
 {
 mark=mark+5;
 }
 
 }
 ++i;
 
 } 
 
 if(mark >= 10)
 {
 out.println("<h4>Your Mark Is : "+mark+"</h4>");
 out.println("<h3>Congratulations....! You Are Eligible For The Next Round...</h3>");
 }
 else
 {
 out.println("<h4>Your Mark is : "+mark+"</h4>");
 out.println("<h3>Sorry....!! You Are Not Eligible For The Next Round...</h3>");
 } 
 }
 
 catch(Exception e)
 {
 System.out.println("SQLException :"+e);
 }
 
 }
 
 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException 
 {
 try {
 processRequest(request, response);
 } catch (SQLException ex) {
Logger.getLogger(insert.class.getName()).log(Level.SEVERE, null, ex);
 }
 }
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 try {
 processRequest(request, response);
 } catch (SQLException ex) {
 Logger.getLogger(insert.class.getName()).log(Level.SEVERE, null, ex);
 }
 }
 @Override
 public String getServletInfo() {
 return "Short description";
 }// </editor-fold>
}