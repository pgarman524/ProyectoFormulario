package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.model.User;
import com.es.proyectoformulario.services.impl.GestionFicheroUser;
import com.es.proyectoformulario.services.impl.ServiceUser;
import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.Provider;


public class PanelAlta extends JPanel {
    private FrameLogin framePadre;

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

    GestionFicheroUser g = new GestionFicheroUser();

    JButton home;
    String casa = "src/main/resources/pokemonMedia/images/hogar.png";
    ImageIcon icon1 = new ImageIcon(casa);

    String casa2 = "src/main/resources/pokemonMedia/images/hogarGris.png";
    ImageIcon icon2 = new ImageIcon(casa2);

    String casa3 = "src/main/resources/pokemonMedia/images/hogarBl.png";
    ImageIcon icon3 = new ImageIcon(casa3);



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


    MouseListener listenerMouse = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (idUserText.getText().isEmpty() || nombreTexto.getText().isEmpty() || pass1Texto.getText().isEmpty() || pass2Texto.getText().isEmpty()) {
                mensaje.setText("Hay un campo vacio, por favor compruebe de nuevo");

            }else {
                if (pass1Texto.getText().equals(pass2Texto.getText())) {
                    if (!s.checkUser(idUserText.getText(), pass1Texto.getText())) {
                        User user = new User(idUserText.getText(), nombreTexto.getText(), pass1Texto.getText(), isAdminCheck());

                        s.altaUsuarioMouse(user);
                    }
                }
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };

    public PanelAlta(FrameLogin framePadre) {


        this.framePadre = framePadre;

        this.setBackground(new Color(134, 171, 194));
        this.setLayout(null);

        idUserNombre = new JLabel("IdUser: ");
        idUserNombre.setLocation(new Point(150, 158));
        idUserNombre.setSize(new Dimension(150, 32));
        // usuario.setFont(new Font("Consolas", Font.BOLD, 22));
        this.add(idUserNombre);

        idUserText = new JTextField();
        idUserText.setLocation(new Point(250, 158));
        idUserText.setSize(new Dimension(150, 32));
        this.add(idUserText);

        nombreNombre = new JLabel("Nombre: ");
        nombreNombre.setLocation(new Point(150, 208));
        nombreNombre.setSize(new Dimension(152, 32));
        this.add(nombreNombre);

        nombreTexto = new JTextField();
        nombreTexto.setLocation(new Point(250, 208));
        nombreTexto.setSize(new Dimension(150, 32));
        this.add(nombreTexto);

        pass1nombre = new JLabel("Pass: ");
        pass1nombre.setLocation(new Point(150, 258));
        pass1nombre.setSize(new Dimension(152, 32));
        this.add(pass1nombre);

        pass1Texto = new JPasswordField();
        pass1Texto.setLocation(new Point(250, 258));
        pass1Texto.setSize(new Dimension(150, 32));
        this.add(pass1Texto);

        pass2nombre = new JLabel("Pass: ");
        pass2nombre.setLocation(new Point(150, 308));
        pass2nombre.setSize(new Dimension(152, 32));
        this.add(pass2nombre);

        pass2Texto = new JPasswordField();
        pass2Texto.setLocation(new Point(250, 308));
        pass2Texto.setSize(new Dimension(150, 32));
        this.add(pass2Texto);

        isAdminNombre = new JLabel("IsAdmin: ");
        isAdminNombre.setLocation(new Point(150, 358));
        isAdminNombre.setSize(new Dimension(152, 32));
        this.add(isAdminNombre);

        isAdmin = new JComboBox<String>();
        isAdmin.addItem("Si");
        isAdmin.addItem("No");
        isAdmin.setLocation(new Point(250, 358));
        isAdmin.setSize(new Dimension(150, 32));
        this.add(isAdmin);

        alta = new JButton("Alta");
        alta.setLocation(new Point(175, 428));
        alta.setSize(new Dimension(150, 32));
        alta.addMouseListener(listenerMouse);
        this.add(alta);


        mensaje = new JLabel();
        mensaje.setLocation(new Point(85, 488));
        mensaje.setSize(new Dimension(450, 32));
        this.add(mensaje);


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

    public boolean isAdminCheck(){
        if (isAdmin.getActionCommand().equalsIgnoreCase("si")){
            return true;
        } else {
            return false;
        }

    }

}
