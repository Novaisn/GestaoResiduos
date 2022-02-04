package GUIFORM;

import Modelo.ChefeEquipa;
import Repositorio.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarChefe {
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
    private JComboBox comboBoxAlterar;
    private JPanel Jpainel;
    private JButton eliminarButton;
    private JComboBox comboBoxMunicipio;


    public AlterarChefe() {

        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();
        for (ChefeEquipa c : repo.getEquipaMap().values()){
            comboBoxAlterar.addItem(c);
        }
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();
                ChefeEquipa aux;
                aux = (ChefeEquipa) comboBoxAlterar.getSelectedItem();
                for (ChefeEquipa c: repo.getEquipaMap().values()){
                    if (c.getIdChefeEquipa() == aux.getIdChefeEquipa()){
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
                ChefeEquipa chefeEquipa1 = (ChefeEquipa) comboBoxAlterar.getSelectedItem();
                for(ChefeEquipa c : repo.getEquipaMap().values()){
                    if (c.getIdChefeEquipa() == chefeEquipa1.getIdChefeEquipa()){
                        repo.getEquipaMap().remove(c);
                        Repositorio.serializar();
                    }
                }
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuAdmin("Menu Admin").trocarParaPainelPrincipal();
            }
        });

        comboBoxAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();
                ChefeEquipa aux;
                aux = (ChefeEquipa) comboBoxAlterar.getSelectedItem();
                textFieldTelefone.setText(aux.getTelefone());
                textFieldUser.setText(aux.getUserName());
                textFieldNome.setText(aux.getNome());
                textFieldMorada.setText(aux.getMorada());
                textFieldLocalidade.setText(aux.getLocalidade());
                textFieldNif.setText(aux.getNif());
                textFieldNCC.setText(aux.getnCC());
                passwordFieldPass.setText(aux.getPass());
                comboBoxMunicipio.addItem(aux.getMunicipio());

            }
        });
    }

    public JPanel getJPanel1() {
        return JPanel1;
    }

    public void setJPanel1(JPanel JPanel1) {
        this.JPanel1 = JPanel1;
    }

    public JPanel getJpainel() {
        return Jpainel;
    }

    public void setJpainel(JPanel jpainel) {
        Jpainel = jpainel;
    }
}
