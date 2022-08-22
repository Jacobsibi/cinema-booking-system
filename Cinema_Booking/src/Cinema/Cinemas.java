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


public class Cinemas {

    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
        
        //List of bookings, customers, movies and theatres.
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        ArrayList<Customer> customers = new ArrayList<Customer>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        ArrayList<FilmTheatre> theatres = new ArrayList<FilmTheatre>();

        // Event cinemas for testing purposes
        FilmTheatre eventCinemas = new FilmTheatre(1, "Star Cinemas");
        eventCinemas.rowCreation(1, 15, 15);
        theatres.add(eventCinemas);

        // movies for testing purposes
        movies.add(new Movie("Bullet Train", "03/08/2022", theatres.get(0)));
        movies.add(new Movie("Thor: Love and Thunder", "06/07/2022", theatres.get(0)));
        movies.add(new Movie("Nope", "11/08/2022", theatres.get(0)));
        movies.add(new Movie("Top Gun: Maverick", "24/05/2022", theatres.get(0)));
        movies.add(new Movie("Elvis", "23/06/2022", theatres.get(0)));
        movies.add(new Movie("Minions: The Rise of Gru", "24/06/2022", theatres.get(0)));

        // Options for user
        int choice = 0;

        do
        {
            //Greeting & 5 options for employee selection.
            //Option 10 for manager, username: admin, password: password

            System.out.println("𝐖𝐞𝐥𝐜𝐨𝐦𝐞 𝐭𝐨 𝐒𝐭𝐚𝐫 𝐂𝐢𝐧𝐞𝐦𝐚𝐬!\n");
            System.out.println("Now Showing!               -    Press 1");
            System.out.println("Coming Soon!               -    Press 2");
            System.out.println("Make a Booking!            -    Press 3");
            System.out.println("Cancellations              -    Press 4");
            //Login Screen -> Find in File -> Cancel Booking
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
                            }

                        }

                        //close br
                        br.close();

                    } catch (IOException e) //Catch IOexception
                    {
                        e.printStackTrace();
                    }

                    //Offer option to make a booking for one of these movies
                    System.out.println("\nPress 3 For Bookings!\n");
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
                        //Greeting message
                        System.out.println("---Create booking---\n");

                        //Generate random customerID for booking
                        Random ran = new Random();
                        int customerId = ran.nextInt(300);

                        //Create customer object
                        Customer attendee = new Customer(customerId);
                        customers.add(attendee);

                        //print current showing movies
                        for (int i = 0; i < movies.size(); i++)
                        {
                            int movieNo = i + 1;
                            System.out.println(movieNo + ": " + movies.get(i).getMovieName() + "\n");

                        }

                        //user selection
                        System.out.println("---Enter movie number to select seats---\n");

                        int chosenShow = 0;

                        //read user input
                        chosenShow = Integer.valueOf(scan.nextLine());

                        System.out.println("");

                        //to rebook more seats loop variable
                        int anotherSeat = 0;

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

                        System.out.println("\n\n");
                        System.out.println("Thank you! \n");
                        System.out.println("---Total cost---");
                        int tCost = 0;

                        //print booking cost
                        for (Booking book : bookings)
                        {
                            if (book.getCustomer().getId() == attendee.getId())
                            {
                                tCost += book.getCost();
                            }
                        }
                        System.out.println("Customer: " + attendee.getId());
                        System.out.println("Total Payable: " + tCost + ".00 NZD\n\n");

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
                    System.out.println("---Cancel booking---");
                    //user must have booking to use this function, input customer ID generated from booking prior
                    System.out.println("Enter ID: ");
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
                    System.out.println("\nThank you for using Event Cinemas Booking System!");
                    System.exit(0);
                /// ------------------------------------------------------------------------------------------ \\\

                case 10:
                    //if choice is 10
                    // Manager login
                    System.out.println("---Login---\n");
                    //Read username (admin)
                    String userName = "";
                    System.out.print("Username:  ");
                    userName = scan.nextLine();
                    //Read password (password)
                    String password = "";
                    System.out.print("Password: ");
                    password = scan.nextLine();

                    int managerInput = 0;
                    String removalAnswer = "";

                    //For example purposes username = admin, password = password
                    //if appropriate username & password given, enter portal
                    if (userName.equals("admin") && password.equals("password"))
                    {
                        //do-while portal functions
                        do
                        {

                            //options greeting
                            System.out.println("Welcome to Manager Portal\n");
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
                                        System.out.println("---Remove Current Shows---");
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
                                        System.out.println();

                                        //add new show to arrayList
                                        movies.add(new Movie(movieName, movieDate, theatres.get(0)));

                                        try
                                        {   //create writer for upcoming movies text file
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