package PROYECTOFINAL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bienvenida extends JFrame {

    private JLabel Title, Copy;
    private JLabel textoIngreso;
    private JTextField ingresoNombre;
    private JButton botonOk;

    public Bienvenida() {
        setLayout(null);

        setTitle("Bienvenido al sistema");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("C:\\Users\\javie\\Downloads\\codigo.jpg").getImage());

        ImageIcon logoIcon = new ImageIcon("C:\\Users\\javie\\Desktop\\log.png");
        Image logoImage = logoIcon.getImage();

        int scaledWidth = 300;
        int scaledHeight = (int) ((double) logoImage.getHeight(null) / logoImage.getWidth(null) * scaledWidth);
        Image logoImageScaled = logoImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        ImageIcon logoIconScaled = new ImageIcon(logoImageScaled);

        JLabel logoLabel = new JLabel(logoIconScaled);
        logoLabel.setBounds(40, 50, scaledWidth, scaledHeight); 
        add(logoLabel); 

        Title = new JLabel("¡Bienvenido al sistema!");
        Title.setFont(new Font("Arial", Font.BOLD, 20));
        Title.setBounds(90, 140, 300, 50);
        add(Title);

        Copy = new JLabel(" ©2024 Agencia Creativa CodiCorp S.A");
        Copy.setFont(new Font("Serif", Font.PLAIN, 12));
        Copy.setForeground(new Color(169, 169, 169));
        Copy.setBounds(100, 400, 200, 30);
        add(Copy);

        textoIngreso = new JLabel("Por favor, ingresa tu nombre");
        textoIngreso.setFont(new Font("Arial", Font.ITALIC, 15));
        textoIngreso.setBounds(100, 160, 300, 50);
        add(textoIngreso);

        ingresoNombre = new JTextField();
        ingresoNombre.setBounds(40, 220, 300, 20);
        add(ingresoNombre);

        botonOk = new JButton("Aceptar");
        botonOk.setBounds(142, 260, 100, 40);
        add(botonOk);

        botonOk.setEnabled(false);
        ingresoNombre.addCaretListener(e -> botonOk.setEnabled(!ingresoNombre.getText().trim().isEmpty()));

        // ActionListener para el botón
        botonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = ingresoNombre.getText();
                TerminosyCondiciones terminosVentana = new TerminosyCondiciones(nombreUsuario);
                CalculadoraMain.mostrarVentana(Bienvenida.this, terminosVentana);
            }
        });
    }
}
