package GUIFORM;

import Modelo.*;
import Repositorio.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MenuAdmin extends JFrame{
    private JPanel panel1;
    private JButton criarMunicipioButton;
    private JButton criarGestorButton;
    private JButton criarAdminButton;
    private JButton criarChefeDeEquipaButton;
    private JButton voltarButton;
    private JButton criarTipoResiduoButton;
    private JComboBox comboBox1;
    private JButton alterarMunicipioButton;
    private JButton alterarGestorButton;
    private JButton alterarChefeButton;

    private JList<ChefeEquipa> listChefes = new JList<>();
    private DefaultListModel<Municipio> modelChefes = new DefaultListModel<>();
    MenuAdmin(String titulo) {

        super(titulo);

        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();
        criarMunicipioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new CriarMunicipio().getJPanel1());
            }
        });

        criarGestorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new CriarGestor().getJPanel1());
            }
        });
        criarChefeDeEquipaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new CriarChefe().getJPanel1());
            }
        });
        criarAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new CriarAdmin().getJPanel1());
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hide();
                setVisible(false);
                new MainWindow("Main Window").trocarParaPainelPrincipal();

            }
        });
        criarTipoResiduoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new CriarTipoResiduo().getPanel1());
            }
        });



        for (TipoResiduos t: repo.getTipoResiduosMap().values()){
            comboBox1.addItem(t);
        }

        alterarMunicipioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new AlterarMunicipio().getPanel1());
            }
        });

        alterarGestorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new AlterarGestor().getPa());
            }
        });
        alterarChefeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new AlterarChefe().getJpainel());
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public static void main(String[] args) {
        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();

        MenuAdmin frame = new MenuAdmin("Menu Admin");



    }
    public void trocarPainel(JPanel painel){
        this.setContentPane(painel);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

    public void trocarParaPainelPrincipal() {
        this.setContentPane(panel1);
        this.pack();
        this.setVisible(true);
    }
    private void listMunicipios(){
        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();

        List<Municipio> municipios = new ArrayList<>();
        for(Municipio m : repo.getMunicipioMap().values()){
            municipios.add(m);
        }

    }

}