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
public class login extends HttpServlet {
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
 try (PrintWriter out = response.getWriter()) 
 {
 
 int count=0;
int rollno = Integer.parseInt(request.getParameter("rollno"));
 int seatno = Integer.parseInt(request.getParameter("seatno"));
 rs=stmt.executeQuery("select * from Studtable where rollno="+rollno+" and 
seatno="+seatno+"");
 while(rs.next())
 {
 count++;
 
 }
 if(count==1)
 {
 String site = new String("http://localhost:8080/Onlineexam/index1.html");
 response.setStatus(response.SC_MOVED_TEMPORARILY);
 response.setHeader("Location", site); 
 }
 else
 {
 out.println("Login Error");
 }
 }
 }
 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 try {
processRequest(request, response);
 } catch (SQLException ex) {
 Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
 }
 }
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 try {
 processRequest(request, response);
 } catch (SQLException ex) {
 Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
 }
 }
 @Override
 public String getServletInfo() {
 return "Short description";
 }// </editor-fold>
}