package GUIFORM;

import Modelo.Contentor;
import Modelo.EstadoContentor;
import Modelo.Gestor;
import Modelo.ParqueContentores;
import Repositorio.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtualizarEstadoContentor {
    private JPanel panel1;
    private JComboBox comboBoxParque;
    private JComboBox comboBoxContentor;
    private JComboBox comboBoxEstado;
    private JButton atualizarButton;
    private JButton voltarButton;
    private JPanel jpanel2;
    private JButton selecionarParqueButton;


    public AtualizarEstadoContentor(Gestor gestor) {

        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();

        for(ParqueContentores p : repo.getParqueMap().values()){
            if(p.getGestor().getIdGestor() == gestor.getIdGestor()){
                comboBoxParque.addItem(p);
            }
        }


        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();
                Contentor cont;
                cont = (Contentor) comboBoxContentor.getSelectedItem();
                EstadoContentor ec;
                ec = (EstadoContentor) comboBoxEstado.getSelectedItem();
                cont.setEstadoContentor(ec);
                repo.serializar();
            }
        });

        selecionarParqueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParqueContentores aux;
                aux = (ParqueContentores) comboBoxParque.getSelectedItem();
                for(Contentor c : aux.getContentores()){
                    comboBoxContentor.addItem(c);
                }

                for(EstadoContentor estadoContentor : EstadoContentor.values()){
                    comboBoxEstado.addItem(estadoContentor);
                }
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuGestor(gestor).trocarParaPainelPrincipal();
            }
        });
    }

    public JPanel getJpanel2() {
        return jpanel2;
    }

    public void setJpanel2(JPanel jpanel2) {
        this.jpanel2 = jpanel2;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
}
