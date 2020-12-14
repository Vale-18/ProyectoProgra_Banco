package proyecto;

import javax.swing.JOptionPane;

public class OperacionesGenerales {

    int tamanio = 10;
    private Clientes arregloCuentas[] = new Clientes[tamanio];
    private int x = 0;

    public void pedirInfo() {

        int id = x;
        String nombre = JOptionPane.showInputDialog(null, "Escriba su nombre:", "Nombre", 3);
        String cedula = JOptionPane.showInputDialog(null, "Digite su cedula, sin caracteres especiales:", "Cédula", 3);
        String numTelefono = JOptionPane.showInputDialog(null, "Digite su número de teléfono, sin caracteres especiales:", "Número de teléfono", 3);
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite su edad, recuerde que debe ser mayor de edad:", "Edad", 3));
        arregloCuentas[x] = new Clientes(cedula, nombre, numTelefono, edad, id);
        retornarDatos(id);
        x++;
    }

    public void depositar(int id, double mon) {
        for (int a = 0; a < arregloCuentas.length; a++) {

            if (arregloCuentas[a].getIdCuenta() == id) {
                arregloCuentas[a].setSaldo(arregloCuentas[a].getSaldo() + mon);
                JOptionPane.showMessageDialog(null, "El nuevo saldo de la cuenta es:" + arregloCuentas[a].getSaldo());
                return;
            }
        }
    }

    public void retornarDatos(int id) {
        if (arregloCuentas[0].getIdCuenta() == 0) {
            for (int a = 0; a < arregloCuentas.length; a++) {

                if (arregloCuentas[a].getIdCuenta() == id) {
                    JOptionPane.showMessageDialog(null, "A continuación se le desplegara la informacion de su cuenta: \n\nNombre: " + arregloCuentas[a].getNombre() + "\nCedula: "
                            + "" + arregloCuentas[a].getCedula() + "\nNúmero de teléfono: " + arregloCuentas[a].getNumTelefono() + "\nEdad: " + arregloCuentas[a].getEdad() + "\nIdentificador de cuenta: " + arregloCuentas[a].getIdCuenta()
                            + "\nSaldo: " + arregloCuentas[a].getSaldo());
                    return;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe ninguna cuenta");
        }
    }

    public void retirar(int id, double mon) {
        if (arregloCuentas[0].getIdCuenta() == 0) {
            for (int a = 0; a < arregloCuentas.length; a++) {

                if (arregloCuentas[a].getIdCuenta() == id) {
                    if (mon <= arregloCuentas[a].getSaldo()) {
                        arregloCuentas[a].setSaldo(arregloCuentas[a].getSaldo() - mon);
                    } else {
                        JOptionPane.showMessageDialog(null, "Lo sentimos, su cuenta tiene fondos insuficientes.", "Fondos insuficientes", 3);
                    }
                    return;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe ninguna cuenta");
        }
    }

    public void transaccionR(int idOrigen, int idDestino, double mon) {

        for (int a = 0; a < arregloCuentas.length; a++) {
            if (arregloCuentas[a].getIdCuenta() == idOrigen) {

                if (mon <= arregloCuentas[a].getSaldo()) {

                    arregloCuentas[a].setSaldo(arregloCuentas[a].getSaldo() - mon);

                    transaccionD(idDestino, mon);
                } else {
                    JOptionPane.showMessageDialog(null, "Lo sentimos, su cuenta tiene fondos insuficientes.", "Fondos insuficientes", 2);
                }
                return;
            }
        }
    }

    public void transaccionD(int idDestino, double mon) {
        for (int b = 0; b < arregloCuentas.length; b++) {
            if (arregloCuentas[b].getIdCuenta() == idDestino) {
                arregloCuentas[b].setSaldo(arregloCuentas[b].getSaldo() + mon);
                return;
            }
        }
    }

    public void mostrarClientes() {
        String texto= "Los clientes disponibles son: \n";
        int cantidadClientes= x;
       if (x>0) {
                
             for (int i = 0; i < cantidadClientes; i++) {
            
            texto+= "Nombre: "+arregloCuentas[i].getNombre()+"        ID: "+arregloCuentas[i].getIdCuenta()+"\n";      
        }
        JOptionPane.showMessageDialog(null, texto, "Clientes existentes", 1);             
       }
       else if (cantidadClientes==0)
       {
            JOptionPane.showMessageDialog(null, "Lo sentimos, no existen cuentas disponibles.", "Cuentas no disponibles", 2);           
       }
    }

    public int getX() {
        return x;
    }

}
