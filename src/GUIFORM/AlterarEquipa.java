package GUIFORM;

import Modelo.ChefeEquipa;
import Modelo.Equipa;
import Modelo.Municipio;
import Repositorio.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarEquipa {

    private JPanel painelPrincipal;
    private JPanel panel1;
    private JPanel painel;
    private JTextField textField1;
    private JComboBox comboBoxChefe;
    private JButton voltarButton;
    private JButton criarEquipaButton;
    private JComboBox comboBoxEquipa;
    private JButton eliminarButton;
    private JTextField textField2;

    public AlterarEquipa(Municipio municipio) {
        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();
        for(Equipa e : repo.getEquipatrabalhadoresMap().values()){
            if(e.getMunicipio().getIdMunicipio() == municipio.getIdMunicipio()){
                comboBoxEquipa.addItem(e);
            }
        }
        for(ChefeEquipa c : repo.getEquipaMap().values()){
            if(c.getMunicipio().getIdMunicipio() == municipio.getIdMunicipio()) {
                comboBoxChefe.addItem(c);
            }
        }
        comboBoxEquipa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipa aux = (Equipa) comboBoxEquipa.getSelectedItem();
                textField1.setText(aux.getNome());
                textField2.setText(aux.getChefeEquipa().getNome());
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();
                Equipa aux = (Equipa) comboBoxEquipa.getSelectedItem();
                for(Equipa equipa : repo.getEquipatrabalhadoresMap().values()) {
                        if(aux.getIdEquipa() == equipa.getIdEquipa()){
                            repo.getEquipatrabalhadoresMap().remove(equipa.getIdEquipa(), equipa);
                            Repositorio.serializar();
                        }
                }
            }
        });
        criarEquipaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();
                Equipa aux = (Equipa) comboBoxEquipa.getSelectedItem();
                for (Equipa equipa1 : repo.getEquipatrabalhadoresMap().values()){
                    if (equipa1.getIdEquipa() == aux.getIdEquipa()){
                        equipa1.setNome(textField1.getText());
                        equipa1.setChefeEquipa((ChefeEquipa) comboBoxChefe.getSelectedItem());
                        Repositorio.serializar();
                        comboBoxEquipa.removeItem(comboBoxEquipa.getSelectedItem());
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

    public JPanel getPainel() {
        return painel;
    }

    public void setPainel(JPanel painel) {
        this.painel = painel;
    }
}
