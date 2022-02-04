package GUIFORM;

import javax.swing.*;

public class AlterarTrabalhador {
    private JPanel panel1;
    private JTextField textFieldNome;
    private JTextField textFieldNSS;
    private JTextField textFieldNIF;
    private JTextField textFieldTelefone;
    private JTextField textFieldSalario;
    private JButton buttonCriarTrabalhador;
    private JButton voltarButton;
    private JComboBox comboBoxTrabalhador;
    private JButton eliminarButton;
    private JPanel painelprincipal;




    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPainelprincipal() {
        return painelprincipal;
    }

    public void setPainelprincipal(JPanel painelprincipal) {
        this.painelprincipal = painelprincipal;
    }
}
