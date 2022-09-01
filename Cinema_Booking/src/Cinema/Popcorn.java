package Cinema;

/**
 *
 * @author jacob.s
 */
public class Popcorn implements Food {
    public void itemCost() {
        System.out.println("Press 0 to Skip!\n");
        System.out.println("Popcorn:");
        System.out.println("1.   Small:   $8.50");
        System.out.println("2.   Medium:  $9.00");
        System.out.println("3.   Large:  $10.00");
        System.out.println("4.   Jumbo:  $11.50");
    }
    public void itemComboCost() {
        System.out.println("5.   Large Popcorn & Water Combo:   $15.50");
        System.out.println("6.   Large Popcorn & Coke Combo:    $14.50");
        System.out.println("7.   Large Double Up Combo:         $25.50");
        System.out.println("8.   Jumbo Popcorn & Water Combo:   $17.50");
        System.out.println("9.   Jumbo Popcorn & Coke Combo:    $16.50");
        System.out.println("10.  Jumbo Double Up Combo:         $28.50");
        System.out.println("");
    }
}
