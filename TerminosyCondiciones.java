package PROYECTOFINAL;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class TerminosyCondiciones extends JFrame {
    
    private String nombreUsuario;
    private JLabel terminos;
    private JTextArea texto;
    private JCheckBox box;
    private JButton aceptar, cancelar;
    
    public TerminosyCondiciones(String nombre) {
       
        this.nombreUsuario = nombre;
        setTitle("Términos y Condiciones");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("C:\\Users\\javie\\Downloads\\codigo.jpg").getImage());                
        getContentPane().setBackground(new Color(0xD3D3D3));
        
        terminos = new JLabel("Bienvenido " + nombre + ", a continuación los términos y condiciones del sistema");
        terminos.setFont(new Font("Arial", Font.ITALIC, 14)); // Texto más pequeño y legible
        terminos.setBounds(70, 25, 460, 50); // Ajustar el ancho para centrar
        terminos.setHorizontalAlignment(SwingConstants.CENTER); // Centrar horizontalmente
        add(terminos);
        
        texto = new JTextArea("Al utilizar los servicios de CodiCorp, usted acepta estos Términos y Condiciones, los cuales rigen el acceso y uso de nuestros servicios creativos, que incluyen diseño gráfico, desarrollo web y marketing digital. Todos los derechos de propiedad intelectual generados son propiedad de CodiCorp y su reproducción sin autorización está prohibida. Nos comprometemos a mantener la confidencialidad de la información proporcionada por nuestros clientes y no divulgaremos dicha información sin su consentimiento, a menos que sea requerido por ley. Los pagos se realizarán según lo acordado, y CodiCorp se reserva el derecho de suspender servicios en caso de impago. Las cancelaciones deben ser enviadas por escrito y no se emitirán reembolsos por trabajos ya realizados. Limitamos nuestra responsabilidad a los pagos recibidos por servicios prestados y nos reservamos el derecho de modificar estos términos en cualquier momento, siendo efectivos al ser publicados en nuestro sitio web. Estos términos se rigen por las leyes del país donde CodiCorp tiene su sede, y cualquier disputa se resolverá en los tribunales competentes. Para consultas, puede contactarnos en contacto@codicorp.com.");
        texto.setBounds(40, 60, 500, 200);
        texto.setEditable(false); // Hacer la caja de texto no editable
        texto.setLineWrap(true); // Permitir el salto de línea automático
        texto.setWrapStyleWord(true); // Hacer el salto de línea por palabra
        texto.setBackground(Color.WHITE); // Fondo blanco
        texto.setForeground(Color.BLACK);
        texto.setFont(new Font("Arial", Font.PLAIN, 12)); // Texto más pequeño y legible
        
        // Justificar el texto (se requiere un componente adicional para lograr la justificación)
        JTextPane textPane = new JTextPane();
        textPane.setText(texto.getText());
        textPane.setEditable(false);
        textPane.setFont(new Font("Arial", Font.PLAIN, 12));
        textPane.setBackground(Color.WHITE);
        textPane.setForeground(Color.BLACK);
        
        JScrollPane scrollPane = new JScrollPane(textPane); // Agregar desplazamiento
        scrollPane.setBounds(40, 60, 500, 200); // Establecer límites del JScrollPane

        add(scrollPane); // Añadir el JScrollPane al marco
        
        // Ajustar el JCheckBox para que quede debajo de la caja de texto
        box = new JCheckBox("Yo, " + nombre + " Acepto los términos y condiciones");
        box.setBounds(40, 270, 500, 30); // Ajustar el tamaño y la posición del JCheckBox
        box.setBackground(new Color(0xD3D3D3));
        add(box);
        
        aceptar = new JButton("Aceptar");
        aceptar.setBounds(40, 300, 100, 30);
        add(aceptar);
        aceptar.setEnabled(false);
        
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(160,300,100,30);
        add(cancelar);
        
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if(box.isSelected()){
                    aceptar.setEnabled(true);
                    cancelar.setEnabled(false);
                }else{
                    aceptar.setEnabled(false);
                    cancelar.setEnabled(true);
                }
            }
        });
        
        aceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
            Principal principal = new Principal(nombreUsuario);
            CalculadoraMain.mostrarVentana(TerminosyCondiciones.this, principal);
            }
        });
        
        cancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
            Bienvenida bienvenida = new Bienvenida();
            
            CalculadoraMain.mostrarVentana(TerminosyCondiciones.this, bienvenida);
            }
            
        });
        
        setLayout(null);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

            
    }
}
