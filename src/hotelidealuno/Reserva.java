/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelidealuno;

/**
 *
 * @author Usuario
 */
public class Reserva {
 private int id_reserva=-1;
 private int cantidadPersonas;
 private String fechaEntrada;
 private String fechaSalida;
 private double importeTotal;
 private boolean estadoReserva;

    public Reserva(int id_reserva, int cantidadPersonas, String fechaEntrada, String fechaSalida, double importeTotal, boolean estadoReserva) {
        this.id_reserva = id_reserva;
        this.cantidadPersonas = cantidadPersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.importeTotal = importeTotal;
        this.estadoReserva = estadoReserva;
    }

    public Reserva(int id_reserva, int cantidadPersonas, String fechaEntrada, double importeTotal, boolean estadoReserva) {
        this.id_reserva = id_reserva;
        this.cantidadPersonas = cantidadPersonas;
        this.fechaEntrada = fechaEntrada;
        this.importeTotal = importeTotal;
        this.estadoReserva = estadoReserva;
    }

    public Reserva() {
        id_reserva=-1;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public boolean isEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(boolean estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
 
 
 
 
 
 
}
