package Cinema;

import java.util.ArrayList;

/**
 *
 * @author jacob.s
 * 
 * reminder: set seat ArrayList 
 */


public class Row {
    
    private int rowNumber;
    private int rowLetter;
    private int count;

    public Row(int rowL, int count, int rowNo) {
        this.rowNumber = rowNo;
        this.rowLetter = rowL;
        this.count = count;
    }

    public int getRowNo() {
        return rowNumber;
    }

    public int getRowLetter() {
        return rowLetter;
    }

    public void setRowLetter(int rowLetter) {
        this.rowLetter = rowLetter;
    }
}
    
