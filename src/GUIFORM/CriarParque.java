package GUIFORM;

import Modelo.Contentor;
import Modelo.Gestor;
import Modelo.Municipio;
import Modelo.ParqueContentores;
import Repositorio.BLL.ParqueContentorBLL;
import Repositorio.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CriarParque {
    private JPanel panel1;
    private JTextField textFieldNome;
    private JTextField textFieldMorada;
    private JTextField textFieldLocalidade;
    private JComboBox comboBoxGestor;
    private JComboBox comboBoxContentor;
    private JButton adicionarContentorButton;
    private JButton criarParqueButton;
    private JButton voltarButton;

    public CriarParque(Municipio municipio) {
        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();
        List<Contentor> contentores = new ArrayList<>();
        for (Contentor c : repo.getContentorMap().values()){

            comboBoxContentor.addItem(c);
        }
        for(Gestor g: repo.getGestorMap().values()){
            comboBoxGestor.addItem(g);
        }
        adicionarContentorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contentor aux;
                aux = (Contentor) comboBoxContentor.getSelectedItem();
                contentores.add(aux);
                comboBoxContentor.removeItem(comboBoxContentor.getSelectedItem());
            }
        });
        criarParqueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = textFieldNome.getText();
                String Morada = textFieldMorada.getText();
                String Localidade = textFieldLocalidade.getText();
                Gestor gestor = (Gestor) comboBoxGestor.getSelectedItem();
                ParqueContentores p = new ParqueContentores(nome,Morada,Localidade,contentores,gestor, municipio);
                ParqueContentorBLL.criarParque(p);
                JOptionPane.showMessageDialog(null,"Parque criado com sucesso");
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuMunicipio("Menu Municipio", municipio);
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
