package proyecto;

import javax.swing.JOptionPane;


public class Sorteo {
    int tamanio=100;
    private String premios[] = new String[tamanio];
  
    
        
public void Introduccion(){
    JOptionPane.showMessageDialog(null, "Buenas noticias querido cliente, nuestro banco durante estas fechas está realizando un sorteo para ganar un viaje a la Isla del Coco.", "Misión", 1);
    }
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
public void Gano(){
int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite un numero del 1 al " +tamanio));
JOptionPane.showMessageDialog(null, premios[numero]);
}

}
