package GUIFORM;

import Modelo.ChefeEquipa;
import Modelo.EstadoOrdemServico;
import Modelo.OrdemServico;
import Repositorio.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuChefe extends JFrame{
    private JPanel panel1;
    private JPanel painel;
    private JButton voltarButton;
    private JButton listarOrdensDeServicoButton;
    private JComboBox comboBox1;
    private JButton terminarOrdemDeServicoButton;


    public MenuChefe(ChefeEquipa chefeEquipa) {
        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();
        for(OrdemServico o : repo.getOrdemServicoMap().values()){
            if(o.getEstado().equals(EstadoOrdemServico.PENDENTE)){
                if(o.getEquipa().getChefeEquipa().getIdChefeEquipa() == chefeEquipa.getIdChefeEquipa()){
                    comboBox1.addItem(o);
                }
            }
        }
        listarOrdensDeServicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new ListarOrdensChefe(chefeEquipa).getPanel1());
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hide();
                new MainWindow("Main Window").trocarParaPainelPrincipal();
            }
        });
        terminarOrdemDeServicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrdemServico aux;
                aux = (OrdemServico) comboBox1.getSelectedItem();
                aux.setEstado(EstadoOrdemServico.TERMINADO);
            }
        });
    }

    public JPanel getPainel() {
        return painel;
    }

    public void setPainel(JPanel painel) {
        this.painel = painel;
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
