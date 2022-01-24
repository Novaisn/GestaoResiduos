package GUIFORM;

import Modelo.Admin;
import Modelo.Municipio;
import Repositorio.BLL.AdminBLL;
import Repositorio.BLL.MunicipioBLL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarAdmin {
    private JPanel JPanel1;
    private JTextField textFieldNCC;
    private JTextField textFieldNome;
    private JTextField textFieldNif;
    private JTextField textFieldTelefone;
    private JTextField textFieldMorada;
    private JTextField textFieldLocalidade;
    private JTextField textFieldUser;
    private JPasswordField passwordFieldPass;
    private JButton criarAdminButton;
    private JButton voltarButton;

    public CriarAdmin() {
        criarAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText();
                String NCC = textFieldNCC.getText();
                String Nif = textFieldNif.getText();
                String telefone = textFieldTelefone.getText();
                String morada = textFieldMorada.getText();
                String localidade = textFieldLocalidade.getText();
                String user = textFieldUser.getText();
                String pass = passwordFieldPass.getText();
                Admin admin = new Admin(nome, NCC, Nif, telefone, morada, localidade, pass, user);
                AdminBLL.criarAdmin(admin);
                JOptionPane.showMessageDialog(null,"Admin criado com sucesso");
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
