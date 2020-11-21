package root;

import javax.swing.*;
import java.awt.*;

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

    GornerTableFrame(double[] coefficients) {
        super("ТАБУЛИРОВАНИЕ ПО СХЕМЕ ГОРНЕРА");
        this.coefficients = coefficients;
        setSize(WIDTH, HEIGHT);

        Toolkit tk = Toolkit.getDefaultToolkit();
        setLocation((tk.getScreenSize().width - WIDTH) / 2, (tk.getScreenSize().height - HEIGHT) / 2);

        constructMenu();
        constructTop();
        constructMid();
        constructBot();
    }

    private void constructMenu() {
        //TODO
    }

    private void constructTop() {
        //TODO
    }

    private void constructMid() {
        //TODO
    }

    private void constructBot() {
        //TODO
    }
}
