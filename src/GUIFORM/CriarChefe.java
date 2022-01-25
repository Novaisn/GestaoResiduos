package GUIFORM;

import Modelo.Admin;
import Modelo.ChefeEquipa;
import Modelo.Municipio;
import Repositorio.BLL.ChefeEquipaBLL;
import Repositorio.BLL.MunicipioBLL;
import Repositorio.RepositorioChefeEquipa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarChefe {
    private JPanel JPanel1;
    private JTextField textFieldNCC;
    private JTextField textFieldNome;
    private JTextField textFieldNif;
    private JTextField textFieldTelefone;
    private JTextField textFieldMorada;
    private JTextField textFieldLocalidade;
    private JTextField textFieldUser;
    private JPasswordField passwordFieldPass;
    private JButton criarChefeButton;
    private JButton voltarButton;


    public CriarChefe() {
        criarChefeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RepositorioChefeEquipa repositorioChefeEquipa = RepositorioChefeEquipa.getRepositorioChefeEquipa();
                RepositorioChefeEquipa.desserializar("ChefeEquipa.repo");
                repositorioChefeEquipa = RepositorioChefeEquipa.getRepositorioChefeEquipa();

                String nome = textFieldNome.getText();
                String NCC = textFieldNCC.getText();
                String Nif = textFieldNif.getText();
                String telefone = textFieldTelefone.getText();
                String morada = textFieldMorada.getText();
                String localidade = textFieldLocalidade.getText();
                String user = textFieldUser.getText();
                String pass = passwordFieldPass.getText();

                for(ChefeEquipa c: repositorioChefeEquipa.getChefeEquipaMap().values()){
                    if(c.getNif().equals(Nif) || c.getUserName().equals(user)){
                        JOptionPane.showMessageDialog(null, "Erro");
                        new MenuAdmin("Menu Admin").trocarParaPainelPrincipal();
                        break;
                    }
                }
                ChefeEquipa chefeEquipa = new ChefeEquipa(nome, NCC, Nif, telefone, morada, localidade, pass, user);
                ChefeEquipaBLL.criarChefe(chefeEquipa);
                JOptionPane.showMessageDialog(null,"Chefe criado com sucesso");
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
}
