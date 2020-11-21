package root;

import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel {

    private double[] coefficients;
    private double xBeg;
    private double xEnd;
    private double step;

    public GornerTableModel(double xBeg, double xEnd, double step, double[] coefficients) {
        this.xBeg = xBeg;
        this.xEnd = xEnd;
        this.step = step;
        this.coefficients = coefficients;
    }

    public double getXBeg() {
        return xBeg;
    }

    public double getXEnd() {
        return xEnd;
    }

    public double getStep() {
        return step;
    }
    
}
