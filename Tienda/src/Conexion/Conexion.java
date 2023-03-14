/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

/**
 *
 * @author Johan Celis
 */


import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Conexion {
    Connection conn;

    private void Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void EjecutarQuery(String sql) {
        try {
            this.Conexion();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ResultSet consulta(String sql){
        ResultSet res = null;
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            res = pstm.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return res;
    }

    public List<String[]> ConsultarPersonas (String sql){
        List<String[]> personas = new ArrayList<>();
        
        try {
            
            this.Conexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                
                String[] registros = new String[5];
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("dni");
                registros[3] = rs.getString("edad");
                registros[4] = rs.getString("genero");
                personas.add(registros);
                
            }
            
            return personas;
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public List<String[]> ConsultarProductos (String sql){
        List<String[]> productos = new ArrayList<>();
        
        try {
            
            this.Conexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                
                String[] registros = new String[3];
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("precio");
                productos.add(registros);
                
            }
            
            return productos;
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

   
}
