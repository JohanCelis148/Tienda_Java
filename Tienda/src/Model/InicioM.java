/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Johan Celis
 */

import Conexion.Conexion;
import Interface.CRUD;
import java.util.ArrayList;
import java.util.List;

public class InicioM implements CRUD{
    
    private Integer idPer;
    private String nombrePer;
    private Integer dniPer;
    private Integer edadPer;
    private String generoPer;
    private Integer idPro;
    private String nombrePro;
    private Integer precioPro;
    private String table;

    public InicioM() {
    }
    
    Conexion conn = new Conexion();

    public Integer getIdPer() {
        return idPer;
    }

    public void setIdPer(Integer idPer) {
        this.idPer = idPer;
    }

    public String getNombrePer() {
        return nombrePer;
    }

    public void setNombrePer(String nombrePer) {
        this.nombrePer = nombrePer;
    }

    public Integer getDniPer() {
        return dniPer;
    }

    public void setDniPer(Integer dniPer) {
        this.dniPer = dniPer;
    }

    public Integer getEdadPer() {
        return edadPer;
    }

    public void setEdadPer(Integer edadPer) {
        this.edadPer = edadPer;
    }

    public String getGeneroPer() {
        return generoPer;
    }

    public void setGeneroPer(String generoPer) {
        this.generoPer = generoPer;
    }

    public Integer getIdPro() {
        return idPro;
    }

    public void setIdPro(Integer idPro) {
        this.idPro = idPro;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public int getPrecioPro() {
        return precioPro;
    }

    public void setPrecioPro(int precioPro) {
        this.precioPro = precioPro;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    @Override
    public void Consultar() {
        
    }

    @Override
    public void Modificar() {
        if (table == "personas") {
            
            String sql ="UPDATE personas SET " +
                                        "nombre = '"+this.getNombrePer()+"'," +
                                        "dni = '"+this.getDniPer()+"'," +
                                        "edad = '"+this.getEdadPer()+"'," +
                                        "genero = '"+this.getGeneroPer()+"'" +
                                    "WHERE id = '"+this.getIdPer()+"';";
            this.conn.EjecutarQuery(sql);
            
        } else if (table == "productos"){
            
            String sql ="UPDATE productos SET " +
                                        "nombre = '"+this.getNombrePro()+"'," +
                                        "precio = '"+this.getPrecioPro()+"'" +
                                    "WHERE id = '"+this.getIdPro()+"';";
            this.conn.EjecutarQuery(sql);
        }
    }

    @Override
    public void Eliminar() {
        if (table == "personas") {
            String sql = "DELETE FROM personas where id = "+this.getIdPer()+";";
            this.conn.EjecutarQuery(sql);
        } else if (table == "productos") {
            String sql = "DELETE FROM productos where id = "+this.getIdPro()+";";
            this.conn.EjecutarQuery(sql);
        }
    }
    
    @Override
    public void GuardarPro() {
        String sql = "INSERT INTO productos("
                        + " nombre, "
                        + " precio "
                    + ") VALUES("
                        + " '" + this.getNombrePro()+ "',"
                        + " " + this.getPrecioPro()+ " );";
        conn.EjecutarQuery(sql);
    }
    
    @Override
    public void GuardarPer() {
        String sql = "INSERT INTO personas("
                        + " nombre, "
                        + " dni, "
                        + " edad, "
                        + " genero "
                    + ") VALUES("
                        + " '" + this.getNombrePer()+ "',"
                        + " " + this.getDniPer()+ ","
                        + "  " + this.getEdadPer()+ ","
                        + " '" + this.getGeneroPer()+ "' );";
        conn.EjecutarQuery(sql);
    }
    
    @Override
    public List<String[]> ExtraerPersonas() {
        String sql = "SELECT * FROM personas;";
        List <String[]> resultado = conn.ConsultarPersonas(sql);
        return resultado;
    }
    
    @Override
    public List<String[]> ExtraerProductos() {
        String sql = "SELECT * FROM productos;";
        List <String[]> resultado = conn.ConsultarProductos(sql);
        return resultado;
    }
    
    @Override
    public List<String[]> ConsultarPersonasNombre() {
        String sql = "SELECT * FROM personas WHERE nombre = "+this.getNombrePer()+";";
        List <String[]> resultado = conn.ConsultarPersonas(sql);
        return resultado;
    }
    
    @Override
    public List <String[]> ValorUnitario() {
        String sql = "SELECT * FROM productos WHERE nombre = '" + nombrePro + "';";
        List <String[]> resultado = conn.ConsultarProductos(sql);
        return resultado;
    }
}