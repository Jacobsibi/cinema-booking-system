package Cinema;

/**
 *
 * @author jacob.s
 */
public class FoodCost {

    public double totalCost(int choice) {

        //switch food & drink choice
        switch (choice)
        {
            case 0: 
                return 0.0;
            case 1:
                return 8.50;
            case 2:
                return 9.00;
            case 3:
                return 10.00;
            case 4:
                return 11.50;
            case 5:
                return 15.50;
            case 6:
                return 14.50;
            case 7:
                return 25.50;
            case 8:
                return 17.50;
            case 9:
                return 16.50;
            case 10:
                return 28.50;
            case 11:
                return 7.50;
            case 12:
                return 6.00;
            case 13:
                return 7.00;
            case 14:
                return 6.50;
            case 15:
                return 13.50;
            case 16:
                return 12.50;
            case 17:
                return 7.70;
            case 18:
                return 7.70;
            case 19:
                return 8.00;
            case 20:
                return 14.00;
            case 21:
                return 14.50;
            default:
                return 0.0;
        }
    }
}
