package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.services.impl.ServiceUser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.Provider;





public class PanelAlta extends JPanel {


    JLabel idUserNombre;
    public JTextField idUserText;

    JLabel nombreNombre;
    public JTextField nombreTexto;

    JLabel pass1nombre;
    public JTextField pass1Texto;

    JLabel pass2nombre;
    public JTextField pass2Texto;

    JLabel isAdminNombre;
    public JComboBox<String> isAdmin;

    JButton alta;

    JLabel mensaje;

    ServiceUser s = new ServiceUser();

    MouseListener listenerMouse = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (idUserText.getText().isEmpty() || nombreTexto.getText().isEmpty() || pass1Texto.getText().isEmpty() || pass2Texto.getText().isEmpty() ){
                if (pass1Texto.getText().equals(pass2Texto)){
                        if (!s.checkUser(idUserText.getText(),pass1Texto.getText())){

                        }else {
                            mensaje.setText("El usuario ya existe");
                        }

                }else{
                    mensaje.setText("La contraseña no coincide");
                }


            }else {
            mensaje.setText("Los campos no han sido rellenados");
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };
    public PanelAlta() {

        this.setBackground(new Color(134, 171, 194));
        this.setLayout(null);

        idUserNombre = new JLabel("IdUser: ");
        idUserNombre.setLocation(new Point(150,158));
        idUserNombre.setSize(new Dimension(150, 32));
        // usuario.setFont(new Font("Consolas", Font.BOLD, 22));
        this.add(idUserNombre);

        idUserText = new JTextField();
        idUserText.setLocation(new Point(250, 158));
        idUserText.setSize(new Dimension(150,32));
        this.add(idUserText);

        nombreNombre = new JLabel("Nombre: ");
        nombreNombre.setLocation(new Point(150, 208));
        nombreNombre.setSize(new Dimension(152,32));
        this.add(nombreNombre);

        nombreTexto = new JTextField();
        nombreTexto.setLocation(new Point(250, 208));
        nombreTexto.setSize(new Dimension(150,32));
        this.add(nombreTexto);

        pass1nombre = new JLabel("Pass: ");
        pass1nombre.setLocation(new Point(150, 258));
        pass1nombre.setSize(new Dimension(152,32));
        this.add(pass1nombre);

        pass1Texto = new JPasswordField();
        pass1Texto.setLocation(new Point(250, 258));
        pass1Texto.setSize(new Dimension(150,32));
        this.add(pass1Texto);

        pass2nombre = new JLabel("Pass: ");
        pass2nombre.setLocation(new Point(150, 308));
        pass2nombre.setSize(new Dimension(152,32));
        this.add(pass2nombre);

        pass2Texto = new JPasswordField();
        pass2Texto.setLocation(new Point(250, 308));
        pass2Texto.setSize(new Dimension(150,32));
        this.add(pass2Texto);

        isAdminNombre = new JLabel("IsAdmin: ");
        isAdminNombre.setLocation(new Point(150, 358));
        isAdminNombre.setSize(new Dimension(152,32));
        this.add(isAdminNombre);

        isAdmin = new JComboBox<String>();
        isAdmin.addItem("Si");
        isAdmin.addItem("No");
        isAdmin.setLocation(new Point(250, 358));
        isAdmin.setSize(new Dimension(150,32));
        this.add(isAdmin);

        alta = new JButton("Alta");
        alta.setLocation(new Point(175, 428));
        alta.setSize(new Dimension(150,32));
        this.add(alta);

        mensaje= new JLabel();
        mensaje.setLocation(new Point(15, 590));

        ServiceUser serviceUser = new ServiceUser();





    }
}
