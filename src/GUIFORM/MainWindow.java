package GUIFORM;

import Repositorio.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {



    private JPanel mainPanel;
    private JLabel welcomeLabel;
    private JButton button1;
    private JButton loginClienteButton;


    MainWindow(String title) {
        super(title);
        //
        // Barra de menus
        //
        this.setJMenuBar(new JMenuBar());
        this.getJMenuBar().add(new JMenu("Municipios"));
        this.getJMenuBar().getMenu(0).add(new JMenuItem("Criar Novo Municipio"));
        this.getJMenuBar().add(new JMenu("Login"));
        this.getJMenuBar().getMenu(0).add(new JMenuItem("Login Municipio"));
        this.getJMenuBar().setVisible(true);
        //
        // Conteudo da Pane da JFrame
        //
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        //
        // Handlers das Opções de Menu
        //

        //
        // Event handlers
        //
        MainWindow window = this;
        this.getJMenuBar().getMenu(0).getItem(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new CriarMunicipio().getPanel1());
            }
        });
        //
        // Event handlers
        //
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new CriarMunicipio().getJPanel1());
            }
        });


        loginClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new Login().getPanel1());
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


        MainWindow frame = new MainWindow("MainWindow");

    }

    public void trocarPainel(JPanel painel){
        this.setContentPane(painel);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public void trocarParaPainelPrincipal() {
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
    }
}
