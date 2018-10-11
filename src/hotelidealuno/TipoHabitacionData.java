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
 * @author okped
 */
public class TipoHabitacionData {
    private Connection connection = null;

    public TipoHabitacionData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    public void guardarTipoHabitacion(TipoHabitacion tipoHabitacion){
        try {
            
            String sql = "INSERT INTO tipoHabitacion (tipo, precioPorNoche, cantPersonasMax, cantCamas, tipoCama ) VALUES ( ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, tipoHabitacion.getTipo());
            statement.setDouble(2, tipoHabitacion.getPrecioPorNoche());
            statement.setInt(3, tipoHabitacion.getCantPersonasMax());
            statement.setInt(4, tipoHabitacion.getCantCamas());
            statement.setString(5, tipoHabitacion.getTipoCama());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                tipoHabitacion.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un tipoHabitacion");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un tipoHabitacion : " + ex.getMessage());
        }
    }
    
    public List<TipoHabitacion> obtenerTipoHabitaciones(){
        List<TipoHabitacion> tipoHabitaciones = new ArrayList<TipoHabitacion>();
            

        try {
            String sql = "SELECT * FROM tipoHabitacion;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            TipoHabitacion tipoHabitacion;
            while(resultSet.next()){
                tipoHabitacion = new TipoHabitacion();
                tipoHabitacion.setId(resultSet.getInt("id")); 
                tipoHabitacion.setTipo(resultSet.getString("tipo"));
                //huesped.setFecNac(resultSet.getDate("fecNac").toLocalDate());
                tipoHabitacion.setPrecioPorNoche(resultSet.getDouble("precioPorNoche"));
                tipoHabitacion.setCantPersonasMax(resultSet.getInt("cantPersonasMax"));
                tipoHabitacion.setCantCamas(resultSet.getInt("cantCamas"));
                tipoHabitacion.setTipoCama(resultSet.getString("tipoCama"));
    
                tipoHabitaciones.add(tipoHabitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los tipoHabitacion: " + ex.getMessage());
        }
        
        
        return tipoHabitaciones;
    }
    
    public void borrarTipoHabitacion(int id){
    try {
            
            String sql = "DELETE FROM tipoHabitacion WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un tipoHabitacion: " + ex.getMessage());
        }
        
    
    }
    
    public void actualizarTipoHabitacion(TipoHabitacion tipoHabitacion){
    
        try {
            
            String sql = "UPDATE tipoHabitacion SET tipo = ?, precioPorNoche = ? , cantPersonasMax = ? , cantCamas = ? , tipoCama = ? WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, tipoHabitacion.getTipo());
            statement.setDouble(2, tipoHabitacion.getPrecioPorNoche());
            //statement.setDate(2, Date.valueOf(huesped.getFecNac()));
            statement.setInt(3, tipoHabitacion.getCantPersonasMax());
            statement.setInt(4, tipoHabitacion.getCantCamas());
            statement.setString(5, tipoHabitacion.getTipoCama());
            statement.setInt(6, tipoHabitacion.getId());
            statement.executeUpdate();
    
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un tipoHabitacion : " + ex.getMessage());
        }
    
    }
    
    public TipoHabitacion buscarTipoHabitacion(int id){
    TipoHabitacion tipoHabitacion=null;
    try {
            
            String sql = "SELECT * FROM tipoHabitacion WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                tipoHabitacion = new TipoHabitacion();
                tipoHabitacion.setId(resultSet.getInt("id"));
                tipoHabitacion.setTipo(resultSet.getString("tipo"));
                //huesped.setFecNac(resultSet.getDate("fecNac").toLocalDate());
                tipoHabitacion.setPrecioPorNoche(resultSet.getDouble("precioPorNoche"));
                tipoHabitacion.setCantPersonasMax(resultSet.getInt("cantPersonasMax"));
                tipoHabitacion.setCantCamas(resultSet.getInt("cantCamas"));
                tipoHabitacion.setTipoCama(resultSet.getString("tipoCama"));
                
            }      
            statement.close();
            
            
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un tipoHabitacion : " + ex.getMessage());
        }
        
        return tipoHabitacion;
    }
   
}
