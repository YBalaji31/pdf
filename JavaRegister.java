import java.io.*;  
import java.sql.*;    
import javax.servlet.http.*;
import javax.servlet.ServletException; 
  
public class JavaRegister extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html"); 
    PrintWriter out = response.getWriter();  
    Connection con = null;         
    String name=request.getParameter("userName");  
    String pass=request.getParameter("userPass");  
    String email=request.getParameter("userEmail");  
    String country=request.getParameter("userCountry");  
    try {
              
    out.println("Database created...");
    Class.forName("com.mysql.jdbc.Driver");//Register
    out.println("Database registered...");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
    out.print("Database connected...");
    PreparedStatement ps=con.prepareStatement(  
    "insert into register(userName,userPass,userEmail,userCountry) values(?,?,?,?)");  
    out.println("Inserted...");
    ps.setString(1,name);  
    ps.setString(2,pass);  
    ps.setString(3,email);  
    ps.setString(4,country);  
              
    int n=ps.executeUpdate();  
    out.println("n="+n);
    if(n>0) 
    out.print("<html><body><br><h2>Your data, entered in form are successfully inserted in database........</h2></body></html>");  
    out.close();
    con.close();   
    }catch (Exception e) {
    System.out.println(e);
    e.printStackTrace();
    }  
}
}


/*

<web-app>  
  
<servlet>  
<servlet-name>Register</servlet-name>  
<servlet-class>JavaRegister</servlet-class>  
</servlet>  
  
<servlet-mapping>  
<servlet-name>Register</servlet-name>  
<url-pattern>/javaregister</url-pattern>  
</servlet-mapping>  
  
</web-app> 

*/