package root;

import javax.swing.*;

public class GornerTableFrame extends JFrame {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    private double[] coefficients;

    private JFileChooser fileChooser = null;

    private JMenuItem saveToTxtMI;
    private JMenuItem saveToBinMI;
    private JMenuItem saveToCsvMI;
    private JMenuItem searchValueMI;
    private JMenuItem searchValueFromRangeMI;
    private JMenuItem infoMI;

    private JTextField xBegTF;
    private JTextField xEndTF;
    private JTextField stepTF;

    private Box hResultTableBox;

    private GornerTableCellRenderer renderer = new GornerTableCellRenderer();

    private GornerTableModel dataTable;

    
}
