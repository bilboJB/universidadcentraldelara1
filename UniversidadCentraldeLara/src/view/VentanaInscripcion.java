package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaInscripcion extends JFrame{
    private GridLayout grid;
    private JLabel lblInscripcion, lblCedula, lblNombre, lblApellido, lblCarrera;
    private JTextField txtCedula, txtNombre, txtApellido, txtCarrera;
    private JPanel panel1, panel2, panel4;
    private JButton btnGuardar, btnBuscar;
    private ImageIcon icnGuardar, icnBuscar;
    private JTable tabla;
    private String[] columnas;
    private DefaultTableModel modelo;
    private JScrollPane scroll;

    public VentanaInscripcion(String titulo){
        super(titulo);
        this.setSize(800,600);
        grid = new GridLayout(4,1);
        this.getContentPane().setLayout(grid);
        Font font = new Font("Arial",Font.BOLD,28);
        Font fontLbl = new Font("Arial", Font.PLAIN, 18);
        Dimension dimensionBotones = new Dimension(250,60);
        Dimension dimensionTxt = new Dimension(200,35);
        //primer panel
        panel1 = new JPanel();
        this.getContentPane().add(panel1,0);
        lblInscripcion = new JLabel("Inscripcion");
        lblInscripcion.setFont(font);
        panel1.add(lblInscripcion);
        //segundo panel
        panel2 = new JPanel();
        this.getContentPane().add(panel2,1);
        lblCedula = new JLabel("Cedula");
        lblCedula.setFont(fontLbl);
        panel2.add(lblCedula);
        txtCedula = new JTextField();
        txtCedula.setPreferredSize(dimensionTxt);
        panel2.add(txtCedula);
        icnBuscar = new ImageIcon("iconos/iconsLupa30.png");
        btnBuscar = new JButton(icnBuscar);
        btnBuscar.setPreferredSize(new Dimension(40,40));
        panel2.add(btnBuscar);
        lblNombre = new JLabel("Nombre");
        lblNombre.setFont(fontLbl);
        panel2.add(lblNombre);
        txtNombre = new JTextField();
        txtNombre.setPreferredSize(dimensionTxt);
        txtNombre.setEditable(false);
        panel2.add(txtNombre);
        lblApellido = new JLabel("Apellido");
        lblApellido.setFont(fontLbl);
        panel2.add(lblApellido);
        txtApellido = new JTextField();
        txtApellido.setPreferredSize(dimensionTxt);
        txtApellido.setEditable(false);
        panel2.add(txtApellido);
        lblCarrera = new JLabel("Carrera");
        lblCarrera.setFont(fontLbl);
        panel2.add(lblCarrera);
        txtCarrera = new JTextField();
        txtCarrera.setPreferredSize(dimensionTxt);
        txtCarrera.setEditable(false);
        panel2.add(txtCarrera);
        //tercer panel pero con un scroll pane
        columnas = new String[]{"Asignatura","Seccion"};
        modelo = new DefaultTableModel(5,columnas.length){
            @Override
            public boolean isCellEditable(int row, int column) {
            return false;
            }
        };
        modelo.setColumnIdentifiers(columnas);
        tabla = new JTable(modelo);
        tabla.setPreferredSize(new Dimension(550,150));
        scroll = new JScrollPane(tabla);
        this.getContentPane().add(scroll,2);
        //cuarto panel
        panel4 = new JPanel();
        this.getContentPane().add(panel4,3);
        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(fontLbl);
        btnGuardar.setPreferredSize(dimensionBotones);
        icnGuardar = new ImageIcon("iconos/iconGuardar.png");
        btnGuardar.setIcon(icnGuardar);
        panel4.add(btnGuardar);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
