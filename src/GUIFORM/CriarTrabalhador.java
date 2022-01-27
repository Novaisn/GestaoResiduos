package GUIFORM;

import Modelo.Municipio;
import Modelo.Trabalhador;
import Repositorio.BLL.TrabalhadorBLL;
import Repositorio.RepositorioTrabalhador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarTrabalhador {
    private JPanel panel1;
    private JTextField textFieldNome;
    private JTextField textFieldNSS;
    private JTextField textFieldNIF;
    private JTextField textFieldTelefone;
    private JTextField textFieldSalario;
    private JButton buttonCriarTrabalhador;
    private JButton voltarButton;


    public CriarTrabalhador(Municipio municipio) {

        buttonCriarTrabalhador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RepositorioTrabalhador repositorioTrabalhador = RepositorioTrabalhador.getRepositorioTrabalhador();
                RepositorioTrabalhador.desserializar("Trabalhador.repo");
                repositorioTrabalhador = RepositorioTrabalhador.getRepositorioTrabalhador();
                String nome = textFieldNome.getText();
                String NSS = textFieldNSS.getText();
                String Nif = textFieldNIF.getText();
                String telefone = textFieldTelefone.getText();
                double salario = Double.parseDouble(textFieldSalario.getText());

                for(Trabalhador t: repositorioTrabalhador.getTrabalhadorMap().values() ){
                    if(t.getNIF().equals(Nif) || t.getNSS().equals(NSS)){
                        JOptionPane.showMessageDialog(null, "Erro");
                        new MenuMunicipio("Menu Municipio", municipio).trocarParaPainelPrincipal();
                        break;
                    }
                }
                Trabalhador trabalhador = new Trabalhador(nome, Nif,NSS,telefone,salario, municipio);
                TrabalhadorBLL.criarTrabalhador(trabalhador);
                JOptionPane.showMessageDialog(null, "Trabalhador criado com sucesso");
                textFieldNome.setText("");
                textFieldNSS.setText("");
                textFieldNIF.setText("");
                textFieldTelefone.setText("");
                textFieldSalario.setText("");
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuMunicipio("Menu Municipio",municipio).trocarParaPainelPrincipal();
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
