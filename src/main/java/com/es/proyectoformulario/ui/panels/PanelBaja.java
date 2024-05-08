package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;

public class PanelBaja extends JPanel {
   private FrameLogin framePadre;
JButton consulta;
JTextField consultaText;
JLabel consultaId;

JLabel datosUser;

JLabel idUser;
JTextField idUserText;

JLabel nomUser;
JTextField nomUserText;

JLabel password;
JPasswordField  passwordText;

JLabel isAdmin;
public JComboBox<String> isAdminCheckBox;

JButton baja;

// ---
JButton home;
    String casa = "src/main/resources/pokemonMedia/images/hogar.png";
    ImageIcon icon1 = new ImageIcon(casa);

    String casa2 = "src/main/resources/pokemonMedia/images/hogarGris.png";
    ImageIcon icon2 = new ImageIcon(casa2);

    String casa3 = "src/main/resources/pokemonMedia/images/hogarBl.png";
    ImageIcon icon3 = new ImageIcon(casa3);


    MouseListener listenerMouseConsulta = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {




        }

        @Override
        public void mouseEntered(MouseEvent e) {


        }

        @Override
        public void mouseExited(MouseEvent e) {


        }
    };
    MouseListener listenerMouseHome = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            goHome();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            home.setIcon(icon3);
            // home.setIcon(icon2);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            home.setIcon(icon1);
        }
    };
    public PanelBaja (FrameLogin framePadre){
    this.setLayout(null);
    this.framePadre = framePadre;
        this.setBackground(new Color(221, 218, 218));


        consultaId = new JLabel("id_usuario");
      //  consultaId.setFont(new Font("Roboto", TextAttribute.UNDERLINE,12));
        Font font = consultaId.getFont();
        Map atributo = font.getAttributes();
        atributo.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        consultaId.setFont(font.deriveFont(atributo));
        consultaId.setLocation(new Point(145, 28));
        consultaId.setSize(new Dimension(150, 32));
        this.add(consultaId);

        consultaText = new JTextField();
        consultaText.setLocation(new Point(225, 28));
        consultaText.setSize(new Dimension(150, 32));
        this.add(consultaText);

        consulta = new JButton("Consultar");
        consulta.setLocation(new Point(225, 68));
        consulta.setSize(new Dimension(150, 32));
        this.add(consulta);


        datosUser = new JLabel("Datos User");
        datosUser.setLocation(new Point(240, 158));
        datosUser.setSize(new Dimension(150, 32));
        datosUser.setFont(new Font("Opens Sans",Font.BOLD,22));
        this.add(datosUser);

        // ------------- JLABELS ----------------
        idUser  = new JLabel("id usuario");
        idUser.setLocation(new Point(155, 198));
        idUser.setSize(new Dimension(150, 32));
        this.add(idUser);

        nomUser = new JLabel("Nombre usuario");
        nomUser.setLocation(new Point(155, 238));
        nomUser.setSize(new Dimension(150, 32));
        this.add(nomUser);

        password = new JLabel("Password");
        password.setLocation(new Point(155, 288));
        password.setSize(new Dimension(150, 32));
        this.add(password);

        isAdmin = new JLabel("Password");
        isAdmin.setLocation(new Point(155, 328));
        isAdmin.setSize(new Dimension(150, 32));
        this.add(isAdmin);

        // ------- JTexField -------------------
        idUserText = new JTextField();
        idUserText.setLocation(new Point(265, 198));
        idUserText.setSize(new Dimension(150, 32));
        this.add(idUserText);

        nomUserText = new JTextField();
        nomUserText.setLocation(new Point(265, 238));
        nomUserText.setSize(new Dimension(150, 32));
        this.add(nomUserText);

        passwordText = new JPasswordField();
        passwordText.setLocation(new Point(265, 288));
        passwordText.setSize(new Dimension(150, 32));
        this.add(passwordText);

        isAdminCheckBox = new JComboBox<String>();
        isAdminCheckBox.setLocation(new Point(265, 328));
        isAdminCheckBox.setSize(new Dimension(150, 32));
        isAdminCheckBox.addItem("Admin");
        isAdminCheckBox.addItem("No Admin");
        this.add(isAdminCheckBox);

        // ----------------------------------------

        baja = new JButton("Baja");
        baja.setLocation(new Point(225, 388));
        baja.setSize(new Dimension(150, 32));
        this.add(baja);

        // ----------------------------------------
        home = new JButton();
        home.setIcon(icon1);
        home.setLocation(new Point(45, 480));
        home.setSize(new Dimension(32, 32));
        home.setOpaque(false);
        home.setContentAreaFilled(false);
        home.setBorderPainted(false);
        home.addMouseListener(listenerMouseHome);
        this.add(home);

    }


    private void goHome() {
        //this es PanelLogin, pero este exacto PanelLogin. No otro...
        framePadre.remove(this);

        //añadimos un panelAlta al frame para que ahora aparezca este
        PanelLogin panelHome = new PanelLogin(framePadre);
        framePadre.add(panelHome);

        //Tenemos que actualizar lo que tiene el frame manualmente
        framePadre.repaint();
        framePadre.revalidate();

    }



}
