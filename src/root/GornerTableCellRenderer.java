package root;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
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
    
}
