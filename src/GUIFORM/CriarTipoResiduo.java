package GUIFORM;

import Modelo.TipoResiduos;
import Repositorio.BLL.TipoResiduoBLL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarTipoResiduo {
    private JPanel panel1;
    private JTextField textFieldTipoResiduo;
    private JButton criarResiduoButton;
    private JButton voltarButton;

    public CriarTipoResiduo() {
        criarResiduoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeTipoResiduo = textFieldTipoResiduo.getText();
                TipoResiduos tipoResiduos = new TipoResiduos(nomeTipoResiduo);
                TipoResiduoBLL.criarTipoResiduo(tipoResiduos);
                textFieldTipoResiduo.setText("");
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuAdmin("Menu Admin").trocarParaPainelPrincipal();
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
