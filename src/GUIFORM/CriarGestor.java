package GUIFORM;

import Modelo.Admin;
import Modelo.Gestor;
import Modelo.Municipio;
import Repositorio.BLL.GestorBLL;
import Repositorio.BLL.MunicipioBLL;
import Repositorio.Repositorio;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarGestor {
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
    private JButton criarGestorButton;
    private JButton voltarButton;


    public CriarGestor() {
        criarGestorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repositorio repo = Repositorio.getRepositorio();
                Repositorio.desserializar("BD.repo");
                repo = Repositorio.getRepositorio();

                String nome = textFieldNome.getText();
                String NCC = textFieldNCC.getText();
                String Nif = textFieldNif.getText();
                String telefone = textFieldTelefone.getText();
                String morada = textFieldMorada.getText();
                String localidade = textFieldLocalidade.getText();
                String user = textFieldUser.getText();
                String pass = passwordFieldPass.getText();
                int aux = 0;
                for(Gestor g: repo.getGestorMap().values() ){
                    if(g.getNif().equals(Nif) || g.getUserName().equals(user)){
                        JOptionPane.showMessageDialog(null, "Erro");
                        aux = 1;
                        break;
                    }
                }
                if(aux != 1) {

                    Gestor gestor = new Gestor(nome, NCC, Nif, telefone, morada, localidade, pass, user);
                    GestorBLL.criarGestor(gestor);
                    JOptionPane.showMessageDialog(null, "Gestor criado com sucesso");
                }
                textFieldNome.setText("");
                textFieldNCC.setText("");
                textFieldNif.setText("");
                textFieldTelefone.setText("");
                textFieldMorada.setText("");
                textFieldLocalidade.setText("");
                textFieldUser.setText("");
                passwordFieldPass.setText("");
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuAdmin("Menu Admin").trocarParaPainelPrincipal();
            }
        });
    }

    public JPanel getJPanel1() {
        return JPanel1;
    }

    public void setJPanel1(JPanel JPanel1) {
        this.JPanel1 = JPanel1;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
}
