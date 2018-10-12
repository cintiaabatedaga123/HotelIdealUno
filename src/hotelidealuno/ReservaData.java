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
 * @author asus
 */
public class ReservaData {
   /*private Connection connection = null;

    public ReservaData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }


    public void guardarReserva(Reserva reserva){
        try {
            
            String sql = "INSERT INTO reserva ( cantidadPersonas , fechaEntrada , fechaSalida , importeTotal , estadoReserva)"
                    + " VALUES ( ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, reserva.getCantidadPersonas());
            statement.setDate(2, reserva.getFechaEntrada());
            statement.setDate(3, reserva.getFechaSalida());
            statement.setDouble(4, reserva.getImporteTotal());
            statement.setLong(5, reserva.getEstadoReserva());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                reserva.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un reserva");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un reserva : " + ex.getMessage());
        }
    }
    

    public List<Reserva> obtenerReserva(){
        List<Reserva> reservas = new ArrayList<Reserva>();
            

        try {
            String sql = "SELECT * FROM reserva;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Reserva reserva;
            
        while(resultSet.next()){
                reserva = new Reserva();
                reserva.setId(resultSet.getInt("id")); 
                reserva.setCantidadPersonas(resultSet.getInt("cantidadPersonas"));
                reserva.setFechaEntrada(resultSet.getDate("fechaEntrada"));
                reserva.setFechaSalida(resultSet.getDate("fechaSalida"));
                reserva.setImporteTotal(resultSet.getDouble("importeTotal"));
                reserva.setEstadoReserva(resultSet.getBoolean("estadoReserva"));

    
                reserva.add(reserva);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los reserva: " + ex.getMessage());
        }
        
        return reserva;
    }
    
    public void borrarReserva(int id){
    try {
            
            int sql = "DELETE FROM reserva WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un reserva: " + ex.getMessage());
        }
    
    }
    
    public void actualizarReserva(Reserva reserva){
    
        try {
            
            int sql = "UPDATE reserva SET cantidadPersonas = ?, fechaEntrada = ? , fechaSalida = ? , importeTotal = ? , estadoReserva = ? WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, reserva.getCantidadPersonas());
            statement.setDate(2, reserva.getFechaEntrada());
            statement.setDate(3, reserva.getFechaSalida());
            statement.setDouble(4, reserva.getImporteTotal());
            statement.setBoolean(5, reserva.getEstadoReserva());
            statement.executeUpdate();
    
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un reserva : " + ex.getMessage());
        }
    
    }
    
    public Reserva buscarReserva(int cantidadPersonas){
    Reserva reserva=null;
    try {
            
            int sql = "SELECT * FROM reserva WHERE dni =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, cantidadPersonas);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                reserva = new Reserva();
            statement.setInt(1, reserva.getCantidadPersonas());
            statement.setDate(2, reserva.getFechaEntrada());
            statement.setDate(3, reserva.getFechaSalida());
            statement.setDouble(4, reserva.getImporteTotal());
            statement.setBoolean(5, reserva.getEstadoReserva());
                
            }      
            statement.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar un reserva : " + ex.getMessage());
        }
        
        return reserva;
    }
   */
}
