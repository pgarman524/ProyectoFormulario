package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelOpciones extends JPanel {
    private FrameLogin framePadre;

    JButton bAlta;
    JButton bBaja;
    JButton bModificar;
    JButton bConsulta;


    JButton home;
    String casa = "src/main/resources/pokemonMedia/images/hogar.png";
    ImageIcon icon1 = new ImageIcon(casa);

    String casa2 = "src/main/resources/pokemonMedia/images/hogarGris.png";
    ImageIcon icon2 = new ImageIcon(casa2);

    String casa3 = "src/main/resources/pokemonMedia/images/hogarBl.png";
    ImageIcon icon3 = new ImageIcon(casa3);


    MouseListener listenerMouseAlta = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            cargarPanelAlta();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            bAlta.setBackground(new Color(151, 174, 145));

        }

        @Override
        public void mouseExited(MouseEvent e) {
            bAlta.setBackground(new Color(192, 221, 184));

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


    MouseListener listenerMouseBaja = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            cargarPanelBaja();

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            bBaja.setBackground(new Color(191, 106, 106));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            bBaja.setBackground(new Color(234, 132, 132));
        }
    };
    MouseListener listenerMouseMod = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {


        }

        @Override
        public void mouseEntered(MouseEvent e) {

            bModificar.setBackground(new Color(161, 137, 75));

        }

        @Override
        public void mouseExited(MouseEvent e) {

            bModificar.setBackground(new Color(216, 185, 105));

        }
    };

    MouseListener listenerMouseCosulta = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            cargarPanelConsulta();
        }

        @Override
        public void mouseEntered(MouseEvent e) {

            bConsulta.setBackground(new Color(86, 150, 186));
        }

        @Override
        public void mouseExited(MouseEvent e) {

            bConsulta.setBackground(new Color(104, 176, 216));
        }
    };

    public PanelOpciones (FrameLogin framepadre){
        this.framePadre = framepadre;

        this.setBackground(new Color(223, 220, 220));
        this.setLayout(null);

        bAlta = new JButton("Alta");
        bAlta.setBackground(new Color(192, 221, 184));
        bAlta.setLocation(new Point(225, 128));
        bAlta.setSize(new Dimension(130, 32));
        bAlta.addMouseListener(listenerMouseAlta);
        this.add(bAlta);


        bBaja = new JButton("Baja");
        bBaja.setBackground(new Color(234, 132, 132));
        bBaja.setLocation(new Point(225, 168));
        bBaja.setSize(new Dimension(130, 32));
        bBaja.addMouseListener(listenerMouseBaja);
        this.add(bBaja);

        bModificar =  new JButton("Modificar");
        bModificar.setBackground(new Color(216, 185, 105));
        bModificar.setLocation(new Point(225, 208));
        bModificar.setSize(new Dimension(130, 32));
        bModificar.addMouseListener(listenerMouseMod);
        this.add(bModificar);

        bConsulta = new JButton("Consulta");
        bConsulta.setBackground(new Color(104, 176, 216));
        bConsulta.setLocation(new Point(225, 248));
        bConsulta.setSize(new Dimension(130, 32));
        bConsulta.addMouseListener(listenerMouseCosulta);
        this.add(bConsulta);

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
    private void cargarPanelAlta() {
        //this es PanelLogin, pero este exacto PanelLogin. No otro...
        framePadre.remove(this);

        //añadimos un panelAlta al frame para que ahora aparezca este
        PanelAlta panelAlta = new PanelAlta(framePadre);
        framePadre.add(panelAlta);

        //Tenemos que actualizar lo que tiene el frame manualmente
        framePadre.repaint();
        framePadre.revalidate();

    }
    private void cargarPanelConsulta() {
        //this es PanelLogin, pero este exacto PanelLogin. No otro...
        framePadre.remove(this);

        //añadimos un panelAlta al frame para que ahora aparezca este
        PanelConsulta panelConsulta = new PanelConsulta(framePadre);
        framePadre.add(panelConsulta);

        //Tenemos que actualizar lo que tiene el frame manualmente
        framePadre.repaint();
        framePadre.revalidate();

    }

    private void cargarPanelBaja() {
        //this es PanelLogin, pero este exacto PanelLogin. No otro...
        framePadre.remove(this);

        //añadimos un panelAlta al frame para que ahora aparezca este
        PanelBaja panelBaja = new PanelBaja(framePadre);
        framePadre.add(panelBaja);

        //Tenemos que actualizar lo que tiene el frame manualmente
        framePadre.repaint();
        framePadre.revalidate();

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
