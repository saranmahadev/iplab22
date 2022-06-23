import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MyServlet extends HttpServlet {
 
 private int iHitCounter;
@Override
 public void init() throws ServletException
 {
 iHitCounter = 0;
 }
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 response.setContentType("text/html;charset=UTF-8");
 try (PrintWriter out = response.getWriter()) {
 out.println("<!DOCTYPE html>");
 out.println("<html>");
 out.println("<head>");
 out.println("<title>Servlet MyServlet SHEIK</title>"); 
 out.println("</head>");
 out.println("<body>");
 out.println("<h1>Servlet MyServlet at " + request.getLocalName() + "</h1>");
 out.println("</body>");
 out.println("</html>");
 }
 }
 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException 
 {
 //processRequest(request, response);
 //response.setContentType("text/html;charset=UTF-8");
 //try (PrintWriter out = response.getWriter()) {
 /* TODO output your page here. You may use following sample code. */
 // out.println("<h2> Welcome</h2>");
 
 //}
 
 PrintWriter out = response.getWriter(); 
 response.setContentType("text/html;charset=UTF-8");
 String n=request.getParameter("userName"); 
 out.print("Welcome "+n); 
//creating form that have invisible textfield 
 out.print("<form action='MyServlet2'>"); 
 out.print("<input type='hidden' name='uname' value='"+n+"'>"); 
 out.print("<input type='submit' value='go'>"); 
 out.print("</form>"); 
 
 // PrintWriter out = response.getWriter();
 out.println("<form><fieldset style='width:15%'>");
 out.println("<h3>Welcome to my website !</h3><hr>");
 out.println("You are visitor number: "+ (++iHitCounter));
 out.println("</fieldset></form>");
 out.close(); 
 
 
 }
 /**
 * Handles the HTTP <code>POST</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException 
 {
 // processRequest(request, response);
 doGet(request, response);
 
 }
 /**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
 @Override
 public String getServletInfo() {
 return "Short description";
 }// </editor-fold>
}