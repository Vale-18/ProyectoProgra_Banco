package proyecto;

import javax.swing.JOptionPane;

public class Menu {

    private int IDtemp; //Variable para usar temporalmente al usar una opcion
//METODO QUE CONTIENE EL MENU E INSTANCIAS DE LAS CLASES
    public void menu() {
        Sorteo sorteo=new Sorteo();
        OperacionesGenerales operacion = new OperacionesGenerales();
        AcercaDe infoBanco = new AcercaDe();
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Bienvenido a tu banco, " + "\nDigite la opción que prefiera: "
                    + "\n1.Crear cuenta nueva" + "\n2.Consultar información de cliente" + "\n3.Retirar dinero " + "\n4.Depositar dinero"
                    + "\n5.Realizar transferencia" + "\n6.Mostrar cuentas disponibles" + "\n7.Acerca del banco" + "\n8.Sorteo del mes"+"\n0. Salir", "Bank App", 1));
            switch (opcion) {
                case 1://CREAR CUENTA NUEVA
                    operacion.pedirInfo();
                    break;
                case 2://CONSULTAR INFORMACION DE CLIENTES
                    IDtemp = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el identificador de la cuenta a la que desea vizualizar"));
                    //VALIDA QUE EXISTA LA CUENTA
                    if (operacion.getX() > IDtemp) {
                        operacion.retornarDatos(IDtemp);
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe ninguna cuenta");
                    }
                    break;

                case 3://RETIRAR
                    IDtemp = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el identificador de la cuenta a la que desea retirar dinero"));
                    //VALIDA QUE EXISTA LA CUENTA
                    if (operacion.getX() > IDtemp) {
                        operacion.retirar(IDtemp,
                                Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el dinero que retirará el cliente ")));
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe ninguna cuenta para retirar");
                    }
                    break;

                case 4://DEPOSITAR
                    IDtemp = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el identificador de la cuenta a la que desea depositar dinero"));
                    //VALIDA QUE EXISTA LA CUENTA
                    if (operacion.getX() >= IDtemp) {
                        operacion.depositar(IDtemp,Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el dinero que depositará el cliente ")));
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe ninguna cuenta para depositar");
                    }
                    break;
                    
                    
                case 5: //TRANSACCION
                    int idO = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el identificador de la cuenta a la que desea retirar dinero"));
                    int idD = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el identificador de la cuenta a la que desea depositar dinero"));
                    //VALIDA QUE EXISTA LA CUENTA
                    if (operacion.getX() >= idO && operacion.getX() >= idD) {
                         double mon = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el dinero de la transacción"));
     
                        operacion.transaccionR(idO,idD,mon);
                 
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe ninguna cuenta para retirar");
                    }
                    break;
                case 6://MOSTRAR CUENTAS DISPONIBLES
                    operacion.mostrarClientes();
                    break;
                case 7://ACERCA DE
                    infoBanco.mision();
                    infoBanco.vision();
                    infoBanco.orientacionAlCliente();
                    infoBanco.orientacionAlLogro();
                    break;
                case 8://SORTEO
                    sorteo.Introduccion();
                    sorteo.cargarPremios();
                    sorteo.Gano();
                break;
                case 0://SALIR
                    opcion = 0;
                    JOptionPane.showMessageDialog(null, "!Gracias por su visita!\nVuelva pronto", "Despedida", 0);

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida, ingrésela de nuevo");
            }
        } while (opcion != 0);
    }
}
