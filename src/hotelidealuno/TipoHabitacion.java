/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelidealuno;

/**
 *
 * @author okped
 */
public class TipoHabitacion {
    private int id=-1;
    private String tipo;
    private Double precioPorNoche;
    private int cantPersonasMax;
    private int cantCamas;
    private String tipoCama;

    public TipoHabitacion(int id, String tipo, Double precioPorNoche, int cantPersonasMax, int cantCamas, String tipoCama) {
        this.id = id;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.cantPersonasMax = cantPersonasMax;
        this.cantCamas = cantCamas;
        this.tipoCama = tipoCama;
    }

    public TipoHabitacion(String tipo, Double precioPorNoche, int cantPersonasMax, int cantCamas, String tipoCama) {
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.cantPersonasMax = cantPersonasMax;
        this.cantCamas = cantCamas;
        this.tipoCama = tipoCama;
    }
    

    public TipoHabitacion() {}
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(Double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public int getCantPersonasMax() {
        return cantPersonasMax;
    }

    public void setCantPersonasMax(int cantPersonasMax) {
        this.cantPersonasMax = cantPersonasMax;
    }

    public int getCantCamas() {
        return cantCamas;
    }

    public void setCantCamas(int cantCamas) {
        this.cantCamas = cantCamas;
    }

    public String getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(String tipoCama) {
        this.tipoCama = tipoCama;
    }
    
}
