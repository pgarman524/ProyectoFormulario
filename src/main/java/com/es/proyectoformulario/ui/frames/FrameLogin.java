package com.es.proyectoformulario.ui.frames;

import com.es.proyectoformulario.ui.panels.PanelAlta;
import com.es.proyectoformulario.ui.panels.PanelLogin;

import javax.swing.*;

public class FrameLogin extends JFrame {

    public FrameLogin() {
        this.setSize(600, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Proyecto UI");
        ImageIcon image = new ImageIcon("src/main/resources/pokemonMedia/images/pikachu.png");
        this.setIconImage(image.getImage());
        this.setResizable(false);

        PanelAlta pAlta = new PanelAlta(this);
        this.add(pAlta);

        // Para que vuelva a activarse el primer panel, descomentar esto:

      PanelLogin p = new PanelLogin(this);
      this.add(p);

        // ------------------------------


        this.setVisible(true);
    }


}
