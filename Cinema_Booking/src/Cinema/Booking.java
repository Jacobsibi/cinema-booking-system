
package Cinema;

/**
 *
 * @author jacob.s
 */
public class Booking {

    int ticketCost;
    int seatNo;
    int rowNo;
    Customer customer;
    Movie movie;

    public Booking(Customer customer, Movie movie) {
        this.customer = customer;
        this.movie = movie;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    

    public int getCost() {
        if (movie.getTheatre().getRows().get(rowNo).getRowLetter() == 1)
        {
            return ticketCost += 20;
        } else
        {
            return ticketCost + 12;
        }
    }

    public boolean bookSeat(int row, int seat) {

        if (movie.getTheatre().getRows().get(row).getSeats().get(seat).checkReservation())
        {
            return false;
        } else
        {
            movie.getTheatre().getRows().get(row).getSeats().get(seat).bookReservation();
            setRowNo(row);
            setSeatNo(seat);
            return true;
        }
    }

    public boolean cancelSeat() {
        movie.getTheatre().getRows().get(rowNo).getSeats().get(seatNo).cancelReservation();
        return true;
    }    
}
