package proyecto;


import javax.swing.JOptionPane;

public class OperacionesGenerales {

    int tamanio = 10;
    private Clientes arregloCuentas[] = new Clientes[tamanio];
    private int x = 0;

    public void PrimeraCuenta() {
        arregloCuentas[0] = new Clientes();
        arregloCuentas[0].setIdCuenta(0);
        arregloCuentas[0].setNombre("Emmanuel");
        arregloCuentas[0].setCedula("118470734");
        arregloCuentas[0].setNumTelefono("62230270");
        arregloCuentas[0].setEdad(18);
    }

    public void pedirInfo() {
        arregloCuentas[x] = new Clientes();
        arregloCuentas[x].setIdCuenta(x);
        arregloCuentas[x].setNombre(JOptionPane.showInputDialog(null, "Escriba su nombre:", "Nombre", 3));
        arregloCuentas[x].setCedula(JOptionPane.showInputDialog(null, "Digite su cedula, sin caracteres especiales(-, _, /,:", "Cédula", 3));
        arregloCuentas[x].setNumTelefono(JOptionPane.showInputDialog(null, "Digite su número de teléfono, sin caracteres especiales(-, _, /, .):", "Número de teléfono", 3));
        arregloCuentas[x].setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite su edad, recuerde que debe ser mayor de edad:", "Edad", 3)));
        retornarDatos(x);
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
                    JOptionPane.showMessageDialog(null, "A continuacion se le desplegara la informacion de su cuenta: \n\nNombre: " + arregloCuentas[a].getNombre() + "\nCedula: "
                            + "" + arregloCuentas[a].getCedula() + "\nNumero de telefono: " + arregloCuentas[a].getNumTelefono() + "\nIdentificador de cuenta: " + arregloCuentas[a].getIdCuenta()
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

    public int getX() {
        return x;
    }

}
