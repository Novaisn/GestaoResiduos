package GUIFORM;

import Modelo.ChefeEquipa;
import Modelo.Gestor;
import Repositorio.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarGestor {
    private JPanel pa;
    private JPanel painel;
    private JPanel panel1;
    private JPanel JPanel1;
    private JTextField textFieldNCC;
    private JTextField textFieldNome;
    private JTextField textFieldNif;
    private JTextField textFieldTelefone;
    private JTextField textFieldMorada;
    private JTextField textFieldLocalidade;
    private JTextField textFieldUser;
    private JPasswordField passwordFieldPass;
    private JButton alterarButton;
    private JButton voltarButton;
    private JComboBox comboBoxGestor;
    private JButton eliminarButton;


    public AlterarGestor() {
        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();
        for (Gestor g : repo.getGestorMap().values()){
            comboBoxGestor.addItem(g);
        }

        comboBoxGestor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();
                Gestor aux;
                aux = (Gestor) comboBoxGestor.getSelectedItem();
                textFieldTelefone.setText(aux.getTelefone());
                textFieldUser.setText(aux.getUserName());
                textFieldNome.setText(aux.getNome());
                textFieldMorada.setText(aux.getMorada());
                textFieldLocalidade.setText(aux.getLocalidade());
                textFieldNif.setText(aux.getNif());
                textFieldNCC.setText(aux.getnCC());
                passwordFieldPass.setText(aux.getPass());

            }
        });
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();
                Gestor aux;
                aux = (Gestor) comboBoxGestor.getSelectedItem();
                for(Gestor g: repo.getGestorMap().values()){
                    if (g.getIdGestor() == aux.getIdGestor()){
                        aux.setNome(textFieldNome.getText());
                        aux.setLocalidade(textFieldLocalidade.getText());
                        aux.setMorada(textFieldMorada.getText());
                        aux.setnCC(textFieldNCC.getText());
                        aux.setNif(textFieldNif.getText());
                        aux.setPass(textFieldLocalidade.getText());
                        aux.setTelefone(textFieldTelefone.getText());
                        aux.setUserName(textFieldUser.getText());
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
                Gestor aux;
                aux = (Gestor) comboBoxGestor.getSelectedItem();
                for (Gestor g : repo.getGestorMap().values()){
                    if(g.getIdGestor() == aux.getIdGestor()){
                        repo.getGestorMap().remove(g.getIdGestor(), g);
                    }
                }
            }
        });
    }

    public JPanel getPa() {
        return pa;
    }

    public void setPa(JPanel pa) {
        this.pa = pa;
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

    public JPanel getJPanel1() {
        return JPanel1;
    }

    public void setJPanel1(JPanel JPanel1) {
        this.JPanel1 = JPanel1;
    }
}
