package Cinema;

/**
 *
 * @author jacob.s
 */
public class Confectionery implements Food{
    public void itemCost() {
        System.out.println("Confectionery:");
        System.out.println("17. M&M Milk Chocolate 180g: $7.70");
        System.out.println("18. Maltesers 140g: $7.70");
        System.out.println("19. Kit Kat 150g: $8.00");
    }
    
    public void itemComboCost() {
        System.out.println("20. Double Up: M&M's & Maltesers: $14.00");
        System.out.println("21. Double Up: Kit Kat & Maltesers: $14.50");
        System.out.println("");
    }
}
