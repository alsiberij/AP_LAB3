package root;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

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
    private JMenuItem showInfoMI;

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
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Файл");
        JMenu tableMenu = new JMenu("Таблица");
        JMenu infoMenu = new JMenu("Справка");

        menuBar.add(fileMenu);
        menuBar.add(tableMenu);
        menuBar.add(infoMenu);

        Action saveToTxtAction = new AbstractAction("Сохранить в .txt") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser == null) {
                    fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File("."));
                }
                if (fileChooser.showSaveDialog(GornerTableFrame.this) == JFileChooser.APPROVE_OPTION) {
                    //SaveToTxt(fileChooser.getSelectedFile())
                }
            }
        };
        saveToTxtMI = fileMenu.add(saveToTxtAction);
        saveToTxtMI.setEnabled(false);

        Action saveToBinAction = new AbstractAction("Сохранить в .bin") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser == null) {
                    fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File("."));
                }
                if (fileChooser.showSaveDialog(GornerTableFrame.this) == JFileChooser.APPROVE_OPTION) {
                    //SaveToBin(fileChooser.getSelectedFile())
                }
            }
        };
        saveToBinMI = fileMenu.add(saveToBinAction);
        saveToBinMI.setEnabled(false);

        Action saveToCsvAction = new AbstractAction("Сохранить в .csv") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser == null) {
                    fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File("."));
                }
                if (fileChooser.showSaveDialog(GornerTableFrame.this) == JFileChooser.APPROVE_OPTION) {
                    //SaveToCsv(fileChooser.getSelectedFile())
                }
            }
        };
        saveToCsvMI = fileMenu.add(saveToCsvAction);
        saveToCsvMI.setEnabled(false);

        Action searchValueAction = new AbstractAction("Найти значение") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = JOptionPane.showInputDialog(GornerTableFrame.this, "Введите значение", "Поиск", JOptionPane.QUESTION_MESSAGE);
                renderer.setRequiredValue(value);
                repaint();
            }
        };
        searchValueMI = tableMenu.add(searchValueAction);
        searchValueMI.setEnabled(false);

        Action searchValueFromRangeAction = new AbstractAction("Найти значение из диапазона") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rangeBegStr = JOptionPane.showInputDialog(GornerTableFrame.this, "Введите начало отрезка", "Поиск", JOptionPane.QUESTION_MESSAGE);
                String rangeEndStr = JOptionPane.showInputDialog(GornerTableFrame.this, "Введите конец отрезка", "Поиск", JOptionPane.QUESTION_MESSAGE);
                Double rangeBeg = null;
                Double rangeEnd = null;
                try {
                    rangeBeg = Double.parseDouble(rangeBegStr);
                    rangeEnd = Double.parseDouble(rangeEndStr);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(GornerTableFrame.this, "Неверные данные");
                    return;
                }
                renderer.setRangeBeg(rangeBeg < rangeEnd ? rangeBeg : rangeEnd);
                renderer.setRangeEnd(rangeBeg < rangeEnd ? rangeEnd : rangeBeg);

                repaint();
            }
        };
        searchValueFromRangeMI = tableMenu.add(searchValueFromRangeAction);
        searchValueFromRangeMI.setEnabled(false);

        Action showInfoAction = new AbstractAction("О программе") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon(new ImageIcon(GornerTableFrame.class.getResource("icon.jpg")).getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT));
                JOptionPane.showMessageDialog(GornerTableFrame.this, "Alexander Sibirtsev, BSU", "Справка", JOptionPane.PLAIN_MESSAGE, icon);
            }
        };
        showInfoMI = infoMenu.add(showInfoAction);

        setJMenuBar(menuBar);
    }

    private void constructTop() {
        JLabel xBegLabel = new JLabel("X от: ");
        xBegTF = new JTextField("0.0", 15);
        xBegTF.setMaximumSize(xBegTF.getPreferredSize());

        JLabel xEndLabel = new JLabel("до: ");
        xEndTF = new JTextField("1.0", 15);
        xEndTF.setMaximumSize(xEndTF.getPreferredSize());

        JLabel stepLabel = new JLabel("с шагом: ");
        stepTF = new JTextField("0.1", 15);
        stepTF.setMaximumSize(stepTF.getPreferredSize());

        Box hBoxTextFields = Box.createHorizontalBox();
        //hBoxTextFields.setBorder(BorderFactory.createBevelBorder(1));
        hBoxTextFields.add(Box.createHorizontalGlue());
        hBoxTextFields.add(xBegLabel);
        hBoxTextFields.add(Box.createHorizontalStrut(10));
        hBoxTextFields.add(xBegTF);
        hBoxTextFields.add(Box.createHorizontalStrut(30));
        hBoxTextFields.add(xEndLabel);
        hBoxTextFields.add(Box.createHorizontalStrut(10));
        hBoxTextFields.add(xEndTF);
        hBoxTextFields.add(Box.createHorizontalStrut(30));
        hBoxTextFields.add(stepLabel);
        hBoxTextFields.add(Box.createHorizontalStrut(10));
        hBoxTextFields.add(stepTF);
        hBoxTextFields.add(Box.createHorizontalGlue());

        hBoxTextFields.setPreferredSize(new Dimension(
                (int) hBoxTextFields.getMaximumSize().getWidth(),
                (int) hBoxTextFields.getMinimumSize().getHeight() * 2));

        add(hBoxTextFields, BorderLayout.NORTH);
    }

    private void constructMid() {
        //TODO
    }

    private void constructBot() {
        //TODO
    }
}
