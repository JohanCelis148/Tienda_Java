/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.InicioM;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johan Celis
 */
public class InicioC {
    
    InicioM inicioM  = new InicioM();
    List<String[]> resultado = new ArrayList<>();
    
    public void GuardarPersona(String Nombre, Integer Dni, Integer Edad, String Genero){
        inicioM.setNombrePer(Nombre);
        inicioM.setDniPer(Dni);
        inicioM.setEdadPer(Edad);
        inicioM.setGeneroPer(Genero);
        inicioM.GuardarPer();
    }
    
    public void ModificarPersona(Integer Id, String Nombre, Integer Dni, Integer Edad, String Genero, String Table){
        inicioM.setNombrePer(Nombre);
        inicioM.setIdPer(Id);
        inicioM.setDniPer(Dni);
        inicioM.setEdadPer(Edad);
        inicioM.setGeneroPer(Genero);
        inicioM.setTable(Table);
        inicioM.Modificar();    
    }
    
    public void GuardarProducto(String nombre, Integer precio){
        inicioM.setNombrePro(nombre);
        inicioM.setPrecioPro(precio);
        inicioM.GuardarPro();
    }
    
    public void ModificarProducto(Integer Id, String nombre, Integer precio, String Table){
        inicioM.setIdPro(Id);
        inicioM.setNombrePro(nombre);
        inicioM.setPrecioPro(precio);
        inicioM.setTable(Table);
        inicioM.Modificar();    
    }
    
    public List <String[]> ExtraerProductos(){
        resultado = inicioM.ExtraerProductos();
        return resultado;
    }
    
    public List <String[]> ExtraerPersonas(){
        resultado = inicioM.ExtraerPersonas();
        return resultado;
    }
    
    public List <String[]> ConsultarPersonasNombre(String Nombre){
        inicioM.setNombrePer(Nombre);
        resultado = inicioM.ExtraerPersonas();
        return resultado;
    }
    
    public void EliminarProducto (Integer id, String Table){
        inicioM.setIdPro(id);
        inicioM.setTable(Table);
        inicioM.Eliminar();
    }
    
    public void EliminarPersonas (Integer id, String Table){
        inicioM.setIdPer(id);
        inicioM.setTable(Table);
        inicioM.Eliminar();
    }
    
    public List <String[]> ValorUnitario (String Producto){
        inicioM.setNombrePro(Producto);
        resultado = inicioM.ValorUnitario();
        return resultado;
    }
}
