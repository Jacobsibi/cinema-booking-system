package Cinema;

/**
 *
 * Comp603: Assignment 1
 *
 * Cinema Booking System
 *
 * @author jacob.s
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.text.DecimalFormat;

public class Cinemas {
    
    //2 decimal format
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        

        //List of bookings, customers, movies and theatres.
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        ArrayList<Customer> customers = new ArrayList<Customer>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        ArrayList<FilmTheatre> theatres = new ArrayList<FilmTheatre>();

        // Star cinemas
        FilmTheatre starCinemas = new FilmTheatre(1, "Star Cinemas");
        starCinemas.rowCreation(1, 15, 15);
        theatres.add(starCinemas);

        // movies for testing purposes
        movies.add(new Movie("BULLET TRAIN", "03/08/2022", theatres.get(0), "R16: Graphic Violence & offensive language\n"
                + "An original movie event, Bullet Train is a fun, delirious action-thriller from the director of Deadpool 2, David Leitch. Brad Pitt headlines an ensemble cast of eclectic, diverse assassins – all with connected yet conflicting objectives – set against the backdrop of a non-stop ride through modern-day Japan.\n"
                + "Release Date:	03/08/2022\n"
                + "Running Time:	126 mins"));
        movies.add(new Movie("THOR: LOVE AND THUNDER ", "06/07/2022", theatres.get(0), "M: Violence\n"
                + "The film finds Thor on a journey unlike anything he’s ever faced – a quest for inner peace. But his retirement is interrupted by a galactic killer known as Gorr the God Butcher, who seeks the extinction of the gods.\n"
                + "Release Date:	06/07/2022\n"
                + "Running Time:	119 mins"));
        movies.add(new Movie("NOPE", "11/08/2022", theatres.get(0), "R13: Violence, horror & offensive language\n"
                + "Oscar® winner Jordan Peele disrupted and redefined modern horror with Get Out and then Us. Now, he reimagines the summer movie with a new pop nightmare: the expansive horror epic, Nope.\n"
                + "Release Date:	11/08/2022\n"
                + "Running Time:	130 mins"));
        movies.add(new Movie("TOP GUN: MAVERICK ", "24/05/2022", theatres.get(0), "M: Violence & offensive language\n"
                + "After more than thirty years of service as one of the Navy’s top aviators, Pete “Maverick” Mitchell (Tom Cruise) is where he belongs, pushing the envelope as a courageous test pilot and dodging the advancement in rank that would ground him.\n"
                + "Release Date:	24/05/2022\n"
                + "Running Time:	130 mins"));
        movies.add(new Movie("ELVIS", "23/06/2022", theatres.get(0), "M: Drug use\n"
                + "Oscar-nominated filmmaker Luhrmann (“The Great Gatsby,” “Moulin Rouge!”) explores the life and music of Presley, through the prism of his complicated relationship with his enigmatic manager, Colonel Tom Parker, played in the film by two-time Oscar winner Tom Hanks (“Forrest Gump,” “Philadelphia”). The story will delve into their complex dynamic spanning over 20 years, from Presley’s rise to fame to his unprecedented stardom, against the backdrop of the evolving cultural landscape and loss of innocence in America.\n"
                + "Release Date:	23/06/2022\n"
                + "Running Time:	159 mins"));
        movies.add(new Movie("MINIONS: THE RISE OF GRU", "24/06/2022", theatres.get(0), "PG: Violence\n"
                + "In the 1970s, young Gru tries to join a group of supervillains called the Vicious 6 after they oust their leader -- the legendary fighter Wild Knuckles. When the interview turns disastrous, Gru and his Minions go on the run with the Vicious 6 hot on their tails. Luckily, he finds an unlikely source for guidance -- Wild Knuckles himself -- and soon discovers that even bad guys need a little help from their friends.\n"
                + "Release Date:	24/06/2022\n"
                + "Running Time:	90 mins"));
        movies.add(new Movie("TESTING", "12/12/2023", theatres.get(0), "Movie Description for Testing Purposes"));

        // Options for user
        int choice = 0;

        do
        {
            //Greeting & 5 options for employee selection.
            //Option 10 for manager, username: admin, password: password

            System.out.println("Welcome to Star Cinemas!\n");
            System.out.println("Now Showing!               -    Press 1");
            System.out.println("Coming Soon!               -    Press 2");
            System.out.println("Make a Booking!            -    Press 3");
            System.out.println("Cancellations!             -    Press 4");
            System.out.println("Exit                       -    Press 5\n\n");
            System.out.println("Manager Functions          -    Press 10!");

            //Numberformatexception for choice, must enter 1-5, no letters
            try
            {
                choice = Integer.valueOf(scan.nextLine());
            } catch (NumberFormatException e)
            {
                System.out.println("Invalid input, please enter 1-5 only\n");
            }

            // if invalid number chosen
            if (choice < 1 || choice > 5 && choice != 10)
            {
                System.out.println("Try again!");
            }

            /// ------------------------------------------------------------------------------------------ \\\
            switch (choice)
            {
                /// ------------------------------------------------------------------------------------------ \\\
                //if choice is 1
                case 1:
                    //greeting
                    System.out.println("---Now showing at Star Cinemas---\n");
                    //try-catch block
                    try
                    {
                        /*
                        Create buffered & file reader & writer from input to output
                        Read current movies text file
                         */
                        BufferedReader br = new BufferedReader(new FileReader("./resources/current_movies.txt"));

                        //declare String to read from input
                        String s;

                        //read string from input until null
                        while ((s = br.readLine()) != null)
                        {

                            //create array to hold each name of movie split by new line
                            String[] currentMovies = s.split("\n");

                            for (int i = 0; i < currentMovies.length; i++)
                            {
                                System.out.println(currentMovies[i]);
                                System.out.println("");

                            }

                        }
                        //close br
                        br.close();

                    } catch (IOException e) //Catch IOexception
                    {
                        e.printStackTrace();
                    }
                    
                    System.out.println("//------------Extra Details------------\\\\" + "\n");

                    for (int k = 0; k < movies.size(); k++)
                    {
                        
                        System.out.println(movies.get(k).getMovieName());
                        System.out.println(movies.get(k).getDescription());
                        System.out.println("");
                    }
                    //Offer option to make a booking for one of these movies
                    System.out.println("Press 3 For Bookings!\n");
                    break;
                /// ------------------------------------------------------------------------------------------ \\\
                case 2:
                    //if choice is 2
                    //Greeting
                    System.out.println("---Coming Soon to Star Cinemas---\n");
                    //try-catch block
                    try
                    {
                        /*
                        Create buffered & file reader & writer from input to output
                        Read upcoming movies text file
                         */
                        BufferedReader br2 = new BufferedReader(new FileReader("./resources/upcoming_movies.txt"));

                        //declare String to read from input
                        String s2;

                        //read string from input until null
                        while ((s2 = br2.readLine()) != null)
                        {

                            //create array to hold each name of movie split by date
                            String[] upcomingMovies = s2.split("\n");
                            for (int i = 0; i < upcomingMovies.length; i++)
                            {
                                System.out.println(upcomingMovies[i]);
                            }

                        }

                        //close br
                        br2.close();

                    } catch (IOException e) //Catch IOexception
                    {
                        e.printStackTrace();
                    }

                    //Closing message
                    System.out.println("\nCheck back near release date for show times!\n");
                    break;
                /// ------------------------------------------------------------------------------------------ \\\
                case 3:
                    //if choice is 3
                    // make a movie booking
                    //try-catch block
                    try
                    {
                        //Line Spacing & Greeting
                        System.out.println("\nWelcome to Star Cinemas ");
                        System.out.println("\nNow Showing:\n");
                        //Generate random customerID for booking
                        Random ran = new Random();
                        int customerId = ran.nextInt(300);

                        //Create customer object
                        // Customer attendee = new Customer(customerId, firstName, lastName, email, phoneNo);
                        Customer attendee = new Customer(customerId);
                        customers.add(attendee);

                        //customers.add(new Customer(customerId, firstName, lastName, email, phoneNo));
                        //Save user details to file 
                        //print current showing movies
                        for (int i = 0; i < movies.size(); i++)
                        {
                            int movieNo = i + 1;
                            System.out.println(movieNo + ": " + movies.get(i).getMovieName() + "\n");
                        }

                        //user selection
                        System.out.println("---Enter Movie Number for Seat Allocation---\n");

                        int chosenShow = 0;

                        //read user input
                        chosenShow = Integer.valueOf(scan.nextLine());

                        System.out.println("");

                        //to rebook more seats loop variable
                        int anotherSeat = 0;

                        //create arrayList for Row & Seat for print ticket output
                        ArrayList<Integer> rowList = new ArrayList<>();
                        ArrayList<Integer> seatList = new ArrayList<>();

                        //do while loop to print seats & make bookings
                        do
                        {
                            movies.get(chosenShow - 1).getTheatre().seatingMap();
                            System.out.print("Row?: ");
                            int row = Integer.valueOf(scan.nextLine());

                            System.out.print("Seat?: ");
                            int seat = Integer.valueOf(scan.nextLine());

                            //create booking with customer and chosen movie
                            Booking book = new Booking(attendee, movies.get(chosenShow - 1));

                            //reserve seat if free, if not then display not available.
                            if (book.bookSeat(row - 1, seat - 1))
                            {
                                bookings.add(book);
                                System.out.println("\nReservation made!");
                                rowList.add(row);
                                seatList.add(seat);
                            } else
                            {
                                System.out.println("\nSorry! seat is not available");
                            }

                            //try-catch block for another booking input.
                            //press 1 to re-book.
                            try
                            {
                                System.out.println("\nPress 1 to book another seat, Press any other number to finalise: ");
                                anotherSeat = Integer.valueOf(scan.nextLine());

                            } catch (NumberFormatException e)
                            {
                                System.out.println("Invalid input, please enter numbers only!");

                            }

                        } while (anotherSeat == 1);

                        //Food & Beverages & Confectionery Information 
                        System.out.println("\nFood & Drinks Options:\n");

                        Popcorn popcorn = new Popcorn();
                        popcorn.itemCost();
                        popcorn.itemComboCost();

                        Beverages beverage = new Beverages();
                        beverage.itemCost();
                        beverage.itemComboCost();

                        Confectionery confectionery = new Confectionery();
                        confectionery.itemCost();
                        confectionery.itemComboCost();

                        //food&drink selection 
                        int foodChoice = 0;

                        FoodCost foodCost = new FoodCost();

                        //total food&drink cost
                        double totalCost = 0.0;

                        //loop until user inputs 0
                        do
                        {
                            try
                            {
                                System.out.println("\nPlease enter Number Selection (Press 0 to complete)");
                                foodChoice = Integer.valueOf(scan.nextLine());

                                totalCost += foodCost.totalCost(foodChoice);

                            } catch (NumberFormatException e)
                            {
                                System.out.println("Invalid input, please enter numbers only!");
                            }

                        } while (foodChoice != 0);

                        double tCost = 0.0;

                        //print booking cost
                        for (Booking book : bookings)
                        {
                            if (book.getCustomer().getId() == attendee.getId())
                            {
                                tCost += book.getCost();
                            }
                        }

                        System.out.println("Enter First Name to Finalize Booking:");

                        //Read firstName for Ticket Print output
                        String cusFirstName = "";
                        System.out.print("First Name?:  ");
                        cusFirstName = scan.nextLine();

                        //Ticket Output
                        System.out.println("\nThank you " + cusFirstName + "!\n");
                        System.out.println("----------Checkout----------\n");
                        System.out.println("Tickets for " + cusFirstName.toUpperCase() + "!");
                        System.out.println("Customer ID: " + attendee.getId() + "\n");
                        for (int i = 0; i < rowList.size(); i++)
                        {
                            System.out.println("Row: " + rowList.get(i) + ", Seat: " + seatList.get(i) + " ");
                        }
                        System.out.println("Food & Drink Cost: $" + df.format(totalCost));
                        System.out.println("Ticket Cost:       $" + df.format(tCost));
                        System.out.println("-----------------------------");
                        
                        //calculate total cost
                        double totalPrice = tCost + totalCost;
                        System.out.println("Total:             $" + (df.format(totalPrice) + " NZD\n"));

                        
                } catch (IndexOutOfBoundsException e)
                {
                    System.out.println("Invalid input! Try again \n");

                } catch (NumberFormatException e)
                {
                    System.out.println("Invalid input, please enter numbers only!\n");
                }
                break;
                /// ------------------------------------------------------------------------------------------ \\\
                case 4:
                    //if choice is 4
                    //cancel reservation
                    System.out.println("\n-----Cancellations-----");
                    //user must have booking to use this function, input customer ID generated from booking prior
                    System.out.println("For Booking Cancellation please enter Customer ID: ");
                    int givenId = 0;

                    //try-catch block for user ID input
                    try
                    {
                        givenId = Integer.valueOf(scan.nextLine());
                    } catch (NumberFormatException e)
                    {
                        System.out.println("Invalid input, please enter numbers only\n");
                    }

                    //check if ID is valid and has assosiated booking. 
                    for (Customer attendee : customers)
                    {
                        if (attendee.getId() == givenId)
                        {
                            for (Booking book : bookings)
                            {
                                if (book.getCustomer().getId() == attendee.getId())
                                {
                                    if (book.cancelSeat())
                                    {
                                        //Successful cancellation
                                        System.out.println("Booking cancelled!");
                                    }
                                }
                            }

                        } else
                        {
                            //No matching ID
                            System.out.println("Invalid ID!");
                        }

                    }
                    System.out.println("\n");
                    break;
                /// ------------------------------------------------------------------------------------------ \\\

                case 5:
                    //if choice is 5
                    //Greeting and quit
                    System.out.println("\nThank you for using Star Cinemas!");
                    System.exit(0);
                /// ------------------------------------------------------------------------------------------ \\\

                case 10:
                    //if choice is 10
                    // Manager login
                    System.out.println("\n-----Login-----\n");
                    //Read username (admin)
                    String userName = "";
                    System.out.print("Username: ");
                    userName = scan.nextLine();
                    //Read password (password)
                    String password = "";
                    System.out.print("Password: ");
                    password = scan.nextLine();

                    int managerInput = 0;
                    String removalAnswer = "";

                    //For example purposes username = admin, password = password
                    //if appropriate username & password given, enter portal
                    System.out.println("");
                    if (userName.equals("admin") && password.equals("password"))
                    {
                        //do-while portal functions
                        do
                        {

                            //options greeting
                            System.out.println("Welcome to Star Cinemas Manager Portal\n");
                            System.out.println("Press 1 to remove a current show");
                            System.out.println("Press 2 to add a current show");
                            System.out.println("Press 3 to add an upcoming show");
                            System.out.println("Press 5 to exit");

                            //try-catch block for manager option
                            try
                            {
                                managerInput = Integer.valueOf(scan.nextLine());

                                switch (managerInput)
                                {
                                    //if 1 selected, remove a current show from file and arraylist
                                    case 1:
                                        //print current shows
                                        System.out.println("-----Remove Current Shows-----\n");
                                        for (int i = 0; i < movies.size(); i++)
                                        {
                                            int movieNumber = i + 1;
                                            System.out.println(movieNumber + ": " + movies.get(i).getMovieName() + "\n");

                                        }
                                        //x to exit, select number assosiated with movie to remove
                                        System.out.println("Which movie would you like to remove? (press X to exit) \n");

                                        removalAnswer = scan.nextLine();
                                        int removal = Integer.parseInt(removalAnswer);

                                        do
                                        {
                                            try
                                            {

                                                //Remove movie from text file current_shows.txt as well
                                                File currentMovies = new File("./resources/current_Movies.txt");
                                                File tempFile = new File("./resources/myTempFile.txt");

                                                BufferedReader rdr = new BufferedReader(new FileReader(currentMovies));
                                                BufferedWriter wtr = new BufferedWriter(new FileWriter(tempFile));

                                                String lineToRemove = movies.get(removal - 1).getMovieName();
                                                String currentLine;

                                                while ((currentLine = rdr.readLine()) != null)
                                                {
                                                    // trim newline when comparing with lineToRemove
                                                    String trimmedLine = currentLine.trim();
                                                    if (trimmedLine.equals(lineToRemove))
                                                    {
                                                        continue;
                                                    }
                                                    wtr.write(currentLine + System.getProperty("line.separator"));
                                                }
                                                wtr.close();
                                                rdr.close();
                                                boolean successful = tempFile.renameTo(currentMovies);

                                            } catch (IOException e) //Catch IOexception
                                            {
                                                e.printStackTrace();
                                            } catch (IndexOutOfBoundsException e)
                                            {
                                                System.out.println("");
                                            }

                                            //remove current movie from ArrayList as well
                                            movies.remove(removal - 1);

                                            System.out.println("Successfully Removed\n");
                                        } while (removalAnswer.equalsIgnoreCase("x"));

                                        break;

                                    case 2:
                                        //Add a current show to both file and arrayList
                                        System.out.println("---Add Current Shows---");
                                        String movieName = "";
                                        System.out.print("Enter movie name: ");
                                        movieName = scan.nextLine();
                                        String movieDate = "";
                                        System.out.print("Enter movie release date: ");
                                        movieDate = scan.nextLine();
                                        String movieDesc = "";
                                        System.out.println("Enter movie description: ");
                                        movieDesc = scan.nextLine();
                                        System.out.println();

                                        //add new show to arrayList
                                        movies.add(new Movie(movieName, movieDate, theatres.get(0), movieDesc));

                                        try
                                        {   //create writer for current movies text file
                                            BufferedWriter bw = new BufferedWriter(new FileWriter("./resources/current_movies.txt", true));

                                            //write new current show to file
                                            bw.write("\n" + movieName);

                                            bw.close();

                                        } catch (Exception e) //Catch IOexception
                                        {
                                            e.printStackTrace();
                                        }
                                        System.out.println(movieName + " successfully added to current shows\n");
                                        break;
                                    case 3:

                                        //Read input for new upcoming show
                                        System.out.println("---Add Upcoming Shows---");

                                        String newMovieName = "";
                                        System.out.print("Enter movie name: ");
                                        newMovieName = scan.nextLine();
                                        String newMovieDate = "";
                                        System.out.print("Enter movie release date: ");
                                        newMovieDate = scan.nextLine();
                                        System.out.println();

                                        try
                                        {   //create writer for upcoming movies text file
                                            BufferedWriter bw = new BufferedWriter(new FileWriter("./resources/upcoming_movies.txt", true));

                                            //write new upcoming show & date to file
                                            bw.write("\n" + newMovieName + "         " + newMovieDate);

                                            bw.close();

                                        } catch (Exception e) //Catch IOexception
                                        {
                                            e.printStackTrace();
                                        }
                                        break;
                                    case 5:
                                        //If input is 5, shut manager portal down.
                                        System.out.println("Shutting Manager Portal!\n");
                                }
                            } catch (IndexOutOfBoundsException e)
                            {
                                System.out.println("Invalid input! Try again \n");

                            } catch (NumberFormatException e)
                            {
                                if (removalAnswer.equalsIgnoreCase("x"))
                                {
                                    break;
                                } else
                                {
                                    System.out.println("Invalid input, please enter numbers only!\n");
                                }

                            }
                        } while (managerInput != 5);

                    } else
                    {
                        System.out.println("Invalid username or password!\n");
                        break;
                    }

            }

        } while (true);

    }

}
