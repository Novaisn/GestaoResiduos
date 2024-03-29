package GUIFORM;

import Modelo.Contentor;
import Modelo.EstadoContentor;
import Modelo.Municipio;
import Modelo.TipoResiduos;
import Repositorio.BLL.ContentorBLL;
import Repositorio.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarContentor {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JButton criarContentorButton;
    private JButton voltarButton;


    public CriarContentor(Municipio municipio) {
        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();

        for (TipoResiduos t: repo.getTipoResiduosMap().values()){
            comboBox1.addItem(t);
        }
        criarContentorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TipoResiduos tipoSelecionado = (TipoResiduos) comboBox1.getSelectedItem();
                Contentor c = new Contentor(tipoSelecionado, EstadoContentor.ATE_MEIO, municipio);
                ContentorBLL.criarContentor(c);
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuMunicipio("Menu Municipio", municipio).trocarParaPainelPrincipal();
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
