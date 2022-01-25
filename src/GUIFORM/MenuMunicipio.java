package GUIFORM;

import Repositorio.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuMunicipio extends JFrame {
    private JPanel panel1;
    private JButton criarParqueButton;
    private JButton voltarButton;
    private JButton criarTrabalhadorButton;


    public MenuMunicipio(String titulo) {
        super(titulo);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        criarParqueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainWindow("Menu Principal").trocarParaPainelPrincipal();
            }
        });
        criarTrabalhadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        RepositorioTrabalhador repositorioTrabalhador = RepositorioTrabalhador.getRepositorioTrabalhador();
        RepositorioTrabalhador.desserializar("Trabalhador.repo");
        repositorioTrabalhador = RepositorioTrabalhador.getRepositorioTrabalhador();

        RepositorioAdmin repositorioAdmin = RepositorioAdmin.getRepositorioAdmin();
        RepositorioAdmin.desserializar("Admin.repo");
        repositorioAdmin = RepositorioAdmin.getRepositorioAdmin();

        RepositorioParqueContentores repositorioParqueContentores = RepositorioParqueContentores.getRepositorioParqueContentores();
        RepositorioParqueContentores.desserializar("Parques.repo");
        repositorioParqueContentores = RepositorioParqueContentores.getRepositorioParqueContentores();

        RepositorioMunicipio repositorioMunicipio = RepositorioMunicipio.getRepositorioMunicipio();
        RepositorioMunicipio.desserializar("Municipio.repo");
        repositorioMunicipio = RepositorioMunicipio.getRepositorioMunicipio();

        RepositorioGestor repositorioGestor = RepositorioGestor.getRepositorioGestor();
        RepositorioGestor.desserializar("Gestor.repo");
        repositorioGestor = RepositorioGestor.getRepositorioGestor();

        RepositorioChefeEquipa repositorioChefeEquipa = RepositorioChefeEquipa.getRepositorioChefeEquipa();
        RepositorioChefeEquipa.desserializar("ChefeEquipa.repo");
        repositorioChefeEquipa = RepositorioChefeEquipa.getRepositorioChefeEquipa();
        MenuMunicipio frame = new MenuMunicipio("Menu Municipio");
    }
    public void trocarPainel(JPanel painel){
        this.setContentPane(painel);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public void trocarParaPainelPrincipal() {
        this.setContentPane(panel1);
        this.pack();
        this.setVisible(true);
    }
}
