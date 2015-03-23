/*
 * login.java
 *
 * Created on October 29, 2009, 12:06 PM
 */

import java.io.*;
import java.net.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author User
 * @version
 */
public class login extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Statement sqlst=null;
        try
        { Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
            Connection con = DriverManager.getConnection("jdbc:odbc:master");//getOracleJDBCConnection();
	    if(con!= null){
               System.out.println("Got Connection.");
	   sqlst=con.createStatement();
            }
                     
         ResultSet rs=null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         String t2=request.getParameter("T1");
        
        Integer in1=new Integer(t2);
      int w=in1.intValue();
        rs=sqlst.executeQuery("select * from custinfo where PNRNO="+w+" ");
       
        boolean b=rs.next();
     	String s1=rs.getString(1);
     	String s2=rs.getString(2);
        String s3=rs.getString(3);
        String s4=rs.getString(4);
        String s5=rs.getString(5);
        String s6=rs.getString(6);
        String s7=rs.getString(7);
        String s8=rs.getString(8);
        String s9=rs.getString(9);
        String s10=rs.getString(10);
        String s11=rs.getString(11);
        String s12=rs.getString(12);
        
         
         
          out.print("<html><head></head><body>");
        out.print("<center>");
        out.print("<table border=2>");
        out.print("<tr>");   
             out.print("<th>");
                    out.print("Details");
                      out.print("</th>");
                      out.print("<th>");
                    out.print("Customer");
                      out.print("</th>");
                         out.print("</tr>");
             out.print("<tr>");
              out.print("<td>");
                    out.print("FIRSTNAME");
                      out.print("</td>");
                 out.print("<td>");
            out.print(s1);
            out.print("</td>");
            out.print("</tr>");
          out.print("<tr>");
           out.print("<td>");
                    out.print("LASTNAME");
                      out.print("</td>");
                 out.print("<td>");
           out.print(s2);
             out.print("</td>");
           out.print("</tr>");
          out.print("<tr>");
           out.print("<td>");
                    out.print("EMAIL ID");
                      out.print("</td>");
           out.print("<td>");
           out.print(s3);
          out.print("</td>");
          out.print("</tr>");   
          out.print("<tr>");
           out.print("<td>");
                    out.print("DATE OF JOURNEY");
                      out.print("</td>");
           out.print("<td>");
           out.print(s4);
             out.print("</td>");
          out.print("</tr>");
              out.print("<tr>");   
             out.print("<td>");
                    out.print("MONTH");
                      out.print("</td>");
                      out.print("<td>");
                    out.print(s5);
                      out.print("</td>");
                         out.print("</tr>");
                            out.print("<tr>");   
             out.print("<td>");
                    out.print("YEAR");
                      out.print("</td>");
                      out.print("<td>");
                    out.print(s6);
                      out.print("</td>");
                         out.print("</tr>");
                            out.print("<tr>");   
             out.print("<td>");
                    out.print("SOURCE");
                      out.print("</td>");
                      out.print("<td>");
                    out.print(s7);
                      out.print("</td>");
                         out.print("</tr>");
                            out.print("<tr>");   
             out.print("<td>");
                    out.print("destination");
                      out.print("</td>");
                      out.print("<td>");
                    out.print(s8);
                      out.print("</td>");
                         out.print("</tr>");
                            out.print("<tr>");   
             out.print("<td>");
                    out.print("FLIGHT NAME");
                      out.print("</td>");
                      out.print("<td>");
                    out.print(s9);
                      out.print("</td>");
                         out.print("</tr>");
                            out.print("<tr>");   
             out.print("<td>");
                    out.print("AGE");
                      out.print("</td>");
                      out.print("<td>");
                    out.print(s10);
                      out.print("</td>");
                         out.print("</tr>");
                            out.print("<tr>");   
             out.print("<td>");
                    out.print("GENDER");
                      out.print("</td>");
                      out.print("<td>");
                    out.print(s11);
                      out.print("</td>");
                         out.print("</tr>");
                            out.print("<tr>");   
             out.print("<td>");
                    out.print("CREDIT CARD NO");
                      out.print("</td>");
                      out.print("<td>");
                    out.print(s12);
                      out.print("</td>");
                         out.print("</tr>");
                         
           out.println("<br>");
            out.print("</table>");
            out.print("<form  method='post' action='TP.HTML'>") ;
                out.print("<input type='submit' name='Next' value='Next'>" );
                out.print("</form>");
        
        out.print("</center>");
        
        out.print("</body></html>");
       
         }
        
            catch(Exception e)
            {
                e.printStackTrace();
            }
        //out.close();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
