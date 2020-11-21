package root;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class GornerTableCellRenderer implements TableCellRenderer {

    private String requiredValue;

    private Double rangeBeg;
    private Double rangeEnd;

    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();

    private DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();

    {
        formatter.setMaximumFractionDigits(6);
        formatter.setGroupingUsed(false);
        DecimalFormatSymbols curSymbol = formatter.getDecimalFormatSymbols();
        curSymbol.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(curSymbol);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        String formattedValue = formatter.format(value);

        label.setText(formattedValue);
        panel.add(label);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        if ((row + column) % 2 != 0) {
            panel.setBackground(Color.BLACK);
            label.setForeground(Color.WHITE);
        } else {
            panel.setBackground(Color.WHITE);
            label.setBackground(Color.BLACK);
        }

        if (column == 1 && ((requiredValue != null && requiredValue.equals(formattedValue)) || (rangeBeg != null && rangeEnd != null && (Double) value >= rangeBeg && (Double) value <= rangeEnd))) {
            panel.setBackground(Color.getHSBColor(121, 54, 100));
        }

        return panel;
    }

    public void setRequiredValue(String requiredValue) {
        this.requiredValue = requiredValue;
    }

    public void setRangeBeg(Double rangeBeg) {
        this.rangeBeg = rangeBeg;
    }

    public void setRangeEnd(Double rangeEnd) {
        this.rangeEnd = rangeEnd;
    }
}
