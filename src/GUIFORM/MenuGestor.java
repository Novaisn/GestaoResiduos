package GUIFORM;

import Modelo.Gestor;
import Repositorio.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGestor extends JFrame{
    private JPanel panel1;
    private JButton atualizarEstadoDeContentorButton;
    private JButton criarOrdemDeTrabalhoButton;
    private JButton voltarButton;
    private JButton listarContentoresButton;
    private JButton listarOrdensDeTrabalhoButton;

    public MenuGestor(Gestor gestor) {
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        atualizarEstadoDeContentorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new AtualizarEstadoContentor(gestor).getJpanel2());
            }
        });
        criarOrdemDeTrabalhoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new CriarOrdemTrab(gestor).getPainel());
            }
        });
        listarContentoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new ListarContentores(gestor).getPanel1());
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainWindow("Menu Principal").trocarParaPainelPrincipal();
            }
        });
        listarOrdensDeTrabalhoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new ListarOrdensGestor(gestor).getPanel1());
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
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
        hide();
        this.setContentPane(panel1);
        this.pack();
        this.setVisible(true);
    }
}
