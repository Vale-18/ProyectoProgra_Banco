package proyecto;

import proyecto.OperacionesGenerales;
import proyecto.AcercaDe;
import javax.swing.JOptionPane;

public class Menu {

    private int IDtemp;

    public void menu() {
        OperacionesGenerales operacion = new OperacionesGenerales();
        AcercaDe infoBanco = new AcercaDe();
        //operacion.PrimeraCuenta();
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Bienvenido a tu banco, " + "\nDigite la opción que prefiera: "
                    + "\n1.Crear cuenta nueva" + "\n2.Consultar información de cliente" + "\n3.Retirar dinero " + "\n4.Depositar dinero"
                    + "\n5.Realizar transferencia" + "\n6.Solicitar préstamo" + "\n7.Acerca del banco EVA" + "\n0. Salir", "Bankito", 1));

            switch (opcion) {
                case 1:
                    operacion.pedirInfo();
                    break;

                case 2:
                    IDtemp = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el identificador de la cuenta a la que desea vizualizar"));
                    if (operacion.getX() > IDtemp) {
                        operacion.retornarDatos(IDtemp);
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe ninguna cuenta");
                    }

                    break;

                case 3:
                    IDtemp = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el identificador de la cuenta a la que desea retirar dinero"));
                    if (operacion.getX() > IDtemp) {
                        operacion.retirar(IDtemp,
                                Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el dinero que retirará el cliente ")));
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe ninguna cuenta para retirar");
                    }
                    break;

                case 4:
                    IDtemp = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el identificador de la cuenta a la que desea depositar dinero"));
                    if (operacion.getX() >= IDtemp) {
                        operacion.depositar(IDtemp,
                                Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el dinero que depositará el cliente ")));
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe ninguna cuenta para depositar");
                    }
                    break;
                    
                    
                case 5: 
                    int idO = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el identificador de la cuenta a la que desea retirar dinero"));
                    int idD = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el identificador de la cuenta a la que desea depositar dinero"));
                    
                    if (operacion.getX() >= idO && operacion.getX() >= idD) {
                         double mon = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el dinero de la transacción"));
     
                        operacion.transaccionR(idO,idD,mon);
                 
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe ninguna cuenta para retirar");
                    }
                    break;
                case 7:
                    infoBanco.mision();
                    infoBanco.vision();
                    infoBanco.orientacionAlCliente();
                    infoBanco.orientacionAlLogro();
                    break;
                case 0:
                    opcion = 0;
                    JOptionPane.showMessageDialog(null, "!Gracias por su visita!\nVuelva pronto", "Despedida", 0);

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida, ingrésela de nuevo");
            }
        } while (opcion != 0);
    }
}
