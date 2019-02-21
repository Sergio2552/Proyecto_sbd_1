/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Sergio
 */
public class UsuarioPOJO {
    //Plain Old Java Object
    private String correo;
    private String contrasena;

    /**
     * @return the correo
     */
    
    public UsuarioPOJO(String email, String pass){
        correo= email;
        contrasena = pass;
    }


    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }
    
    public void set(String set){
        correo = set;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }
  
   
    
    /**
     * @return the nombre
     */
    
    
    
    
    
}
