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


    public AtualizarEstadoContentor(Gestor gestor) {

        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();

        for(ParqueContentores p : repo.getParqueMap().values()){
            if(p.getGestor().equals(gestor)){
                comboBoxParque.addItem(p);
            }
        }
        ParqueContentores aux;
        aux = (ParqueContentores) comboBoxParque.getSelectedItem();
        comboBoxContentor.addItem(aux.getContentores());

        for(EstadoContentor estadoContentor : EstadoContentor.values()){
            comboBoxEstado.addItem(estadoContentor);
        }

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contentor cont;
                cont = (Contentor) comboBoxContentor.getSelectedItem();
                EstadoContentor ec;
                ec = (EstadoContentor) comboBoxEstado.getSelectedItem();
                cont.setEstadoContentor(ec);
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
