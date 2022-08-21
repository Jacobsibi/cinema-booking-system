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
    private ArrayList<Seat> seating;

    public Row(int rowL, int count, int rowNo) {
        this.rowNumber = rowNo;
        this.rowLetter = rowL;
        this.count = count;
        seating = new ArrayList<Seat>();
        seatCreation(this.count);
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

    public void seatCreation(int count) {
        for (int i = 1; i <= count; i++)
        {
            seating.add(new Seat(false, i));
        }
    }

    public ArrayList<Seat> getSeats() {
        return seating;
    }
}