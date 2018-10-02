/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelidealuno;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class HuespedData {
    private Connection connection = null;

    public HuespedData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    public void guardarHuesped(Huesped huesped){
        try {
            
            String sql = "INSERT INTO huesped (nombre, dni, domicilio, correo, celular ) VALUES ( ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, huesped.getNombre());
            statement.setInt(2, huesped.getDni());
            statement.setString(3, huesped.getDomicilio());
            statement.setString(4,huesped.getCorreo());
            statement.setLong(5, huesped.getCelular());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                huesped.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un husped");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped : " + ex.getMessage());
        }
    }
    
    public List<Huesped> obtenerHuespedes(){
        List<Huesped> huespedes = new ArrayList<Huesped>();
            

        try {
            String sql = "SELECT * FROM huesped;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Huesped huesped;
            while(resultSet.next()){
                huesped = new Huesped();
                huesped.setId(resultSet.getInt("id")); 
                huesped.setNombre(resultSet.getString("nombre"));
                //huesped.setFecNac(resultSet.getDate("fecNac").toLocalDate());
                huesped.setDni(resultSet.getInt("dni"));
                huesped.setDomicilio(resultSet.getString("domicilio"));
                huesped.setCorreo(resultSet.getString("correo"));
                huesped.setCelular(resultSet.getLong("celular"));
    
                huespedes.add(huesped);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los huesped: " + ex.getMessage());
        }
        
        
        return huespedes;
    }
    
    public void borrarAlumno(int id){
    try {
            
            String sql = "DELETE FROM alumno WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped: " + ex.getMessage());
        }
        
    
    }
    
    public void actualizarHusped(Huesped huesped){
    
        try {
            
            String sql = "UPDATE husped SET nombre = ?, dni = ? , domicilio = ? , correo = ? , celular = ? WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, huesped.getNombre());
            statement.setInt(2, huesped.getDni());
            //statement.setDate(2, Date.valueOf(huesped.getFecNac()));
            statement.setString(3, huesped.getDomicilio());
            statement.setString(4, huesped.getCorreo());
            statement.setLong(5, huesped.getCelular());
            statement.setInt(6, huesped.getId());
            statement.executeUpdate();
    
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped : " + ex.getMessage());
        }
    
    }
    
    public Huesped buscarHuesped(int id){
    Huesped huesped=null;
    try {
            
            String sql = "SELECT * FROM huesped WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                huesped = new Huesped();
                huesped.setId(resultSet.getInt("id"));
                huesped.setNombre(resultSet.getString("nombre"));
                //huesped.setFecNac(resultSet.getDate("fecNac").toLocalDate());
                huesped.setDni(resultSet.getInt("dni"));
                huesped.setDomicilio(resultSet.getString("domicilio"));
                huesped.setCorreo(resultSet.getString("correo"));
                huesped.setCelular(resultSet.getLong("celular"));
                
            }      
            statement.close();
            
            
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped : " + ex.getMessage());
        }
        
        return huesped;
    }
   
}
