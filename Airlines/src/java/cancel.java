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
public class cancel extends HttpServlet {
    
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
                     
         
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         String t2=request.getParameter("T1");
        
        Integer in1=new Integer(t2);
      int w=in1.intValue();
        int i=sqlst.executeUpdate("delete from custinfo where PNRNO="+w+" ");
       
         
         
          out.print("<html><head></head><body>");
        out.print("<center>");
        out.print("<table border=2>");
        out.print("<tr>");   
             out.print("<th>");
                    out.print("Details");
                      out.print("</th>");
                      out.print("<th>");
                    out.print("Your Cacellation is Done");
                      out.print("</th>");
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
