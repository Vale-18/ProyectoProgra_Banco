package proyecto;

import proyecto.OperacionesGenerales;
import javax.swing.JOptionPane;

public class Clientes {

    OperacionesGenerales operacion = new OperacionesGenerales();

    private String cedula;
    private String nombre;
    private String numTelefono;
    private int edad;
    private double saldo = 0;
    private int idCuenta;


    public Clientes() {
        this.cedula = cedula;
        this.nombre = nombre;
        this.numTelefono = numTelefono;
        this.edad = edad;
        this.idCuenta = idCuenta;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        do {
            if (cedula.length() == 9) {
                JOptionPane.showMessageDialog(null, "Cédula guardada exitosamente");
               this.cedula = cedula;
            } else {
                JOptionPane.showMessageDialog(null, "Cédula inválida, digítela de nuevo");
                cedula = JOptionPane.showInputDialog(null, "Digite su cedula, sin caracteres especiales(-, _, /,:", "Cédula", 3);
                this.cedula = cedula;
            }
        } while (cedula.length() != 9);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        do {
            if (numTelefono.length() == 8) {
                JOptionPane.showMessageDialog(null, "Número de teléfono guardado exitosamente");
               this.numTelefono = numTelefono;
            } else {
                JOptionPane.showMessageDialog(null, "Número de teléfono inválido, digítelo de nuevo");
                numTelefono = JOptionPane.showInputDialog(null, "Digite su número de teléfono, sin caracteres especiales(-, _, /, .):", "Número de teléfono", 3);
                this.numTelefono = numTelefono;
            }
        } while (numTelefono.length() != 8);

    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        do {
            if (edad >= 18) {
                JOptionPane.showMessageDialog(null, "Edad guardada exitosamente");
                this.edad = edad;
            } else {
                JOptionPane.showMessageDialog(null, "Edad inválida, digítela de nuevo");
                edad = (Integer.parseInt(JOptionPane.showInputDialog(null, "Digite su edad, recuerde que debe ser mayor de edad:", "Edad", 3)));
                this.edad = edad;
            }
        } while (edad < 18);

    }

}
