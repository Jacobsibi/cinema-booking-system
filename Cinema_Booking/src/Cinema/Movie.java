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
}

