package GUIFORM;

import Modelo.Municipio;
import Repositorio.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarMunicipio {
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
    private JButton voltarButton;

    private JButton alterarButton;
    private JButton eliminarButton;
    private JComboBox comboBox1;
    private JList<Municipio> listMunicipios = new JList<>();
    private DefaultListModel<Municipio> modelMunicipios = new DefaultListModel<>();


    public AlterarMunicipio() {
        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();

        for ( Municipio m : repo.getMunicipioMap().values()){
            comboBox1.addItem(m);
        }


        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuAdmin("Menu Admin").trocarParaPainelPrincipal();
            }
        });
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();
                Municipio municipio2 = (Municipio) comboBox1.getSelectedItem();
                for (Municipio m : repo.getMunicipioMap().values()){
                    if ( m.getIdMunicipio() == municipio2.getIdMunicipio()){
                        m.setNome(textFieldNome.getText());
                        m.setLocalidade(textFieldLocalidade.getText());
                        m.setMorada(textFieldMorada.getText());
                        m.setnCC(textFieldNCC.getText());
                        m.setNif(textFieldNif.getText());
                        m.setPass(textFieldLocalidade.getText());
                        m.setTelefone(textFieldTelefone.getText());
                        m.setUserName(textFieldUser.getText());
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
                Municipio municipio3 = (Municipio) comboBox1.getSelectedItem();
                for (Municipio m : repo.getMunicipioMap().values()){
                    if (m.getIdMunicipio() == municipio3.getIdMunicipio()){
                        repo.getMunicipioMap().remove(m);
                    }
                }
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Municipio aux;

                aux = (Municipio) comboBox1.getSelectedItem();
                textFieldTelefone.setText(aux.getTelefone());
                textFieldMorada.setText(aux.getMorada());
                textFieldUser.setText(aux.getUserName());
                textFieldNif.setText(aux.getNif());
                textFieldNCC.setText(aux.getnCC());
                textFieldLocalidade.setText(aux.getLocalidade());
                textFieldNome.setText(aux.getNome());
                passwordFieldPass.setText(aux.getPass());
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
