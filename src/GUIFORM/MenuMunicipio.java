package GUIFORM;

import Modelo.Municipio;
import Repositorio.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuMunicipio extends JFrame {
    private JPanel panel1;
    private JButton criarParqueButton;
    private JButton voltarButton;
    private JButton criarTrabalhadorButton;
    private JButton criarEquipaButton;


    public MenuMunicipio(String titulo, Municipio municipio) {
        super(titulo);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        criarParqueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new CriarParque(municipio).getPanel1());
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
            trocarPainel(new CriarTrabalhador(municipio).getPanel1());
            }

        });
        criarEquipaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new CriarEquipa(municipio).getPanel1());
            }
        });
    }

    public static void main(String[] args) {
        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();


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
