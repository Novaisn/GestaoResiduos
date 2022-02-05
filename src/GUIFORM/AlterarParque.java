package GUIFORM;

import Modelo.Gestor;
import Modelo.Municipio;
import Modelo.ParqueContentores;
import Repositorio.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarParque {
    private JPanel painelPrincipal;
    private JPanel panel1;
    private JTextField textFieldNome;
    private JTextField textFieldMorada;
    private JTextField textFieldLocalidade;
    private JComboBox comboBoxGestor;
    private JButton alterarButton;
    private JButton voltarButton;
    private JComboBox comboBoxParque;
    private JButton eliminarButton;
    private JTextArea textArea1;

    public AlterarParque(Municipio municipio) {
        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();
        for(ParqueContentores p : repo.getParqueMap().values()){
            if(p.getMunicipio().getIdMunicipio() == municipio.getIdMunicipio()){
                comboBoxParque.addItem(p);
            }
        }
        for(Gestor g : repo.getGestorMap().values()){
            comboBoxGestor.addItem(g);
        }
        comboBoxParque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();
                ParqueContentores aux = (ParqueContentores) comboBoxParque.getSelectedItem();
                textFieldNome.setText(aux.getNome());
                textFieldMorada.setText(aux.getMorada());
                textFieldLocalidade.setText(aux.getLocalidade());
                textArea1.setText(aux.getGestor().getNome());
            }
        });

        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();
                ParqueContentores aux = (ParqueContentores) comboBoxParque.getSelectedItem();
                for(ParqueContentores p : repo.getParqueMap().values()){
                    if(p.getIdParqueContentor() == aux.getIdParqueContentor()) {
                        p.setNome(textFieldNome.getText());
                        p.setMorada(textFieldMorada.getText());
                        p.setLocalidade(textFieldLocalidade.getText());
                        p.setGestor((Gestor) comboBoxGestor.getSelectedItem());
                        Repositorio.serializar();
                    }
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();
                ParqueContentores aux = (ParqueContentores) comboBoxParque.getSelectedItem();
                for(ParqueContentores p : repo.getParqueMap().values()) {
                    if (p.getIdParqueContentor() == aux.getIdParqueContentor()) {
                            repo.getParqueMap().remove(p.getIdParqueContentor(), p);
                            Repositorio.serializar();
                            comboBoxParque.removeItem(comboBoxParque.getSelectedItem());
                            break;
                    }
                }
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuMunicipio("Menu Municipio", municipio).trocarParaPainelPrincipal();
            }
        });
    }


    public JPanel getPainelPrincipal() {
        return painelPrincipal;
    }

    public void setPainelPrincipal(JPanel painelPrincipal) {
        this.painelPrincipal = painelPrincipal;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
}
