package GUIFORM;

import Modelo.Contentor;
import Modelo.Gestor;
import Modelo.OrdemServico;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ListarOrdensGestor {
    private JPanel panel1;
    private JTable table1;
    private JButton voltarButton;


    public ListarOrdensGestor(Gestor gestor) {
        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();
        List<OrdemServico> ordemServicos = new ArrayList<>();

        for (OrdemServico o : repo.getOrdemServicoMap().values()){
            if(o.getParqueContentores().getGestor().getIdGestor() == gestor.getIdGestor()){
                ordemServicos.add(o);
            }
        }
        TabelaOrdem tabelaOrdem = new TabelaOrdem(ordemServicos);
        table1.setModel(tabelaOrdem);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuGestor(gestor).trocarParaPainelPrincipal();
            }
        });
    }

    private static class TabelaOrdem extends AbstractTableModel {
        private final String[] COLUMNS = {"ID", "DESCRICAO","ESTADO","EQUIPA","DATA","PARQUE"};
        List<OrdemServico> ordemServicos;

        private TabelaOrdem(List<OrdemServico> ordemServicos){
            this.ordemServicos= ordemServicos;
        }

        @Override
        public int getRowCount() {
            return ordemServicos.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex){
                case 0 -> ordemServicos.get(rowIndex).getIdOrdem();
                case 1 -> ordemServicos.get(rowIndex).getDescricao();
                case 2 -> ordemServicos.get(rowIndex).getEstado();
                case 3 -> ordemServicos.get(rowIndex).getEquipa();
                case 4 -> ordemServicos.get(rowIndex).getData();
                case 5 -> ordemServicos.get(rowIndex).getParqueContentores();
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

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
}
