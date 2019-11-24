import utils.Persona;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Ventana extends JFrame  implements ActionListener {

    JLabel nombre, direccion,telefono,dni,seleccionEstudios,anosExperiencia,titulo;
    JLabel nTelefono,nDni,anosExpe,selecEstudios,result;
    JButton insertarDatos, salir;
    JButton btnBuscar,btnSalir;
    JTextArea estudios,tselecEstudios,tresult;
    JTextField tNombre,tDireccion,tTelefono,tDni;
    JTextField tnTelefono,tnDni;
    Container container;
    JRadioButton soltero,casado,divorciado;
    ButtonGroup radios;
    JSpinner anios,tAnosExpe;
    SpinnerNumberModel modeloSpinnerNumeros;
    JMenuBar barraMenu;
    JMenu menuUno;
    JMenuItem buscar,insertar;
    JPanel panelcentro, panelInsertar, panelBuscar;
    CardLayout cardLayout;
    ArrayList datosPersona;

    public void initGUI(){
        instancias();
        configurarMenu();
        configurarContainer();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        acciones();
        setVisible(true);
    }

    public void configurarConstraint(int posX, int posY,int fill, int anchor
            ,double pesX, double pesY, int tamX, int tamY, JComponent component){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posX;
        constraints.gridy = posY;
        constraints.fill = fill ;
        constraints.anchor= anchor;
        constraints.weightx = pesX;
        constraints.weighty = pesY;
        constraints.gridwidth= tamX;
        constraints.gridheight= tamY;
        panelInsertar.add(component,constraints); //NO ENTIENDO POR QUE
    }
    public void configurarConstraint2(int posX, int posY,int fill, int anchor
            ,double pesX, double pesY, int tamX, int tamY, JComponent component){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posX;
        constraints.gridy = posY;
        constraints.fill = fill ;
        constraints.anchor= anchor;
        constraints.weightx = pesX;
        constraints.weighty = pesY;
        constraints.gridwidth= tamX;
        constraints.gridheight= tamY;
        panelBuscar.add(component,constraints); //NO ENTIENDO POR QUE
    }
    public void configurarContainer() {
        container.setLayout(cardLayout);
        container.add(configInsertar(),Constantes.TAG_P1);
        container.add(configBuscar(),Constantes.TAG_P2);

    }

    private Component configBuscar() {
        panelBuscar.setLayout(new GridBagLayout());
        //fila 1
        configurarConstraint2(0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                1, 0, 1, 1, nTelefono);
        //fila 2
        configurarConstraint2(0, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                1, 0, 1, 1, tnTelefono);
        //fila 3
        configurarConstraint2(0, 2, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                1, 0, 1, 1, nDni);
        //fila 4
        configurarConstraint2(0, 3, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                1, 0, 1, 1, tnDni);
        //fila 5
        configurarConstraint2(0, 4, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                1, 0, 1, 1, anosExpe);
        //fila 6
        configurarConstraint2(0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                1, 0, 1, 1, tAnosExpe);
        //fila 7
        configurarConstraint2(0, 6, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                1, 0, 1, 1, selecEstudios);
        //fila 8
        configurarConstraint2(0, 7, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
                0, 0, 3, 3, tselecEstudios);
        //fila 9
        configurarConstraint2(0, 10, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                1, 0, 1, 1, result);
        //fila 10
        configurarConstraint2(0, 11, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
                0, 0, 3, 3, tresult);
        //fila 9
        configurarConstraint2(0, 14, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                1, 0, 1, 1, btnBuscar);
        configurarConstraint2(1, 14, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
                1, 0, 1, 1, btnSalir);

        return panelBuscar;
    }

    private JPanel configInsertar() {
        panelInsertar.setLayout(new GridBagLayout());
        //fila 1
        configurarConstraint(0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                0, 0, 7, 1, titulo);
        //fila 2
        configurarConstraint(0, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                0, 0, 1, 1, nombre);
        configurarConstraint(5, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                0, 0, 2, 1, seleccionEstudios);
        //fila 3
        configurarConstraint(0, 2, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                1, 1, 3, 1, tNombre);
        configurarConstraint(5, 2, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
                0, 0, 3, 3, estudios);
        //fila 4
        configurarConstraint(0, 3, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                0, 0, 1, 1, direccion);
        //fila 5
        configurarConstraint(0, 4, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                1, 1, 3, 1, tDireccion);
        //fila 6
        configurarConstraint(0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                0, 0, 1, 1, telefono);
        configurarConstraint(5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                0, 0, 1, 1, soltero);
        configurarConstraint(6, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                0, 0, 1, 1, casado);
        configurarConstraint(7, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                0, 0, 1, 1, divorciado);

        //Fila 7
        configurarConstraint(0, 6, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                1, 1, 3, 1, tTelefono);
        configurarConstraint(5, 6, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                0, 0, 1, 1, anosExperiencia);
        configurarConstraint(6, 6, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                0, 0, 1, 1, anios);

        //fila 6
        configurarConstraint(0, 7, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                0, 0, 1, 1, dni);
        //Fila 7
        configurarConstraint(0, 8, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                1, 1, 3, 1, tDni);
        configurarConstraint(4, 8, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                1, 1, 2, 1, insertarDatos);
        configurarConstraint(6, 8, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER,
                1, 1, 1, 1, salir);
        return panelInsertar;

    }
    private void configurarMenu() {
        barraMenu.add(menuUno);
        menuUno.add(insertar);
        menuUno.add(buscar);

        this.setJMenuBar(barraMenu);
    }

    public void instancias(){

        nombre = new JLabel("NOMBRE");
        telefono = new JLabel("TELÉFONO");
        direccion = new JLabel("DIRECCIÓN");
        dni = new JLabel("DNI");
        seleccionEstudios = new JLabel("SELECCIONA TUS ESTUDIOS");
        anosExperiencia = new JLabel("AÑOS DE EXPERIENCIA");
        titulo = new JLabel("PORFAVOR,RELLENA LOS DATOS DE TU CURRICULUM");
        tNombre = new JTextField();
        tDireccion = new JTextField();
        tTelefono = new JTextField();
        tDni = new JTextField();
        radios = new ButtonGroup();
        soltero = new JRadioButton("SOLTERO",false);
        casado = new JRadioButton("CASADO",false);
        divorciado = new JRadioButton("DIVORCIADO",false);
        radios.add(soltero);
        radios.add(divorciado);
        radios.add(casado);
        estudios = new JTextArea();
        insertarDatos = new JButton("Insertar Datos");
        salir = new JButton("Salir");
        modeloSpinnerNumeros = new SpinnerNumberModel(0,0,99,1);
        anios = new JSpinner(modeloSpinnerNumeros);
        barraMenu = new JMenuBar();
        menuUno = new JMenu("Menu");
        buscar = new JMenuItem("Buscar Datos");
        insertar = new JMenuItem("Insertar Datos");
        container = getContentPane();
        panelcentro = new JPanel();
        panelInsertar = new JPanel();
        panelBuscar = new JPanel();
        cardLayout = new CardLayout();
        nTelefono = new JLabel("TELEFONO");
        selecEstudios = new JLabel("SELECCIONA TUS ESTUDIOS");
        tselecEstudios = new JTextArea();
        result = new JLabel(" RESULTADO DE BUSQUEDA");
        tresult = new JTextArea();
        tnTelefono = new JTextField();
        anosExpe = new JLabel("AÑOS DE EXPERIENCIA");
        tAnosExpe  = new JSpinner(modeloSpinnerNumeros);
        nDni = new JLabel("DNI");
        btnBuscar = new JButton("BUSCAR");
        btnSalir = new JButton("SALIR");
        tnDni = new JTextField();
        datosPersona = new ArrayList();
    }

    public void acciones(){
        insertarDatos.addActionListener(this);
        salir.addActionListener(this);
        insertar.addActionListener(this);
        buscar.addActionListener(this);
        tTelefono.addKeyListener(new ManejoTeclas());
        tDni.addKeyListener(new ManejoTeclas());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==insertarDatos){
                if (tNombre.getText().isEmpty()||tDireccion.getText().isEmpty()
                        ||tDni.getText().isEmpty()||tTelefono.getText().isEmpty()) {
                    tNombre.setText("FALTAN DATOS");
                    tDireccion.setText("FLATAN DATOS");
                    tTelefono.setText("FALTAN DATOS");
                    tDni.setText("FALTAN DATOS");
                }else {
                    String nombre = tNombre.getText();
                    String direccion = tDireccion.getText();
                    int telefono = Integer.valueOf(tTelefono.getText());
                    int dni = Integer.valueOf(tDni.getText());
                    int aniosExperiencia = Integer.valueOf(anios.getModel().getValue().toString());
                    Persona persona = new Persona(nombre,direccion,dni,telefono,aniosExperiencia);
                    datosPersona.add(persona);
                }

        } else if (e.getSource()==salir){
            System.exit(0);
        }else if(e.getSource()==insertar){
            cardLayout.show(container,Constantes.TAG_P1);
        }else if (e.getSource()==buscar){
            cardLayout.show(container,Constantes.TAG_P2);
        }
        }
    class ManejoTeclas extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            char tecla = e.getKeyChar();
            if (!Character.isDigit(tecla)){
                e.consume();
            } else if (tDni.getText().length()>7||tTelefono.getText().length()>8){
                e.consume();
            }
        }
    }
}
