package GUIFORM;

import Modelo.ChefeEquipa;
import Modelo.Municipio;
import Modelo.TipoResiduos;
import Modelo.Trabalhador;
import Repositorio.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CriarEquipa {
    private JPanel panel1;
    private JComboBox comboBoxChefe;
    private JButton adicionarTrabalhadorButton;
    private JButton criarParqueButton;
    private JTextField textField1;
    private JComboBox comboBoxResiduo;
    private JButton adicionarResiduoButton;
    private JComboBox comboBoxTrabalhador;
    private JPanel painel;
    private JButton voltarButton;


    public CriarEquipa() {
        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();




        for(TipoResiduos t : repo.getTipoResiduosMap().values()){
            comboBoxResiduo.addItem(t);
        }
        for (ChefeEquipa c: repo.getEquipaMap().values()){
            comboBoxChefe.addItem(c);
        }
        for(Trabalhador tra: repo.getTrabalhadorMap().values()){
            comboBoxTrabalhador.addItem(tra);
        }


        criarParqueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        adicionarResiduoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<TipoResiduos> residuos = new ArrayList<>();
                TipoResiduos aux;
                aux = (TipoResiduos) comboBoxResiduo.getSelectedItem();
                residuos.add(aux);
                comboBoxResiduo.removeItem(comboBoxResiduo.getSelectedItem());
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
