package GUIFORM;

import Modelo.ChefeEquipa;
import Modelo.Gestor;
import Modelo.OrdemServico;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ListarOrdensChefe {
    private JPanel panel1;
    private JButton voltarButton;
    private JTable table1;


    public ListarOrdensChefe(ChefeEquipa chefeEquipa) {
        Repositorio repo = Repositorio.getRepositorio();
        Repositorio.desserializar("BD.repo");
        repo = Repositorio.getRepositorio();
        List<OrdemServico> ordemServicos = new ArrayList<>();

        for (OrdemServico o : repo.getOrdemServicoMap().values()){
            if(o.getEquipa().getChefeEquipa().getIdChefeEquipa() == chefeEquipa.getIdChefeEquipa()){
                ordemServicos.add(o);
            }
        }
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuChefe(chefeEquipa).trocarParaPainelPrincipal();
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
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


}
