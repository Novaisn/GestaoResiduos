package GUIFORM;

import Modelo.Contentor;
import Modelo.Gestor;
import Modelo.ParqueContentores;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ListarContentores {
    private JPanel panel1;
    private JPanel painel;
    private JTable table1;
    private JButton voltarButton;


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public ListarContentores(Gestor gestor) {

        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();
        List<Contentor> contentor = new ArrayList<>();

        for(ParqueContentores p : repo.getParqueMap().values()){
            if(p.getGestor().getIdGestor() == gestor.getIdGestor()){
                for (Contentor c : p.getContentores()){
                    contentor.add(c);
                }
            }
       }


        TabelaContentor tabelaContentor = new TabelaContentor(contentor);
        table1.setModel(tabelaContentor);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new MenuGestor(gestor).trocarParaPainelPrincipal();
            }
        });
    }

    private static class TabelaContentor extends AbstractTableModel {
        private final String[] COLUMNS = {"ID", "TIPO RESIDUO","ESTADO","Parque"};
        List<Contentor> contentors;

        private TabelaContentor(List<Contentor> contentors){
            this.contentors= contentors;
        }

        @Override
        public int getRowCount() {
            return contentors.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex){
                        case 0 -> contentors.get(rowIndex).getIdContentor();
                        case 1 -> contentors.get(rowIndex).getTipoResiduo();
                        case 2 -> contentors.get(rowIndex).getEstadoContentor();
                        case 3 -> contentors.get(rowIndex).getParqueContentores();
                default -> "-";
            };
        }
        public String getColumnName(int column){
            return COLUMNS[column];
        }

        public Class<?> getColumnClass(int columnIndex){
            if (getValueAt(0, columnIndex) != null){
                return getValueAt(0, columnIndex).getClass();
            }else {
                return Object.class;
            }
        }
    }

    public JPanel getPainel() {
        return painel;
    }

    public void setPainel(JPanel painel) {
        this.painel = painel;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
}
