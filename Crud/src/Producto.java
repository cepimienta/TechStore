



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Rafael Pimienta
 */

import java.io.Serializable;


public class Producto implements Serializable {

    private String nombre;
    private String descripcion;
    private int cantidad;
    private double valor;

    public Producto(String nombre, String descripcion, int cantidad, double valor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.valor = valor;

    }



    // getters and setters
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public int getCantidad() {
        return cantidad;
    }
    public double getValor() {
        return valor;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    //toString
    @Override
	public String toString() {
		return "Producto [" + nombre + ", " + descripcion + ", Cantidad=" + cantidad + ", Valor="
				+ valor + "]";
	}


}
