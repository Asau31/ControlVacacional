
package PROYECTOFINAL;

import java.io.IOException;
import javax.swing.*;
import java.awt.*;



public class CalculadoraMain {
    public static void main(String[] args) throws IOException {
            Bienvenida bienvenida = new Bienvenida();
            bienvenida.setLocationRelativeTo(null);
            bienvenida.setVisible(true);  


    }
    
    public static void mostrarVentana(javax.swing.JFrame ventanaActual, javax.swing.JFrame nuevaVentana){
        ventanaActual.setVisible(false);
        nuevaVentana.setLocationRelativeTo(null);
        nuevaVentana.setVisible(true);

        
    }
}
