/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelidealuno;

/**
 *
 * @author asus
 */
public class Reserva {
    private int id=-1;
    private int cantidadPersonas;
    private String fechaEntrada;
    private String fechaSalida;
    private double importeTotal;
    private boolean estadoReserva;

    public Reserva(int id, int cantidadPersonas, String fechaEntrada, String fechaSalida, double importeTotal, boolean estadoReserva) {
        this.id = id;
        this.cantidadPersonas = cantidadPersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.importeTotal = importeTotal;
        this.estadoReserva = estadoReserva;
    }

    public Reserva(int cantidadPersonas, String fechaEntrada, String fechaSalida, double importeTotal, boolean estadoReserva) {
        this.cantidadPersonas = cantidadPersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.importeTotal = importeTotal;
        this.estadoReserva = estadoReserva;
    }
    
    
    
    
    public Reserva() {
    
    
}
