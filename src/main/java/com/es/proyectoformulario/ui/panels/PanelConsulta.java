package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.services.impl.GestionFicheroUser;
import com.es.proyectoformulario.services.impl.ServiceUser;
import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class PanelConsulta extends JPanel {
    private FrameLogin framePadre;

    JButton consultar;
    JButton home;
    JButton goBack;
    JTextField idCOnsultar;
    JTextArea texto;
    String casa = "src/main/resources/pokemonMedia/images/hogar.png";
    ImageIcon icon1 = new ImageIcon(casa);

    String casa2 = "src/main/resources/pokemonMedia/images/hogarGris.png";
    ImageIcon icon2 = new ImageIcon(casa2);

    String casa3 = "src/main/resources/pokemonMedia/images/hogarBl.png";
    ImageIcon icon3 = new ImageIcon(casa3);

    String goBackB = "src/main/resources/pokemonMedia/images/goBack.png";
    ImageIcon iconBack = new ImageIcon(goBackB);

    String goBackW = "src/main/resources/pokemonMedia/images/goBackBl.png";
    ImageIcon iconBackW = new ImageIcon(goBackW);

    // -------------------------------
    GestionFicheroUser g = new GestionFicheroUser();
    String ruta = "src/main/resources/users/users.txt";

    ServiceUser s = new ServiceUser();
    // -------------------------------


    MouseListener listenerMouse = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            String usuario = idCOnsultar.getText();
            if (s.userExists(usuario)) {
                texto.setText(s.buscarUsuario(usuario).toString());
            }


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

    MouseListener listenerMouseBack = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            goBack();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            goBack.setIcon(iconBackW);
            // home.setIcon(icon2);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            goBack.setIcon(iconBack);
        }
    };

    public PanelConsulta(FrameLogin framePadre) {
        this.framePadre = framePadre;
        this.setLayout(null);

        this.setBackground(new Color(134, 171, 194));

        consultar = new JButton("Consultar");
        // consultar.setIcon(icon);
        // consultar.setBackground(null);
        consultar.setLocation(new Point(310, 158));
        consultar.setSize(new Dimension(150, 32));
        // usuario.setFont(new Font("Consolas", Font.BOLD, 22));
        consultar.addMouseListener(listenerMouse);
        this.add(consultar);

        idCOnsultar = new JTextField("Introduzca su idUser");
        idCOnsultar.setLocation(new Point(110, 158));
        idCOnsultar.setSize(new Dimension(150, 32));
        this.add(idCOnsultar);

        texto = new JTextArea();
        texto.setLocation(new Point(110, 238));
        texto.setSize(new Dimension(350, 150));
        this.add(texto);

        home = new JButton();
        home.setIcon(icon1);
        home.setLocation(new Point(45, 480));
        home.setSize(new Dimension(32, 32));
        home.setOpaque(false);
        home.setContentAreaFilled(false);
        home.setBorderPainted(false);
        home.addMouseListener(listenerMouseHome);
        this.add(home);

        goBack = new JButton();
        goBack.setIcon(iconBack);
        goBack.setLocation(new Point(15, 480));
        goBack.setSize(new Dimension(32, 32));
        goBack.setOpaque(false);
        goBack.setContentAreaFilled(false);
        goBack.setBorderPainted(false);
        goBack.addMouseListener(listenerMouseBack);
        this.add(goBack);


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

    private void goBack() {
        //this es PanelLogin, pero este exacto PanelLogin. No otro...
        framePadre.remove(this);

        //añadimos un panelAlta al frame para que ahora aparezca este
        PanelOpciones goBack = new PanelOpciones(framePadre);
        framePadre.add(goBack);

        //Tenemos que actualizar lo que tiene el frame manualmente
        framePadre.repaint();
        framePadre.revalidate();

    }

}
