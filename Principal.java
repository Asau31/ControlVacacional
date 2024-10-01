package PROYECTOFINAL;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Principal extends JFrame {
    private JTextField nombreField, apellidoPaternoField, apellidoMaternoField;
    private JComboBox<String> departamentoComboBox, antiguedadComboBox;
    private JTextArea resultadoArea;
    private JMenuBar menuBar;
    private JMenu opcionesMenu, calcularMenu, acercaDeMenu;
    private JMenuItem cambiarColorMenuItem, infoDesarrolladorMenuItem, salirMenuItem, limpiarMenuItem, calcularMenuItem;

    public Principal(String nombreUsuario) {
        setTitle("Pantalla principal");
        setSize(800, 600);  // Ajuste del tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(0xD3D3D3));
        
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\javie\\Desktop\\log.png");
        Image logoImage = logoIcon.getImage();

        int scaledWidth = 300;
        int scaledHeight = (int) ((double) logoImage.getHeight(null) / logoImage.getWidth(null) * scaledWidth);
        Image logoImageScaled = logoImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        ImageIcon logoIconScaled = new ImageIcon(logoImageScaled);

        JLabel logoLabel = new JLabel(logoIconScaled);
        logoLabel.setBounds(250, 400, scaledWidth, scaledHeight); 
        add(logoLabel);

        JLabel bienvenidoLabel = new JLabel("Bienvenido " + nombreUsuario);
        bienvenidoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        bienvenidoLabel.setBounds(250, 20, 400, 30);
        add(bienvenidoLabel);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(50, 80, 150, 20);
        add(nombreLabel);

        nombreField = new JTextField();
        nombreField.setBounds(200, 80, 200, 20);  // Aumentado el ancho
        add(nombreField);

        JLabel apellidoPaternoLabel = new JLabel("Apellido Paterno:");
        apellidoPaternoLabel.setBounds(50, 120, 150, 20);
        add(apellidoPaternoLabel);

        apellidoPaternoField = new JTextField();
        apellidoPaternoField.setBounds(200, 120, 200, 20);  // Aumentado el ancho
        add(apellidoPaternoField);

        JLabel apellidoMaternoLabel = new JLabel("Apellido Materno:");
        apellidoMaternoLabel.setBounds(50, 160, 150, 20);
        add(apellidoMaternoLabel);

        apellidoMaternoField = new JTextField();
        apellidoMaternoField.setBounds(200, 160, 200, 20);  // Aumentado el ancho
        add(apellidoMaternoField);

        JLabel departamentoLabel = new JLabel("Selecciona el Departamento:");
        departamentoLabel.setBounds(450, 80, 200, 20);
        add(departamentoLabel);

        String[] departamentos = {"Atención al Cliente", "Logística", "Gerentes"};
        departamentoComboBox = new JComboBox<>(departamentos);
        departamentoComboBox.setBounds(650, 80, 100, 20);  // Ajuste de posición y tamaño
        add(departamentoComboBox);

        JLabel antiguedadLabel = new JLabel("Selecciona la Antigüedad:");
        antiguedadLabel.setBounds(450, 120, 200, 20);
        add(antiguedadLabel);

        String[] antiguedad = {"1 año", "2-6 años", "7+ años"};
        antiguedadComboBox = new JComboBox<>(antiguedad);
        antiguedadComboBox.setBounds(650, 120, 100, 20);  // Ajuste de posición y tamaño
        add(antiguedadComboBox);

        JLabel resultadoLabel = new JLabel("Resultado del Cálculo:");
        resultadoLabel.setBounds(50, 220, 150, 20);
        add(resultadoLabel);

        resultadoArea = new JTextArea("Aquí aparece el resultado del cálculo de las vacaciones.");
        resultadoArea.setBounds(50, 250, 700, 100);  // Aumentado el tamaño del área de texto
        resultadoArea.setEditable(false);
        add(resultadoArea);

        // Menú
        menuBar = new JMenuBar();

        opcionesMenu = new JMenu("Opciones");
        calcularMenu = new JMenu("Calcular");
        acercaDeMenu = new JMenu("Acerca de");

        // Submenús
        cambiarColorMenuItem = new JMenuItem("Cambiar Color");
        cambiarColorMenuItem.addActionListener(e -> mostrarOpcionesColores());
        opcionesMenu.add(cambiarColorMenuItem);

        infoDesarrolladorMenuItem = new JMenuItem("Información sobre el desarrollador");
        infoDesarrolladorMenuItem.addActionListener(e -> mostrarInfoDesarrollador());
        opcionesMenu.add(infoDesarrolladorMenuItem);

        salirMenuItem = new JMenuItem("Salir");
        salirMenuItem.addActionListener(e -> System.exit(0));
        opcionesMenu.add(salirMenuItem);

        calcularMenuItem = new JMenuItem("Calcular");
        calcularMenuItem.addActionListener(e -> realizarCalculo());
        calcularMenu.add(calcularMenuItem);

        limpiarMenuItem = new JMenuItem("Limpiar");
        limpiarMenuItem.addActionListener(e -> limpiarCampos());
        calcularMenu.add(limpiarMenuItem);

        menuBar.add(opcionesMenu);
        menuBar.add(calcularMenu);

        setJMenuBar(menuBar);

        setLocationRelativeTo(null);
    }

    private void mostrarOpcionesColores() {
        String[] opciones = {"Gris", "Verde", "Amarillo claro"};
        String seleccion = (String) JOptionPane.showInputDialog(this, "Selecciona un color", "Cambiar Color",
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion != null) {
            switch (seleccion) {
                case "Gris":
                    getContentPane().setBackground(new Color(0x8D8D8D));
                    break;
                case "Verde":
                    getContentPane().setBackground(new Color(0x508F63));
                    break;
                case "Amarillo claro":
                    getContentPane().setBackground(new Color(255, 255, 224));
                    break;
            }
        }
    }

    private void mostrarInfoDesarrollador() {
        JOptionPane.showMessageDialog(this, "Desarrollado por: Javier Vela\n" +
                        "Curso: Programacion II, Ingenieria en sistemas 4to semestre\n" +
                        "Año: 2024", "Información sobre el desarrollador",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void realizarCalculo() {
        // Validar que todos los campos estén llenos
        if (nombreField.getText().isEmpty() || apellidoPaternoField.getText().isEmpty() ||
                apellidoMaternoField.getText().isEmpty() || departamentoComboBox.getSelectedIndex() == -1 ||
                antiguedadComboBox.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String departamento = (String) departamentoComboBox.getSelectedItem();
        String antiguedad = (String) antiguedadComboBox.getSelectedItem();
        int diasVacaciones = 0;

        switch (departamento) {
            case "Atención al Cliente":
                if (antiguedad.equals("1 año")) {
                    diasVacaciones = 6;
                } else if (antiguedad.equals("2-6 años")) {
                    diasVacaciones = 14;
                } else if (antiguedad.equals("7+ años")) {
                    diasVacaciones = 20;
                }
                break;
            case "Logística":
                if (antiguedad.equals("1 año")) {
                    diasVacaciones = 7;
                } else if (antiguedad.equals("2-6 años")) {
                    diasVacaciones = 15;
                } else if (antiguedad.equals("7+ años")) {
                    diasVacaciones = 22;
                }
                break;
            case "Gerentes":
                if (antiguedad.equals("1 año")) {
                    diasVacaciones = 10;
                } else if (antiguedad.equals("2-6 años")) {
                    diasVacaciones = 20;
                } else if (antiguedad.equals("7+ años")) {
                    diasVacaciones = 30;
                }
                break;
        }

        resultadoArea.setText("El trabajador "+ nombreField.getText() + " " + apellidoPaternoField.getText() + " " + apellidoMaternoField.getText() + " tiene derecho a " + diasVacaciones + " días de vacaciones.");
    }

    private void limpiarCampos() {
        nombreField.setText("");
        apellidoPaternoField.setText("");
        apellidoMaternoField.setText("");
        departamentoComboBox.setSelectedIndex(-1);
        antiguedadComboBox.setSelectedIndex(-1);
        resultadoArea.setText("Aquí aparece el resultado del cálculo de las vacaciones.");
    }
}
