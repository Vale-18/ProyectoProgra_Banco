package proyecto;

import javax.swing.JOptionPane;

public class OperacionesGenerales {

    int tamanio = 10; //Tamanio del arreglo de objetos
    private Clientes arregloCuentas[] = new Clientes[tamanio]; //arreglo de objetos que contiene la informacion de los clientes
    private int x = 0; //variable que cuenta la cantidad de cuentas que se han creado
//Metodo que inserta la informacion del cliente en el constructor
    public void pedirInfo() {

        int id = x;
        String nombre = JOptionPane.showInputDialog(null, "Escriba su nombre:", "Nombre", 3);
        String cedula =ValidarCedula();
        String numTelefono = ValidarNumeroTelefono();
        int edad = ValidarEdad();
        arregloCuentas[x] = new Clientes(cedula, nombre, numTelefono, edad, id);
        retornarDatos(id);
        x++;
    }
//METODO QUE DEPOSITA EN UNA CUENTA ESPECIFICA
    public void depositar(int id, double mon) {
        for (int a = 0; a < arregloCuentas.length; a++) {

            if (arregloCuentas[a].getIdCuenta() == id) {
                arregloCuentas[a].setSaldo(arregloCuentas[a].getSaldo() + mon);
                JOptionPane.showMessageDialog(null, "Deposito Realizado con exito");
                return;
            }
        }
    }
//METODO QUE RETORNA LOS DATOS DE UNA CUENTA ESPECIFICA
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
//METODO QUE RETIRA EN UNA CUENTA ESPECIFICA
    public void retirar(int id, double mon) {
        if (arregloCuentas[0].getIdCuenta() == 0) {
            for (int a = 0; a < arregloCuentas.length; a++) {

                if (arregloCuentas[a].getIdCuenta() == id) {
                    if (mon <= arregloCuentas[a].getSaldo()) {
                        arregloCuentas[a].setSaldo(arregloCuentas[a].getSaldo() - mon);
                        JOptionPane.showMessageDialog(null, "Retiro realizado con exito");
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
//METODO QUE EXTRAE EL DINERO DEL LA CUENTA DE ORIGEN
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
//METODO QUE SUMA EL DINERO EN LA CUENTA DESTINO
    public void transaccionD(int idDestino, double mon) {
        for (int b = 0; b < arregloCuentas.length; b++) {
            if (arregloCuentas[b].getIdCuenta() == idDestino) {
                arregloCuentas[b].setSaldo(arregloCuentas[b].getSaldo() + mon);
                JOptionPane.showMessageDialog(null, "Transaccion realizada con exito");
                return;
            }
        }
    }
//METODO QUE INSERTA A TODOS LOS CLIENTES CREADOS EN UNA VARIABLE Y LOS ENSENIA
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
    //METODO QUE VALIDA QUE LA CEDULA TENGA 9 CARACTERES
public String ValidarCedula(){
   String ced=JOptionPane.showInputDialog(null, "Digite su cedula, sin caracteres especiales:", "Cédula", 3);
 do {
            if (ced.length() == 9) {
            
               
            } else {
                JOptionPane.showMessageDialog(null, "Cédula inválida, digítela de nuevo");
                    ced = JOptionPane.showInputDialog(null, "Digite su cedula, sin caracteres especiales: ", "Cédula", 3);
                
            }
        } while (ced.length() != 9);
 return ced;
}
//METODO QUE VALIDA QUE EL NUMERO DE TELEFONO TENGA 8 CARACTERES
public String ValidarNumeroTelefono(){
   String num=JOptionPane.showInputDialog(null, "Digite su número de teléfono, sin caracteres especiales:", "Número de teléfono", 3);
 do {
            if (num.length() == 8) {
            
               
            } else {
                JOptionPane.showMessageDialog(null, "Cédula inválida, digítela de nuevo");
                    num =JOptionPane.showInputDialog(null, "Digite su número de teléfono, sin caracteres especiales:", "Número de teléfono", 3);
                
            }
        } while (num.length() != 8);
 return num;
}
//METODO QUE VALIDA QUE EL CLIENTE SEA MAYOR DE 18 ANIOS
public int ValidarEdad(){
  int ed=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite su edad, recuerde que debe ser mayor de edad:", "Edad", 3));

 do {
            if (ed >= 18) {
            
            } else {
                JOptionPane.showMessageDialog(null, "Edad inválida, digítela de nuevo");
                ed = (Integer.parseInt(JOptionPane.showInputDialog(null, "Digite su edad, recuerde que debe ser mayor de edad:", "Edad", 3)));
                
            }
        } while (ed < 18);
 return ed;
}
//METODO GET DE X
    public int getX() {
        return x;
    }

}
