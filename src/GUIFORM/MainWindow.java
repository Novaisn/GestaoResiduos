package GUIFORM;

import Repositorio.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {



    private JPanel mainPanel;
    private JLabel welcomeLabel;
    private JButton loginButton;


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
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        //
        // Handlers das Opções de Menu
        //

        //
        // Event handlers
        //
        MainWindow window = this;

        //
        // Event handlers
        //



        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new Login().getPanel1());
            }
        });
    }

    public static void main(String[] args) {

        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();

        MainWindow frame = new MainWindow("MainWindow");

    }

    public void trocarPainel(JPanel painel){
        this.setContentPane(painel);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public void trocarParaPainelPrincipal() {
        this.dispose();
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
    }
}
