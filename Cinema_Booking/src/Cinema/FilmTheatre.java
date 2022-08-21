package Cinema;

import java.util.ArrayList;

/**
 *
 * @author jacob.s
 */
public class FilmTheatre {

    private int cinemaNo;
    private String name;
    private int rowC;
    private ArrayList<Row> rows;

    public FilmTheatre(int cinemaNo, String details) {
        this.cinemaNo = cinemaNo;
        this.name = details;
        rows = new ArrayList<Row>();
    }

    public void rowCreation(int rowL, int seatC, int rowC) {
        for (int i = 1; i <= rowC; i++)
        {
            rows.add(new Row(rowL, seatC, i));
        }
        this.rowC += rowC;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public String getName() {
        return name;
    }

    public void seatingMap() {
        {
            System.out.println();
            int maximum = 0;
            for (Row row : getRows())
            {
                if (row.getSeats().size() > maximum)
                {
                    maximum = row.getSeats().size();
                }
            }
            System.out.print("   |");
            for (int i = 1; i <= maximum; i++)
            {
                System.out.print(" " + i);
            }
            System.out.print("\n");
            System.out.print("----");
            for (int i = 1; i <= maximum; i++)
            {
                if (i > 9)
                {
                    System.out.print("---");
                } else
                {
                    System.out.print("--");
                }
            }
            System.out.print("\n");
            for (Row row : getRows())
            {
                if (row.getRowNo() > 9)
                {
                    System.out.print(row.getRowNo() + " | ");
                } else
                {
                    System.out.print(row.getRowNo() + "  | ");
                }
                for (Seat seat : row.getSeats())
                {

                    if (seat.checkReservation())
                    {
                        System.out.print("X ");
                    } else
                    {
                        System.out.print(seat.getSeatNo() + " ");
                    }
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }
    }
}
