/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;

/**
 *
 * @author Johan Celis
 */
public interface CRUD {
    
    public void Consultar();
    
    public void Modificar();
    
    public void Eliminar();
    
    public void GuardarPro();
    
    public void GuardarPer();
    
    public List <String[]> ExtraerPersonas();
    
    public List <String[]> ExtraerProductos();
    
    public List <String[]> ConsultarPersonasNombre();
    
    public List <String[]> ValorUnitario();
}
