package com.es.proyectoformulario.services.impl;

import com.es.proyectoformulario.model.User;
import com.es.proyectoformulario.ui.panels.PanelAlta;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;


public class ServiceUser {

    // ATRIBUTOS
    private ArrayList<User> users; // Contiene todos los registros del fichero users.txt
    private GestionFicheroUser gestionUser; // gestion es un objeto para poder llamar a los métodos de GestionFicheroUser
    private ServiceLogger logger;

    private String ruta = "src/main/resources/users/users.txt";

    public ServiceUser() {
        this.users = new ArrayList<>();
        this.gestionUser = new GestionFicheroUser();
        leerFicheroUsers();
        this.logger = new ServiceLogger();
    }


    public boolean checkUser(String idUser, String password) {
        for (int i = 0; i < this.users.size(); i++) {
            User usuario = this.users.get(i); // usuario es el elemento de la posicion i de users
            if (usuario.getId().equalsIgnoreCase(idUser) && usuario.getPass().equals(password)) {
                this.logger.registrarLog(idUser, "LOGIN", "OK");
                return true;
            }
        }
        this.logger.registrarLog(idUser, "LOGIN", "NOT OK");
        return false;
    }

    public User buscarUsuario(String idUser){
        for (int i = 0; i < this.users.size(); i++) {
            if (idUser.equals(users.get(i))){
            return users.get(i);
               }
        }
        return null;
    }

    public boolean userExists(String idUser) {
        return this.users.stream().anyMatch(user -> user.getId().equalsIgnoreCase(idUser));
    }

    public void leerFicheroUsers() {
        this.users = gestionUser.leerFichero(this.ruta);
    }

    public void anadirFicheroUsers(User u) {
        gestionUser.anadirFichero(u, this.ruta);
    }

    public void modificarFicheroUsers() {
        gestionUser.modificarFichero(this.users, this.ruta);
    }


    /**
    public boolean altaUsuario(User usuario) {
        // 1. Longitud max de todos los campos 20
        // NO pueden contener el símbolo :
        // El IdUser no puede repetirse
        PanelAlta p = new PanelAlta();


        if (p.idUserText.getText().length() < 20 || p.pass1Texto.getText().length() < 20 || p.pass2Texto.getText().length() < 20 || p.isAdmin.getSelectedItem().toString().length() < 20) {

            if (p.idUserText.getText().contains(":") || p.pass1Texto.getText().contains(":") || p.pass2Texto.getText().contains(":")) {
                if (p.idUserText.getText().equals(users.toString())) {

                    gestionUser.anadirFichero(users, ruta);
                    users.add();


                }

            }


        }


    }
     **/
}
