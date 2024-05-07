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

JLabel idUser;
JTextField idUserText;

JLabel nomUser;
JTextField nomUserText;

JLabel password;
JPasswordField  passwordText;

JLabel IsAdmin;
public JComboBox<String> IsAdminCheckBox;

JButton baja;


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


        consulta = new JButton("Consultar");
        consulta.setLocation(new Point(225, 68));
        consulta.setSize(new Dimension(150, 32));
        this.add(consulta);

        consultaText = new JTextField();




    }

}
