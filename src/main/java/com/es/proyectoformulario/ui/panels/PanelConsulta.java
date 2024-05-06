package com.es.proyectoformulario.ui.panels;

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
    JTextField idCOnsultar;
    JTextArea texto;


    MouseListener listenerMouse = new MouseAdapter() {
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



    public PanelConsulta(FrameLogin framePadre) {
        this.framePadre = framePadre;
        this.setLayout(null);

        String pokemon = "src/main/resources/pokemonMedia/images/hogar.png";
        ImageIcon icon = new ImageIcon(pokemon);

        consultar = new JButton("Consultar");
       // consultar.setIcon(icon);
        consultar.setBackground(null);
        consultar.setLocation(new Point(350, 158));
        consultar.setSize(new Dimension(150, 32));
        // usuario.setFont(new Font("Consolas", Font.BOLD, 22));
        this.add(consultar);

        idCOnsultar = new JTextField();
        idCOnsultar.setLocation(new Point(150, 158));
        idCOnsultar.setSize(new Dimension(150, 32));
        this.add(idCOnsultar);

        texto = new JTextArea();
        texto.setLocation(new Point(150, 198));
        texto.setSize(new Dimension(150, 150));
        this.add(texto);


    }



}
