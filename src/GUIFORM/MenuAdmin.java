package GUIFORM;

import Repositorio.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdmin extends JFrame{
    private JPanel panel1;
    private JButton criarMunicipioButton;
    private JButton criarGestorButton;
    private JButton criarAdminButton;
    private JButton criarChefeDeEquipaButton;
    private JButton voltarButton;
    private JButton criarTipoResiduoButton;

    MenuAdmin(String titulo) {
         super(titulo);
         this.setContentPane(panel1);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.pack();
         this.setVisible(true);
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
                new MainWindow("Main Window").trocarParaPainelPrincipal();
            }
        });
        criarTipoResiduoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(new CriarTipoResiduo().getPanel1());
            }
        });
    }

    public static void main(String[] args) {
        RepositorioTrabalhador repositorioTrabalhador = RepositorioTrabalhador.getRepositorioTrabalhador();
        RepositorioTrabalhador.desserializar("Trabalhador.repo");
        repositorioTrabalhador = RepositorioTrabalhador.getRepositorioTrabalhador();

        RepositorioAdmin repositorioAdmin = RepositorioAdmin.getRepositorioAdmin();
        RepositorioAdmin.desserializar("Admin.repo");
        repositorioAdmin = RepositorioAdmin.getRepositorioAdmin();

        RepositorioParqueContentores repositorioParqueContentores = RepositorioParqueContentores.getRepositorioParqueContentores();
        RepositorioParqueContentores.desserializar("Parques.repo");
        repositorioParqueContentores = RepositorioParqueContentores.getRepositorioParqueContentores();

        RepositorioMunicipio repositorioMunicipio = RepositorioMunicipio.getRepositorioMunicipio();
        RepositorioMunicipio.desserializar("Municipio.repo");
        repositorioMunicipio = RepositorioMunicipio.getRepositorioMunicipio();

        RepositorioGestor repositorioGestor = RepositorioGestor.getRepositorioGestor();
        RepositorioGestor.desserializar("Gestor.repo");
        repositorioGestor = RepositorioGestor.getRepositorioGestor();

        RepositorioChefeEquipa repositorioChefeEquipa = RepositorioChefeEquipa.getRepositorioChefeEquipa();
        RepositorioChefeEquipa.desserializar("ChefeEquipa.repo");
        repositorioChefeEquipa = RepositorioChefeEquipa.getRepositorioChefeEquipa();
        MenuAdmin frame = new MenuAdmin("titulo");
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
}
