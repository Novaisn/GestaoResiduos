package GUIFORM;

import Modelo.ChefeEquipa;
import Modelo.Municipio;
import Modelo.Trabalhador;
import Repositorio.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarTrabalhador {
    private JPanel panel1;
    private JTextField textFieldNome;
    private JTextField textFieldNSS;
    private JTextField textFieldNIF;
    private JTextField textFieldTelefone;
    private JTextField textFieldSalario;
    private JButton buttonCriarTrabalhador;
    private JButton voltarButton;
    private JComboBox comboBoxTrabalhador;
    private JButton eliminarButton;
    private JPanel painelprincipal;


    public AlterarTrabalhador(Municipio municipio) {
        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();
        for (Trabalhador t : repo.getTrabalhadorMap().values()){
            if (t.getMunicipio().getIdMunicipio() == municipio.getIdMunicipio()){
                comboBoxTrabalhador.addItem(t);
            }
        }
        comboBoxTrabalhador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();
                Trabalhador aux;
                aux = (Trabalhador) comboBoxTrabalhador.getSelectedItem();
                textFieldTelefone.setText(aux.getTelefone());
                textFieldNome.setText(aux.getNome());
                textFieldSalario.setText(Double.toString(aux.getSalario()));
                textFieldNIF.setText(aux.getNIF());
                textFieldNSS.setText(aux.getNSS());
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuMunicipio("Menu Municipio", municipio).trocarParaPainelPrincipal();
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();
                Trabalhador aux = (Trabalhador) comboBoxTrabalhador.getSelectedItem();
                for (Trabalhador t : repo.getTrabalhadorMap().values()){
                    if (t.getIdTrabalhador() == aux.getIdTrabalhador()){
                        repo.getTrabalhadorMap().remove(t.getIdTrabalhador(), t);
                        Repositorio.serializar();
                        comboBoxTrabalhador.removeItem(comboBoxTrabalhador.getSelectedItem());
                        break;
                    }
                }

            }
        });
        buttonCriarTrabalhador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();
                Trabalhador aux = (Trabalhador) comboBoxTrabalhador.getSelectedItem();
                for (Trabalhador t : repo.getTrabalhadorMap().values()) {
                    if (t.getIdTrabalhador() == aux.getIdTrabalhador()) {
                        t.setNome(textFieldNome.getText());
                        t.setTelefone(textFieldTelefone.getText());
                        t.setNIF(textFieldNIF.getText());
                        t.setNSS(textFieldNSS.getText());
                        t.setSalario(Double.parseDouble(textFieldSalario.getText()));
                        Repositorio.serializar();
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

    public JPanel getPainelprincipal() {
        return painelprincipal;
    }

    public void setPainelprincipal(JPanel painelprincipal) {
        this.painelprincipal = painelprincipal;
    }
}
