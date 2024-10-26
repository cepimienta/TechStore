



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rafael Pimienta
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class Almacen implements Serializable {

    private static ArrayList<Producto> inventario;
    //private static ArrayList<String> inventario;

    public Almacen() {
        if (inventario == null) {
            inventario = new ArrayList<>();
        }

    }

    /**
     * CRUD
     *
     *
     */
    public void create(Producto producto) {
        inventario.add(producto);
        //System.out.println("Creado");
    }

    public Producto read(String nombre) {

        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Producto encontrado: " + nombre);
                return producto;
            }
        }
        return null;
    }

    public void update(String nombre, Producto actualizacion) {
        Producto producto = read(nombre);
        if (producto != null) {
            producto.setNombre(actualizacion.getNombre());
            producto.setDescripcion(actualizacion.getDescripcion());
            producto.setCantidad(actualizacion.getCantidad());
            producto.setValor(actualizacion.getValor());
            inventario.remove(actualizacion);
            System.out.println("Producto actualizado: " + nombre);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void delete(String nombre) {
        Producto producto = read(nombre);
        if (producto != null) {
            inventario.remove(producto);
            System.out.println("Producto eliminado: " + nombre);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    /**
     * Manejo de un archivo .dat
     *
     *
     */
    public static String fichero = "archivos.dat";

    public ArrayList<Producto> cargarDat() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            Object aux = ois.readObject();
            while (aux != null) {
                if (aux instanceof Producto) {
                    create((Producto) aux);
                }
                aux = ois.readObject();

            }
            ois.close();
        } catch (FileNotFoundException e) {
            try {
                File archivo = new File(fichero);
                archivo.createNewFile();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } catch (Exception e) {

        }

        return inventario;

    }

    public void guardarDat() {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
            for (Producto producto : this.inventario) {
                oos.writeObject(producto);
            }
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Mostrar los productos cargados en el ArrayList
     *
     */
    // 
    public void ver() {

        //guardarDat();
        System.out.println("");
        System.out.println("archivo");
        //inventario = cargarDat();

        int i = 0;
        for (Producto producto : inventario) {
            i = i + 1;
            System.out.println(i + ": " + producto);
            // String mensaje = producto.toString();
            // JOptionPane.showMessageDialog(null, mensaje);
        }

    }
    
    public String listar() {

        //guardarDat();
        
        String texto = "";
        texto += "\n" + "coleccion";
        
        //inventario = cargarDat();

        for (Producto producto : inventario) {
            texto += "\n" + " [ " + (inventario.indexOf(producto)+1) + " ] " + producto;

            //System.out.println(i + ": " + producto);
            // String mensaje = producto.toString();
        }
        
        return texto;

    }

    
}
