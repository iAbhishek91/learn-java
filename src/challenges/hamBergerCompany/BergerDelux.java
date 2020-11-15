package challenges.hamBergerCompany;

public class BergerDelux extends Berger {
    private AdditionalItem coke;
    private AdditionalItem chips;

    public BergerDelux() {
        super("Deluxe", CONSTANTS.DELUXE_BURGER, 3d);
        this.coke = new AdditionalItem("coke", 0.99d);
        this.chips = new AdditionalItem("chips", 0.50d);
    }

    @Override
    public double totalCost() {
        double totalCost = super.totalCost();

        System.out.println("Added: " + coke.getName() + " + " + coke.getCost());
        totalCost += coke.getCost();

        System.out.println("Added: " + chips.getName() + " + " + chips.getCost());
        totalCost += chips.getCost();

        return totalCost;
    }
}
