package GUIFORM;

import Modelo.*;
import Repositorio.BLL.OrdemServicoBLL;
import Repositorio.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CriarOrdemTrab {
    private JPanel panel1;
    private JPanel painel;
    private JTextField textFieldDescricao;
    private JComboBox comboBoxParque;
    private JComboBox comboBoxEquipa;
    private JButton criarOrdemButton;
    private JButton voltarButton;
    private JTextField textField1;


    public CriarOrdemTrab(Gestor gestor) {
        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();

        for (ParqueContentores p : repo.getParqueMap().values()){
            if(p.getGestor().getIdGestor() == gestor.getIdGestor()){
                comboBoxParque.addItem(p);
            }
        }



        criarOrdemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descricao = textFieldDescricao.getText();
                ParqueContentores p = (ParqueContentores) comboBoxParque.getSelectedItem();
                Equipa equipa = (Equipa) comboBoxEquipa.getSelectedItem();



            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuGestor(gestor).trocarParaPainelPrincipal();
            }
        });
        comboBoxParque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();
                ParqueContentores aux = (ParqueContentores) comboBoxParque.getSelectedItem();
                for(Equipa eq : repo.getEquipatrabalhadoresMap().values()){
                    if(eq.getMunicipio().getIdMunicipio() == aux.getMunicipio().getIdMunicipio()){
                        comboBoxEquipa.addItem(eq);
                    }
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPainel() {
        return painel;
    }

    public void setPainel(JPanel painel) {
        this.painel = painel;
    }
}
