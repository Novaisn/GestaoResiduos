package GUIFORM;

import Modelo.*;
import Repositorio.BLL.EquipaBLL;
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
    private JButton criarEquipaButton;
    private JTextField textField1;
    private JComboBox comboBoxResiduo;
    private JButton adicionarResiduoButton;
    private JComboBox comboBoxTrabalhador;
    private JPanel painel;
    private JButton voltarButton;

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public CriarEquipa(Municipio municipio) {
        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();

        List<Trabalhador> trabalhadores = new ArrayList<>();
        List<TipoResiduos> residuos = new ArrayList<>();

        for(TipoResiduos t : repo.getTipoResiduosMap().values()){
            comboBoxResiduo.addItem(t);
        }
        for (ChefeEquipa c: repo.getEquipaMap().values()){
            if(c.getMunicipio().getIdMunicipio() == municipio.getIdMunicipio()) {
                comboBoxChefe.addItem(c);
            }
        }
        for(Trabalhador tra: repo.getTrabalhadorMap().values()){
            if(tra.getMunicipio().getIdMunicipio() == municipio.getIdMunicipio()) {
                comboBoxTrabalhador.addItem(tra);
            }
        }


        adicionarResiduoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TipoResiduos aux;
                aux = (TipoResiduos) comboBoxResiduo.getSelectedItem();
                residuos.add(aux);
                comboBoxResiduo.removeItem(comboBoxResiduo.getSelectedItem());
            }
        });
        adicionarTrabalhadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Trabalhador aux;
                aux = (Trabalhador) comboBoxTrabalhador.getSelectedItem();
                trabalhadores.add(aux);
                comboBoxTrabalhador.removeItem(comboBoxTrabalhador.getSelectedItem());
            }
        });
        criarEquipaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textField1.getText();
                ChefeEquipa chefeEquipa = (ChefeEquipa) comboBoxChefe.getSelectedItem();
                Equipa equipa = new Equipa(nome,chefeEquipa,residuos,trabalhadores, municipio);
                EquipaBLL.criarEquipa(equipa);
                JOptionPane.showMessageDialog(null,"Equipa criada com sucesso");
                textField1.setText("");
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
