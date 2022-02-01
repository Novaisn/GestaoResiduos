package GUIFORM;

import Modelo.Equipa;
import Modelo.EstadoOrdemServico;
import Modelo.OrdemServico;
import Modelo.ParqueContentores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CriarOrdemTrab {
    private JPanel panel1;
    private JPanel painel;
    private JTextField textFieldDescricao;
    private JComboBox comboBoxParque;
    private JComboBox comboBoxEquipa;
    private JButton criarOrdemButton;
    private JButton voltarButton;
    private JTextField textField1;


    public CriarOrdemTrab() {
        criarOrdemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descricao = textFieldDescricao.getText();
                ParqueContentores p = (ParqueContentores) comboBoxParque.getSelectedItem();
                Equipa equipa = (Equipa) comboBoxEquipa.getSelectedItem();
                String dataString = textField1.getText();
                SimpleDateFormat DataFormat = new SimpleDateFormat("dd/mm/yyyy");
                try {
                    Date data = DataFormat.parse(dataString);
                    OrdemServico ordemServico = new OrdemServico(data, descricao, p,equipa, EstadoOrdemServico.PENDENTE);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }




            }
        });
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
