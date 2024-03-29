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
    private JButton criarContentorButton;
    private JButton alterarTrabalhadorButton;
    private JButton alterarEquipaButton;
    private JButton alterarEliminarParqueButton;


    public MenuMunicipio(String titulo, Municipio municipio) {
        super(titulo);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
                hide();
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
        criarContentorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new CriarContentor(municipio).getPanel1());
            }
        });
        alterarTrabalhadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new AlterarTrabalhador(municipio).getPainelprincipal());
            }
        });
        alterarEquipaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new AlterarEquipa(municipio).getPainelPrincipal());
            }
        });
        alterarEliminarParqueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new AlterarParque(municipio).getPainelPrincipal());
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
