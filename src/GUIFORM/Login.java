package GUIFORM;

import Modelo.Admin;
import Modelo.ChefeEquipa;
import Modelo.Gestor;
import Modelo.Municipio;
import Repositorio.Repositorio;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JPanel panel1;
    private JTextField textFieldUser;
    private JPasswordField passwordFieldPass;
    private JButton voltarButton;
    private JButton entrarButton;


    public Login() {
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {

                new MainWindow("main window").trocarParaPainelPrincipal();

            }
        });
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldUser.getText();
                String pass = passwordFieldPass.getText();

                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();

                for(Admin admin: repo.getAdminMap().values()){
                    if(nome.equals(admin.getUserName())&& pass.equals(admin.getPass())){
                        JOptionPane.showMessageDialog(null, "login efetuado com sucesso");
                            new MenuAdmin("menu admin").trocarParaPainelPrincipal();
                        break;
                    }
                }

                for(Municipio municipio : repo.getMunicipioMap().values()){
                    if(nome.equals(municipio.getUserName()) && pass.equals(municipio.getPass())) {
                        JOptionPane.showMessageDialog(null, "login efetuado com sucesso");

                        new MenuMunicipio("Menu Municipio" ,municipio).trocarParaPainelPrincipal();

                        break;
                    }
                }

                for(Gestor gestor: repo.getGestorMap().values()){
                    if(nome.equals(gestor.getUserName())&& pass.equals(gestor.getPass())){
                        JOptionPane.showMessageDialog(null,"login efetuado com sucesso");
                        new MenuGestor(gestor).getPanel1();
                        break;
                    }
                }
                for(ChefeEquipa chefeEquipa: repo.getEquipaMap().values()){
                    if(nome.equals(chefeEquipa.getUserName()) && pass.equals(chefeEquipa.getPass())){
                        JOptionPane.showMessageDialog(null, "login efetuado com sucesso");
                        new MenuChefe(chefeEquipa).trocarParaPainelPrincipal();
                        break;
                    }
                }
                textFieldUser.setText("");
                passwordFieldPass.setText("");
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
}
