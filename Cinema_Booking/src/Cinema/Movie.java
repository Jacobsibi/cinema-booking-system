package Cinema;

import java.util.ArrayList;

/**
 *
 * @author jacob.s
 */
public class Movie {

    private String movieName;
    private String movieDate;
    private ArrayList<Seat> seating;
    private int emptySeats;
    private FilmTheatre theatre;
    private String description;

    public Movie(String movieName, String movieDate, FilmTheatre theatre, String desc) {
        this.movieName = movieName;
        this.movieDate = movieDate;
        this.theatre = theatre;
        this.description = desc;

    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Seat> getSeating() {
        return seating;
    }

    public FilmTheatre getTheatre() {
        return theatre;
    }

    public void setMap(FilmTheatre t) {
        this.theatre = t;
    }

    public int getEmptySeats() {

        for (Seat seat : seating)
        {
            if (!seat.checkReservation())
            {
                emptySeats++;
            }
        }

        return emptySeats;
    }

    public void seating() {
        for (Row row : theatre.getRows())
        {
            for (Seat seat : row.getSeats())
            {
                seating.add(seat);
            }
        }
    }
}
