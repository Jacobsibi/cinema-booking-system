package Cinema;

/**
 *
 * @author jacob.s
 */
public class Beverages implements Food {
    public void itemCost() {
        System.out.println("Beverages:");
        System.out.println("11. Large Frozen Coke:      $7.50");
        System.out.println("12. Pump Water 750ml:       $6.00");
        System.out.println("13. Jumbo Drink:            $7.00");
        System.out.println("14. Large Drink:            $6.50");
    }
    
    public void itemComboCost() {
        System.out.println("15. Double Up Jumbo Drink: $13.50");
        System.out.println("16. Double Up Large Drink: $12.50");
        System.out.println("");
    }
}
