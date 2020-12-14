package proyecto;

import javax.swing.JOptionPane;


public class Sorteo {
    //ARREGLO QUE CONTIENE SI GANO O NO.
    int tamanio=100;
    private String premios[] = new String[tamanio];
  
    
        //METODO QUE ENSENIA UNA INTRODUCCION DEL SORTEO
public void Introduccion(){
    JOptionPane.showMessageDialog(null, "Buenas noticias querido cliente, nuestro banco durante estas fechas está realizando un sorteo para ganar un viaje a la Isla del Coco.", "Misión", 1);
    }
//METODO QUE CARGA POR PROBABILIDAD EL ARREGLO DE PREMIOS
public void cargarPremios(){
    int prob=(int) (Math.random() * 101);
    for (int i = 0; i < premios.length; i++) {
        if(prob>=20){
        premios[i]="GANO UN VIAJE A LAS ISLA DEL COCO";
        }
        else{
        premios[i]="NO GANO NADA";
        }
    }
}
//METODO QUE PIDE UN NUMERO Y ENSENIA SI GANO O NO GANO EL VIAJE
public void Gano(){
int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite un numero del 1 al " +tamanio));
JOptionPane.showMessageDialog(null, premios[numero]);
}

}
