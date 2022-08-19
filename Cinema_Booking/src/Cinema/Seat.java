package Cinema;

/**
 *
 * @author jacob.s
 */
public class Seat {

    int seatNumber;
    boolean checkReservation;

    public Seat(boolean check, int seatNo) {
        this.checkReservation = check;
        this.seatNumber = seatNo;
    }

    public int getSeatNo() {
        return this.seatNumber;
    }

    public void setSeatNo(int seatNo) {
        this.seatNumber = seatNo;
    }

    public boolean checkReservation() {
        return checkReservation;
    }

    public void bookReservation() {
        this.checkReservation = true;
    }

    public void cancelReservation() {
        this.checkReservation = false;
    }

}
