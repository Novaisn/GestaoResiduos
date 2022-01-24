package GUIFORM;

import Modelo.Admin;
import Modelo.ChefeEquipa;
import Modelo.Gestor;
import Modelo.Municipio;
import Repositorio.RepositorioAdmin;
import Repositorio.RepositorioChefeEquipa;
import Repositorio.RepositorioGestor;
import Repositorio.RepositorioMunicipio;

import javax.swing.*;
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
            public void actionPerformed(ActionEvent e) {
                new MainWindow("main window").trocarParaPainelPrincipal();
            }
        });
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldUser.getText();
                String pass = passwordFieldPass.getText();

                RepositorioMunicipio repositorioMunicipio;
                RepositorioMunicipio.desserializar("Municipio.repo");
                repositorioMunicipio = RepositorioMunicipio.getRepositorioMunicipio();

                RepositorioAdmin repositorioAdmin;
                RepositorioAdmin.desserializar("Admin.repo");
                repositorioAdmin = RepositorioAdmin.getRepositorioAdmin();

                RepositorioGestor repositorioGestor;
                RepositorioGestor.desserializar("Gestor.repo");
                repositorioGestor = RepositorioGestor.getRepositorioGestor();

                RepositorioChefeEquipa repositorioChefeEquipa;
                RepositorioChefeEquipa.desserializar("ChefeEquipa.repo");
                repositorioChefeEquipa = RepositorioChefeEquipa.getRepositorioChefeEquipa();

                for(Municipio municipio : repositorioMunicipio.getMunicipioMap().values()){
                    if(nome.equals(municipio.getUserName()) && pass.equals(municipio.getPass())) {
                        JOptionPane.showMessageDialog(null, "login efetuado com sucesso");
                        break;
                    }
                }
                for(Admin admin: repositorioAdmin.getAdminMap().values()){
                    if(nome.equals(admin.getUserName())&& pass.equals(admin.getPass())){
                        JOptionPane.showMessageDialog(null, "login efetuado com sucesso");
                    }
                }
                for(Gestor gestor: repositorioGestor.getGestorMap().values()){
                    if(nome.equals(gestor.getUserName())&& pass.equals(gestor.getPass())){
                        JOptionPane.showMessageDialog(null,"login efetuado com sucesso");
                    }
                }
                for(ChefeEquipa chefeEquipa: repositorioChefeEquipa.getChefeEquipaMap().values()){
                    if(nome.equals(chefeEquipa.getUserName()) && pass.equals(chefeEquipa.getPass())){
                        JOptionPane.showMessageDialog(null, "login efetuado com sucesso");
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
