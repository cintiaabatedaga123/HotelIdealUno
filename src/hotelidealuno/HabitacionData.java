/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelidealuno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class HabitacionData {
    private Connection connection = null;

    public HabitacionData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }

    // GUARDA UNA HABITACION NUEVA EN LA BASE DE DATOS...
    public void guardarHabitacion(Habitacion habitacion){
        try {
            
            String sql = "INSERT INTO habitacion ( piso, estado )"
                    + " VALUES ( ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, habitacion.getPiso());
            statement.setBoolean(2, habitacion.isEstado());
            
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                habitacion.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un habitacion");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una habitacion : " + ex.getMessage());
        }
    }
    
    // LISTA TODOS LAS HABITACIONES EXISTENTES EN LA BASE DE DATOS (metodo no utilizado)
    public List<Habitacion> obtenerHabitaciones(){
        List<Habitacion> habitaciones = new ArrayList<Habitacion>();
            

        try {
            String sql = "SELECT * FROM habitacion;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setId(resultSet.getInt("id_habitacion")); 
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setEstado(resultSet.getBoolean("estado"));
                
                 
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las habitaciones: " + ex.getMessage());
        }
        
        return habitaciones;
    }
    
   
    // ACTUALIZAR UNA HABITACION EXISTENTE EN LA BASE DE DATOS...
    public void actualizarHabitacion(Habitacion habitacion){
    
        try {
            
            String sql = "UPDATE habitacion SET piso = ?, estado = ? WHERE id_habitacion = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, habitacion.getPiso());
            statement.setBoolean(2, habitacion.isEstado());
            //statement.setDate(2, Date.valueOf(huesped.getFecNac()));
            
            statement.setInt(3, habitacion.getId());
            statement.executeUpdate();
    
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un habitacion : " + ex.getMessage());
        }
    
    }
    
    // BUSCA UNA HABITACION EXISTENTE EN LA BASE DE DATOS...
    public Habitacion buscarHabitacion(boolean estado){
    Habitacion habitacion=null;
    try {
            
            String sql = "SELECT * FROM habitacion WHERE  = ? ;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setBoolean(1, estado);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setId(resultSet.getInt("id_habitacion"));
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setEstado(resultSet.getBoolean("estado"));
               
                
            }      
            statement.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar un habitacion : " + ex.getMessage());
        }
        
        return habitacion;
    }
   
}


